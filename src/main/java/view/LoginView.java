package view;

import model.User;
import provider.UsersProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class LoginView extends JFrame {

    public LoginView() {
        setTitle("Interface de Connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new BorderLayout());

        // Panel du formulaire
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Connexion", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JLabel userLabel = new JLabel("Nom d'utilisateur:");
        JTextField userField = new JTextField("Entrez votre nom d'utilisateur");
        userField.setForeground(Color.GRAY);
        userField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (userField.getText().equals("Entrez votre nom d'utilisateur")) {
                    userField.setText("");
                    userField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (userField.getText().isEmpty()) {
                    userField.setText("Entrez votre nom d'utilisateur");
                    userField.setForeground(Color.GRAY);
                }
            }
        });

        JLabel passLabel = new JLabel("Mot de passe:");
        JPasswordField passField = new JPasswordField();
        passField.setEchoChar('\u2022');  // Caractère de remplacement pour masquer le mot de passe

        // Case à cocher pour masquer ou afficher le mot de passe
        JCheckBox showPasswordCheckBox = new JCheckBox("Afficher le mot de passe");
        showPasswordCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    passField.setEchoChar((char) 0);  // Afficher le mot de passe
                } else {
                    passField.setEchoChar('\u2022');  // Masquer le mot de passe
                }
            }
        });

        JButton loginButton = new JButton("Se Connecter");
        loginButton.setBackground(new Color(46, 139, 87));  // Couleur verte foncée
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener((ActionEvent e) -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            UsersProvider usersProvider = UsersProvider.getInstance();
            User user = usersProvider.getUserByLoginInfo(username, password);

            if (user == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "Nom d'utilisateur ou Mot de passe incorrect",
                        "Erreur de Connexion",
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(this, "Connexion réussie");
            }
        });

        formPanel.add(userLabel);
        formPanel.add(userField);
        formPanel.add(passLabel);
        formPanel.add(passField);
        formPanel.add(showPasswordCheckBox);
        formPanel.add(loginButton);

        add(formPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginView::new);
    }
}
