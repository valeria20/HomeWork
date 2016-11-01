/**
 The class is used to perform 
the method for calculating the amount of 
subtraction multiplication and division of two numbers 
we get from command line
@author Valeria Sholomova
*/

public class Calculator {
    public static double sum(double num1, double num2){ //method for sum
        //variable for saving the result  sim
		double resultOfSum=num1+num2;
        return resultOfSum;
    }
    public static double subtraction(double num1, double num2){ //method for substraction
        //variable for saving the result of substraction
		double resultOfSub=num1-num2;
        return resultOfSub;
    }
    public static double multiplication(double num1, double num2){//method for multiplication
        //variable for saving the result  multiplication
		double resultOfMultiplic=num1*num2;
        return resultOfMultiplic;
    }
    public static double division(double num1, double num2){ //method for division
       //variable for saving the result division
	   double resultOfDiv=num1/num2;
        return resultOfDiv;
    }
    public static void main(String[] args){
        //args length check. there are should be only two arguments
        if(args.length<=1 || args.length>2){
            System.out.println("Enter only two arguments.");
            System.exit(2);
        }
        double number1=Double.parseDouble(args[0]); //from string to double
        double number2=Double.parseDouble(args[1]);
        double resOfSum=sum(number1, number2);
        double resOfSub=subtraction(number1, number2);
        double resOfMultiplic=multiplication(number1, number2);
        double resOfDiv=division(number1, number2);
        System.out.println("Result of sum: "+resOfSum);
        System.out.println("Result of subtraction: "+resOfSub);
        System.out.println("Result of multiplication: "+resOfMultiplic);
        //check division by 0
        if(number2==0){
            System.out.println("Result of division: Error. Division by 0.");
        }
        else{
            System.out.println("Result of division: "+resOfDiv);
			}
    }
}
