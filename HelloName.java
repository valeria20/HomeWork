//class for displaying "Hello, NAME". Name we get from command line
public class HelloName {
    public static void main(String [] args){
        for(int i=0; i<args.length; i++)
        System.out.println("Hello"+", " +args[i]);
    }
}