import java.util.Scanner;
/*class for checking the form of a triangle using three input parameters*/
public class Triangle {
    public static void main(String[] args){
        System.out.println("Enter the lengthes of the sides of the triangle");
        Scanner in=new Scanner(System.in);
        //a, b, c-lengthes of the triangle
        double a=in.nextDouble();
        double b=in.nextDouble();
        double c=in.nextDouble();
        if(a==0||b==0||c==0){
            System.exit(2);
        }
        if((a>b+c || b>a+c || c>a+b)){
            System.out.println("A triangle with side lengths such does not exist");
        }
        if((a!=b&& b!=c && c!=a)){
            System.out.println("Triangle with different sides.");
        }
        if(((a==b && a!=c && b!=c)||(b==c && b!=a && c!=a)||(c==a && c!=b && a!=b))){
            System.out.println("The triangle is isosceles.");
        }
        if(((a==b)&&(b==c)&&(c==a))){
            System.out.println("Equilateral triangle");
        }
    }
}
