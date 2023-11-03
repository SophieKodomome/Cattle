package connexion;

import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

import betail.*;
import client.*;
import erreurclasses.*;

public class Transaction {
        static Connection con;
        static Statement stmnt;
        static LocalDate dateLocal;
        static NegativeValueException erreurPasdArgent;

        public static void makeTransaction(Olona acheteur, Omby vendu) throws NegativeValueException, Exception {
                dateLocal = LocalDate.now();
                DateTimeFormatter dateTempsFormatteur = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
                String dateFormate = dateLocal.format(dateTempsFormatteur);
                System.out.println(dateFormate);
                try {
                        if (acheteur.getCredit() - vendu.getPrice() < 0)
                                throw erreurPasdArgent;
                        {

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

                                stmnt.executeUpdate("UPDATE Olona SET credit ="
                                                + (acheteur.getCredit() - vendu.getPrice())
                                                + " WHERE Id="
                                                + acheteur.getID());

                                stmnt.executeUpdate("UPDATE Olona SET credit ="
                                                + (acheteur.getCredit() + vendu.getPrice())
                                                + " WHERE Id="
                                                + vendu.getIDOwner());

                                stmnt.executeUpdate("UPDATE Omby SET IdOwner ="
                                                + acheteur.getID()
                                                + " WHERE Id="
                                                + vendu.getID());

                                stmnt.executeUpdate("commit");
                        }
                } catch (Exception erreurTransaction) {
                        throw erreurTransaction;
                }

        }
}
