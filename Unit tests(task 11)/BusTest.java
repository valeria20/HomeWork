import org.junit.Test;

import static org.junit.Assert.*;

public class BusTest {

    @Test
    public void testGetTime() throws Exception {
        Bus bus=new Bus();
        double time=bus.getTime(60);
        assertEquals(1, time, 0.1);
    }

    @Test
    public void testGetCost() throws Exception {
        Bus bus=new Bus();
        double cost=bus.getCost(100);
        assertEquals(0.34, cost, 0.01);
    }
}