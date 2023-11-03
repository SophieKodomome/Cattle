package connexion;

import java.sql.*;

public class UserData {
    public static Connection setUserData(String userName, String password) throws Exception {
        System.out.println(userName);
        Syste.out.println(password);
        Connection con;
        Statement stmnt;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", userName, password);
            stmnt = con.createStatement();
            stmnt.executeUpdate(
                    "CREATE TABLE OmbyUser(nom VARCHAR(20) NOT NULL,password VARCHAR(20) NOT NULL);INSERT INTO OmbyUser VALUES("
                            + "'"
                            + userName
                            + "','"
                            + password
                            + "');"
                            + "commit");
            System.out.println("Data Inserted");
            System.out.println("Saving Data OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
