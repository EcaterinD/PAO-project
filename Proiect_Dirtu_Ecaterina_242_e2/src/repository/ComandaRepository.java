package repository;

import others.DatabaseConnection;
import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class ComandaRepository {

    public void addComanda(Comanda comanda) {
        String query = "insert into `comanda` values (null, ";
        Cumparator cumparator = comanda.getCumparator();
        query = query + cumparator.getId() + ", ";
        Meniu meniu = comanda.getMeniu();
        if (meniu != null) {
            query = query + meniu.getId() + ", ";
        }
        else {
            query = query + "null, ";
        }
        Desert desert = comanda.getDesert();
        if (desert != null) {
            query = query + desert.getId() + ", ";
        }
        else {
            query = query + "null, ";
        }
        Bautura bautura = comanda.getBautura();
        if (bautura != null) {
            query = query + bautura.getId() + ");";
        }
        else {
            query = query + "null);";
        }

        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Comanda> getAllComenzi(Map<Integer, Cumparator> cumparatori, Map<Integer, Meniu> menius, Map<Integer, Desert> deserturi, Map<Integer, Bautura> bauturi) {
        ArrayList<Comanda> comenzi = new ArrayList<>();
        String query = "select * from `comanda`;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Comanda comanda = new Comanda();
                Integer id = resultSet.getInt(1);
                comanda.setCumparator(cumparatori.get(resultSet.getInt(2)));
                if (resultSet.getInt(3) != 0) {
                    comanda.setMeniu(menius.get(resultSet.getInt(3)));
                }
                if (resultSet.getInt(4) != 0) {
                    comanda.setDesert(deserturi.get(resultSet.getInt(4)));
                }
                if (resultSet.getInt(5) != 0) {
                    comanda.setBautura(bauturi.get(resultSet.getInt(5)));
                }
                comenzi.add(comanda);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return comenzi;
    }

    public void getAllComenziByCumparator(Integer cumparatorId, Map<Integer, Cumparator> cumparatori, Map<Integer, Meniu> menius, Map<Integer, Desert> deserturi, Map<Integer, Bautura> bauturi) {
        String query = "select * from `comanda` where `cumparatorId` = ?;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, cumparatorId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Comanda comanda = new Comanda();
                Integer id = resultSet.getInt(1);
                comanda.setCumparator(cumparatori.get(resultSet.getInt(2)));
                if (resultSet.getInt(3) != 0) {
                    comanda.setMeniu(menius.get(resultSet.getInt(3)));
                }
                if (resultSet.getInt(4) != 0) {
                    comanda.setDesert(deserturi.get(resultSet.getInt(4)));
                }
                if (resultSet.getInt(5) != 0) {
                    comanda.setBautura(bauturi.get(resultSet.getInt(5)));
                }
                System.out.println(comanda);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
