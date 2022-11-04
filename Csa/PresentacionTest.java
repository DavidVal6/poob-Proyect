

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PresentacionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PresentacionTest
{
    @Test
    public void ciclo1()
    {
        ICPC ic1 = new ICPC(1000,1000);
        ic1.addIntersection("blue", 450, 450);
        ic1.addIntersection("red", 560, 700);
        ic1.addRoute("blue","red", 33);
        ic1.putSign("blue", "red", 22);
        ic1.removeSign("blue", "red");
        ic1.delRoad("blue","red");
        ic1.delIntersection("blue");
        ic1.delIntersection("red");
    }
    
    @Test
    public void ciclo2(){
        int[][] matriz = new int[][]{{1,3,10},{1,4,20},{1,5,25},{1,2,25},{2,6,15}};
        ICPC ic1 = new ICPC(12, matriz);
        ic1.putSign("1", "3", 14);
        ic1.putSign("1", "blue", 22);
    }
    
    @Test
    public void ciclo3(){
       int[][] matriz = new int[][]{{1,3,10},{1,4,20},{1,5,25},{1,2,25},{2,6,15}};
       ICPCContest icp1 = new ICPCContest(12,matriz);
    }
    
    @Test
    public void ciclo4Caoutious(){
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
    public void ciclo4Twin(){
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
    public void ciclo4Hermit(){
        ICPC ic1 = new ICPC(1000,1000,40);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("hermit","red",670,300);
        ic1.addIntersection("green",330,78);
        ic1.addRoute("red","blue",20);
        ic1.addRoute("red","green",10);
    }
    @Test
    public void Ciclo4Fixed(){
        ICPC ic1 = new ICPC(1000,1000,40);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("green",330,78);
        ic1.addRoute("fixed","blue","green",10);
        ic1.delRoad("blue","green");
    }
    @Test
    public void Ciclo4Needy(){
        ICPC ic1 = new ICPC(1000,1000,40);
        ic1.addIntersection("Needy","blue",20,30);
        ic1.addIntersection("Needy","red",670,300);
        ic1.addIntersection("green",330,78);
        ic1.addRoute("red","blue",20);
        ic1.addRoute("blue","green",10);
        ic1.delRoad("red","blue");
    }
    @Test
    public void ciclo4Rebel(){
        ICPC ic1 = new ICPC(1000,1000,40);
        ic1.addIntersection("blue",20,30);
        ic1.addIntersection("green",330,78);
        ic1.addRoute("Rebel","blue","green",10);
        ic1.putSign("Normal","blue", "green", 8);
    }
}
