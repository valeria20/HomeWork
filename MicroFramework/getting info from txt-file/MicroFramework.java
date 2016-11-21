import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriverService;
import java.io.FileInputStream;
import org.openqa.selenium.By;
import java.io.PrintWriter;
import org.apache.commons.io.IOUtils;

/**
 * The entry point to the program.
 *
 * @author Valeria
 */

public class MicroFramework extends Parser {
    private static final String testFile = "tests.txt";

    /**
     * method for reading instructions from file
     * @return file information
     *
     */

    private static String readInstructions() throws IOException {
        FileInputStream inputStream = new FileInputStream(testFile);
        try {
            String data = IOUtils.toString(inputStream);
            return data;
        } finally {
            inputStream.close();
        }
    }

    /**
     * method opens a web browser and follow the instructions
     * received from txt-file
     * @param args-arguments of command line
     *
     */

    public static void main(String[] args) throws IOException {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("e:\\программы\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
        WebDriver driver = new ChromeDriver(service);

        String[] instructions = readInstructions().split("\\r\\n");
        //time of all tests
        long totalTime = 0;
        //number of failed tests
        int failed = 0;
        String log = " ";
        for (String instruction : instructions) {
            long startTime = System.currentTimeMillis();
            String success = "+";

            if (parseInstruction(instruction).equals("open")) {
                String url = parseFirstArgument(instruction);
                driver.get(url);
                int defultTime = Integer.parseInt(parseSecondArgument(instruction));
                int timeToOpen = (int) (System.currentTimeMillis() / 1000);
                if (timeToOpen> defultTime) {
                    success = "!";
                    failed++;
                }
            } else if (parseInstruction(instruction).equals("checkLinkPresentByHref")) {
                String href = parseFirstArgument(instruction);
                try {
                    driver.findElement(By.xpath("//a[href='" + href + "']"));
                } catch (Exception e) {
                    success = "!";
                    failed++;
                }
            } else if (parseInstruction(instruction).equals("checkLinkPresentByName")) {
                String text = parseFirstArgument(instruction);
                try {
                    driver.findElement(By.xpath("//a[text()='" + text + "']"));
                } catch (Exception e) {
                    success = "!";
                    failed++;
                }
            } else if (parseInstruction(instruction).equals("checkPageTitle")) {
                String title = parseFirstArgument(instruction);
                if (!driver.getTitle().equals(title)) {
                    success = "!";
                    failed++;
                }
            } else if (parseInstruction(instruction).equals("checkPageContains")) {
                String contain = parseFirstArgument(instruction);
                if (!driver.getPageSource().contains(contain)) {
                    success = "!";
                    failed++;
                }
            }
            long endTime = System.currentTimeMillis();
            long timeOfOneTest = (endTime - startTime);
            totalTime += timeOfOneTest;
            log += success + " [" + instruction + "] " + timeOfOneTest * 0.001 + "\n";
        }
        log += "Total time: " + totalTime * 0.001 + "\n";
        log += "Average time: " + String.valueOf(totalTime * 0.001 / instructions.length) + "\n";

        String globalTestsResult = " ";
        //count of passed tests
        int passed = instructions.length - failed;
        globalTestsResult = "Passed/Failed: " + passed + "/" + failed + "\n";
        String totalTests = "Total tests: " + String.valueOf(instructions.length) + "\n";

        PrintWriter writer = new PrintWriter("result.txt");
        writer.write(log);
        writer.write(totalTests);
        writer.write(globalTestsResult);
        writer.close();

        driver.quit();
        service.stop();
    }
}

