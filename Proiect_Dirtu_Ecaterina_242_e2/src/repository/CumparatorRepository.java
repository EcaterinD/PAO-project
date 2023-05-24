package repository;

import others.DatabaseConnection;
import model.Cumparator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CumparatorRepository {

    public void addCumparator(Cumparator cumparator) {
        String query = "insert into cumparator values (null, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, String.valueOf(cumparator.getNume()));
            statement.setDouble(2, cumparator.getVarsta());
            statement.setString(3, String.valueOf(cumparator.getEmail()));
            statement.setString(4, String.valueOf(cumparator.getNrTel()));
            statement.setString(5, String.valueOf(cumparator.getAdresa()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateEmail(Cumparator cumparator, String email) {
        String query = "update `cumparator` set `email` = ? where `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, email);
            statement.setDouble(2, cumparator.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteCumparator(Cumparator cumparator) {
        String query = "delete from `cumparator` where `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, cumparator.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Cumparator> getAllCumparatori() {
        Map<Integer, Cumparator> map = new HashMap<>();
        String query = "select * from cumparator";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cumparator cumparator = new Cumparator();
                Integer id = resultSet.getInt(1);
                cumparator.setId(id);
                cumparator.setNume(resultSet.getString(2));
                cumparator.setVarsta(resultSet.getInt(3));
                cumparator.setEmail(resultSet.getString(4));
                cumparator.setNrTel(resultSet.getString(5));
                cumparator.setAdresa(resultSet.getString(6));
                map.put(id, cumparator);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}