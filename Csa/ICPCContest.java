import javax.swing.JOptionPane;
import java.util.*;
/**
 * New class
 */
public class ICPCContest{
    public static int totalCost;
    public static int cost;
    private HashMap<int[],Integer> routes = new HashMap();
    private HashMap<int[],Boolean> wIsign = new HashMap();

    public ICPCContest(int cost, int[][] routesSpeedLimits){
        totalCost = 0;
        this.cost = cost;
        for(int i = 0; i < routesSpeedLimits.length;i++){
            int[] touple = new int[2];
            touple[0] = routesSpeedLimits[i][0];
            touple[1] = routesSpeedLimits[i][1];
            routes.put(touple,routesSpeedLimits[i][2]);
        }
        solve(cost,routesSpeedLimits);
        showFinalCost();
    }
    public int solve(int cost, int[][] routesSpeedLimits) {
        int velMax = -1;
        boolean flag = false;
        int diff;
        int[] routeMax = new int[2];
        for(int[] a : routes.keySet()){
            if(routes.get(a) > velMax){
                velMax = routes.get(a);
                routeMax = a;
            }
        }
        routes.remove(routeMax);

        for(int[] a : routes.keySet()){
            diff = velMax - routes.get(a);
            if(diff <= cost){
                totalCost += diff;
                routes.replace(a, routes.get(a) + diff);
                wIsign.put(a, false);
            }
            else{
                totalCost += cost;
                wIsign.put(a, true);
                flag = true;
            }
           
        }
        if(flag){
            totalCost += cost;
        }
        wIsign.put(routeMax, flag);
        int cont = 1;
        int[][] finalRoutes = new int[routesSpeedLimits.length][3];
        int[] triple = new int[3];
        triple[0] = routeMax[0];
        triple[1] = routeMax[1];
        triple[2] = velMax;
        finalRoutes[0] = triple;
        for(int[] a : routes.keySet()){
            int[] triple2 = new int[3];
            triple2[0] = (a[0]);
            triple2[1] = (a[1]);
            triple2[2] = (routes.get(a));
            finalRoutes[cont] = (triple2);
            cont++;
        }
        routes.put(routeMax, velMax);
        simulate(cost,finalRoutes);
        return totalCost;          
    }
    /**
     * This method should simulate a icpc net to make easier the solution
     * @param cost
     * @param game
     */
    public void simulate(int cost, int[][] routesSpeedLimits){
        ICPC ic1 = new ICPC(cost, routesSpeedLimits);
        for
    }
    private void showFinalCost(){
        JOptionPane.showMessageDialog(null, "The final cost was: " + totalCost);
    }
}
