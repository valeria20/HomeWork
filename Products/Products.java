/**
 * class Products describes product's features
 * @author Valeria
 */
public class Products {
    public String productType;
    public String productName;
    public int productQuantity;
    public double costOfOne;
    /*
    * method for entering data of product's features
    * @param costOfOne - cost of one product
    * @param productName -name of product
    * @param productType -type of product
    * @param productQuantity -quantuty of product
    * */
    public Products(String productType, String productName, int productQuantity, double costOfOne){
        this.productType=productType;
        this.productName=productName;
        this.productQuantity=productQuantity;
        this.costOfOne=costOfOne;
    }
    /*
    * method gets type of product
    * @return productType-type of product
    * */
    public String getProductType(){
        return productType;
    }
    /*
    * method gets name of product
    * @return productName-name of product
    * */
    public String getProductName(){
        return productName;
    }
    /*
    * method gets quantity of product
    * @return productQuantity-quantity  of product
    * */
    public int getProductQuantity(){
        return productQuantity;
    }
    /*
    * method gets cost of one product
    * @return CostOne-cost of product
    * */
    public double getCostOfOne(){
        return costOfOne;
    }
}


