import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Comparator;
import javax.swing.JOptionPane;
import java.lang.Math;
import java.awt.*;

/**
 * This class is a graphical representation of the ICPC problem B: The Cost of speed Limits
 * 
 * @author Olaya - Valencia
 * @1.0
 */
public class ICPC
{    
    public static int length;
    public static int width;
    public static int cost;
    public static boolean isVisible = true;
    private ArrayList<String> intersectionC = new ArrayList();
    private HashMap<String, Intersection> intersectionP = new HashMap();
    private HashMap<String, Circle> intersectionO = new HashMap();
    private ArrayList<String[]> routesC = new ArrayList();
    private HashMap<Intersection[], Route> routesO = new HashMap();
    private ArrayList<String[]> signsC = new ArrayList();
    private HashMap<String[], Sign> signsO = new HashMap();
    private boolean ok;
    
    /**
     * Create a simulation of a ICPC network
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas 
     */
    public ICPC(int length, int width){
        this.width = width;
        this.length = length;
        if(isVisible){
            Canvas canvas = Canvas.getCanvas(length, width);
            canvas.wait(10);
        }
    }

    public ICPC(int length, int width, int cost){
        this.width = width;
        this.length = length;
        this.cost = cost;
        if(isVisible){
            Canvas canvas = Canvas.getCanvas(length, width);
            canvas.wait(10);
    }
}
    
    /**
     * Add the new intersection to the canvas
     * @param color the desired color and identification of the intersection (should be unique)
     * @x y the desired position of the intersecion in the canvas
     */
    public void addIntersection(String color, int x, int y){
        if(!intersectionP.containsKey(color)){
            Intersection intr1 = new Intersection(color, x, y);
            intersectionP.put(color, intr1);
            createIntersection(color);
            ok = true;
            intersectionC.add(color);
        }else{
            JOptionPane.showMessageDialog(null, "This intersection already exists");
            ok = false;
        }
    }
    
    /**
     * Create the intersection in the canvas
     */
    private void createIntersection(String key){
        intersectionP.get(key).makeVisible();
    }

    
    /**
     * Add the new road to the canvas
     * @param intersectionA and intersectionB indicates the begin and the end of the route 
     */
    public void addRoute(String a, String b){
        Intersection touple[] = new Intersection[2];
        touple[0] = intersectionP.get(a);
        touple[1] = intersectionP.get(b);
        if(!routesO.containsKey(touple)){
            Route r1 = new Route(a, b, touple[0], touple[1]);
            routesO.put(touple, r1);
            String toupleS[] = new String[2];
            toupleS[0] = a;
            toupleS[1] = b;
            routesC.add(toupleS);
        }
    }
        // if(isIn(routesC, touple, toupleR) == false){
        //     routesC.add(touple);
        //     createRoute(intersectionA, intersectionB, touple);
        //     ok = true;
    //     }else{
    //         JOptionPane.showMessageDialog(null, "This road already exists");
    //         ok = false;
    //     } 
    // }
    
    // /**
    //  * Create the route in the canvas
    //  */
    // private void createRoute(String intersectionA, String intersectionB, String[] touple){
    //     Rectangle rect = new Rectangle();
    //     rect.changeColor("black");
    //     rect.moveHorizontal(intersectionP.get(intersectionA)[0]);
    //     rect.moveVertical(intersectionP.get(intersectionA)[1]);
    //     routesO.put(touple, rect);
    //     resize(rect, intersectionA, intersectionB);
    //     rotate(rect, intersectionA, intersectionB);
    //     intersectionO.get(intersectionA).makeInvisible();
    //     intersectionO.get(intersectionB).makeInvisible();
    //     rect.makeVisible();
    //     intersectionO.get(intersectionA).makeVisible();
    //     intersectionO.get(intersectionB).makeVisible();
    // }
    
