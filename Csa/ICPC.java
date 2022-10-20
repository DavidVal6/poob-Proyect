import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
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
    private ArrayList<String[]> wrongSign = new ArrayList();
    private ArrayList<String[]> unNecessarySign = new ArrayList();
    private HashMap<Intersection[], Route> routesO = new HashMap();
    private ArrayList<String[]> signsC = new ArrayList();
    private HashMap<String[], Sign> signsO = new HashMap();
    private boolean ok;
    private HashMap<Integer, int[]> posiciones = new HashMap();
    
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
     * This method works as the input from the contest
     * @param cost
     * @param roadsSpeedLimits
     */
    public ICPC(int cost, int[][] roadsSpeedLimits){
        this.width = 1000;
        this.length = 1000;
        this.cost = cost;
        fillPosiciones();
        if(isVisible){
            Canvas canvas = Canvas.getCanvas(length, width);
            canvas.wait(10);
        }
        for (int i = 1; i <= roadsSpeedLimits.length+1;++i){
            addIntersection(Integer.toString(i), this.posiciones.get(i)[0], this.posiciones.get(i)[1]);
        }
        for (int i = 0; i < roadsSpeedLimits.length;++i){
            roadSpeedLimit(Integer.toString(roadsSpeedLimits[i][0]),Integer.toString(roadsSpeedLimits[i][1]),roadsSpeedLimits[i][2]);
        }

    }
    public void roadSpeedLimit(String intersectionA, String intersectionB, int speedLimit){
        addRoute(intersectionA, intersectionB,speedLimit);
        putSign(intersectionA, intersectionB, speedLimit);
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
    public void addRoute(String a, String b,int velocity){
        Intersection touple[] = new Intersection[2];
        touple[0] = intersectionP.get(a);
        touple[1] = intersectionP.get(b);
        Intersection toupleR[] = new Intersection[2];
        toupleR[0] = intersectionP.get(b);
        toupleR[1] = intersectionP.get(a);
        Intersection[] checker = isInRoute(routesO.keySet(),touple);
        Intersection[] checkerR = isInRoute(routesO.keySet(),toupleR);
        if(checker == null && checkerR == null){
            Route r1 = new Route(a, b, touple[0], touple[1],velocity);
            routesO.put(touple, r1);
            String toupleS[] = new String[2];
            toupleS[0] = a;
            toupleS[1] = b;
            routesC.add(toupleS);
            ok = true;
        }else{
            JOptionPane.showMessageDialog(null, "This road already exists");
            ok = false;
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
            String speed = Integer.toString(speedLimit);
            String inside[] = new String[3];
            inside[0] = intersectionA;
            inside[1] = intersectionB;
            inside[2] = speed;
            if(isIn(signs(), touple, toupleR) == true){
                unNecessarySign.add(inside);
            }else{
                wrongSign.add(inside);
            }
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
        moveSign(sign, intersectionA,intersectionB);
    }
    
    private void fillPosiciones(){
        int[] pos = {500, 500};
        this.posiciones.put(1, pos);
        int[] pos2 = {700, 500};
        this.posiciones.put(2, pos2);
        int[] pos3 = {500, 300};
        this.posiciones.put(3, pos3);
        int[] pos4 = {300, 500};
        this.posiciones.put(4, pos4);
        int[] pos5 = {700, 700};
        this.posiciones.put(5, pos5);
    }
    /**
     * Move the signal over the intersection A
     */
    private void moveSign(Sign sign, String intersectionA, String intersectionB){
        int touple[] = direction(intersectionA, intersectionB);
        int x = touple[0];
        int y = touple[1];
        sign.move(x, y);
    }
    private int[] direction(String intersectionA, String intersectionB){
        int x = intersectionP.get(intersectionA).getX();
        int x1 = intersectionP.get(intersectionB).getX();
        int y1 = intersectionP.get(intersectionB).getY();
        int y = intersectionP.get(intersectionA).getY();
        int moveX ;
        int moveY ;
        if(x< x1){
            moveX = x + 30;
            moveY = y - 10;
        }else if(x > x1){
            moveX = x - 30;
            moveY = y - 10;
        }else if(y < y1){
            moveX = x + 10;
            moveY = y + 30;
        }else{
            moveX = x - 10;
            moveY = y - 30;
        }
        int[] touple = {moveX, moveY};
        return touple;
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
        Intersection toupleR[] = new Intersection[2];
        toupleR[1] = intersectionP.get(a);
        toupleR[0] = intersectionP.get(b);
        touple = isInRoute(routesO.keySet(),touple);
        toupleR = isInRoute(routesO.keySet(),toupleR);
        // routesO.get(touple).makeInvisible();
        if(touple != null){
            routesO.get(touple).makeInvisible();
            routesO.remove(touple);
            ok = true;
        }else if(toupleR != null){
            routesO.get(toupleR).makeInvisible();
            routesO.remove(toupleR);
            ok = true;
        }else{
            JOptionPane.showMessageDialog(null, "This road not exists");
            ok = false;
        }
        // //String[] toupleR = reverseTouple(touple);
        // if(isIn(routesC, touple, toupleR)){
        //     removeSign(a, b);
        //     routesC.remove(touple);
        //     String[] key = findKeyR(touple, routesO);
        //     routesO.get(key).makeInvisible();
        //     routesO.remove(key);
            
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

    public ArrayList<String[]> wronSigns(){
        return wrongSign;
    }
    public ArrayList<String[]> unNecessarySigns(){
        return unNecessarySign;
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
    private Intersection[] isInRoute(Set<Intersection[]> keys, Intersection[] touple){
        boolean flag = false;
        Intersection intersectionA = touple[0];
        Intersection intersectionB = touple[1];
        for(Intersection[] a : keys){
            if(a[0].equals(intersectionA) && a[1].equals(intersectionB)){
                return a;
            }
        }
        return null;
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
    public int getTotalSignCost(){
        int counter = 0;
        counter += cost * signsC.size();
        return counter;
    }
    public void finish(){
        int total = getTotalSignCost();
        JOptionPane.showMessageDialog(null, "Wow you finish the total cost of your net is: " + total );
        System.exit(0);
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
