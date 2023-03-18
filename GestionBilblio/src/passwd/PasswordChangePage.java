/*
package passwd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/*public class PasswordChangePage extends JFrame implements ActionListener {
 Interface graphique pour saisir un nouveau mot de passe
    private JTextField newPasswordField;
    private JTextField confirmPasswordField;
    private JButton submitButton;

     Connexion à la base de données
    private Connection conn;*/

    /* ID de l'utilisateur dont on veut modifier le mot de passe
    private int id_user;

    public PasswordChangePage(Connection conn, int id_user) {
        super("Changer le mot de passe");

        this.conn = conn;
        this.id_user = id_user;

        // Création des éléments de l'interface graphique
        newPasswordField = new JTextField(20);
        confirmPasswordField = new JTextField(20);
        submitButton = new JButton("Enregistrer");
        submitButton.addActionListener(this);

        // Ajout des éléments à la fenêtre
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Nouveau mot de passe : "));
        panel.add(newPasswordField);
        panel.add(new JLabel("Confirmer le mot de passe : "));
        panel.add(confirmPasswordField);
        panel.add(submitButton);
        add(panel);

        // Affichage de la fenêtre
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Vérification que les deux champs de mot de passe sont identiques
        String newPassword = newPasswordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Les mots de passe ne correspondent pas.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Enregistrement du nouveau mot de passe dans la base de données
        try {
            Statement stmt = conn.createStatement();
            String query = "UPDATE user SET mot_de_passe='" + newPassword + "' WHERE id_user=" + id_user;
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Le mot de passe a été modifié avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Fermeture de la fenêtre
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Une erreur est survenue lors de la modification du mot de passe : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}*/
