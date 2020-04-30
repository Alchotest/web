package by.servlets.db;

import by.servlets.exceptions.InitException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ServiceDb {
    private String user;
    private String password;
    private String dbUrl;

    public static ServiceDb serviceDb = null;

    private ServiceDb(String dbUrl, String user, String password) {
        this.dbUrl = "jdbc:mysql://localhost:3306/" + dbUrl + "?serverTimezone=UTC&useSSL=false";
        this.user = user;
        this.password = password;
    }

    public static void init( String dbUrl, String user, String password) throws InitException {
        if (serviceDb != null){
            return;
        }
        serviceDb = new ServiceDb(dbUrl, user, password);
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection dbConnection = null;
        Properties info = new Properties();
        Class.forName("com.mysql.cj.jdbc.Driver");
        info.put("user", "root");
        info.put("password", "qwerty12");
        String url = "jdbc:mysql://localhost:3306/web?serverTimezone=Europe/Minsk&useSSL=false";
        dbConnection = DriverManager.getConnection(url, info);
//        return DriverManager.getConnection(serviceDb.dbUrl, serviceDb.user,serviceDb.password);
        return dbConnection;
    }
}
