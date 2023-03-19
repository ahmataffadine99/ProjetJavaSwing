package Dashboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFrame extends JFrame {

    public UserFrame(String username) {
        setTitle("Tableau de bord");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UserPanel dashboardPanel = new UserPanel(username);
        add(dashboardPanel);

        dashboardPanel.getViewBooksButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action à effectuer lorsque le bouton "Voir la liste des livres" est cliqué
            }
        });

        dashboardPanel.getAddBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action à effectuer lorsque le bouton "Ajouter un livre" est cliqué
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
