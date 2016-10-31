import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void testGetTime() throws Exception {
            Car car=new Car();
            double time=car.getTime(180);
            assertEquals(2, time, 0.1);
    }

    @Test
    public void testGetCost() throws Exception {
        Car car=new Car();
        double cost=car.getCost(100);
        assertEquals(1.36, cost, 0.1);
    }
}