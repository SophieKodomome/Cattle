package visuel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import connexion.*;
import client.*;
import betail.*;

public class PageAccueil extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    ArrayList<JButton> buttonAcheteur = new ArrayList<>();
    JButton title = new JButton("choose your buyer");
    ArrayList<Omby> test = OmbyCon.getListOmby();
    ArrayList<Olona> olonaList = OlonaCon.getListOlona();
    JPanel boxContent = new JPanel(new GridLayout(3, 1));

    public PageAccueil() {
        this.setTitle("Accueil");
        this.setLayout(new BorderLayout());
        this.setSize(screenSize.width, screenSize.height);

        for (int i = 0; i < olonaList.size(); i++) {
            JButton button = new JButton(
                    "nom: " + olonaList.get(i).getName() + " solde: " + olonaList.get(i).getCredit()
                            + " valeur betail: " + olonaList.get(i).getValeurBetail());
            buttonAcheteur.add(button);
            boxContent.add(buttonAcheteur.get(i));

            final int j = i;
            buttonAcheteur.get(i).addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent action) {
                    setVisible(false);
                    PageAchat pageAchat = new PageAchat(olonaList.get(j));
                }
            });
        }
        this.add(title, BorderLayout.NORTH);
        this.add(boxContent, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
