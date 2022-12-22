package Connection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class KoneksiDatabase {
    String DBurl = "jdbc:mysql://localhost/database_krs";
    String DBusername = "root";
    String DBpassword = "";
    
    public static Connection connection;
    public Statement statement;
public static Connection GetConnection(){
    if(connection==null){
        try{
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            String DBurl = "jdbc:mysql://localhost/database_krs";
            String DBusername = "root";
            String DBpassword = "";
            connection = DriverManager.getConnection(DBurl,DBusername,DBpassword);
        
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }return connection;
}

    public KoneksiDatabase() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Connection Failed\n" + ex.getMessage());
        }
    }
    
    
}