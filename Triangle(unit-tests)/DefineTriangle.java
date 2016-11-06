/**
 * Class contains methods for checking type of triangle
 *
 * @author Valeria
 */
public class DefineTriangle {
    /**
     * check triangle for a different sides
     *
     * @param a side of triangle
     * @param b side of triangle
     * @param c side of triangle
     */

    public String checkForIvalidVariables(double a, double b, double c){
        if (a == 0 || b == 0 || c == 0||a > b + c || b > a + c || c > a + b) {
            System.out.println("A triangle with this sides  does not exist.Try again.");
        }
        return "A triangle with this sides  does not exist.Try again.";
    }
    public String differentSides(double a, double b, double c) {
        if ((a != b && b != c && c != a)) {
            System.out.println("Triangle with different sides.");
        }
        return "Triangle with different sides.";
    }
    /**
     * check triangle for isosceles
     *
     * @param a side of triangle
     * @param b side of triangle
     * @param c side of triangle
     */
    public String isoscelesTriangle(double a, double b, double c) {
        if (((a == b && a != c && b != c) || (b == c && b != a && c != a) || (c == a && c != b && a != b))) {
            System.out.println("The triangle is isosceles.");
        }
        return "The triangle is isosceles.";
    }

    /**
     * check triangle for equilateral
     *
     * @param a side of triangle
     * @param b side of triangle
     * @param c side of triangle
     */
    public String equilateralTriangle(double a, double b, double c) {
        if (((a == b) && (b == c) && (c == a))) {
            System.out.println("Equilateral triangle");
        }
        return "Equilateral triangle";
    }
}
