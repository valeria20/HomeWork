import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

import static org.junit.Assert.*;

public class BicycleTest {
    double nan = 1.0 / 0;

    @DataProvider(name = "time")
    public Object[][] calculateTime() {
        return new Object[][]{
                {12, 180},
                {24.06, 360.9},
                {nan, nan},
                {-12, -180},
        };
    }

    @Test(dataProvider = "time")
    public void testGetTime(double expected, double distance) throws Exception {
        Bicycle b = new Bicycle();
        double time = b.getTime(distance);
        assertEquals(expected, distance);
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
    public void testGetCost(double expected, double distance) throws Exception {
        Bicycle b = new Bicycle();
        double cost = b.getCost(distance);
        assertEquals(expected, cost);
    }
}