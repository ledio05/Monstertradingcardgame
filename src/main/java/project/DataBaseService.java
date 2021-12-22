package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseService {

    private static DataBaseService instance;

    private static final String DB_URL = "jdbc:postgresql://localhost/mtcg";
    private static final String USER = "progres";
    private static final String PASS = "";

    public static DataBaseService getInstance() {
        if (DataBaseService.instance == null) {
            DataBaseService.instance = new DataBaseService();
        }
        return DataBaseService.instance;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
