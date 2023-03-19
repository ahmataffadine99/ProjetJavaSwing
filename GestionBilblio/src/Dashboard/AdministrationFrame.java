package Dashboard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class AdministrationFrame extends JFrame {

    private JTabbedPane tabs;
    private JPanel booksTab;
    private JTable booksTable;
    private JPanel usersTab;
    private JTable usersTable;



    private JPanel exemplairesTab;
    private JTable exemplairesTable;

    private JPanel emprunteursTab;
    private JTable emprunteursTable;
    private Button addBookButton;
    private Button deleteBookButton;
    private Button editBookButton;
    private Button addUserButton;
    private Button deleteUserButton;
    private Button editUserButton;


    private Button addExemplaireButton;
    private Button deleteExemplaireButton;
    private Button editExemplaireButton;

    private Button deleteEmprunteurButton;

    private Button manageBorrowingsButton;
    private Button statisticsButton;
    private JLabel booksLabel;
    private JLabel usersLabel;

    public AdministrationFrame() {
        setTitle("Gestion de la bibliothèque");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Création des onglets
        tabs = new JTabbedPane();
        booksTab = new JPanel(new BorderLayout());
        usersTab = new JPanel(new BorderLayout());
        exemplairesTab = new JPanel(new BorderLayout());
        emprunteursTab = new JPanel(new BorderLayout());

        //LIVRES

        // Création de l'onglet pour les livres
        AdministrationPanel booksPanel = new AdministrationPanel("Livres");
        booksTab.add(booksPanel, BorderLayout.CENTER);

        // Création des boutons pour la gestion des livres
        addBookButton = new Button("Ajouter livre");
        deleteBookButton = new Button("Supprimer livre");
        editBookButton = new Button("Modifier livre");
        JPanel booksButtonsPanel = new JPanel();
        booksButtonsPanel.add(addBookButton);
        booksButtonsPanel.add(deleteBookButton);
        booksButtonsPanel.add(editBookButton);

        booksTab.add(booksButtonsPanel, BorderLayout.NORTH);

        // Création du tableau pour la liste des livres
        Object[] columns = {"ISBN", "Titre", "Description", "Editeur", "Date de publication", "Auteur"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        booksTable = new JTable(model);
        JScrollPane booksScrollPane = new JScrollPane(booksTable);
        booksTab.add(booksScrollPane, BorderLayout.CENTER);

        //UTILISATEURS

        // Création de l'onglet pour les utilisateurs
        AdministrationPanel usersPanel = new AdministrationPanel("Utilisateurs");
        usersTab.add(usersPanel, BorderLayout.CENTER);

        // Création des boutons pour la gestion des utilisateurs
        addUserButton = new Button("Ajouter utilisateur");
        deleteUserButton = new Button("Supprimer utilisateur");
        editUserButton = new Button("Modifier utilisateur");
        JPanel usersButtonsPanel = new JPanel();
        usersButtonsPanel.add(addUserButton);
        usersButtonsPanel.add(deleteUserButton);
        usersButtonsPanel.add(editUserButton);
        usersTab.add(usersButtonsPanel, BorderLayout.NORTH);

        // Création du tableau pour la liste des utilisateurs
        Object[] userColumns = {"Identifiant", "Nom", "Prénom", "Rôle"};
        DefaultTableModel userTableModel = new DefaultTableModel(userColumns, 0);
        usersTable = new JTable(userTableModel);
        JScrollPane usersScrollPane = new JScrollPane(usersTable);
        usersTab.add(usersScrollPane, BorderLayout.CENTER);


        //EXEMPLAIRES

        // Création de l'onglet pour les exemplaires
        AdministrationPanel exemplairesPanel = new AdministrationPanel("Exemplaires");
        exemplairesTab.add(exemplairesPanel, BorderLayout.CENTER);

        // Création des boutons pour la gestion des exemplaires
        addExemplaireButton = new Button("Ajouter exemplaire");
        deleteExemplaireButton = new Button("Supprimer exemplaire");
        editExemplaireButton = new Button("Modifier exemplaire");
        JPanel exemplairesButtonsPanel = new JPanel();
        exemplairesButtonsPanel.add(addExemplaireButton);
        exemplairesButtonsPanel.add(deleteExemplaireButton);
        exemplairesButtonsPanel.add(editExemplaireButton);
        exemplairesTab.add(exemplairesButtonsPanel, BorderLayout.NORTH);

        // Création du tableau pour la liste des exemplaires
        Object[] exemplaireColumns = {"ID_EXEMPLAIRE", "Etat", "Date Acquisition", "ISBN-LIVRE"};
        DefaultTableModel exemplaireTableModel = new DefaultTableModel(exemplaireColumns, 0);
        exemplairesTable = new JTable(exemplaireTableModel);
        JScrollPane exemplairesScrollPane = new JScrollPane(exemplairesTable);
        exemplairesTab.add(exemplairesScrollPane, BorderLayout.CENTER);


        //EMPRUNTEURS

        // Création de l'onglet pour les exemplaires
        AdministrationPanel emprunteursPanel = new AdministrationPanel("Emprunteurs");
        emprunteursTab.add(emprunteursPanel, BorderLayout.CENTER);

        // Création des boutons pour la gestion des exemplaires
        deleteEmprunteurButton = new Button("Supprimer emprunteur");
        JPanel emprunteursButtonsPanel = new JPanel();
        exemplairesButtonsPanel.add(deleteEmprunteurButton);
        emprunteursTab.add(emprunteursButtonsPanel, BorderLayout.NORTH);

        // Création du tableau pour la liste des exemplaires
        Object[] emprunteurColumns = {"ID_EMPRUNTEUR", "Nom", "Prenom", "Adresse","Telephone"};
        DefaultTableModel emprunteurTableModel = new DefaultTableModel(emprunteurColumns, 0);
        emprunteursTable = new JTable(emprunteurTableModel);
        JScrollPane emprunteursScrollPane = new JScrollPane(emprunteursTable);
        emprunteursTab.add(emprunteursScrollPane, BorderLayout.CENTER);




        // GERER EMPRUNT ET STATISTIQUES

        // Création des boutons pour la gestion des emprunts et des statistiques
        manageBorrowingsButton = new Button("Gérer les emprunts");
        statisticsButton = new Button("Statistiques");
        JPanel managementButtonsPanel = new JPanel();
        managementButtonsPanel.add(manageBorrowingsButton);
        managementButtonsPanel.add(statisticsButton);
        usersTab.add(managementButtonsPanel, BorderLayout.SOUTH);


        // Ajout des onglets à la fenêtre
        tabs.addTab("Livres", booksTab);
        tabs.addTab("Utilisateurs", usersTab);
        tabs.addTab("Exemplaires", exemplairesTab);
        tabs.addTab("Emprunteurs",emprunteursTab);
        add(tabs);

        //caher les bouttons au lancement de dashboard
        addUserButton.setVisible(false);
        editUserButton.setVisible(false);
        deleteUserButton.setVisible(false);
        addBookButton.setVisible(false);
        editBookButton.setVisible(false);
        deleteBookButton.setVisible(false);
        addExemplaireButton.setVisible(false);
        deleteExemplaireButton.setVisible(false);
        editExemplaireButton.setVisible(false);
        deleteEmprunteurButton.setVisible(false);
        manageBorrowingsButton.setVisible(false);
        statisticsButton.setVisible(false);


        // Affichage des boutons correspondant à l'onglet sélectionné
        tabs.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = tabs.getSelectedIndex();

                if (selectedIndex == 0) { // Onglet Utilisateurs on affiche que les bouttons correspondants
                    addUserButton.setVisible(false);
                    editUserButton.setVisible(false);
                    deleteUserButton.setVisible(false);
                    addBookButton.setVisible(true);
                    editBookButton.setVisible(true);
                    deleteBookButton.setVisible(true);
                    addExemplaireButton.setVisible(false);
                    deleteExemplaireButton.setVisible(false);
                    editExemplaireButton.setVisible(false);
                    deleteEmprunteurButton.setVisible(false);
                    manageBorrowingsButton.setVisible(false);
                    statisticsButton.setVisible(false);
                } else if (selectedIndex == 1) { // Onglet Livres on affiche que les bouttons correspondants
                    addBookButton.setVisible(false);
                    editBookButton.setVisible(false);
                    deleteBookButton.setVisible(false);
                    addUserButton.setVisible(true);
                    editUserButton.setVisible(true);
                    deleteUserButton.setVisible(true);
                    addExemplaireButton.setVisible(false);
                    deleteExemplaireButton.setVisible(false);
                    editExemplaireButton.setVisible(false);
                    deleteEmprunteurButton.setVisible(false);
                    manageBorrowingsButton.setVisible(false);
                    statisticsButton.setVisible(false);
                } else if (selectedIndex == 2) { // Onglet Exemplaires on affiche que les bouttons correspondants
                    addExemplaireButton.setVisible(true);
                    deleteExemplaireButton.setVisible(true);
                    editExemplaireButton.setVisible(true);
                    manageBorrowingsButton.setVisible(true);
                    addUserButton.setVisible(false);
                    editUserButton.setVisible(false);
                    deleteUserButton.setVisible(false);
                    addBookButton.setVisible(false);
                    editBookButton.setVisible(false);
                    deleteBookButton.setVisible(false);
                    deleteEmprunteurButton.setVisible(false);

                    manageBorrowingsButton.setVisible(false);
                    statisticsButton.setVisible(false);
                } else if (selectedIndex == 3) { // Onglet Emprunteurs on affiche que les bouttons correspondants
                    deleteEmprunteurButton.setVisible(true);
                    addExemplaireButton.setVisible(false);
                    deleteExemplaireButton.setVisible(false);
                    editExemplaireButton.setVisible(false);
                    addUserButton.setVisible(false);
                    editUserButton.setVisible(false);
                    deleteUserButton.setVisible(false);
                    addBookButton.setVisible(false);
                    editBookButton.setVisible(false);
                    deleteBookButton.setVisible(false);
                    manageBorrowingsButton.setVisible(false);
                    statisticsButton.setVisible(false);
                }
            }
        });





        // ActionListener pour l'ajout de livres
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code pour ajouter un livre à la base de données
            }
        });

        // ActionListener pour la suppression de livres
        deleteBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code pour supprimer un livre de la base de données
            }
        });

        // ActionListener pour la modification de livres
        editBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code pour modifier les informations d'un livre dans la base de données
            }
        });

        // ActionListener pour l'ajout d'utilisateurs
        addUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code pour ajouter un utilisateur à la base de données
            }
        });

// ActionListener pour la suppression d'utilisateurs
        deleteUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code pour supprimer un utilisateur de la base de données
            }
        });

                // ActionListener pour la modification d'utilisateurs
        editUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code pour modifier les informations d'un utilisateur dans la base de données
            }
        });



                // ActionListener pour la gestion des emprunts
        manageBorrowingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code pour gérer les emprunts de livres dans la base de données
            }
        });

            // ActionListener pour les statistiques
        statisticsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code pour afficher des statistiques sur la bibliothèque
            }
        });

        // Ajout des boutons au panneau
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addBookButton);
        buttonPanel.add(editBookButton);
        buttonPanel.add(deleteBookButton);
        buttonPanel.add(addUserButton);
        buttonPanel.add(editUserButton);
        buttonPanel.add(deleteUserButton);

        buttonPanel.add(addExemplaireButton);
        buttonPanel.add(editExemplaireButton);
        buttonPanel.add(deleteExemplaireButton);
        buttonPanel.add(deleteEmprunteurButton);
        buttonPanel.add(manageBorrowingsButton);
        buttonPanel.add(statisticsButton);
        add(buttonPanel, BorderLayout.SOUTH);

    }
}
