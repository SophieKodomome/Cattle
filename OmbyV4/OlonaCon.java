package connexion;

import java.sql.*;
import java.util.*;
import client.*;

public class OlonaCon {

    public static ArrayList<Olona> getListOlona() {
        ArrayList<Olona> olonaList = new ArrayList<>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    LocalStorage.getUser(),
                    LocalStorage.getPassword());
            Statement stmnt = con.createStatement();

            ResultSet resultatOlona = stmnt.executeQuery("SELECT * FROM OLONA");

            int i = 0;
            while (resultatOlona.next()) {
                Olona olona = new Olona();
                olona.setID(resultatOlona.getInt("Id"));
                olona.setName(resultatOlona.getString("nom"));
                olona.setCredit(resultatOlona.getInt("credit"));
                olonaList.add(olona);
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return olonaList;
    }
}
