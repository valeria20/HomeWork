import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Class for creatig code of html table,
 * filling html table by information of current directore
 *
 * @author Valeria
 */
public class HtmlCreate {
    /**
     * HEADER- the  first part of hrml table code
     */
    private String HEADER = "<html>\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\"/>\n" +
            "</head>\n" +
            "<table border=\"0\" WIDTH=\"100%\" bordercolor=\"#FFFFFF\">\n" +
            "<tr bgcolor=\"#A9A9A9\">\n" +
            "<th>ИМЯ</th>\n" +
            "<th>ТИП</th>\n" +
            "<th>ДАТА<div>СОЗДАНИЯ</div></th>\n" +
            "<th>РАЗМЕР(в kb)</th>\n" +
            "</tr>\n";
    /**
     * FOOTER- the  last  part of hrml table code
     */
    private String FOOTER = "</table>\n" +
            "<body>\n" +
            "</html>";

    /**
     * create html file which consists table
     * filling table by curren directory inforation
     * cteating object of Dit=rectoryInformation class
     *
     * @param list-all files and subdirectories if current directory
     */
    public void createFile(File[] list) {

        try {
            File file = new File("html_table.html");
            /*wrt, bw is used for writiing data in file*/
            FileWriter wrt = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(wrt);
            bw.write(HEADER);

            DirectoryInformation di = new DirectoryInformation();

            for (File field : list) {
                /*getting name of files*/
                String name = field.getName();
                String type = " ";
                long size = 0;
                /*check type of files*/
                if (field.isFile()) {
                    type = "File";
                }
                if (field.isDirectory()) {
                    type = "DIR";
                }

                if (type.equals("File")) {
                    size = di.sizeKbyteFormat(di.getSizeFile(field));
                }
                if (type.equals("DIR")) {
                    size = di.sizeKbyteFormat(di.getSizeDirectory(field.getPath()));
                }
                Path path = Paths.get(field.getPath());
                String date = di.getDate(path);
                fillingTable(bw, name, type, size, date);
            }
            bw.write(FOOTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*filling  table by directory information
     * @param bw-object of BufferedWriter class for writing data in file
     * @param name- name of files/subdirectories
     * @param-type-type of current directory files("File" or "DIR")
     * @param size-size of file or subdirectory in kb
     * @param date-date of file creation
      * */

    public void fillingTable(BufferedWriter bw, String name, String type, long size, String date) throws IOException {
        bw.write("<td>" + name + "</td>\n" +
                "<td>" + type + "</td>\n" +
                "<td>" + date + "</td>\n" +
                "<td>\n" + size + "</td>\n");
    }
}



