package view;

import provider.Provider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.Client;

public class HotelManagementApp extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Provider.getInstance(
                    "jdbc:mysql://localhost:3306/hotel",
                    "root",
                    "designmydream",
                    true);

            HotelManagementApp app = new HotelManagementApp();
            app.setLocationRelativeTo(null);
            app.setVisible(true);
        });
    }

    public HotelManagementApp() {
        setTitle("Système de Gestion de l'Hôtel");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Connexion à la base de données
        if (establishDatabaseConnection()) {
            // Si la connexion réussit, créez le menu et les panneaux de gestion
            createMenu();
            createManagementPanels();
        } else {
            // Affichez un message d'erreur ou prenez d'autres mesures en cas d'échec de connexion
            JOptionPane.showMessageDialog(this, "Erreur de connexion à la base de données.", "Erreur", JOptionPane.ERROR_MESSAGE);
            dispose(); // Ferme l'application en cas d'échec de connexion
        }
    }

    private boolean establishDatabaseConnection() {
        try {
            Provider.getInstance(
                    "jdbc:mysql://localhost:3306/hotel",
                    "root",
                    "designmydream",
                    true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void createMenu() {
        // Créez ici votre menu avec les éléments pour chaque fonctionnalité
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu clientMenu = new JMenu("Clients");
        JMenuItem clientMenuItem = new JMenuItem("Gestion des Clients");
        clientMenuItem.addActionListener(e -> showClientPanel());
        clientMenu.add(clientMenuItem);
        menuBar.add(clientMenu);

        JMenu roomMenu = new JMenu("Chambres");
        JMenuItem roomMenuItem = new JMenuItem("Gestion des Chambres");
        roomMenuItem.addActionListener(e -> showRoomPanel());
        roomMenu.add(roomMenuItem);
        menuBar.add(roomMenu);

        // ... Ajoutez d'autres éléments de menu pour d'autres fonctionnalités
    }

    private void createManagementPanels() {
        // Créez ici les panneaux de gestion pour chaque fonctionnalité
        JTabbedPane tabbedPane = new JTabbedPane();
        add(tabbedPane);

        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new BorderLayout());
        clientPanel.add(new ClientManagementPanel(), BorderLayout.CENTER);
        tabbedPane.addTab("Gestion des Clients", clientPanel);

        JPanel roomPanel = new JPanel();
        roomPanel.setLayout(new BorderLayout());
        roomPanel.add(new RoomManagementPanel(), BorderLayout.CENTER);
        tabbedPane.addTab("Gestion des Chambres", roomPanel);

        // ... Ajoutez d'autres onglets et panneaux pour d'autres fonctionnalités
    }

    private void showClientPanel() {
        // Implémentez le code pour afficher le panneau de gestion des clients
    }

    private void showRoomPanel() {
        // Implémentez le code pour afficher le panneau de gestion des chambres
    }

    private static class ClientManagementPanel extends JPanel {
        // ... Ajoutez le code pour la gestion des clients
        private final DefaultTableModel tableModel;
    private final JTextField nomField;
    private final JTextField prenomField;
    private final JTextField numCarteField;
    private final JTextField telephoneField;
    private final JTextField nationaliteField;

    public ClientManagementPanel() {
        setLayout(new BorderLayout());

        // Table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nom");
        tableModel.addColumn("Prénom");
        tableModel.addColumn("Numéro Carte");
        tableModel.addColumn("Téléphone");
        tableModel.addColumn("Nationalité");

        JTable clientTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(clientTable);

        // Text Fields
        nomField = new JTextField(20);
        prenomField = new JTextField(20);
        numCarteField = new JTextField(20);
        telephoneField = new JTextField(20);
        nationaliteField = new JTextField(20);

        // Buttons
        JButton addButton = new JButton("Ajouter");
        addButton.addActionListener(e -> addClient());

        JButton updateButton = new JButton("Modifier");
        updateButton.addActionListener(e -> updateClient());

        JButton deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(e -> deleteClient());

        // Layout
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Nom:")); inputPanel.add(nomField);
        inputPanel.add(new JLabel("Prénom:")); inputPanel.add(prenomField);
        inputPanel.add(new JLabel("Numéro Carte:")); inputPanel.add(numCarteField);
        inputPanel.add(new JLabel("Téléphone:")); inputPanel.add(telephoneField);
        inputPanel.add(new JLabel("Nationalité:")); inputPanel.add(nationaliteField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.SOUTH);

        // Chargez les données existantes dans la table
        // loadClientData();
    }

  

    private void addClient() {
        // Ajoutez la logique pour ajouter un client à la table et à la base de données (à remplacer par votre logique)
        // Utilisez les valeurs des champs nomField, prenomField, etc.
        // Exemple fictif pour illustration :
        Client newClient = new Client(
                0, // L'ID peut être 0 pour une insertion, il sera rempli par la base de données
                nomField.getText(),
                prenomField.getText(),
                Integer.parseInt(numCarteField.getText()),
                Integer.parseInt(telephoneField.getText()),
                nationaliteField.getText(),
                null // Remplacez par la catégorie du client si vous avez une classe ClientCategory
        );

        // Ajoutez le client à la base de données (à remplacer par votre logique)
        boolean addedSuccessfully = addClientToDatabase(newClient);

        if (addedSuccessfully) {
            // Mettez à jour la table avec le nouveau client
            Object[] rowData = {newClient.getId(), newClient.getNameCli(), newClient.getFirstName(),
                    newClient.getNumCart(), newClient.getNumPhone(), newClient.getNationality()};
            tableModel.addRow(rowData);

            // Effacez les champs de saisie
            clearInputFields();
        } else {
            JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout du client.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean addClientToDatabase(Client client) {
        // Ajoutez la logique pour ajouter le client à la base de données (à remplacer par votre logique)
        // Utilisez votre provider pour ajouter le client à la base de données
        // Retournez true si l'ajout est réussi, sinon false
        // Exemple fictif pour illustration :
        return true;
    }

    private void updateClient() {
        int selectedRow = tableModel.getRowCount() > 0 ? tableModel.getRowCount() - 1 : -1;

        if (selectedRow != -1) {
            // Récupérer l'ID du client sélectionné
            int clientID = (int) tableModel.getValueAt(selectedRow, 0);

            // Mettez à jour le client dans la base de données (à remplacer par votre logique)
            boolean updatedSuccessfully = updateClientInDatabase(clientID, nomField.getText(), prenomField.getText(),
                    Integer.parseInt(numCarteField.getText()), Integer.parseInt(telephoneField.getText()),
                    nationaliteField.getText());

            if (updatedSuccessfully) {
                // Mettez à jour la table avec les nouvelles informations du client
                tableModel.setValueAt(nomField.getText(), selectedRow, 1);
                tableModel.setValueAt(prenomField.getText(), selectedRow, 2);
                tableModel.setValueAt(numCarteField.getText(), selectedRow, 3);
                tableModel.setValueAt(telephoneField.getText(), selectedRow, 4);
                tableModel.setValueAt(nationaliteField.getText(), selectedRow, 5);

                // Effacez les champs de saisie
                clearInputFields();
            } else {
                JOptionPane.showMessageDialog(this, "Erreur lors de la mise à jour du client.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sélectionnez un client à mettre à jour.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean updateClientInDatabase(int clientID, String nom, String prenom, int numCarte, int telephone, String nationalite) {
        // Ajoutez la logique pour mettre à jour le client dans la base de données (à remplacer par votre logique)
        // Utilisez votre provider pour mettre à jour le client dans la base de données
        // Retournez true si la mise à jour est réussie, sinon false
        // Exemple fictif pour illustration :
        return true;
    }

    private void deleteClient() {
        int selectedRow = tableModel.getRowCount() > 0 ? tableModel.getRowCount() - 1 : -1;

        if (selectedRow != -1) {
            // Récupérer l'ID du client sélectionné
            int clientID = (int) tableModel.getValueAt(selectedRow, 0);

            // Supprimer le client de la base de données (à remplacer par votre logique)
            boolean deletedSuccessfully = deleteClientFromDatabase(clientID);

            if (deletedSuccessfully) {
                // Supprimer la ligne sélectionnée du modèle de table
                tableModel.removeRow(selectedRow);

                // Effacez les champs de saisie
                clearInputFields();
            } else {
                JOptionPane.showMessageDialog(this, "Erreur lors de la suppression du client.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sélectionnez un client à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean deleteClientFromDatabase(int clientID) {
        // Ajoutez la logique pour supprimer le client de la base de données                                                          
        
        
        // Utilisez votre provider pour supprimer le client de la base de données
        // Retournez true si la suppression est réussie, sinon false
        // Exemple fictif pour illustration :
        return true;
    }

    private void clearInputFields() {
        nomField.setText("");
        prenomField.setText("");
        numCarteField.setText("");
        telephoneField.setText("");
        nationaliteField.setText("");
    }
    }

    private static class RoomManagementPanel extends JPanel {
        // ... Ajoutez le code pour la gestion des chambres
    }

    // ... Ajoutez d'autres classes internes pour d'autres fonctionnalités
}
