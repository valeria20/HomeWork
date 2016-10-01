/*
 Напишите программу, которая выводит в консоль “Hello, ИМЯ”, где ИМЯ берёт из командной строки.
 */
import java.util.Scanner;
public class HelloName {
        public static void main(String [] args){
            System.out.println("Enter name: ");
            Scanner in=new Scanner(System.in);
            String name=in.next(); //ввод имени из консоли
            System.out.println("Hello"+", " +name);
        }
}

