package jdbcTest;

import databaseTesting.MicrosoftSQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MicrosoftSQLTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = MicrosoftSQLConnection.getMicrosoftSQLServerConnection();


        System.out.println("Open Connection: "+conn);

        Statement statement = conn.createStatement();
        String sql = "SELECT EMP_ID, FIRST_NAME, LAST_NAME, DEPT_ID FROM [automation].[dbo].[EMPLOYEE];";
        //thuc thi cau lenh SQL tra ve doi tuong ResultSet.
        ResultSet rs = statement.executeQuery(sql);

        //Duyet ket qua tra ve
        while (rs.next()){
            //Di chuyen con tro xuong ban ghi tiep theo
            int emplId = rs.getInt(1);
            String empFirstName  = rs.getString(2);
            String empLastName = rs.getString("Last_Name");
            int DeptID = rs.getInt("Dept_Id");

            System.out.println("--------------------");
            System.out.println("Emp Id: " + emplId);
            System.out.println("Emp Firstname: " + empFirstName);
            System.out.println("Emp Lastname: " + empLastName);
            System.out.println("Department ID: " + DeptID);
        }

        //dong ket noi
        conn.close();
        System.out.println("------------Closed Connection--------------");
    }
}

