// Margot Laleu
import java.awt.*;

public class Ellipse extends Figure{

    protected int semiAxysX;
    protected int semiAxysY;


    public Ellipse (int px, int py, Color c){
        super(new Point(px, py), c);
        semiAxysX = 0;
        semiAxysY = 0;
    }

    public int getSemiAxysX(){
        return semiAxysX;
    }

    public int getSemiAxysY(){
        return semiAxysY;
    }

    public void setSemiAxysX(int semiAxysX){
        this.semiAxysX = semiAxysX;
    }

    public void setSemiAxysY(int semiAxysY){
        this.semiAxysY = semiAxysY;
    }

    @Override
    public void setBoundingBox (int heightBB, int widthBB){
        semiAxysX = widthBB/2;
        semiAxysY = heightBB/2;
    }

    @Override
    public void draw (Graphics g){
        g.setColor(couleur);
        g.fillOval(origine.getX(), origine.getY(), 2*semiAxysX, 2*semiAxysY );
    }


    // Inutile pour le paint :
    public double getPerimeter(){
        return 2*Math.PI*Math.sqrt((semiAxysX^2 + semiAxysY^2)/2);
    }
    public double getSurface(){
        return Math.PI*semiAxysY*semiAxysX;
    }


    @Override
    public String toString(){
        return "Cette Ellipse a pour demi-axe selon x "+ semiAxysX +" et pour demi-axe selon y"+ semiAxysY;
    }

}


/* Ellipse contient :
semiAxysX : int
semiAxysY : int

Ellipse(px, py, color)

getsemiAxysX
getsemiAxysY
setsemiAxysX
setsemiAxysY

setBoundingBox
draw

getPerimeter
getSurface

toString
 */