package jdbcTest;

import databaseTesting.MySQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLTest {
   public static void main(String[] args) throws SQLException {
       Connection conn;

       conn = MySQLConnection.getMySQLConnection();
       System.out.println("Open Connection: "+conn);

       Statement statement = conn.createStatement();
       String sql = "Select Emp.Emp_Id, Emp.First_Name, Emp.Last_Name, Emp.Dept_Id From Employee Emp;";
        //thuc thi cau lenh SQL tra ve doi tuong ResultSet.
       ResultSet rs = statement.executeQuery(sql);

       //Duyet ket qua tra ve
       while (rs.next()){
           //Di chuyen con tro xuong ban ghi tiep theo
           int emplId = rs.getInt(1);
           String empFirstName  = rs.getString(2);
           String empLastName = rs.getString("Last_Name");

           System.out.println("--------------------");
           System.out.println("Emp Id: " + emplId);
           System.out.println("Emp Firstname: " + empFirstName);
           System.out.println("Emp Lastname: " + empLastName);
       }

       //dong ket noi
       conn.close();
       System.out.println("------------Closed Connection--------------");
   }
}