    // /**
    //  * Resize the rectangle to the correct dimensions to the road
    //  */
    // private void resize(Rectangle rect, String intersectionA, String intersectionB){
    //     int x = (intersectionP.get(intersectionA)[0] - intersectionP.get(intersectionB)[0]);
    //     int xsqr = x*x;
    //     int y = (intersectionP.get(intersectionA)[1] - intersectionP.get(intersectionB)[1]);
    //     int ysqr = y*y; 
    //     double hipotenuse = Math.sqrt(xsqr + ysqr);
    //     int size = (int) Math.round(hipotenuse);
    //     rect.changeSize(10, size);
    // }
    
    // /**
    //  * rotate the rectangle for connect with the intersectionB
    //  */
    // private void rotate(Rectangle rect, String intersectionA, String intersectionB){
    //     int x = (intersectionP.get(intersectionA)[0] - intersectionP.get(intersectionB)[0]);
    //     int xsqr = x*x;
    //     int y = (intersectionP.get(intersectionA)[1] - intersectionP.get(intersectionB)[1]);
    //     int ysqr = y*y; 
    //     double hipotenuse = Math.sqrt(xsqr + ysqr);
    //     if(!(intersectionP.get(intersectionA)[1] == intersectionP.get(intersectionB)[1])){                  //If the intersections are in the same y axis, then not rotate
    //             double theta = Math.asin(x/hipotenuse);
    //             rect.rotate(theta);
    //         }
    //     if(intersectionP.get(intersectionA)[0] == intersectionP.get(intersectionB)[0]){        //If the intersections are in the same x axis, then rotate 90 degrees
    //             int size = (int) Math.round(hipotenuse);
    //             System.out.println("Hi");
    //             rect.changeSize(size, 10);
    //             rect.moveHorizontal(-5);
    //     }
    // }
    
    /**
     * Put a sign in the canvas of the simulation
     * @param intersectionA and intersectionB indicates the road that going to have the sign
     * @param speedLimit indicates the value of the sign
     */
    public void putSign(String intersectionA, String intersectionB, int speedLimit){
        String[] touple = new String[2];
        touple[0] = intersectionA;
        touple[1] = intersectionB;
        String[] toupleR = reverseTouple(touple);
        if(isIn(signsC, touple, toupleR) == false && isIn(routesC, touple, toupleR) == true){
            signsC.add(touple);
            createSign(intersectionA, intersectionB, speedLimit, touple);            
            ok = true;
        }else{
            JOptionPane.showMessageDialog(null, "This sign already exists or the route not exists");
            ok = false;
        }
    }
    
    /**
     * Create the sign in the canvas
     */
    private void createSign(String intersectionA, String intersectionB, int speedLimit, String[] touple){
        String speed = String.valueOf(speedLimit);
        Sign sign = new Sign(speed);
        signsO.put(touple, sign);
        moveSign(sign, intersectionA);
    }
    
    /**
     * Move the signal over the intersection A
     */
    private void moveSign(Sign sign, String intersectionA){
        int x = intersectionP.get(intersectionA).getX();
        int y = intersectionP.get(intersectionA).getY();
        int moveX = x + 30;
        int moveY = y - 10;
        sign.move(moveX, moveY);
    }
    
    /**
     * Delete an intersection from the simulation
     * @param color indicates the intersection that wants delete
     */
    public void delIntersection(String color){
        if(intersectionP.containsKey(color)){
            intersectionO.get(color).makeInvisible();
            ok = true;
        }else{
            JOptionPane.showMessageDialog(null, "This intersection not exists");
            ok = false;
        }
    }
    
    /**
     * Delete a road from the simulation
     * @param intersectionA and intersectionB indicates the road that wants delete
     */
    public void delRoad(String a, String b){
        Intersection touple[] = new Intersection[2];
        touple[0] = intersectionP.get(a);
        touple[1] = intersectionP.get(b);
        // routesO.get(touple).makeInvisible();
        if(routesO.containsKey(touple)){
            System.out.println("Si esta");
        }else{
            System.out.println("No esta");
        }
        routesO.remove(touple);
        //String[] toupleR = reverseTouple(touple);
        // if(isIn(routesC, touple, toupleR)){
        //     removeSign(a, b);
        //     routesC.remove(touple);
        //     String[] key = findKeyR(touple, routesO);
        //     routesO.get(key).makeInvisible();
        //     routesO.remove(key);
            ok = true;
        // }else{
            // JOptionPane.showMessageDialog(null, "This road not exists");
            // ok = false;
        // }
    }
    
