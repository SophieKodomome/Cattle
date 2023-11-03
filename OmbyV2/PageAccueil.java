package visuel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import connexion.*;

public class PageAccueil extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public PageAccueil() {
        this.setTitle("Accueil");
        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new CardLayout());
        this.setVisible(true);
    }
}
