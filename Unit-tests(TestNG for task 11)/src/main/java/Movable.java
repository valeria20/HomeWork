/**
 * describe movable matter  behavior
 *
 * @author Valeria Sholomova
 */
public interface Movable {
    double getTime(double distance);

    double getCost(double distance);

    String travellerType();

    void setStartingPoint(Point pt);

    void move(Point pt);
}
