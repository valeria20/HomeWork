import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;

/**
 * Class for getting information such as size of filed,
 * size of subdirectories and date of file creation
 *
 * @author Valeria
 */
public class DirectoryInformation {
    /*
     *  getting size of file
     *  @return sizeF-size of file
     *  @param list - current directory files list
     *  */
    public long getSizeFile(File list) {
        long sizeF = list.length();
        return sizeF;
    }

    /*
    *getting size of directories
    *@param absolutePath-path of current directory
     */
    public long getSizeDirectory(String absolutePath) {
        long sizeD = 0;
        File dir = new File(absolutePath);
        if (dir.isFile()) {
            sizeD = dir.length();
        } else {
            File[] subFiles = dir.listFiles();
            for (File subF : subFiles) {
                if (subF.isFile()) {
                    sizeD += subF.length();
                } else {
                    sizeD += getSizeDirectory(subF.getPath());
                }
            }
        }
        return sizeD;
    }

    /*
    * getting size of curent directory files
    * @param list-all files and subdirectories of current directory
    * @return size - size of file in byte format
    * */
    public long sizeFiles(File list) {
        long size = list.length();
        return size;
    }

    int KILOBYTE = 1024;
    /*
    * converting file size in Kb format
    * @parametr size-size of fi;e
    * @return-size of file in Kb format
    * */

    public long sizeKbyteFormat(long size) {
        return size / KILOBYTE;
    }

    /*
    *@throws IOException auto generated exception
    * getting date if creation files and subditectories of current directory
    * @param path-adress to files and subdirectories
    * @return date-date of creation file or subdirectory
    * */
    public String getDate(Path path) throws IOException {
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        FileTime dateC = attributes.creationTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
        String date = sdf.format(dateC.toMillis());
        return date;
    }
}
