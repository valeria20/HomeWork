/**
 * Class consists a string user set from console
 * and method for cheking a sting has no numbers
 */
public class StringHasNoNumbers {
    /*methos firstCondition check a string shouldn't consits numbers*/
    public void firstCondition(String string1) {
        char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        /* conversation from string to char*/
        char[] chString = string1.toCharArray();
        //Count of numbers in string
        int countOfNum = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < string1.length(); j++) {
                //compliance check the number and character of the string
                if (numbers[i] == chString[j]) {
                    countOfNum++;
                }
            }
        }
        if (countOfNum == 0) {
            System.out.println("String has no numbers");
        }
    }
}

