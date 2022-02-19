package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connect_database {
    public static Connection con;
    private static String url = "";
    private static final String database_name = "carsalesystem";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "";
    
    public static void seturl()
    {
        url = "jdbc:mysql://localhost:3306/" + database_name + 
                "?useUnicode=true&characterEncoding=UTF-8";
    }
    public static void setconnection() throws SQLException
    {
        seturl();
        con = DriverManager.getConnection(url , username , password); 
    }
    //................................../
}
