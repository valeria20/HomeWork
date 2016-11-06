import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DefineTriangleTest {
    @DataProvider(name = "sides")
    public Object[][] enterSide() {
        double NaN = 1.0 / 0;
        return new Object[][]{
                {"Triangle with different sides.", 3, 4, 5},
                {"Triangle with different sides.", -3, -4, -5},
                {"Triangle with different sides.", 3.48, 5.56, 4.04},
                {"Triangle with different sides.", NaN, 5, 6},
        };
    }

    @Test(dataProvider = "sides")
    public void testDifferentSides(String excepted, double a, double b, double c) throws Exception {
        DefineTriangle triangle = new DefineTriangle();
        String result;
        result = triangle.differentSides(a, b, c);
        Assert.assertEquals(excepted, result);
    }

    @DataProvider(name = "lengthes")
    public Object[][] triangleSides() {
        double NaN = 1.0 / 0;
        return new Object[][]{
                {"The triangle is isosceles.", 4, 4, 3},
                {"The triangle is isosceles.", 4.5, 4.500000000000000000000001, 3},
                {"The triangle is isosceles.", 5, 5, 5}
        };
    }

    @Test(dataProvider = "lengthes")
    public void testIsoscelesTriangle(String excepted, double a, double b, double c) throws Exception {
        DefineTriangle triangle = new DefineTriangle();
        String result;
        result = triangle.isoscelesTriangle(a, b, c);
        Assert.assertEquals(excepted, result);
    }

    @DataProvider(name = "triangles sides")
    public Object[][] sides() {
        double NaN = 1.0 / 0;
        return new Object[][]{
                {"Equilateral triangle", 4, 4, 4},
                {"Equilateral triangle", 0.1, 0.1, 0.1},
                {"Equilateral triangle", NaN, NaN, NaN}
        };
    }

    @Test(dataProvider = "triangles sides")
    public void testEquilateralTriangle(String excepted, double a, double b, double c) throws Exception {
        DefineTriangle triangle = new DefineTriangle();
        String result;
        result = triangle.equilateralTriangle(a, b, c);
        Assert.assertEquals(excepted, result);
    }

    @DataProvider(name = "invalid")
    public Object[][] ivlalid() {
        double NaN = 1.0 / 0;
        return new Object[][]{
                {"A triangle with this sides  does not exist.Try again.", -1, 0, 1},
                {"A triangle with this sides  does not exist.Try again.", 3, 4, 0},
                {"A triangle with this sides  does not exist.Try again.", NaN, 4, 5},
                {"A triangle with this sides  does not exist.Try again.", 12312, 1, 1},
                {"A triangle with this sides  does not exist.Try again.", NaN, NaN, NaN},
                {"A triangle with this sides  does not exist.Try again.", 0.1, 0.1, 1},
                {"A triangle with this sides  does not exist.Try again.", 3, 4., 5}
        };
    }

    @Test(dataProvider = "invalid")
    public void testTheckForIvalidVariables(String excepted, double a, double b, double c) throws Exception {
        DefineTriangle triangle = new DefineTriangle();
        String result;
        result = triangle.checkForIvalidVariables(a, b, c);
        Assert.assertEquals(excepted, result);
    }
}
