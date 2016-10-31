import org.junit.Test;
import static org.junit.Assert.*;

public class RouteBuilderTest {
    @Test
    public void testBuildRoute() throws Exception {
        String currentLine = "3 5 7";
        String message = " ";
        String[] lineParts = currentLine.split("\\s");
        if (lineParts.length != 2) {
            message = "Incorrect number of coordinates in line";
        }
        assertEquals("Incorrect number of coordinates in line", message);
    }
    @Test
    public void TestErrorMessage() throws Exception {
        double x;
        double y;
        String s1 = "1i1";
        String s2 = "1@";
        String message=" ";
        try {
            x = Double.parseDouble(s1);
            y = Double.parseDouble(s2);
        } catch (NumberFormatException e) {
            message="Invalid characters in file";
        }
        assertEquals("Invalid characters in file", message);
    }
}
