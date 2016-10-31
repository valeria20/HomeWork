import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;

/**
 * @author Valeria Sholomova
 */
public class RouteBuilder {
    /*list with points*/
    private ArrayList<Point> route = new ArrayList<Point>();

    /**
     * Builds route using information about points from file
     *
     * @param checkpointFile - file with points
     * @return route
     * @throws IOException - if IO error occurs
     */
    public ArrayList<Point> buildRoute(File checkpointFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(checkpointFile));
        String currentLine;
        while (((currentLine = reader.readLine()) != null)) {
            String[] lineParts = currentLine.split("\\s");
            if (lineParts.length != 2) {
                System.out.println("Incorrect number of coordinates in line");
                System.exit(2);
            }
            double x;
            double y;
            try {
                x = Double.parseDouble(lineParts[0]);
                y = Double.parseDouble(lineParts[1]);
                route.add(new Point(x, y));
            } catch (NumberFormatException e) {
                System.out.println("Invalid characters in file");
            }
        }
        return route;
    }
}


