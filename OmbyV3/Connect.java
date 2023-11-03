package connexion;

import java.sql.*;

public class Connect {

    public static Connection getOracleCon(String user, String password) throws Exception {
        Connection con;
        Statement stmnt;
        ResultSet resultat;
        String reponse;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", user, password);
            /*
             * stmnt = con.createStatement();
             * resultat = stmnt.executeQuery("SELECT NOM FROM OMBY");
             * 
             * while (resultat.next()) {
             * reponse = resultat.getString(1);
             * System.out.println(reponse);
             * }
             */
            return con;
        } catch (Exception e) {
            throw e;
        }
    }
}
