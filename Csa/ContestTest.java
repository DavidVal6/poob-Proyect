

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ContestTest.
 *
 * @author  (Olaya - Valencia )
 * @version (a version number or a date)
 */
public class ContestTest
{   
    @Test
    public void shouldSolve()
    {   
        int[][] matriz = {{1,2,10},{1,3,5},{1,4,7},{2,5,9}};
        ICPCContest ic1 = new ICPCContest(2, matriz);
        assertEquals(7,ic1.totalCost);
    }
    @Test
    public void shouldChangeTheCost()
    {   
        int[][] matriz = {{1,2,10},{1,3,5},{1,4,7},{2,5,9}};
        ICPCContest ic1 = new ICPCContest(100, matriz);
        assertEquals(100,ic1.cost);
    }
}
