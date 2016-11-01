
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static junit.framework.Assert.assertEquals;

public class BusTest {
    @DataProvider(name = "time")
    public Object[][] calculateTime() {
        double nan = 1.0 / 0;
        return new Object[][]{
                {2, 120},
                {6, 006, 360.360},
                {-3, -180},
                {nan, nan}
        };
    }

    @Test(dataProvider = "time")
    public void testGetTime(double expected, double distance) throws Exception {
        Bus bus = new Bus();
        double time = bus.getTime(distance);
        assertEquals(expected, time);
    }

    @DataProvider(name = "cost")
    public Object[][] calculateCost() {
        double nan = 1.0 / 0;
        return new Object[][]{
                {1.7, 500},
                {0.4, 120.12},
                {-0, 408, -120},
                {nan, nan}
        };
    }

    @Test(dataProvider = "cost")
    public void testGetCost(double expected, double distance) throws Exception {
        Bus bus = new Bus();
        double cost = bus.getCost(distance);
        assertEquals(expected, cost);
    }
}