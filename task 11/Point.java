/**
 * Checkpoints information
 *
 * @author Valeria
 */
public class Point {
    /*coordinates of points*/
    private double x;
    private double y;

    /**
     * constructor of points
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * return x component of point
     *
     * @return x-abscissa
     */
    public double getX() {
        return x;
    }

    /**
     * @return y component of point
     */
    public double getY() {

        return y;
    }

    /**
     * calculate distanse between points
     *
     * @parametr pt-start point
     */
    public double calculateDistanceBetweenPoints(Point pt) {
        double xDistance = Math.abs(this.x - pt.x);
        double yDistance = Math.abs(this.y - pt.x);
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }
}


