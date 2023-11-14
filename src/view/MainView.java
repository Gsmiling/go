package view;

import provider.Provider;
import provider.UsersProvider;

import javax.swing.*;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;

public class MainView {


    public static void main(String[] args){
        Provider.getInstance(
                "jdbc:mysql://localhost:3306/hotel",
                "root",
                "designmydream",
                true);

        UsersProvider usersProvider = UsersProvider.getInstance();
        SwingUtilities.invokeLater(() -> {
        LoginView fenetre = new LoginView();
        //Définit un titre pour votre fenêtre
        //fenetre.setTitle("Ma première fenêtre java");
//Définit une taille pour celle-ci ; ici, 400 px de
        // large et 500 px de haut
        //fenetre.setSize(400, 200);
//Nous allons maintenant dire à notre objet de se
        //  positionner au centre
        fenetre.setLocationRelativeTo(null);
//Terminer le processus lorsqu'on clique sur
        // "Fermer"

        fenetre.setVisible(true);

        });
    }
}

