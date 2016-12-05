import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WordpressLogin {
   private  ChromeDriverService service;
   private  WebDriver driver;
    /**
     * method running before test.
     * create browser driver object.
     */

   @BeforeMethod
    public void chromeDriver() throws IOException{
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
     * closes browser
     */

    @AfterMethod
    public void downDriver(){
        driver.quit();
        service.stop();
    }

    /**
     * method checks registered users can login without problems
     * @param username name of user
     * @param password password to login
     * @throws IOException
     */

    @Test(dataProvider ="wordpressData", description = "Test valid log in")
    public void ValidLoginToWordpress   (String username, String password) throws IOException {
        driver.get("http://localhost:8888/wp-login.php");

        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }

    /**
     * Methos checks unregistrated users
     * can't login
     */

    @Test public void invalidLoginToWordpress(){
        driver.get("http://localhost:8888/wp-login.php");
        driver.findElement(By.id("user_login")).sendKeys("invalidName");
        driver.findElement(By.id("user_pass")).sendKeys("invalisPass");
        driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
        Assert.assertFalse(driver.getTitle().contains("Dashboard"));
    }

    @DataProvider(name = "wordpressData")
    public Object[][] userData() {
        return new Object[][]{
                {"user6", "6787778tarja6"},
                {"user7", "6787778tarja7"},
                {"user8", "6787778tarja8"},
                {"valeria", "ZCwiAhZ789"}
        };
    }




}


