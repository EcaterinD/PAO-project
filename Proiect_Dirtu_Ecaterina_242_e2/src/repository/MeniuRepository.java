package repository;

import others.DatabaseConnection;
import model.Meniu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MeniuRepository {

    public void addMeniu(Meniu meniu) {
        String query = "insert into meniu values (null, ?, ?, ?, ?, ?, ?);";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, meniu.getPret());
            statement.setDouble(2, meniu.getTimpPreparare());
            statement.setDouble(3, meniu.getGramaj());
            statement.setString(4, String.valueOf(meniu.getTipSandwich()));
            statement.setDouble(5, meniu.getNrSuplimente());
            statement.setDouble(6, meniu.getCantitateCartofi());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updatePret(Meniu meniu, Float price) {
        String query = "update `meniu` set `pret` = ? where `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setFloat(1, price);
            statement.setInt(2, meniu.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteMeniu(Meniu meniu) {
        String query = "delete from `meniu` where `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, meniu.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Meniu> getAllMeniu() {
        Map<Integer, Meniu> map = new HashMap<>();
        String query = "select * from meniu;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Meniu meniu = new Meniu();
                Integer id = resultSet.getInt(1);
                meniu.setId(id);
                meniu.setPret(resultSet.getFloat(2));
                meniu.setTimpPreparare(resultSet.getInt(3));
                meniu.setGramaj(resultSet.getInt(4));
                meniu.setTipSandwich(resultSet.getString(5));
                meniu.setNrSuplimente(resultSet.getInt(6));
                meniu.setCantitateCartofi(resultSet.getInt(7));
                map.put(id, meniu);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

//    public int price(int index)
//    {
//        int pret=0;
//        Meniu m = (Meniu) meniuri.get(index);
//        if (meniuri.get(index) != null){
//            if (m.getCantitateCartofi()<300)
//                pret+=5;
//            else
//                pret+=7;
//            if (m.getTipSandwich()!="nimic")
//                pret+=10;
//            if (m.getTipSos()!="nimic")
//                pret+=3;
//            pret+=m.getNrSuplimente()*4;
//            return pret;
//        }
//        else
//            System.out.println("Meniul cautat nu exista!");
//        return -1;
//    }
}
