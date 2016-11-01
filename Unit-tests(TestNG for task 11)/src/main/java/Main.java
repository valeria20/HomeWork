import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * the entry point to the program
 *
 * @author Valeria Sholomova
 */
public class Main {
    /**
     * read file and print travelling statistic
     *
     * @param args-command line arguments
     */

    public static void main(String[] args) {
        RouteBuilder builder = new RouteBuilder();
        File routeFile = new File("points.txt");
        ArrayList<Point> checkpointsList = new ArrayList();
        try {
            checkpointsList = builder.buildRoute(routeFile);
        } catch (IOException e) {
            System.out.println("Reading file problems");
            System.exit(2);
        }
        System.out.println("-------Statistics--------");
        Statistic statistic = new Statistic().add(new Bicycle()).add(new Pedestrian()).add(new Car());
        statistic.add(new Car());
        statistic.add((new Pedestrian()));
        statistic.add(new Bicycle());
        statistic.add(new Bus());

        statistic.goOnRoute(checkpointsList);
        statistic.getStatistic();
    }
}

