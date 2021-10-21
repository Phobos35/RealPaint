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
    }


    public void setCouleurActuelle(Color c){
        couleurActuelle = c;
    }

    public void setNomFigureActuelle(String f){
        nomFigureActuelle = f;
    }
////?????
    public void paintComponent(){} // ?????
////?????


// Méthodes abstraites de MouseListener

    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){


    }
    public void mouseEntered(MouseEvent e){} // on ne s'en sert pas
    public void mouseExited(MouseEvent e){} // on ne s'en sert pas


// Méthodes abstraites de MouseMotionListener
    public void mouseDragged(MouseEvent e){}
        /*Figure
        int xFinal = e.getX();
        int yFinal = e.getY();
        int moveDeX =

    }*/
    public void mouseMoved(MouseEvent e){} // on ne s'en sert pas

}

/* Drawing contient :
listFigures : ArrayList<Figure>
couleurActuelle : Color
figureActuelle : Figure

Drawing

setcouleurActuelle
setNomFigureActuelle
 */