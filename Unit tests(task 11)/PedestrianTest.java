import org.junit.Test;

import static org.junit.Assert.*;

public class PedestrianTest {

    @Test
    public void testGetTime() throws Exception {
        Pedestrian p=new Pedestrian();
        double time=p.getTime(150);
        assertEquals(30, time, 1);

    }

    @Test
    public void testGetCost() throws Exception {
        Pedestrian p=new Pedestrian();
        double cost=p.getCost(50);
        assertEquals(0, cost, 0.1);
    }
}