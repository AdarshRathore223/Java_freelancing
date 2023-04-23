import java.sql.*;
import packages.Graphics.Registerpanel;
import packages.Database.DbConnection;
public class Main {
    public static void main(String[] args) {
        Connection con = DbConnection.getconnection();
        Registerpanel.guicalled(con);
        
        // System.out.println("hello");

    }
}