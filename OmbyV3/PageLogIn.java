package visuel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import connexion.*;

public class PageLogIn extends JFrame {
    JLabel title = new JLabel("Log In");
    JLabel labelUser = new JLabel("Name:");
    JLabel labelPassword = new JLabel("Password");
    JTextField fieldUserName = new JTextField(10);
    JPasswordField fieldPassword = new JPasswordField(10);
    JButton buttonLogin = new JButton("Log In");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public PageLogIn() {
        this.setTitle("Log In");
        this.setSize(screenSize.width, screenSize.height);
        this.setLayout(new FlowLayout());
        this.add(title);
        this.add(labelUser);
        this.add(fieldUserName);
        this.add(labelPassword);
        this.add(fieldPassword);
        this.add(buttonLogin);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        buttonLogin.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent actionLogIn) {
                try {
                    Connection logIn = LogIn.getOracleLogin(
                            fieldUserName.getText(),
                            new String(fieldPassword.getPassword()));
                    Connection userData = LogIn.setUserData(
                            fieldUserName.getText(),
                            new String(fieldPassword.getPassword()));
                    setVisible(false);
                    PageAccueil pageAccueil = new PageAccueil();

                    JOptionPane.showMessageDialog(null,
                            "Connection successfull! Welcome " + fieldUserName.getText() + "!");

                } catch (Exception erreurConnection) {
                    if (fieldUserName.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Username Empty!");
                    }
                    if (new String(fieldPassword.getPassword()).isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Password Empty!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Username or password");
                        erreurConnection.printStackTrace();
                    }
                }
            }
        });
    }

}
