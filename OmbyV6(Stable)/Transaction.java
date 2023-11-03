package connexion;

import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

import betail.*;
import client.*;

public class Transaction {
    static Connection con;
    static Statement stmnt;
    static LocalDate dateLocal;

    public static void makeTransaction(Olona acheteur, Omby vendu) {
        dateLocal = LocalDate.now();
        DateTimeFormatter dateTempsFormatteur = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        String dateFormate = dateLocal.format(dateTempsFormatteur);
        System.out.println(dateFormate);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    LocalStorage.getUser(),
                    LocalStorage.getPassword());
            stmnt = con.createStatement();

            stmnt.executeUpdate("INSERT INTO Transaction VALUES('"
                    + acheteur.getID()
                    + "','"
                    + vendu.getIDOwner()
                    + "','"
                    + vendu.getID()
                    + "','"
                    + vendu.getPrice()
                    + "','"
                    + dateFormate
                    + "')");

            System.out.println("update 1 done");
            stmnt.executeUpdate("UPDATE Olona SET credit =" + (acheteur.getCredit() - vendu.getPrice()) + " WHERE Id="
                    + acheteur.getID());
            System.out.println("update 2 done");
            stmnt.executeUpdate("UPDATE Olona SET credit =" + (acheteur.getCredit() + vendu.getPrice()) + " WHERE Id="
                    + vendu.getIDOwner());
            System.out.println("update 3 done");
            stmnt.executeUpdate("UPDATE Omby SET IdOwner =" + acheteur.getID() + " WHERE Id=" + vendu.getID());
            System.out.println("update 4 done");

            stmnt.executeUpdate("commit");
        } catch (Exception erreurTransaction) {
            erreurTransaction.printStackTrace();
        }
    }
}
