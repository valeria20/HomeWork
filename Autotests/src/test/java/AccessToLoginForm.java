import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Class for testing correct access to login form.
 *
 * @author Valeria
 */
public class AccessToLoginForm {
    private  ChromeDriverService service;
    private WebDriver driver;
    /**
     * method running before test.
     * create browser driver object.
     */

   @BeforeMethod
    public void chromeDriver() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("e:\\программы\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
        driver = new ChromeDriver(service);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    /**
     * method running after test.
     * close browser
     */
    @AfterMethod
    public void downDriver(){
        driver.quit();
        service.stop();
    }
    /**
     * test method for checking for correct access
     * to the login form
     */

    @Test
    public void enterToLoginForm(){
        driver.get("http://localhost:8888/");
        driver.findElement(By.xpath(".//*[@id='meta-2']/ul/li[1]/a")).click();
        Assert.assertTrue(driver.getTitle().contains("Log In"));
    }
}
