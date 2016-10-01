/**
 Написать программу для поиска действительных корней квадратного уравнения
 ax^2 + bx + c = 0. Корректно обработать случай, когда дискриминант равен нулю.

 */
import java.util.Scanner;
public class QuadratiEquation {
 public static double discriminant(double a0, double b0, double c0){ //функция для вычисления дискриминанта
     double discrim=b0*b0-4*a0*c0;
     return discrim;
 }
    public static void main(String[]args){
        System.out.println("Введите a, b, c: ");
        Scanner in=new Scanner(System.in);
        Double a=in.nextDouble();
        Double b=in.nextDouble();
        Double c=in.nextDouble();
        System.out.println(a+"*x^2+"+b+"*x+"+c+"=0");
        double discriminant=discriminant(a, b, c); //результат вычисления дискриминанта
        if(discriminant<0){
            System.out.println("Уравнение не имеет действительных корней.");
        }
        if(discriminant==0){
            double x=(-b)/2*a; //нахождение корня уравнения
            System.out.println("Корни уравнения: x1=x2="+x);
        }
        if(discriminant>0){
            double x1=((-b)+Math.sqrt(discriminant))/2*a;
            double x2=((-b)-Math.sqrt(discriminant))/2*a;
            System.out.println("Корни уравнения: x1="+x1 +" "+"x2="+x2);
        }

    }
}
