package databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLJTDSConnection {

    public static Connection getSQLServerConnection(){
    String hostName = "localhost";
    String sqlInstanceName = "SQLExpress";
    String database = "automation";
    String userName = "sa";
    String password = "Automation@2022";
        return getSQLServerConnection(hostName,sqlInstanceName, database,userName,password);
}

    private static Connection getSQLServerConnection(String hostName, String sqlInstanceName,String database, String userName, String password){
        Connection conn = null;
        try {
            //Khai bao class Driver cho SQL Server
            //Viec nay can thiet voi Java 5
            //Java 6 tu dong tim kiem Driver thich hop - Khong bat buoc dong nay
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            //Cau truc URL Connection danh cho SQL Server
            //Vi du: jtds:sqlserver://localhost:1433/automation;instance=SQLEXPRESS
            String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/"+database + ";instance=" +sqlInstanceName;
            conn = DriverManager.getConnection(connectionURL, userName,password);

        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
