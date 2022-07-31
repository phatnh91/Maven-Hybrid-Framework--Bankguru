package databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;

public class MicrosoftSQLConnection {
    public static Connection getMicrosoftSQLServerConnection(){
        String hostName = "localhost";
        String sqlInstanceName = "SQLExpress";
        String database = "automation";
        String userName = "sa";
        String password = "Automation@2022";
        return getMicrosoftSQLServerConnection(hostName,sqlInstanceName, database,userName,password);
    }

    private static Connection getMicrosoftSQLServerConnection(String hostName, String sqlInstanceName,String database, String userName, String password){
        Connection conn = null;
        try {
            //Khai bao class Driver cho SQL Server
            //Viec nay can thiet voi Java 5
            //Java 6 tu dong tim kiem Driver thich hop - Khong bat buoc dong nay
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //Cau truc URL Connection danh cho SQL Server
            //Vi du: jtds:sqlserver://localhost:1433/automation;instance=SQLEXPRESS
            String connectionURL = "jdbc:sqlserver://" + hostName + ":1433/"+ ";instance=" +sqlInstanceName +";databaseName="+database;
            conn = DriverManager.getConnection(connectionURL, userName,password);

        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
