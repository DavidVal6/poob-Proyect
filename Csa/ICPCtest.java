

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
