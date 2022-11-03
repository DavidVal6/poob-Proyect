

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
        ic1.addRoute("blue","red",12);
    }
    @Test
    public void shouldEliminateRoute(){
        ICPC ic1 = new ICPC(1000,1000);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("red",20,780);
        ic1.addRoute("blue","red",12);
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
        ic1.addRoute("blue","red",12);
        String[][] ans = ic1.roads();
        assertEquals(1,ans.length);
    }
    @Test
    public void shouldAddSign(){
        ICPC ic1 = new ICPC(1000,1000);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("red",20,780);
        ic1.addRoute("blue","red",12);
        ic1.putSign("blue", "red",30);
    }
    @Test
    public void shouldEliminateSign(){
        ICPC ic1 = new ICPC(1000,1000);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("red",20,780);
        ic1.addRoute("blue","red",12);
        ic1.putSign("blue", "red",30);
        ic1.removeSign("blue", "red");
        //ArrayList<String[]> signs = ic1.signs();
        //assertEquals(0,signs.size());
    }
    @Test
    public void shouldGaveMeThetotalCost(){
        ICPC ic1 = new ICPC(1000,1000,40);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("red",20,780);
        ic1.addRoute("blue","red",30);
        ic1.addIntersection("yellow",140,30);
        ic1.addRoute("blue","yellow",12);
        ic1.putSign("blue", "red",30);
        ic1.putSign("blue", "yellow",12);
        assertEquals(80,ic1.getTotalSignCost());
    }
    @Test
    public void shouldShowMessage(){
        ICPC ic1 = new ICPC(1000,1000,40);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("red",20,780);
        ic1.addRoute("blue","red",30);
        ic1.addIntersection("yellow",140,30);
        ic1.addRoute("blue","yellow",20);
        ic1.putSign("blue", "red",30);
        ic1.putSign("blue", "yellow",20);
        ic1.finish();
    }
    @Test
    public void ShouldProveICPC(){
        ICPC ic1 = new ICPC(1000,1000);
    }
    @Test
    public void shouldMakeICPC(){
        //ICPC newIc = new ICPC(2,{{1,2,10},{2,3,7},{3,5,5},{2,4,9}});
        
    }
    @Test
    public void shouldWorkxd(){
        ICPC ic1 = new ICPC(1000,1000,40);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("red",67,30);
        ic1.addRoute("red","blue",20);
    }
    @Test
    public void shouldPutRightCautious(){
        ICPC ic1 = new ICPC(1000,1000,40);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("red",670,300);
        ic1.addIntersection("green",330,78);
        ic1.addRoute("red","blue",20);
        ic1.addRoute("red","green",10);
        ic1.putSign("cautious", "blue", "red", 70);
        ic1.putSign("cautious", "red", "green", 8);
    }
    @Test
    public void shouldPutRightTwins(){
        ICPC ic1 = new ICPC(1000,1000,40);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("red",670,300);
        ic1.addIntersection("green",330,78);
        ic1.addIntersection("yellow",160,780);
        ic1.addRoute("red","blue",20);
        ic1.addRoute("yellow","green",10);
        ic1.putSign("twin", "blue", "red", 70);
        ic1.putSign("twin", "yellow", "green", 8);
    }
    @Test
    public void shouldNotPutRoute(){
        ICPC ic1 = new ICPC(1000,1000,40);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("hermit","red",670,300);
        ic1.addIntersection("green",330,78);
        ic1.addRoute("red","blue",20);
        ic1.addRoute("red","green",10);
    }
    @Test
    public void shouldNotDelRoute(){
        ICPC ic1 = new ICPC(1000,1000,40);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("green",330,78);
        ic1.addRoute("fixed","blue","green",10);
        ic1.delRoad("blue","green");
    }
    @Test
    public void shouldMakeInvisible(){
        ICPC ic1 = new ICPC(1000,1000,40);
        ic1.addIntersection("Needy","blue",20,30);
        ic1.addIntersection("Needy","red",670,300);
        ic1.addIntersection("green",330,78);
        ic1.addRoute("red","blue",20);
        ic1.addRoute("blue","green",10);
        ic1.delRoad("red","blue");
    }
    @Test
    public void sholdCreateUnnecesary(){
        ICPC ic1 = new ICPC(1000,1000);
        ic1.addIntersection("red", 200, 200);
        ic1.addIntersection("blue", 600, 600);
        ic1.addRoute("red","blue", 10);
        ic1.putSign("red", "blue", 8);
        ic1.putSign("red","blue", 7);
    }
}
