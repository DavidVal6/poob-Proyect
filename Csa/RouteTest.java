

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RouteTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RouteTest
{
 @Test
 public void shouldCreateRoute(){
    ICPC can = new ICPC(1000,1000);
    Intersection intr1 = new Intersection("blue", 120,456);
    Intersection intr2 = new Intersection("yellow", 340, 890);
    Route r1 = new Route("blue","yellow",intr1,intr2);
 }
 @Test
 public void ShouldConnect(){
    ICPC can = new ICPC(1000,1000);
    Intersection intr1 = new Intersection("blue", 120,456);
    Intersection intr2 = new Intersection("yellow", 610, 890);
    intr1.makeVisible();
    intr2.makeVisible();
    Route r1 = new Route("blue","yellow",intr1,intr2);
 }
}
