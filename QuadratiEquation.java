import java.util.Scanner;
/*class for calculating the real roots 
of a quadratic equation*/
public class QuadratiEquation {
 public static double discriminant(double a0, double b0, double c0){ //function for calculating discriminant
     double discrim=b0*b0-4*a0*c0;
     return discrim;
 }
    public static void main(String[]args){
        System.out.println("Enter a, b, c: ");
        Scanner in=new Scanner(System.in);
        Double a=in.nextDouble();
        Double b=in.nextDouble();
        Double c=in.nextDouble();
        System.out.println(a+"*x^2+"+b+"*x+"+c+"=0");
        double discriminant=discriminant(a, b, c); //the result of calculating discriminant
        if(discriminant<0){
            System.out.println("The equation has no real roots.");
        }
        if(discriminant==0.0){
            double x=(-b)/2*a; // roots calcilation
            System.out.println("Roots: x1=x2="+x);
        }
        if(discriminant>0){
            double x1=((-b)+Math.sqrt(discriminant))/2*a;
            double x2=((-b)-Math.sqrt(discriminant))/2*a;
            System.out.println("Roots: x1="+x1 +" "+"x2="+x2);
        }
    }
}
