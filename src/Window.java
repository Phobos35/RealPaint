import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{



    public Window(String Title, int x, int y){
        // Définition et affichage du titre et des dimensions de la fenêtre
        super(Title);
        this.setSize(x, y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // création du lieu de stockage des éléments de la fenêtre
        Container contentPanel = this.getContentPane();

        // création des Boutons de couleur
        JButton Noir = new JButton("Noir"); // crée le bouton
        Noir.setBackground(Color.black); // lui donne sa couleur de fond
        Noir.setForeground(Color.white);
        contentPanel.add(Noir); // l'ajoute dans le champ
        JButton Rouge = new JButton("Rouge");
        Rouge.setBackground(Color.red);
        contentPanel.add(Rouge);
        JButton Vert = new JButton("Vert");
        Vert.setBackground(Color.green);
        contentPanel.add(Vert);
        JButton Bleu = new JButton("Bleu");
        Bleu.setBackground(Color.blue);
        Bleu.setForeground(Color.white);
        contentPanel.add(Bleu);
        JButton Jaune = new JButton("Jaune");
        Jaune.setBackground(Color.yellow);
        contentPanel.add(Jaune);
        JButton Rose = new JButton("Rose");
        Rose.setBackground(Color.pink);
        contentPanel.add(Rose);
        JButton Magenta = new JButton("Magenta");
        Magenta.setBackground(Color.magenta);
        contentPanel.add(Magenta);
        JButton Orange = new JButton("Orange");
        Orange.setBackground(Color.orange);
        contentPanel.add(Orange);

        // création du tabeau de boutons de couleurs
        JPanel southWestPanel = new JPanel();

        // dimentionnement du tableau de couleur et ajout des boutons puis positionnement du tableau
        southWestPanel.setLayout(new GridLayout(2,4)); // Affiche une grille de bouton de 1*2
        southWestPanel.add(Noir); // donne le texte du 1er Bouton
        southWestPanel.add(Rouge);// donne le texte du 2nd Bouton
        southWestPanel.add(Vert);
        southWestPanel.add(Bleu);
        southWestPanel.add(Jaune);
        southWestPanel.add(Rose);
        southWestPanel.add(Magenta);
        southWestPanel.add(Orange);
        //contentPanel.add(southWestPanel, "South"); // donne la position du bouton sur la fenêtre

        //this.setVisible(true);

        // création des Boutons de Figures
        JButton Ellipse = new JButton("paintPackage.Ellipse");
        contentPanel.add(Ellipse);
        JButton Cercle = new JButton("paintPackage.Circle");
        contentPanel.add(Cercle);
        JButton Rectangle = new JButton("paintPackage.Rectangle");
        contentPanel.add(Rectangle);
        JButton Carre = new JButton("paintPackage.Square");
        contentPanel.add(Carre);


        // création du tabeau de boutons de figures
        JPanel southEastPanel = new JPanel();


        southEastPanel.setLayout(new GridLayout(2,2)); // Affiche une grille de bouton de 1*2
        southEastPanel.add(Ellipse); // donne le texte du 1er Bouton
        southEastPanel.add(Cercle);// donne le texte du 2nd Bouton
        southEastPanel.add(Rectangle);
        southEastPanel.add(Carre);
        //contentPanel.add(southEastPanel, "South");

        //this.setVisible(true);

        // On crée un tableau de tableaux :
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1,2));
        southPanel.add(southWestPanel);
        southPanel.add(southEastPanel);
        contentPanel.add(southPanel, "South");

        this.setVisible(true);



        // On crée la barre de menu
        JMenuBar menuBar = new JMenuBar();
        // On crée les onglets de la barre de menu
        JMenu fichier = new JMenu("Fichier");
        JMenu aPropos = new JMenu("A Propos");
        // On crée les propositions apparaîssant en déroulant les onglets
        JMenuItem news = new JMenuItem("Nouveau");
        JMenuItem open = new JMenuItem("Ouvrir");
        JMenuItem save = new JMenuItem("Sauvegarder");
        JMenuItem quit = new JMenuItem("Quitter");
        // On les ajoute à l'onglet que l'on souhaite
        fichier.add(news);
        fichier.add(save);
        fichier.add(open);
        fichier.add(quit);

        // On ajoute les onglets à la barre de menu
        menuBar.add(fichier);
        menuBar.add(aPropos);
        // On ajoute la barre de menu
        setJMenuBar(menuBar);

        this.setVisible(true);
    }




    public static void main(String[] args){
        Window win = new Window("Paint", 800, 600);
    }

}
