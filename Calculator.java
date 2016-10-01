/*Напишите «калькулятор», который принимает из командной строки два числа и
  выводит в консоль их сумму, разность, произведение и частное.
 */
public class Calculator {

    public static double sum(double num1, double num2){ //method for sum
    double resultOfSum=num1+num2;
        return resultOfSum;
}
    public static double subtraction(double num1, double num2){ //method for substraction
        double resultOfSub=num1-num2;
        return resultOfSub;
    }
    public static double multiplication(double num1, double num2){//method for multiplication
        double resultOfMultiplic=num1*num2;
        return resultOfMultiplic;
    }

    public static double division(double num1, double num2){ //method for division
        double resultOfDiv=num1/num2;
        return resultOfDiv;
    }

    public static void main(String[] args){
        double number1=Double.parseDouble(args[0]); //from string to double
        double number2=Double.parseDouble(args[1]);

        double resOfSum=sum(number1, number2);
        double resOfSub=subtraction(number1, number2);
        double resOfMultiplic=multiplication(number1, number2);
        double resOfDiv=division(number1, number2);

        System.out.println("Результат сложения: "+resOfSum);
        System.out.println("Результат вычитания: "+resOfSub);
        System.out.println("Результат умножения: "+resOfMultiplic);
        System.out.println("Результат деления: "+resOfDiv);
    }

}
