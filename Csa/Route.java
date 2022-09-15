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
    private Rectangle road = new Rectangle();
    private HashMap<String, int[]> parts = new HashMap();
    private HashMap<String, Intersection>  circ = new HashMap();  
    private boolean visible = false;
    
    public Route(String a, String b, Intersection a1, Intersection b1){
        int[] touple2 = new int[2];
        int[] touple3 = new int[2];
        touple2[0] = a1.getX();
        touple2[1] = a1.getY();
        touple3[0] = b1.getX();
        touple3[1] = b1.getY();
        parts.put(a, touple2);
        parts.put(b, touple3);
    }
    public void connect(String a, String b){
        road.changeColor("black");
        road.moveHorizontal(parts.get(a)[0]);
        road.moveVertical(parts.get(a)[1]);
        resize(a, b);
        circ.get(a).makeInvisible();
        circ.get(b).makeInvisible();
        road.makeVisible();
        circ.get(a).makeVisible();
        circ.get(b).makeVisible();
    }
    private void resize(String a, String b){
        int x = (parts.get(a)[0] - parts.get(b)[0]);
        int xsqr = x*x;
        int y = (parts.get(a)[1] - parts.get(b)[1]);
        int ysqr = y*y;
        double hipotenuse = Math.sqrt(xsqr + ysqr);
        int size = (int)Math.round(hipotenuse);
        road.changeSize(10, size);
    }
    public void draw(){
        road.makeVisible();
        visible = true;
    }

    public Rectangle getRoad() {
        return road;
    }

    public ArrayList<String> getParts() {
        ArrayList<String> keys = new ArrayList<>();
        Set<String> key = parts.keySet();
        for(String a : key){
            keys.add(a);
        }
        return keys;
    }
    public HashMap<String, Intersection> getCirc() {
        return circ;
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
}
