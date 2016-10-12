/**
 * Created by Eva on 12.10.2016.
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void Main(String[] args) {
        /*List with information about product*/
        ArrayList<Products> pList = new ArrayList<>();
    /*enter product's information*/
        Scanner in = new Scanner(System.in);
        /*
         *string variable allows user to choose action:
         * continue eintertind product's data or get information
         * about entered products
         * */
        String continueAdd;
        continueAdd = in.next();

        String productType;
        String productName;
        Double costOfOne;
        int productQuantity;
        do {
            System.out.println("Type: ");
            productType = in.nextLine();

            System.out.println("Name: ");
            productName = in.next();

            System.out.println("Cost of one product: ");
            costOfOne = in.nextDouble();

            System.out.println("Quantity: ");
            productQuantity = in.nextInt();

            Products dataList = new Products(productType, productName, productQuantity, costOfOne);
            /*
             * fill the list of information entered
             * from console by user
            * */
            pList.add(dataList);
            System.out.print("To create one more list write 'More'");
        } while (continueAdd.equals("More"));
    }
}