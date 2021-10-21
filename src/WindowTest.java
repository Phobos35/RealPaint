import javax.swing.*;
import java.awt.*;

public class WindowTest extends JFrame {

    public WindowTest(String Title, int x, int y){
        super(Title);
        this.setSize(x, y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  /// ferme l'application quand on ferme la fenêtre

        Container contentPanel = this.getContentPane(); /// défini le lieu où afficher

        JMenuBar m = new JMenuBar();

        JMenu menu1 = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        menu1.add(open);
        m.add(menu1);

        JButton OkButton = new JButton("Que viva ENSEA !");
        contentPanel.add(OkButton);   /// Ajoute dans le lieu d'affichage
        JButton OkButton2 = new JButton("Que viva ENSEA...");
        contentPanel.add(OkButton2);

        //this.setVisible(true);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1,2)); // Affiche une grille de bouton de 1*2
        southPanel.add(OkButton); // donne le texte du 1er Bouton
        southPanel.add(OkButton2);// donne le texte du 2nd Bouton
        contentPanel.add(southPanel, "South"); // donne la position du bouton sur la fenêtre

        this.setVisible(true); // rend visible les bouton (le dernier élément ajouté)
    }


    public static void main(String[] args){
        WindowTest win = new WindowTest("Paint is black", 800, 600);
    }
}


