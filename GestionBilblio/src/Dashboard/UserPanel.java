package Dashboard;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {

    private JLabel welcomeLabel;
    private JButton viewBooksButton;
    private JButton addBookButton;

    public UserPanel(String username) {
        welcomeLabel = new JLabel("Bienvenue, " + username + " !");
        viewBooksButton = new JButton("Voir la liste des livres");
        addBookButton = new JButton("Ajouter un livre");

        setLayout(new BorderLayout());
        add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonsPanel.add(viewBooksButton);
        buttonsPanel.add(addBookButton);
        add(buttonsPanel, BorderLayout.CENTER);
    }

    public JButton getViewBooksButton() {
        return viewBooksButton;
    }

    public JButton getAddBookButton() {
        return addBookButton;
    }
}
