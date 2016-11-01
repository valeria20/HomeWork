import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static junit.framework.Assert.assertEquals;

public class CarTest {
    @DataProvider(name = "time")
    public Object[][] calculateTime() {
        double nan = 1.0 / 0;
        return new Object[][]{
                {2, 180},
                {4.01, 360.9},
                {-2, -180},
                {nan, nan},
        };
    }

    @Test(dataProvider = "time")
    public void testGetTime(double expected, double distance) throws Exception {
        Car car = new Car();
        double time = car.getTime(distance);
        assertEquals(expected, time);
    }


    @DataProvider(name = "cost")
    public Object[][] calculateCost() {
        double nan = 1.0 / 0;
        return new Object[][]{
                {1.36, 100},
                {4.900896, 360.360},
                {-2.448, -180},
                {nan, nan}
        };
    }

    @Test(dataProvider = "cost")
    public void testGetCost(double expected, double distance) throws Exception {
        Car car = new Car();
        double cost = car.getCost(distance);
        assertEquals(expected, cost);
    }
}