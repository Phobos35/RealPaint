import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener{

    protected Drawing myDraw = new Drawing();

    public Window(String Title, int x, int y){
        // Définition et affichage du titre et des dimensions de la fenêtre
        super(Title);
        this.setSize(x, y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // création du lieu de stockage des éléments de la fenêtre
        Container contentPanel = this.getContentPane();

        // création des Boutons de couleur et on les rend cliquable
        JButton Noir = new JButton("Noir"); // crée le bouton
        Noir.addActionListener(this);
        Noir.setBackground(Color.black); // lui donne sa couleur de fond
        Noir.setForeground(Color.white); // change la couleur du mot
        contentPanel.add(Noir); // l'ajoute dans le champ
        JButton Rouge = new JButton("Rouge");
        Rouge.addActionListener(this);
        Rouge.setBackground(Color.red);
        contentPanel.add(Rouge);
        JButton Vert = new JButton("Vert");
        Vert.addActionListener(this);
        Vert.setBackground(Color.green);
        contentPanel.add(Vert);
        JButton Bleu = new JButton("Bleu");
        Bleu.addActionListener(this);
        Bleu.setBackground(Color.blue);
        Bleu.setForeground(Color.white);
        contentPanel.add(Bleu);
        JButton Jaune = new JButton("Jaune");
        Jaune.addActionListener(this);
        Jaune.setBackground(Color.yellow);
        contentPanel.add(Jaune);
        JButton Rose = new JButton("Rose");
        Rose.addActionListener(this);
        Rose.setBackground(Color.pink);
        contentPanel.add(Rose);
        JButton Magenta = new JButton("Magenta");
        Magenta.addActionListener(this);
        Magenta.setBackground(Color.magenta);
        contentPanel.add(Magenta);
        JButton Orange = new JButton("Orange");
        Orange.addActionListener(this);
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

        // création des Boutons de Figures et on les rend cliquable
        JButton Ellipse = new JButton("Ellipse");
        Ellipse.addActionListener(this);
        contentPanel.add(Ellipse);
        JButton Cercle = new JButton("Cercle");
        Cercle.addActionListener(this);
        contentPanel.add(Cercle);
        JButton Rectangle = new JButton("Rectangle");
        Rectangle.addActionListener(this);
        contentPanel.add(Rectangle);
        JButton Carre = new JButton("Carré");
        Carre.addActionListener(this);
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
        JMenu annuler = new JMenu("Annuler");
        // On crée les propositions apparaîssant en déroulant les onglets (et on les rend cliquable)
        JMenuItem news = new JMenuItem("Nouveau");
        news.addActionListener(this);
        JMenuItem open = new JMenuItem("Ouvrir");
        open.addActionListener(this);
        JMenuItem save = new JMenuItem("Sauvegarder");
        save.addActionListener(this);
        JMenuItem quit = new JMenuItem("Quitter");
        quit.addActionListener(this);
        JMenuItem autor = new JMenuItem("Auteur");
        autor.addActionListener(this);
        JMenuItem effacer = new JMenuItem( "Annuler");
        effacer.addActionListener(this);
        // On les ajoute à l'onglet que l'on souhaite
        fichier.add(news);
        fichier.add(save);
        fichier.add(open);
        fichier.add(quit);
        aPropos.add(autor);
        annuler.add(effacer);

        // On ajoute les onglets à la barre de menu
        menuBar.add(fichier);
        menuBar.add(aPropos);
        menuBar.add(annuler);
        // On ajoute la barre de menu
        setJMenuBar(menuBar);

        // ajout du dessin au centre de mon application
        contentPanel.add(myDraw, "Center");
        //myDraw.addActionListener(this);


        this.setVisible(true);

    }









// Indique ce qui doit se passer quand on clique sur tel ou tel bouton

    @Override

    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();
        switch (cmd)
        {
            case "Noir" :
                System.out.println("couleur noire");
                myDraw.setCouleurActuelle(Color.black);
                break;
            case "Rouge" :
                System.out.println("couleur rouge");
                myDraw.setCouleurActuelle(Color.red);
                break;
            case "Bleu" :
                System.out.println("couleur bleue");
                myDraw.setCouleurActuelle(Color.blue);
                break;
            case "Vert" :
                System.out.println("couleur verte");
                myDraw.setCouleurActuelle(Color.green);
                break;
            case "Jaune" :
                System.out.println("couleur jaune");
                myDraw.setCouleurActuelle(Color.yellow);
                break;
            case "Rose" :
                System.out.println("couleur rose");
                myDraw.setCouleurActuelle(Color.pink);
                break;
            case "Magenta" :
                System.out.println("couleur magenta");
                myDraw.setCouleurActuelle(Color.magenta);
                break;
            case "Orange" :
                System.out.println("couleur orange");
                myDraw.setCouleurActuelle(Color.orange);
                break;




            case "Ellipse" :
                System.out.println("figure ellipse");
                myDraw.setNomFigureActuelle("Ellipse");
                break;
            case "Rectangle" :
                System.out.println("figure rectangle");
                myDraw.setNomFigureActuelle("Rectangle");
                break;
            case "Cercle" :
                System.out.println("figure cercle");
                myDraw.setNomFigureActuelle("Cercle");
                break;
            case "Carré" :
                System.out.println("figure carré");
                myDraw.setNomFigureActuelle("Carré");
                break;






            case "Nouveau" :
                System.out.println("I've been clicked !");
                myDraw.nouveau();
                break;
            case "Ouvrir" :
                System.out.println("I've been clicked !");
                myDraw.open();
                break;
            case "Sauvegarder" :
                System.out.println("I've been clicked !");
                myDraw.save();
                break;
            case "Quitter" :
                System.out.println("I've been clicked !");
                this.dispose();
                break;
            case "Auteur" :
                System.out.println("I've been clicked !");
                JOptionPane info = new JOptionPane();
                info.showInternalMessageDialog( info, "Auteur : Margot",
                        "information",JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Annuler" :
                System.out.println("I've been clicked !");
                myDraw.annuler();

        }
    }


    public static void main(String[] args){
        Window win = new Window("Paint", 800, 600);
    }

}

/* Window contient :
myDraw : Drawing

Window(String title, int, int)

actionPerformed

main
 */