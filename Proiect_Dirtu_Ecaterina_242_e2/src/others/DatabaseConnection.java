package others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection() {

    }

    public static Connection getInstance() throws SQLException {
        if(connection == null) {
            String url = "jdbc:mysql://localhost:3306/pao";
            String user = "root";
            String password = "Kati2@@2";

            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}