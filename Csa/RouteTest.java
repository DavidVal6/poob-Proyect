

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
    Intersection intr1 = new Intersection("blue", 120,456);
    Intersection intr2 = new Intersection("yellow", 120, 890);
    Route r1 = new Route("blue","yellow",intr1,intr2);
 }
 @Test
 public void ShouldConnect(){
    Intersection intr1 = new Intersection("blue", 120,456);
    Intersection intr2 = new Intersection("yellow", 120, 890);
    Route r1 = new Route("blue","yellow",intr1,intr2);
    r1.connect("blue","yellow");
 }
}
