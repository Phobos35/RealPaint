import java.io.Serializable;

public class Point implements Serializable {
    private int x;
    private int y;

    public Point(int a, int b){
        x=a;
        y=b;
    }

    public Point(){
        x=0;
        y=0;
    }

    public int getX(){
        return x;
    }

    public int getY(){
       return y;
    }

    public void setX(int a){
        x=a;
    }

    public void setY(int a){
        y=a;
    }

    @Override
    public String toString(){
        return "("+x+";"+y+")";
    }
}

/* Point contient :
x : int
y : int

Point(int, int)
Point()

getX
getY
setX
setY

toString
 */