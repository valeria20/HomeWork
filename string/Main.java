/**
 * in class Main we create objects of StringHasNoNumbers,
 * StringHasOnlyNumbers and MoreThanFiveWords classes.
 * We get from console sting and transfer to firstCondition(),
 * secondCondition() and thirdCondition() methods string.
 * Apply this methods to created objects.
 * @author Valeria
 */
import java.util.Scanner;
public class Main {
    /**
     * in method main() we enter string fron console,
     * create object condition of MoreThanFiveWords class.
     */
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        String string = new String();
        Scanner in = new Scanner(System.in);
        string = in.nextLine();
        /*
         *create oblect 'condition' of MoreThanFiveWords class
         */
        MoreThanFiveWords condition = new MoreThanFiveWords();
        /*
        * Apply for object 'condition' method firstCondition()
        * {@link StringHasNoNumbers#firstCondition(string1)}
        * @param string-taxt from console
        * */
        condition.firstCondition(string);
        /*
        * Apply for object 'condition' method firstCondition()
        * {@link StringHasOnlyNumbers#secondCondition(string2)}
        * @param string-taxt from console
        * */
        condition.secondCondition(string);
        /*
        * Apply for object 'condition' method firstCondition()
        * {@link MoreThanFiveWords#thirdCondition(string3)}
        * @param string-taxt from console
        * */
        condition.thirdCondition(string);
    }
}