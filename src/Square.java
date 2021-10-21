import java.awt.*;


public class Square extends Rectangle {

    public Square(int cote, Color c){
        super(cote, cote, c);
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB){
        length = Math.min(heightBB, widthBB);
        width = length;
    }

    public void setLength(int l){
        length = l;
        width = l;
    }

    public void setWidth(int w){
        width = w;
        length = w;
    }

    @Override
    public String toString(){
        return "Ce carré est de coté "+ length +"et est de couleur" + couleur;
    }

}

/* Square contient :

Square()

setBoundingBox
setLength
setWidth

toString
 */