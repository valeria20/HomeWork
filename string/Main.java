/**
 * in this class we create objects of StringHasNoNumbers,
 * StringHasOnlyNumbers and MoreThanFiveWords classes.
 * We get from console sting and transfer to firstCondition(),
 * secondCondition() and thirdCondition() methods string.
 * Apply this methods to created objects.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        String string = new String();
        Scanner in = new Scanner(System.in);
        string = in.nextLine();

        MoreThanFiveWords condition = new MoreThanFiveWords();
        condition.firstCondition(string);
        condition.secondCondition(string);
        condition.thirdCondition(string);
    }
}