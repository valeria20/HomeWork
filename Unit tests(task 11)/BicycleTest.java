import org.junit.Test;

import static org.junit.Assert.*;

public class BicycleTest {

    @Test
    public void testGetTime() throws Exception {
        Bicycle b=new Bicycle();
        double time=b.getTime(150);
        assertEquals(10, time, 0.1);
    }

    @Test
    public void testGetCost() throws Exception {
        Bicycle b=new Bicycle();
        double cost=b.getCost(105);
        assertEquals(0, cost, 0.1);
    }
}