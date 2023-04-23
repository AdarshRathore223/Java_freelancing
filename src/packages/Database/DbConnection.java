package packages.Database;

import java.sql.*;

// import com.mysql.cj.protocol.Resultset;

public class DbConnection {
    static final String Db_url = "jdbc:mysql://localhost:3306";
    static final String User = "root";
    static final String password = "fuckthisshit";


    public static Connection getconnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(Db_url, User, password);
            Statement stmt = con.createStatement();
            String Query = "use freelancing";
            stmt.execute(Query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void entry(String Faculty_id, String First_name, String Last_name, String Address, String Contact_no,
            String Email_Id) {
        Connection con = getconnection();
        try {
            Statement stmt = con.createStatement();
            String Query = "insert into PersonData values(" + Faculty_id + ",'" + First_name + "','" + Last_name + "','"
                    + Address + "'," + Contact_no + ",'" + Email_Id + "')";
            stmt.execute(Query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getallentry() {
        Connection con = getconnection();
        ResultSet rs=null;
        try {
            Statement stmt = con.createStatement();
            String Query = "select * from PersonData";
            rs = stmt.executeQuery(Query);
            
            
            // System.out.println(rs.);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    public static ResultSet filteredData(String Facultyid, String FirstName, String Lastname) {
        Connection con = getconnection();
        ResultSet rs=null;
        try {
            Statement stmt = con.createStatement();
            String Query = "select * from PersonData where FacultyID like '"+Facultyid+"%' and FirstName like '"+FirstName+"%' and LastName like '"+Lastname+"%'";
            // String Query = "select * from PersonData where LastName like '"+Lastname+"%'";
            rs = stmt.executeQuery(Query);
            
            
            // System.out.println(rs.);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

}