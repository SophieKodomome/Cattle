package connexion;

import java.util.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class LocalStorage {
    static File fichier = new File("localstorage/logs");

    public LocalStorage() {
    }

    public LocalStorage(String u, String p) {
        if (fichier.exists() == true) {
            fichier.delete();
            File fichier = new File("localstorage/logs");
        }
        try {
            FileWriter ecritureFichier = new FileWriter(fichier, true);
            ecritureFichier.write(u + "\n");
            ecritureFichier.write(p + "\n");
            ecritureFichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sesssionStop() {
        fichier.delete();
    }

    public static String getUser() {
        String userData = null;

        try {
            Scanner lectureFichier = new Scanner(new File("localstorage/logs"));
            userData = lectureFichier.nextLine();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userData;
    }

    public static String getPassword() {
        String passwordData = null;
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader("localstorage/logs"))) {
            int lineCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;

                if (lineCount == 2) {
                    passwordData = line;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passwordData;
    }
}
