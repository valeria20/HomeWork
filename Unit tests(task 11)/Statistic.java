import java.util.ArrayList;

/**
 * Class that performs the travel along the route and prints statistic
 *
 * @author Valeria Sholomova
 */
public class Statistic {
    ArrayList<Movable> movableMatters = new ArrayList<Movable>();

    /**
     * Adds movableMatter to list
     *
     * @param movableMatter to add
     * @return this object
     */
    public Statistic add(Movable movableMatter) {
        movableMatters.add(movableMatter);
        return this;
    }

    /**
     * passing the route
     *
     * @param route list of points
     */
    public void goOnRoute(ArrayList<Point> route) {
        for (Movable m : movableMatters) {
            m.setStartingPoint(route.get(0));
        }
        for (int i = 1; i < route.size(); i++) {
            for (Movable m : movableMatters) {
                m.move(route.get(i));
            }
        }
    }

    /**
     * Prints a statistic about moving
     */
    public void getStatistic() {
        for (Movable m : movableMatters) {
            System.out.println(m.travellerType() + ": ");
            //System.out.println("Travel time: " + m.getTime(double distance));
            //System.out.println("Travel cost: " + m.getCost(double distance));
        }
    }
}
