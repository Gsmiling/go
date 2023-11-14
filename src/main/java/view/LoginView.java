package view;

import model.User;
import provider.UsersProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame  {
    @Override
    public void setLayout(LayoutManager manager) {
        super.setLayout(manager);

        setTitle("Interface de Connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Nom d'utilisateur:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Mot de passe:");
        JPasswordField passField = new JPasswordField();

        JButton loginButton = new JButton("Se Connecter");

        int paddingSize = 20;
        panel.setBorder(BorderFactory.createEmptyBorder(paddingSize, paddingSize, paddingSize, paddingSize));


        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(new JLabel()); // Ajoute un espace vide
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener((ActionEvent e) -> {
            String username = userField.getText();
            String password = "";
            for (char c : passField.getPassword()) {
                password += c;
            }
            System.out.println("password " + password);
            // Ici, vous pouvez vérifier les informations de connexion
            // par exemple, en les comparant à une base de données.
            
            UsersProvider usersProvider = UsersProvider.getInstance();
            
            User user = usersProvider.getUserByLoginInfo(username, password);
            
            if (user == null) {
                JOptionPane.showMessageDialog(
                        getThisFrame(),
                        "Nom d'utilisateur ou Mot de passe incorrect"
                );
            } else {
                
                // Pour cet exemple, nous affichons simplement les informations saisies.
                JOptionPane.showMessageDialog(getThisFrame(), "l'utilisateur existe ");
            }
        });
        setVisible(true);
    }

    JFrame getThisFrame() {
        return this;
    }
}
