import java.io.File;

/**
 * THE ENRTY POINT TO THE PROGRAM
 *
 * @author Valeria
 */

public class Main {
    /*
    * get path of current directory
    * create File class oblect of current directory
    * creating oblect of HtmlCreate class
    * creating list of files in current direc
    * @param args-arguments of command line
    *
     * */
    public static void main(String[] args) {
        try {
            /*adress of current directoty*/
            String absolutePath = new File(".").getAbsolutePath();
            File newFile = new File(absolutePath);
            File list[] = newFile.listFiles();
            HtmlCreate html = new HtmlCreate();
            html.createFile(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
