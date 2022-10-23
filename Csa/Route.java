import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Write a description of class Routes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Route
{
    protected Line road = new Line();
    protected HashMap<String, double[]> parts = new HashMap();
    protected boolean visible = true;
    protected int velocity;
    
    public Route(String a, String b, Intersection a1, Intersection b1,int velocity){
        double[] touple2 = new double[2];
        double[] touple3 = new double[2];
        touple2[0] = a1.getX();
        touple2[1] = a1.getY();
        touple3[0] = b1.getX();
        touple3[1] = b1.getY();
        this.velocity = velocity;
        parts.put(a, touple2);
        parts.put(b, touple3);
        connect(a,b,a1,b1);
        //rotate(a, b);
    }
    public void connect(String a, String b, Intersection a1, Intersection b1){
        road.changeColor("black");
        road.changePosition(parts.get(a), 0);
        road.changePosition(parts.get(b), 1);
        road.makeVisible();
    }
    public int getSpeed(){
        return velocity;
    }
    
    // private void correctPos(String a, String b){
        // int posxA = parts.get(a)[0];
        // int posyA = parts.get(a)[1];
        // int posxB = parts.get(b)[0];
        // int posyB = parts.get(b)[1];
        // if(posxA > posxB){
            // road.moveHorizontal(posxB - posxA);
        // }else if(posyA > posyB){
            // road.moveVertical(posyB - posyA);
        // }
    // }
    // private void resize(String a, String b){
        // road.changeColor("black");
        // road.moveHorizontal(parts.get(a)[0]);
        // road.moveVertical(parts.get(a)[1]);
        // int x = (parts.get(a)[0] - parts.get(b)[0]);
        // int xsqr = x*x;
        // int y = (parts.get(a)[1] - parts.get(b)[1]);
        // int ysqr = y*y;
        // double hipotenuse = Math.sqrt(xsqr + ysqr);
        // int size = (int)Math.round(hipotenuse);
        // road.changeSize(10, size);
    // }
     // /**
     // * rotate the rectangle for connect with the intersectionB
     // */
    // private void rotate(String a, String b){
        // int x = (parts.get(a)[0] - parts.get(b)[0]);
        // int xsqr = x*x;
        // int y = (parts.get(a)[1] - parts.get(b)[1]);
        // int ysqr = y*y;
        // double hipotenuse = Math.sqrt(xsqr + ysqr);
        // if(!(parts.get(a)[1] == parts.get(b)[1])){                  //If the intersections are in the same y axis, then not rotate
                // double theta = Math.asin(x/hipotenuse);
                // road.rotate(theta);
            // }
        // if(parts.get(a)[0] == parts.get(b)[0]){//If the intersections are in the same x axis, then rotate 90 degrees
                // int size = (int) Math.round(hipotenuse);
                // road.changeSize(size, 10);
                // road.moveHorizontal(-5);
        // }
    // }
    public void draw(){
        road.makeVisible();
        visible = true;
    }

    public Line getRoad() {
        return road;
    }
    public void makeInvisible(){
        road.makeInvisible();
    }
    public void makeVisible(){
        draw();
    }
    public ArrayList<String> getParts(){
        ArrayList<String> keys = new ArrayList<>();
        Set<String> key = parts.keySet();
        for(String a : key){
            keys.add(a);
        }
        return keys;
    }
    public boolean isVisible() {
        return visible;
    }
    @Override
    public boolean equals(Object obj) {
        return equals((Route)obj);
    }
    public boolean equals(Route other){
        if((this.getParts().get(0).equals(other.getParts().get(0)))&&(this.getParts().get(1).equals(other.getParts().get(1)))){
            return true;
        }else if((this.getParts().get(0) == other.getParts().get(1))&&(this.getParts().get(1) == other.getParts().get(0))){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public String toString() {
        return "Route [parts=" + parts + ", road=" + road + "]";
    }
}
