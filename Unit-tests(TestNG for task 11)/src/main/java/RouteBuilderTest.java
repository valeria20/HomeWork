import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class RouteBuilderTest {
    @DataProvider(name = "coordinates")
    public Object[][] coordinateCountInLine() {
        return new Object[][]{
                {"Incorrect number of coordinates in line", "3 5 6"},
                {"Incorrect number of coordinates in line", "3 3"},
                {"Incorrect number of coordinates in line", "1"},
                {"Incorrect number of coordinates in line", " "}
        };
    }

    @Test(dataProvider="coordinates")
    public void testBuildRoute(String expected, String currentLine) throws Exception {
        String message = " ";
        String[] lineParts = currentLine.split("\\s");
        if (lineParts.length != 2) {
            message = "Incorrect number of coordinates in line";
        }
        assertEquals(expected, message);
    }
    @DataProvider(name = "characters")
    public Object[][] invalidCharactars() {
        return new Object[][]{
                {"Invalid characters in file", "@2314"},
                {"Invalid characters in file", "-.!"},
                {"Invalid characters in file", "1..0"},
                {"Invalid characters in file", "--12"},
                {"Invalid characters in file", "  1"},
                {"Invalid characters in file", "1  "},
        };
    }

    @Test(dataProvider = "characters")
    public void testInvalidCharacters(String expected, String line) throws Exception {
        double x;
        double y;
        String message = " ";
        try {
            x = Double.parseDouble(line);
            y = Double.parseDouble(line);
        } catch (NumberFormatException e) {
            message = "Invalid characters in file";
        }
        assertEquals(expected, message);
    }
}
