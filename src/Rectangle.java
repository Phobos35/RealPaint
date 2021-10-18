import java.awt.*;

public class Rectangle extends Figure {

    protected int width;
    protected int length;

    public Rectangle (int px, int py, Color c){
        super(new Point(px, py), c);
        width = 0;
        length = 0;
    }

    public int getWidth(){
        return width;
    }

    public int getLength(){
        return length;
    }

    public void setWidth(int w){
        width = w;
    }

    public void setLength(int l){
        length = l;
    }

    public void setBoundingBox (int heightBB, int widthBB){
        width = widthBB;
        length = heightBB;
    }


    public void draw (Graphics g){

    }

    public int getPerimeter(){
        return 2*(width + length);
    }

    public int getSurface(){
        return width*length;
    }


    public String toString(){
        return "Ce rectangle a une largeur de " + width+ "et une largeur de "+ length;
    }

}


/* Rectangle contient :
width : int
length : int

Rectangle(px, py, color)

setBoundingBox
draw

getPerimeter
getSurface

getWidth
getLenght
setWidth
setLength

toString

 */