    /**
     * Remove a specific sign from the canvas of the simulation
     * @param intersectionA and intersectionB indicates the road that going to have the sign
     */
    public void removeSign(String intersectionA, String intersectionB){
        String[] touple = new String[2];
        touple[0] = intersectionA;
        touple[1] = intersectionB;
        String[] toupleR = reverseTouple(touple);
        if(isIn(signsC, touple, toupleR)){
            signsC.remove(touple);
            String[] key = findKeyS(touple, signsO);
            signsO.get(key).makeInvisible();
            signsO.remove(key);
            ok = true;
        }else{
            JOptionPane.showMessageDialog(null, "This sign not exists");
            ok = false;
        }     
    }
    
    /**
     * return if the last method was successfully finished 
     */
    public boolean ok(){
        return ok;
    }
    
    /**
     * return the collection of the intersections in the simulation
     */
    public String[] intersections(){
        String[] intersections = new String[intersectionC.size()];
        for(int i = 0; i < intersectionC.size(); i++){
            intersections[i] = intersectionC.get(i);
        }
        return intersections;
    }
    
    /**
     * return the collection of the routes in the simulation
     */
    public String[][] roads(){
        String[][] roads = new String[routesC.size()][];
        for(int i = 0; i < routesC.size(); i++){
            roads[i] = routesC.get(i);
        }
        return roads;
    }
    public ArrayList<String[]> signs(){
        return signsC;
    }
    
    /**
     * Makes visible the canvas with the simulation
     */
    public void makeVisible(){
        if(!isVisible){
            for(String key: intersectionO.keySet()){
                intersectionO.get(key).makeVisible();
            }
            for(String[] key: signsO.keySet()){
                signsO.get(key).move(0,0);
            }
            isVisible = true;
        }
    }
    public int getSpeedLimit(String speed){
        return signsO.get(speed).speedLimit();

    }
    
    /**
     * Makes invisible the canvas with the simulation
     */
    public void makeInvisible(){
        if(isVisible){
            for(String key: intersectionO.keySet()){
                intersectionO.get(key).makeInvisible();
            }
            for(Intersection[] key: routesO.keySet()){
                routesO.get(key).makeInvisible();
            }
            for(String[] key: signsO.keySet()){
                signsO.get(key).makeInvisible();
            }
            isVisible = false;
        }
        
    }
    
    /**
     * Return if the touples are contains in the Arrays
     */
    private boolean isIn(ArrayList<String[]> x, String[] touple, String[] toupleR){
        boolean flag = false;
        for(int i = 0; i < x.size() && flag == false; i++){
                flag = Arrays.equals(x.get(i), touple) ||  Arrays.equals(x.get(i), toupleR);
        } 
        return flag;
    }
    
    /**
     * Return if an intersection is hava an associated road
     */
    private boolean isInRoute(String color){
        boolean flag = false;
        for(int i = 0; i < routesC.size() && flag == false; i++){
            flag = Arrays.asList(routesC.get(i)).contains(color);
        }
        return flag;
    }
    /**
     * Return the reverse of a touple
     */
    private String[] reverseTouple(String[] touple){
        String[] reverse = new String[2];
        reverse[0] = touple[1];
        reverse[1] = touple[0];
        return reverse;
    }
    
    /**
     * Find the key of the HashMap that is equals to a parameter
     * @param a touple to compare
     */
    private String[] findKeyR(String[] touple, HashMap<String[], Rectangle> hash){
        for(String[] key : hash.keySet()){
            if(Arrays.equals(key, touple)){
                return key;
            }
        }
        return null;
    }
    
    /**
     * Find the key of the HashMap that is equals to a parameter
     * @param a touple to compare
     */
    private String[] findKeyS(String[] touple, HashMap<String[], Sign> hash){
        for(String[] key : hash.keySet()){
            if(Arrays.equals(key, touple)){
                return key;
            }
        }
        return null;
    }
}
