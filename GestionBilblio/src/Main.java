import ComposantsInterfaces.*;
import ComposantsInterfaces.Button;
import ComposantsInterfaces.Menu;
import ComposantsInterfaces.MenuBar;
import ComposantsInterfaces.MenuItem;
import Dashboard.AdministrationFrame;
import Dashboard.DashboardAdmin;
import Dashboard.UserFrame;
import Gmail.GmailSender;
import Interfaces.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import db.DatabaseConnexion;


import java.security.MessageDigest;


public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("Hello world!");
        //paneau

        JPanel panel = new JPanel();


        //fenetre

        Frame frame = new Frame();
        frame.add(panel);

        // Création de la barre d'outils

        Toolbar toolbar = new Toolbar();
        // toolbar.setAlignmentX(Component.RIGHT_ALIGNMENT);
        frame.add(toolbar, BorderLayout.PAGE_START);

        // Ajout d'un espace vide à droite de la barre d'outils
        Component horizontalGlue = Box.createHorizontalGlue();
        toolbar.add(horizontalGlue);

        // Ajout de boutons à la barre d'outils
        Button addButton = new Button("Ajouter un livre");
        toolbar.add(addButton);

        Button searchButton = new Button("Rechercher un livre");
        toolbar.add(searchButton);

        //menubar

        MenuBar menuBar = new MenuBar();
        frame.setMenuBar(menuBar);

        //Menu de navigation
        Menu fileMenu = new Menu("Fichier");
        Menu editMenu = new Menu("Edition");
        Menu loginMenu = new Menu("Connexion");
        Menu helpMenu = new Menu("Aide");


        //Gestion de menu de Fichier
        MenuItem newMenuItem = new MenuItem("Nouveau");
        MenuItem openMenuItem = new MenuItem("Ouvrir");
        MenuItem saveMenuItem = new MenuItem("Enregistrer");
        MenuItem exitMenuItem = new MenuItem("Quitter");


        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);


        //Gestion de menu de Edition
        MenuItem firstEdition = new MenuItem("1ere Edition");
        MenuItem secondEdition = new MenuItem("2eme Edition");
        MenuItem thirdEdition = new MenuItem("3eme Edition");
        MenuItem fourEdition = new MenuItem("4eme Edition");

        editMenu.add(firstEdition);
        editMenu.add(secondEdition);
        editMenu.add(thirdEdition);
        editMenu.addSeparator();
        editMenu.add(fourEdition);

        //Gestion de menu de Connexion

        MenuItem loginMenuItem = new MenuItem("Se connecter");

        // Ajout de l'élément de menu "Se connecter" au menu "Connexion"
        loginMenu.add(loginMenuItem);


        //Gestion de menu Aide a completer apres


        // Ajout des menus à la barre de menu
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(loginMenu);
        menuBar.add(helpMenu);

        // Création du panel pour le bouton "S'enregistrer"
        JPanel registerPanel = new JPanel();
        JButton registerButton = new JButton("S'enregistrer");
        registerPanel.add(registerButton);

        // Création du panel pour le bouton "Mot de passe oublié"
        JPanel forgotPasswordPanel = new JPanel();
        Button forgotPasswordButton = new Button("Mot de passe oublié");
        forgotPasswordPanel.add(forgotPasswordButton);

        // Création du panel pour les boutons "S'enregistrer" et "Mot de passe oublié"
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Orientation horizontale, alignement à gauche
        buttonPanel.add(registerPanel);
        buttonPanel.add(forgotPasswordPanel);


        //LOGIN

        loginMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Affichage d'une boîte de dialogue pour la saisie du nom d'utilisateur et du mot de passe
                JTextField usernameField = new JTextField(10);
                JPasswordField passwordField = new JPasswordField(10);
                // Création du panel pour les champs de saisie
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Nom d'utilisateur :"));
                panel.add(usernameField);
                panel.add(new JLabel("Mot de passe :"));
                panel.add(passwordField);


                panel.add(buttonPanel); // Ajout du panel contenant les boutons


                int result = JOptionPane.showConfirmDialog(null, panel, "Connexion",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    //  Le bouton "OK" a été cliqué, Récupération du nom d'utilisateur et du mot de passe saisis
                    String username = usernameField.getText();
                    String password = new String(passwordField.getPassword());
                    // Vérification de l'authentification et traitement de la connexion

                    try {
                        // Requête SQL pour récupérer les informations de l'utilisateur
                        String sql = "SELECT * FROM user WHERE nom_user = ? AND password_user = ?";
                        PreparedStatement statement = DatabaseConnexion.getConnection().prepareStatement(sql);
                        statement.setString(1, username);

                        // Hash du mot de passe
                        MessageDigest digest = MessageDigest.getInstance("SHA-256");
                        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
                        String hashedPassword = new BigInteger(1, hash).toString(16);

                        statement.setString(2, hashedPassword);


                        ResultSet resultset = statement.executeQuery();

                        if (resultset.next()) {
                            // L'utilisateur est authentifié
                            // Traitement de la connexion
                            JOptionPane.showMessageDialog(null, "Connexion réussie !");
                            // Créer une instance de la classe Dashboard-Administrateur
                             AdministrationFrame administrationFrame= new AdministrationFrame();

                            administrationFrame.setVisible(true);

                        } else {
                            // L'utilisateur n'est pas authentifié
                            JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect.");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erreur lors de l'authentification.");
                    } catch (NoSuchAlgorithmException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (result == JOptionPane.CANCEL_OPTION) {
                    // Le bouton "Annuler" a été cliqué
                    System.out.println("Authentification annulée ! A très Bientot ");
                }
            }

        });
        // S'ENREGISTRER

        // Ajout d'un ActionListener pour le bouton "S'enregistrer"

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Affichage d'une boîte de dialogue pour la saisie des informations de l'utilisateur
                JTextField emailField = new JTextField(10);
                JTextField usernameField = new JTextField(10);
                JPasswordField passwordField = new JPasswordField(10);
                // Création du panel pour les champs de saisie
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Email :"));
                panel.add(emailField);
                panel.add(new JLabel("Nom d'utilisateur :"));
                panel.add(usernameField);
                panel.add(new JLabel("Mot de passe (minimum 8 caractères avec au moins une majuscule et un chiffre) :"));                panel.add(passwordField);

                int result = JOptionPane.showConfirmDialog(null, panel, "S'enregistrer",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    // Le bouton "OK" a été cliqué, récupération des informations saisies
                    String email = emailField.getText();
                    String nom_user = usernameField.getText();
                    String password = new String(passwordField.getPassword());
                    //String prenom_user = email.substring(0, email.indexOf('@'));


                    // Vérification de la validité des informations saisies
                    if (nom_user.isEmpty() || email.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplis.");
                    }  else if (!password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$")) {
                        JOptionPane.showMessageDialog(null, "Le mot de passe doit contenir au moins 8 caractères, dont au moins une majuscule et un chiffre");
                    }else if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") || !(email.endsWith("@gmail.com") || email.endsWith("@yahoo.fr"))) {
                        JOptionPane.showMessageDialog(null, "L'adresse e-mail n'est pas valide. Elle doit se terminer par '@gmail.com' ou '@yahoo.fr'");
                    }else {
                        // Remplissage des champs manquants
                        String role = "user";
                        String[] parts = email.split("@");
                        String prenom_user = parts[0];

                        try {

                            // Requête SQL pour insérer un nouvel utilisateur dans la base de données
                            String sql = "INSERT INTO user (email, nom_user, password_user, prenom_user, role) VALUES (?, ?, ?, ?, ?)";
                            PreparedStatement statement = DatabaseConnexion.getConnection().prepareStatement(sql);
                            statement.setString(1, email);
                            statement.setString(2, nom_user);

                            // Hash du mot de passe
                            MessageDigest digest = MessageDigest.getInstance("SHA-256");
                            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
                            String hashedPassword = new BigInteger(1, hash).toString(16);
                            statement.setString(3, hashedPassword);
                            statement.setString(4, prenom_user);
                            statement.setString(5, role);

                            int rowsInserted = statement.executeUpdate();

                            if (rowsInserted > 0) {
                                // L'utilisateur a été ajouté à la base de données avec succès
                                JOptionPane.showMessageDialog(null, "Utilisateur ajouté avec succès !");
                            } else {
                                // Une erreur s'est produite lors de l'ajout de l'utilisateur à la base de données
                                JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'ajout de l'utilisateur à la base de données.");
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'utilisateur à la base de données.");
                        } catch (NoSuchAlgorithmException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                }

            }
        });

        // RECUPERATION DE MOT DE PASSE

        forgotPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = JOptionPane.showInputDialog("Veuillez saisir votre adresse e-mail :");
                // Vérifier si l'adresse e-mail est présente dans la base de données
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "root");
                    String query = "SELECT * FROM user WHERE email=?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, email);
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        // L'adresse e-mail est présente dans la base de données, on peut générer un code de hachage
                        String resetCode = generateResetCode();
                        // Enregistrer le code de hachage dans la base de données
                        String updateQuery = "UPDATE user SET password_user=? WHERE email=?";
                        PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                        updateStmt.setString(1, resetCode);
                        updateStmt.setString(2, email);
                        int rowsUpdated = updateStmt.executeUpdate();
                        if (rowsUpdated > 0) {
                            // Le code de hachage a été enregistré avec succès dans la base de données
                            sendResetLink(email, resetCode);
                            JOptionPane.showMessageDialog(null, "Un lien de réinitialisation de mot de passe a été envoyé à votre adresse e-mail.");
                        } else {
                            // Erreur lors de l'enregistrement du code de hachage dans la base de données
                            JOptionPane.showMessageDialog(null, "Erreur lors de la réinitialisation de mot de passe. Veuillez réessayer plus tard.");
                        }
                    } else {
                        // L'adresse e-mail n'est pas présente dans la base de données
                        JOptionPane.showMessageDialog(null, "Cette adresse e-mail n'est pas associée à un compte utilisateur.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            // Fonction pour générer un code de hachage aléatoire
            private String generateResetCode() {
                // Génère un code aléatoire de 6 caractères pour le lien de réinitialisation
                String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                StringBuilder sb = new StringBuilder(6);
                for (int i = 0; i < 6; i++) {
                    int index = (int) (Math.random() * characters.length());
                    sb.append(characters.charAt(index));
                }
                return sb.toString();
            }

            // Fonction pour envoyer le lien de réinitialisation de mot de passe par e-mail

            private boolean sendResetLink(String recipient, String resetCode) {
                try {
                    GmailSender.sendEmail(recipient, "Réinitialisation de votre mot de passe", "Bonjour,\n\n" +
                            "Nous avons reçu une demande de réinitialisation de mot de passe pour votre compte.\n" +
                            "Pour réinitialiser votre mot de passe, veuillez cliquer sur le lien suivant : \n\n" +
                            "http://127.0.0.1:8888/resetPassword?code=" + resetCode + "\n\n" +
                            "Si vous n'avez pas demandé la réinitialisation de votre mot de passe, veuillez ignorer ce message.\n\n" +
                            "Cordialement,\n" +
                            "L'équipe de votre site web");
                    return true;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return false;
                }
            }



        });


        frame.pack();
        frame.setSize(1000, 1000);
        frame.setVisible(true);


    }
}


