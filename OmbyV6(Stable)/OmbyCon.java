package connexion;

import java.sql.*;
import java.util.*;
import betail.*;

public class OmbyCon {
    public static ArrayList<Omby> getListOmby() {
        ArrayList<Omby> ombyList = new ArrayList<>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    LocalStorage.getUser(),
                    LocalStorage.getPassword());
            Statement stmnt = con.createStatement();

            ResultSet resultatOmby = stmnt.executeQuery("SELECT * FROM OMBY");

            int i = 0;
            while (resultatOmby.next()) {
                Omby omby = new Omby();
                omby.setID(resultatOmby.getInt("Id"));
                omby.setName(resultatOmby.getString("nom"));
                omby.setWeight(resultatOmby.getDouble("weight"));
                omby.setPrice(resultatOmby.getInt("price"));
                omby.setIDOwner(resultatOmby.getInt("idOwner"));
                omby.setLost(resultatOmby.getString("etat"));
                ombyList.add(omby);
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ombyList;
    }
}
