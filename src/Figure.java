import java.awt.*;

abstract class Figure {

    protected Point origine;
    protected Color couleur;

    public abstract void setBoundingBox (int heightBB, int widthBB);
    public abstract void draw (Graphics g);

    public Figure(Point origine, Color  couleur){
        this.origine = origine;
        this.couleur = couleur;
    }

    /*public Figure(){
        origine = new Point();
        couleur = new Color();
    }
    */

    public Point getOrigine(){
        return origine;
    }

    public Color getCouleur(){
        return couleur;
    }

    public String toString(){
        return "L'origine de cette est figure est : "+ origine +
                "Elle est de couleur" + couleur;
    }
}
