import java.sql.*;
import packages.Graphics.*;
import packages.Database.DbConnection;

public class Main {
    public static void main(String[] args) {
        Connection con = DbConnection.getconnection();
        // Registerpanel.guicalled(con);
        Editpanel.guicalled();
        // System.out.println("hello");

    }
}