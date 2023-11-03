package connexion;

import java.sql.*;

public class LogIn {

    public static Connection getOracleLogin(String u, String p) throws Exception {
        Connection con;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", u, p);
            System.out.println("Log In OK");
            return con;
        } catch (Exception erreurConnection) {
            throw erreurConnection;
        }
    }

    public static Connection setUserData(String userName, String password) throws Exception {
        Connection con;
        Statement stmnt;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", userName, password);
            stmnt = con.createStatement();

            stmnt.executeUpdate("CREATE TABLE OmbyUser(nom VARCHAR(20) NOT NULL, password VARCHAR(20) NOT NULL)");

            stmnt.executeUpdate("INSERT INTO OmbyUser VALUES('" + userName + "','" + password + "')");

            stmnt.executeUpdate("commit");

            System.out.println("Data Inserted");
            System.out.println("Saving Data OK");

            return con;
        } catch (Exception erreurSaveData) {
            throw erreurSaveData;
        }
    }

}
