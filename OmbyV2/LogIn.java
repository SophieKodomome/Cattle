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

}
