package Interfaces;
import ComposantsInterfaces.MenuBar;
import javax.swing.JFrame;
public class Frame extends JFrame {

    public Frame(){
        super("Gestion de Bibliotheque");

        // définition des propriétés et des événements de composants  ici
    }
    public void setMenuBar(MenuBar menuBar) {
        setJMenuBar(menuBar);
    }


    // Ajout des méthodes spécifiques de composants si nécessaire



}
