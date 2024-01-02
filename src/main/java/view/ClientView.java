/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author gr
 */
public class ClientView extends JFrame {
    private static final int WIDTH = SwingUtils.getMainWidth();
    private static final int HEIGHT = SwingUtils.getHeight();
    private final Dimension MAINMENU_DIM = new Dimension(WIDTH,HEIGHT);
    
    private JButton clientButton;
    private JButton roomButton;
    private JButton reservationButton;
    private JButton serviceButton;
    private JButton billButton;
    private JButton deconnexionButton;
    
    public CardLayout card;
    private JPanel clientPane;
    private JPanel roomPane;
    private JPanel reservationPane; 
    private JPanel servicePane;
    private JPanel billPane;
    private JPanel deconnexionPane;
      
    private final String[] list = {"CLIENTS","ROOM","RESERVATION","SERVICE","BILL","DECONNEXION"};
    public ClientView(){
        this.setTitle("Hotel");
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setAlwaysOnTop(false);
        this.setLocation(0, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(MAINMENU_DIM);
        this.setPreferredSize(MAINMENU_DIM);
        this.setVisible(true);
        
        clientButton = new JButton("CLIENTS");
        roomButton = new JButton("CHAMBRES");
        reservationButton = new JButton("RESERVATIONS");
        serviceButton = new  JButton("SERVICES");
        billButton = new JButton("FACTURATION");
        deconnexionButton = new JButton("DECONNEXION");
        
        card = new CardLayout();
        
        clientPane = new JPanel();
        roomPane = new JPanel();
        reservationPane = new JPanel();
        servicePane = new JPanel();
        billPane = new JPanel();
        
        init();
    }
    
    
    public void init(){
        JPanel mainPane = new JPanel();
        JPanel centerPane = new JPanel();
        JPanel leftPane = new  JPanel();
        JTabbedPane tabbedPane = new JTabbedPane();
        
        this.setContentPane(mainPane);
        mainPane.setLayout(new BorderLayout(4, 4));
        mainPane.add(leftPane, BorderLayout.WEST);
        mainPane.add(centerPane, BorderLayout.CENTER);
        leftPane.setBackground(Color.blue);
        leftPane.setPreferredSize(new Dimension(WIDTH/6, HEIGHT-25));
        centerPane.setBackground(Color.YELLOW);
        centerPane.setPreferredSize(new Dimension((WIDTH*5)/6, HEIGHT-25));
        
        leftPane.setLayout(new BorderLayout(2, 2));
        JPanel leftPaneCenter = new JPanel();
        JPanel leftPaneBottom = new JPanel();
        leftPane.add(leftPaneCenter, BorderLayout.CENTER);
        leftPane.add(leftPaneBottom, BorderLayout.SOUTH);
        leftPaneCenter.setLayout(new GridLayout(6,1,2,2));//
        
        
        leftPaneCenter.add(new JLabel("Hotel"){{
            setFont(new Font("TimesNewRoman", Font.BOLD,36));
            setIcon(new ImageIcon(""));
            setForeground(Color.WHITE);
            setHorizontalAlignment(JLabel.CENTER);
        }});
        
        leftPaneCenter.setBackground(new Color(0, 0,0,0));
        leftPaneCenter.add(clientButton);
        leftPaneCenter.add(roomButton);
        leftPaneCenter.add(serviceButton);
        leftPaneCenter.add(reservationButton);
        leftPaneCenter.add(billButton);
        leftPaneBottom.add(deconnexionButton);
        
        deconnexionButton.setBackground(Color.red);
        
        centerPane.setLayout(card);
        centerPane.add(clientPane, list[0]);
        centerPane.add(roomPane, list[1]);
        centerPane.add(reservationPane, list[2]);
        centerPane.add(servicePane, list[3]); 
        centerPane.add(billPane, list[4]);
        
        clientPane.setBackground(Color.red);
        roomPane.setBackground(Color.MAGENTA);
        reservationPane.setBackground(Color.ORANGE);
        servicePane.setBackground(Color.GREEN);
        billPane.setBackground(Color.CYAN);
        
        clientButton.addActionListener(e -> card.show(centerPane, list[0]));
        roomButton.addActionListener(e -> card.show(centerPane, list[1]));
        reservationButton.addActionListener(e -> card.show(centerPane, list[2]));
        serviceButton.addActionListener(e -> card.show(centerPane, list[3]));
        billButton.addActionListener(e -> card.show(centerPane, list[4]));
        
    }
     private JLabel clientInfoLabel;

   
    

    private void showClientInfo() {
        // Ajouter la logique pour afficher les informations du client
        // Remplacez cela par votre propre logique pour récupérer les données du client

        // Exemple simplifié : Affichage d'un message statique
        String clientInfo = "ID: 1\nNom: John Doe\nNuméro Carte: 123";
        clientInfoLabel.setText("Informations sur le client :\n" + clientInfo);
    }
    
    
   
   
}