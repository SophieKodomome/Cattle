package connexion;

import java.sql.*;
import java.util.*;
import client.*;
import betail.*;

public class OlonaCon {

    public static ArrayList<Olona> getListOlona() {
        ArrayList<Olona> olonaList = new ArrayList<>();
        ArrayList<Omby> ombyList = OmbyCon.getListOmby();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    LocalStorage.getUser(),
                    LocalStorage.getPassword());
            Statement stmnt = con.createStatement();

            ResultSet resultatOlona = stmnt.executeQuery("SELECT * FROM OLONA");

            while (resultatOlona.next()) {
                Olona olona = new Olona();
                olona.setID(resultatOlona.getInt("Id"));
                olona.setName(resultatOlona.getString("nom"));
                olona.setCredit(resultatOlona.getInt("credit"));

                for (int i = 0; i < ombyList.size(); i++) {
                    if (olona.getID() == ombyList.get(i).getIDOwner()) {
                        olona.setBetail(ombyList.get(i));
                    }
                }

                olonaList.add(olona);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return olonaList;
    }

}
