package visuel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import connexion.*;
import client.*;
import betail.*;

public class PageConfirmAchat extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JButton confirmButton = new JButton("Confirm");
    ArrayList<Olona> olonaList = OlonaCon.getListOlona();

    public PageConfirmAchat(Olona user, Omby ombyClicked) {
        this.setTitle("Confirm Purchase");
        this.setSize(screenSize.width, screenSize.height);
        this.setLayout(new GridLayout(6, 1));
        JLabel ombyNameLabel = new JLabel(ombyClicked.getName());
        JLabel ombyIDLabel = new JLabel(Integer.toString(ombyClicked.getID()));
        JLabel ombyWeightLabel = new JLabel(Double.toString(ombyClicked.getWeight()));
        JLabel ombyPriceLabel = new JLabel(Integer.toString(ombyClicked.getPrice()));
        JLabel ombyOwnerLabel = new JLabel(Olona.getOwnerbyID(ombyClicked, olonaList).getName());

        this.add(ombyNameLabel);
        this.add(ombyIDLabel);
        this.add(ombyWeightLabel);
        this.add(ombyPriceLabel);
        this.add(ombyOwnerLabel);
        this.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent action) {
                Transaction.makeTransaction(user, ombyClicked);
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
