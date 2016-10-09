/**
 * Class consists a string user set from console
 * and method for cheking this string contains more
 * than five words
 *
 * @author Valeria
 */
public class MoreThanFiveWords extends StringHasOnlyNumbers {
    /*
     * thirdCondition() check our string for more
     * than 5 words the string consists.
     * Method contains massive with split symbols
     * @param sting3-text we get from console
     */
    public void thirdCondition(String string3) {
        /*
         * massive of splits we use to determine a number of words
        */
        char[] splits = {' ', ',', '!', ';', '?', '-', '(', ':'};
        /*
        conversation from string to char
        */
        char[] chString = string3.toCharArray();
        /*
         *{@value countOfWords-variable for calculating number of words in string}
         */
        int countOfWords = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < string3.length(); j++) {
                if (splits[i] == chString[j]) {
                    countOfWords++;
                }
            }
        }
        /*if countOfWords more than 5 string has more than 5 words*/
        if (countOfWords > 5) {
            System.out.println("String consists more than 5 words");
        }
    }
}
