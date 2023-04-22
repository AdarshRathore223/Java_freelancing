package packages.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DbConnection {
    static final String Db_url = "jdbc:mysql://localhost:3306";
    static final String User = "root";
    static final String password = "fuckthisshit";

    public static Connection getconnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(Db_url, User, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    
}