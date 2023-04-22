import java.sql.*;
import packages.Graphics.Gui;
import packages.Database.DbConnection;
public class Main {
    public static void main(String[] args) {
        Connection con = DbConnection.getconnection();
        Gui.guicalled(con);
        
        // System.out.println("hello");

    }
}