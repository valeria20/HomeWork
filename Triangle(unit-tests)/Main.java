import java.util.Scanner;

/**
 * the entry point to the program
 *
 * @author Valeria
 */
public class Main extends DefineTriangle {
    /**
     * check the form of a triangle using three input parameters
     *
     * @param args-arguments of command line
     */

    public static void main(String[] args) {
        try {
            System.out.println("Enter the lengthes of the sides of the triangle");
            Scanner in = new Scanner(System.in);
            /**
             * a, b, c-lengthes of the triangle*
             */
            Double a = in.nextDouble();
            Double b = in.nextDouble();
            Double c = in.nextDouble();

            DefineTriangle triangle = new DefineTriangle();
            triangle.checkForIvalidVariables(a, b, c);
            triangle.differentSides(a, b, c);
            triangle.equilateralTriangle(a, b, c);
            triangle.isoscelesTriangle(a, b, c);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
