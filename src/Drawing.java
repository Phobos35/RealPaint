import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener {

    protected ArrayList<Figure> listFigures;
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
        //g.fillOval(200, 200, 100, 100);
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
 */