package databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

    public static Connection getMySQLConnection(){
        //public IP
        String hostName = "localhost";
        String dbName = "automation";
        String userName = "root";
        String password = "Automation@2022";
        return getMySQLConnection(hostName,dbName,userName,password);
    }

    private static Connection getMySQLConnection(String hostName,String dbName, String userName, String password){
        Connection conn = null;
        try {
            //Khai bao class Driver cho MYSQL
            //Viec nay can thiet voi Java 5
            //Java 6 tu dong tim kiem Driver thich hop - Khong bat buoc dong nay
            Class.forName("com.mysql.jdbc.Driver");

            //Cau truc URL Connection danh cho MYSQL
            //Vi du: jdbc:mysql://localhost:3306/automationfc
            String connectionURL = "jdbc:mysql://" + hostName + ":3306/"+dbName;
            conn = DriverManager.getConnection(connectionURL, userName,password);

        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
