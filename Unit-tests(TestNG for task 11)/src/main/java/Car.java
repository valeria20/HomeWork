/**
 * Describe info about car speed, fuel consumption, passengers
 * get cost and time of travelling
 *
 * @author Valeria Sholomova
 */
public class Car implements Movable {
    double SPEED = 90;
    int FUEL_CONSUMPTION = 2;
    double FUEL_COST = 0.68;
    int PASSENGERS = 1;
    Point currentPoint;
    double distance = 0;
    double time = 0;
    double cost = 0;

    /**
     * set start point
     *
     * @parameter pt-start point
     */

    public void setStartingPoint(Point pt) {
        Point startPoint = pt;
        Point currentPoint = startPoint;
    }

    /**
     * calculating distance
     *
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
     * calculate cost of travelling
     *
     * @return cost-cost of travelling
     */
    public double getCost(double distance) {
        cost = distance * FUEL_COST * FUEL_CONSUMPTION / (100 * PASSENGERS);
        return cost;
    }

    public String travellerType() {
        return "Car";
    }

}
