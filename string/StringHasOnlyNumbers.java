/*
 * Class consists a string user set from console
 * and method for cheking a sting has only numbers
 */
public class StringHasOnlyNumbers extends StringHasNoNumbers {
    /*methos firstCondition check a string
     *should consits only numbers
    */
    public void secondCondition(String string2) {
        char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        /* conversation from string to char*/
        char[] chString = string2.toCharArray();
        /*
         *check-variable that will change their value for 1 if
         *the string does not contain only numbers
        */
        int check = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < string2.length(); j++) {
                if (numbers[i] == chString[j] && chString[i] != ' ') {
                    check = 1;
                } else check = 0;
            }
        }
        /*if 'check' change value for 1 string has only numbers*/
        if (check == 1) {
            System.out.println("String consists only numbers");
        }
    }
}
