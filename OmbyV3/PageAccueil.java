package visuel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import connexion.*;
import client.*;

public class PageAccueil extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel carteOption1 = new JPanel();
    JPanel carteOption2 = new JPanel();
    JPanel carteOption3 = new JPanel();
    JPanel boiteOption = new JPanel();
    JPanel scroll = new JPanel(new CardLayout());
    JButton buttonConfirm = new JButton("OK");
    String[] nomListOptions = { "Option 1", "Option 2", "Option 3" };
    JComboBox<String> caroussel = new JComboBox<>(nomListOptions);

    public PageAccueil() {
        this.setTitle("Accueil");
        this.setLayout(new GridLayout(3, 1));
        this.setSize(1080, 720);

        carteOption1.add(new JLabel("Truc 1"));
        carteOption2.add(new JLabel("Truc 2"));
        carteOption3.add(new JLabel("Truc 3"));

        scroll.add(carteOption1);
        scroll.add(carteOption2);
        scroll.add(carteOption3);

        caroussel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) scroll.getLayout();
                cardLayout.show(scroll, (String) caroussel.getSelectedItem());
            }
        });

        boiteOption.add(caroussel);
        this.add(boiteOption);
        this.add(scroll);
        this.add(buttonConfirm);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
