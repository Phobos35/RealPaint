// Margot Laleu
import java.awt.*;

public class Circle extends Ellipse {


    public Circle(int px,int py, Color c){
        super(px,py, c);
        System.out.println("cercle créé");
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB){
        semiAxysX = Math.max(heightBB,widthBB)/2;
        semiAxysY = semiAxysX;
    }

    public void setSemiAxysX(int x){
        semiAxysX = x;
        semiAxysY = x;
    }

    public void setSemiAxysY(int y){
        semiAxysY = y;
        semiAxysX = y;
    }

    @Override
    public String toString(){
        return "Ce cercle est de rayon "+ semiAxysX +" et est de couleur" + couleur;
    }

}


/* Circle contient :

Circle(px, py, Color)

setBoundingBox
setSemiAxysX
setSemiAxysY

toString
 */