
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class PedestrianTest {
    double nan = 1.0 / 0;

    @DataProvider(name = "time")
    public Object[][] calculateTime() {
        return new Object[][]{
                {36, 180},
                {72.18, 360.9},
                {nan, nan},
                {-2, -180},
        };
    }

    @Test(dataProvider = "time")
    public void testGetTime(double expected, double distance) throws Exception {
        Pedestrian p = new Pedestrian();
        double time = p.getTime(distance);
        assertEquals(expected, time);

    }

    @DataProvider(name = "cost")
    public Object[][] calculateCost() {
        return new Object[][]{
                {0, 180},
                {0, 360.9},
                {nan, nan},
                {0, -180},
        };
    }

    @Test
    public void testGetCost(double expexted, double distance) throws Exception {
        Pedestrian p = new Pedestrian();
        double cost = p.getCost(distance);
        assertEquals(expexted, distance);
    }
}