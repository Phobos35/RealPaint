import java.awt.*;

public class Circle extends Ellipse {


    public Circle(int rayon, Color c){
        super(rayon, rayon, c);
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB){

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
        return "Ce cercle est de rayon "+ semiAxysX +"et est de couleur" + couleur;
    }

}


/* Circle contient :

Circle()

setBoundingBox
setSemiAxysX
setSemiAxysY

toString
 */