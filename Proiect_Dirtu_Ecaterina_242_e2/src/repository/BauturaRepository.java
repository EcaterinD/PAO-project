package repository;

import others.DatabaseConnection;
import model.Bautura;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BauturaRepository {

    public void addBautura(Bautura bautura) {
        String query = "insert into bautura values (null, ?, ?, ?, ?);";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, bautura.getPret());
            statement.setString(2, String.valueOf(bautura.getCaldaRece()));
            statement.setString(3, String.valueOf(bautura.getDenumire()));
            statement.setString(4, String.valueOf(bautura.getDimensiune()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updatePret(Bautura bautura, Float pret) {
        String query = "update `bautura` set `pret` = ? where `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setFloat(1, pret);
            statement.setInt(2, bautura.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteBautura(Bautura bautura) {
        String query = "delete from `bautura` where `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, bautura.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Bautura> getAllBauturi() {
        Map map = new HashMap<Integer, Bautura>();
        String query = "select * from bautura;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bautura bautura = new Bautura();
                Integer id = resultSet.getInt(1);
                bautura.setId(id);
                bautura.setPret(resultSet.getFloat(2));
                bautura.setCaldaRece(resultSet.getBoolean(3));
                bautura.setDenumire(resultSet.getString(4));
                bautura.setDimensiune(resultSet.getString(5));
                map.put(id, bautura);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public Map<Integer, Bautura> getByPret(Bautura bautura) {
        Map map = new HashMap<Integer, Bautura>();
        String query = "select * from bautura b where b.pret = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, bautura.getPret());

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Bautura bauturaaux = new Bautura();
                Integer id = resultSet.getInt(1);
                bauturaaux.setId(id);
                bauturaaux.setPret(resultSet.getFloat(2));
                bauturaaux.setCaldaRece(resultSet.getBoolean(3));
                bauturaaux.setDenumire(resultSet.getString(4));
                bauturaaux.setDimensiune(resultSet.getString(5));
                map.put(id, bauturaaux);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return map;
    }


//    public int readyTime(int index)
//    {
//        int timp=0;
//        Bautura b = (Bautura) bauturi.get(index);
//        if (bauturi.get(index) != null){
//            if(b.getDimensiune()=="S")
//                timp=1;
//            else if(b.getDimensiune()=="M")
//                timp=2;
//            else if (b.getDimensiune()=="L")
//                timp=3;
//
//            if (Objects.equals(b.getCaldaRece(), "calda"))
//                if (Objects.equals(b.getDenumire(), "ceai"))
//                    timp=4;
//                else timp=8; // cafea/cappuccino
//            else // rece
//                if (!Objects.equals(b.getDenumire(), "suc")) // frappe
//                    timp=8;
//            // else ramane timpul de la dimensiune
//            return timp;
//        }
//        else
//            System.out.println("Bautura cautata nu exista!");
//        return -1;
//    }

}