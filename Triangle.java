/* Написать программу, получающую с клавиатуры длины трёх сторон треугольника, и выводящую на экран информацию о том, является ли этот треугольник
равносторонним;равнобедренным;«обычным»
 */
import java.util.Scanner;
public class Triangle {
    public static void main(String[] args){
        System.out.println("Введите длины сторон треугольника");
        Scanner in=new Scanner(System.in);
        //a, b, c-длины сторон треугольника
        double a=in.nextDouble();
        double b=in.nextDouble();
        double c=in.nextDouble();

        if(a==0||b==0||c==0){
            System.exit(2);
        }
        if((a>b+c || b>a+c || c>a+b)){
            System.out.println("Треугольник с такими длинами сторон не существует");
        }

        if((a!=b&& b!=c && c!=a)){
            System.out.println("Треугольник разносторонний");
        }
        if(((a==b && a!=c && b!=c)||(b==c && b!=a && c!=a)||(c==a && c!=b && a!=b))){
            System.out.println("Треугольник равнобедренный");
        }
        if(((a==b)&&(b==c)&&(c==a))){
            System.out.println("Треугольник равносторонний");
        }

    }
}
