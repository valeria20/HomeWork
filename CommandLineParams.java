
public class CommandLineParams {
    public static void main(String[] args) {
        //cycle for reverse outputting of command line parameters
        for (int j = (args.length - 1); j >= 0; j--) {
            for (int i = 0; i < args.length; i++) {
                System.out.println("Аргумент " + i + "=" + args[j--]);
            }
        }
    }
}