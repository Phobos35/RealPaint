// Margot Laleu
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileOutputStream;


public class Drawing extends JPanel implements MouseListener, MouseMotionListener {

    protected ArrayList<Figure> listFigures;
    protected ArrayList<Figure> listFiguresAnnulation = new ArrayList<Figure>();
    protected Color couleurActuelle;
    protected String nomFigureActuelle;


    protected int x;
    protected int y;

    public Drawing(){
        this.setBackground(Color.white);
        couleurActuelle = Color.black;
        nomFigureActuelle = "Rectangle";
        listFigures = new ArrayList<Figure>();
        this.setSize(800,600);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void addFigure(Figure f) { listFigures.add(f);}

    public void setCouleurActuelle(Color c){
        couleurActuelle = c;
    }

    public void setNomFigureActuelle(String f){
        nomFigureActuelle = f;
    }


@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Figure f : listFigures){
            f.draw(g);
        }
}


// Méthodes abstraites de MouseListener

@Override
    public void mousePressed(MouseEvent e){
        x = e.getX();
        y = e.getY();
        System.out.println("pressed on "+x);
        switch (nomFigureActuelle) {
            case "Ellipse":
                addFigure(new Ellipse(x, y, this.couleurActuelle));
                System.out.println("Ellipse de taille nulle ajoutée à la liste !");
                break;
            case "Rectangle":
                addFigure(new Rectangle(x, y, this.couleurActuelle));
                System.out.println("Rectangle de taille nulle ajouté à la liste !");
                break;
            case "Cercle":
                addFigure(new Circle(x, y, this.couleurActuelle));
                System.out.println("Cercle de taille nulle ajouté à la liste !");
                break;
            case "Carré":
                addFigure(new Square(x, y, this.couleurActuelle));
                System.out.println("Carré de taille nulle ajouté à la liste !");
                break;
        }
    }

@Override
    public void mouseClicked(MouseEvent e) {} // on ne s'en sert pas
    public void mouseReleased(MouseEvent e){} // on ne s'en sert pas
    public void mouseEntered(MouseEvent e){} // on ne s'en sert pas
    public void mouseExited(MouseEvent e){} // on ne s'en sert pas


// Méthodes abstraites de MouseMotionListener

@Override
    public void mouseDragged(MouseEvent e){
        if((e.getY()-y) >= 0 && (e.getX()-x) >= 0 ) {
            listFigures.get(listFigures.size()-1).setOrigine(x,y);
            listFigures.get(listFigures.size() - 1).setBoundingBox(e.getY() - y, e.getX() - x);
        }

        else if ((e.getY()-y) < 0 && (e.getX()-x) >= 0){
            if (nomFigureActuelle.equals("Carré")||nomFigureActuelle.equals("Cercle")) {
                if (Math.abs(e.getX() - x) < Math.abs(e.getY() - y)) {
                    listFigures.get(listFigures.size() - 1).setOrigine(x, e.getY());
                }
                else {
                    listFigures.get(listFigures.size() - 1).setOrigine(x, y - (e.getX() - x));
                }
            }
            else{
                    listFigures.get(listFigures.size() - 1).setOrigine(x,e.getY());
            }

            listFigures.get(listFigures.size()-1).setBoundingBox(Math.abs(e.getY() - y), e.getX()-x);
        }

        else if ((e.getY()-y) < 0 && (e.getX()-x) < 0){
            if (nomFigureActuelle.equals("Carré")||nomFigureActuelle.equals("Cercle")) {
                if (Math.abs(e.getX() - x) < Math.abs(e.getY() - y)) {
                    listFigures.get(listFigures.size() - 1).setOrigine(x - Math.abs((e.getY()-y)), e.getY());
                }
                else {
                    listFigures.get(listFigures.size() - 1).setOrigine(e.getX(), y - Math.abs((e.getX() - x)));
                }
            }
            else{
                listFigures.get(listFigures.size() - 1).setOrigine(e.getX(),e.getY());
            }

            listFigures.get(listFigures.size()-1).setBoundingBox(Math.abs(e.getY() - y), Math.abs(e.getX()-x));
        }

        else if ((e.getY()-y) >= 0 && (e.getX()-x) < 0){
            if (nomFigureActuelle.equals("Carré")||nomFigureActuelle.equals("Cercle")){
                if (Math.abs(e.getX()-x) < Math.abs(e.getY()-y)){
                    listFigures.get(listFigures.size()-1).setOrigine(x-(e.getY()-y),y);
                }
                else{
                    listFigures.get(listFigures.size()-1).setOrigine(e.getX(),y);
                }
            }
            else {
                listFigures.get(listFigures.size() - 1).setOrigine(e.getX(), y);
            }

            listFigures.get(listFigures.size() - 1).setBoundingBox(e.getY() - y, Math.abs(e.getX() - x));
        }


        this.repaint();
    }


    public void mouseMoved(MouseEvent e){} // on ne s'en sert pas

    // Les fonctions associées à mes boutons

    public void save(){
        try{
            System.out.println("sauvegarde activée");

            //Pour choisir le nom et l'emplacement du fichier
            /*//Crée un JFileChooser
            //final JFileChooser fc = new JFileChooser();
            //En réponse à un click: demande un Component en entrée
            //int returnVal = fc.showOpenDialog();
            */

            //Crée un fichier
            FileOutputStream fos = new FileOutputStream("sauvegardeDessin");
            //Permet d'écrire dans le fichier
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //O sauvegarde la taille de la figure
            oos.writeInt(listFigures.size());
            //On enregistre chaque figure de la liste en court une à une
            for(Figure f : listFigures){
                oos.writeObject(f);
            }
            oos.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("la sauvegarde a échouée");
        }

    }


    public void open(){
        try {
            FileInputStream fis = new FileInputStream("sauvegardeDessin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            //vider ma liste en court
            listFigures.clear();

            //ajouter à la liste courante les éléments de la sauvegarde
            int taille = ois.readInt(); //la taille de la liste sauvegardée était le premier élément sauvegardé dans le fichier
            for(int i=0 ; i<taille ; i++) {
                listFigures.add((Figure) ois.readObject()); // (Figure) déclare le type Object renvoyé par readObject comme un type Figure
            }

            //On dessine les éléments de la liste courante, provenant du fichier de sauvegarde
            this.repaint();

            //ferme le fichier ois une fois qu'on a récupéré ses informations dans la liste courante
            ois.close();

        }
        catch(Exception e){
            System.out.println("Le fichier n'a pas pu être ouvert");
        }

    }


    public void nouveau(){
        listFigures.clear();
        this.repaint();
    }



    public void annuler(){
        listFiguresAnnulation.add(listFigures.get(listFigures.size() - 1));
        listFigures.remove(listFigures.size() - 1);
        System.out.println("dernier élément effacé");
        this.repaint();
    }


    public void redraw(){
        listFigures.add(listFiguresAnnulation.get(listFiguresAnnulation.size() -1));
        listFiguresAnnulation.remove(listFiguresAnnulation.size()-1);
        this.repaint();
    }

}

/* Drawing contient :
listFigures : ArrayList<Figure>
couleurActuelle : Color
figureActuelle : Figure
x : int
y : int

Drawing()

addFigure
setcouleurActuelle
setNomFigureActuelle

paintComponent
mousePressed
mouseDragged

save
open
nouveau
annuler
redraw
 */