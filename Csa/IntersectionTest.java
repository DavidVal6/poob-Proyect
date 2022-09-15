

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class IntersectionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class IntersectionTest
{
    @Test
    public void shouldCreateNewIntersection(){
        ICPC can = new ICPC(1000,1000);
        Intersection intr1 = new Intersection("blue", 120,456);
        Intersection intr2 = new Intersection("yellow", 120, 890);
    }
    @Test
    public void shouldCreateMakeVisible(){
        ICPC can = new ICPC(1000,1000);
        Intersection intr1 = new Intersection("blue", 120,456);
        Intersection intr2 = new Intersection("yellow", 120, 890);
        intr1.makeVisible();
        intr2.makeVisible();
    }
    @Test
    public void shouldFindEquals(){
        ICPC can = new ICPC(1000,1000);
        Intersection intr1 = new Intersection("blue", 120,456);
        Intersection intr2 = new Intersection("blue", 120, 890);
        assertEquals(intr1,intr2);
    }
    
}
