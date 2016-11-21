import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.By;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * The entry point to the program.
 *
 * @author Valeria
 */

public class MicroFrameworkCL extends Parser {
    /**
     * method opens a web browser and follow the instructions
     * received from command line
     *
     * @param args-arguments of command line
     */
    public static void main(String[] args) throws IOException {
        /**
         * check command line for arguments availability
         */

        if (args.length == 0) {
            System.out.println("Fill command line by arguments");
        }
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("e:\\программы\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
        WebDriver driver = new ChromeDriver(service);
        //List of instructions
        ArrayList<String> instructions = new ArrayList<String>();
        /**
         * filling list of instructions
         */
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("open")) {
                String firstInstruction = args[i] + " " + args[i++] + " " + args[i + 2];
                instructions.add(firstInstruction);
            } else if (args[i].equals("checkLinkPresentByHref")) {
                String secondInstruction = args[i] + " " + args[i++];
                instructions.add(secondInstruction);
            } else if (args[i].equals("checkLinkPresentByName")) {
                String thirdInstruction = args[i] + " " + args[i++];
                instructions.add(thirdInstruction);
            } else if (args[i].equals("checkPageTitle")) {
                String fourthInstruction = args[i] + " " + args[i++];
                instructions.add(fourthInstruction);
            } else if (args[i].equals("checkPageContains")) {
                String fifthInstruction = args[i] + " " + args[i++];
                instructions.add(fifthInstruction);
            }
        }
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
                if (timeToOpen > defultTime) {
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
        log += "Average time: " + String.valueOf(totalTime * 0.001 / instructions.size()) + "\n";

        String globalTestsResult = " ";
        //number of passed tests
        int passed = instructions.size() - failed;
        globalTestsResult = "Passed/Failed: " + passed + "/" + failed + "\n";
        //number of all tests
        String totalTests = "Total tests: " + String.valueOf(instructions.size()) + "\n";

        PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
        writer.write(log);
        writer.write(totalTests);
        writer.write(globalTestsResult);
        writer.close();

        driver.quit();
        service.stop();
    }
}

