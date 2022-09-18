

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * The test class ICPCtest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ICPCtest
{
    @Test
    public void shouldCreateIcpc(){
        ICPC ic1 = new ICPC(1000,1000);
    }
    @Test
    public void shouldAddIntersection(){
        ICPC ic1 = new ICPC(1000,1000);
        ic1.addIntersection("blue",20,30);
    }
    @Test
    public void shouldAddRoute(){
        ICPC ic1 = new ICPC(1000,1000);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("red",20,780);
        ic1.addRoute("blue","red");
    }
    @Test
    public void shouldEliminateRoute(){
        ICPC ic1 = new ICPC(1000,1000);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("red",20,780);
        ic1.addRoute("blue","red");
        ic1.delRoad("blue","red");
    }
    @Test
    public void shouldReturnTheIntersections(){
        ICPC ic1 = new ICPC(1000,1000);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("red",20,780);
        String[] ans = ic1.intersections();
        assertEquals(2,ans.length);
    }
    @Test
    public void shouldReturnTheRoutes(){
        ICPC ic1 = new ICPC(1000,1000);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("red",20,780);
        ic1.addRoute("blue","red");
        String[][] ans = ic1.roads();
        assertEquals(1,ans.length);
    }
    @Test
    public void shouldAddSign(){
        ICPC ic1 = new ICPC(1000,1000);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("red",20,780);
        ic1.addRoute("blue","red");
        ic1.putSign("blue", "red",30);
    }
    @Test
    public void shouldEliminateSign(){
        ICPC ic1 = new ICPC(1000,1000);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("red",20,780);
        ic1.addRoute("blue","red");
        ic1.putSign("blue", "red",30);
        ic1.removeSign("blue", "red");
        //ArrayList<String[]> signs = ic1.signs();
        //assertEquals(0,signs.size());
    }
}
