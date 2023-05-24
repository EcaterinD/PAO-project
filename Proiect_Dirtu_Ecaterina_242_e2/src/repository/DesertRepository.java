package repository;

import others.DatabaseConnection;
import model.Desert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DesertRepository {

    public void addDesert(Desert desert) {
        String query = "insert into desert values (null, ?, ?, ?, ?, ?, ?);";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, desert.getPret());
            statement.setDouble(2, desert.getTimpPreparare());
            statement.setDouble(3, desert.getGramaj());
            statement.setString(4, String.valueOf(desert.getTipDesert()));
            statement.setString(5, String.valueOf(desert.getAroma()));
            statement.setString(6, String.valueOf(desert.getTopping()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updatePret(Desert desert, Float price) {
        String query = "update `desert` set `pret` = ? where `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setFloat(1, price);
            statement.setInt(2, desert.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteDesert(Desert desert) {
        String query = "delete from `desert` where `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, desert.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Desert> getAllDesert() {
        Map<Integer, Desert> map = new HashMap<>();
        String query = "select * from desert;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Desert desert = new Desert();
                Integer id = resultSet.getInt(1);
                desert.setId(id);
                desert.setPret(resultSet.getFloat(2));
                desert.setTimpPreparare(resultSet.getInt(3));
                desert.setGramaj(resultSet.getInt(4));
                desert.setTipDesert(resultSet.getString(5));
                desert.setAroma(resultSet.getString(6));
                desert.setTopping(resultSet.getBoolean(7));
                map.put(id, desert);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

}