/**
 * Describe info about pedestrian speed, fuel consumption, passengers
 * get cost and time of travelling
 *
 * @author Valeria Sholomova
 */
public class Pedestrian implements Movable {
    double SPEED = 5;
    int FUEL_CONSUMPTION = 0;
    double FUEL_COST = 0.68;
    double distance = 0;
    double time = 0;
    double cost = 0;

    Point currentPoint;
    Point startPoint;

    /*
    * set start point
    * @parameter pt-start point
    * */
    public void setStartingPoint(Point pt) {
        Point startPoint = pt;
        Point currentPoint = startPoint;
    }

    /*
    * calculating distance and moving
    * @parameter nextPoint- next point
    */
    public void move(Point nextPoint) {
        distance += currentPoint.calculateDistanceBetweenPoints(nextPoint);
        currentPoint = nextPoint;
    }

    /**
     * calculate time of travelling
     *
     * @return time-time of travveling
     */

    public double getTime(double distance) {
        time = distance / SPEED;
        return time;
    }
    /**
     * calculate time of travelling
     *
     * @return time-time of travveling
     */
    public double getCost(double distance) {
        cost = distance * FUEL_COST * FUEL_CONSUMPTION;
        return cost;
    }

    public String travellerType() {
        return "Pedestrian";
    }
}
