package view;

import provider.Provider;

import javax.swing.*;

public class MainView {


    public static void main(String[] args){
        Provider.getInstance(
                "jdbc:mysql://localhost:3306/hotel",
                "root",
                "designmydream",
                true);
SwingUtilities.invokeLater(() -> new ClientView()/*new Runnable() {
        @Override
        public void run() {
        //LoginView fenetre = new LoginView();
        fenetre.setLocationRelativeTo(null);
//Terminer le processus lorsqu'on clique sur
        // "Fermer"

        //fenetre.setVisible(true);

        }
    }*/);
  
    }
}

