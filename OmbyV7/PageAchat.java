package visuel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import connexion.*;
import client.*;
import betail.*;

public class PageAchat extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    ArrayList<JButton> buttonAchat = new ArrayList<>();
    JButton retourButton = new JButton("Retour");
    ArrayList<Omby> ombyList = OmbyCon.getListOmby();
    JPanel boxContent = new JPanel(new GridLayout());

    public PageAchat(Olona buyer) {
        this.setTitle(buyer.getName() + "'s Feeds");
        this.setSize(screenSize.width, screenSize.height);
        this.setLayout(new BorderLayout());

        JButton title = new JButton(buyer.getName() + "'s Feeds");

        int j = 0;
        for (int i = 0; i < ombyList.size(); i++) {
            if (buyer.getID() != ombyList.get(i).getIDOwner()) {
                if (ombyList.get(i).getLost().equals("1")) {
                    JButton button = new JButton(ombyList.get(i).getName() + " | Price: " + ombyList.get(i).getPrice());
                    buttonAchat.add(button);
                    boxContent.add(buttonAchat.get(j));

                    final int k = i;
                    buttonAchat.get(j).addActionListener(new ActionListener() {
                        @Override

                        public void actionPerformed(ActionEvent action) {
                            setVisible(false);
                            PageConfirmAchat confirmAchat = new PageConfirmAchat(buyer, ombyList.get(k));
                        }

                    });

                    j++;

                } else {
                    JButton button = new JButton(ombyList.get(i).getName() + " | unavailable (Lost) ");
                    buttonAchat.add(button);
                    boxContent.add(buttonAchat.get(j));
                }
            }
        }
        this.add(boxContent, BorderLayout.CENTER);
        this.add(title, BorderLayout.NORTH);
        this.add(retourButton, BorderLayout.SOUTH);

        retourButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent action) {
                setVisible(false);
                PageAccueil accueil = new PageAccueil();
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
