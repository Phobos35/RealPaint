// Margot Laleu
import java.awt.*;
import java.io.Serializable;

abstract class Figure implements Serializable {

    protected Point origine;
    protected Color couleur;

    public abstract void setBoundingBox (int heightBB, int widthBB);
    public abstract void draw (Graphics g);

    public Figure(Point origine, Color  couleur){
        this.origine = origine;
        this.couleur = couleur;
    }

    public Point getOrigine(){
        return origine;
    }

    public Color getCouleur(){
        return couleur;
    }

    public void setOrigine(int x, int y) {
        origine.setX(x);
        origine.setY(y);
    }

    @Override
    public String toString(){
        return "L'origine de cette est figure est : "+ origine +
                "Elle est de couleur" + couleur;
    }
}

/* Figure contient :
origine : Point
couleur : Color

setBoundingBox
draw

Figure(Point, Color)

getOrigine
getColor
setOrigine

toString
 */