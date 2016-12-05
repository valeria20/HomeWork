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
 * Class simulates typical admin actions and
 * check results for correct end
 *
 * @author Valeria
 */
public class AdminAction {
   private  ChromeDriverService service;
    private WebDriver driver;
    /**
     * method running before test.
     * creates browser driver object.
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
     * Creating new post and chcks it  really
     * appears at site
     * @throws InterruptedException
     */


    @Test (description = "creating new post")
    public void createNewPost() throws InterruptedException{
        driver.get("http://localhost:8888/wp-login.php");
        driver.findElement(By.id("user_login")).sendKeys("valeria");
        driver.findElement(By.id("user_pass")).sendKeys("ZCwiAhZ789");
        driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
        //click to "Post"
        driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]")).click();
        //click to "Add new"
        driver.findElement(By.xpath(".//*[@id='wpbody-content']/div[3]/h1/a")).click();
        //find space "Enter title here"
        driver.findElement(By.id("title")).sendKeys("New test post");
        //Enter text
        //driver.findElement(By.xpath(".//*[@id='tinymce']/p")).sendKeys("New test post text");
        //click publish
        driver.findElement(By.xpath(".//*[@id='publish']")).click();
        //go to site Test Blog
        driver.findElement(By.xpath(".//*[@id='wp-admin-bar-site-name']/a")).click();
        //click to added new
        driver.findElement(By.linkText("NEW TEST POST")).click();
    }

    /**
     * Methos edits post and check that changes are really comes
     *
     */
    @Test
    public void editPost(){
        driver.get("http://localhost:8888/wp-login.php");
        driver.findElement(By.id("user_login")).sendKeys("valeria");
        driver.findElement(By.id("user_pass")).sendKeys("ZCwiAhZ789");
        driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
        //go to site Test Blog
        driver.findElement(By.xpath(".//*[@id='wp-admin-bar-site-name']/a")).click();

        driver.findElement(By.linkText("EDIT")).click();
        driver.findElement(By.id("title")).sendKeys(" wow");
        //update
        driver.findElement(By.xpath(".//*[@id='publish']")).click();
        //go to site Test Blog
        driver.findElement(By.xpath(".//*[@id='wp-admin-bar-site-name']/a")).click();
        driver.findElement(By.partialLinkText(" WOW")).click();
    }

    /**
     * Method addes new user and check that he really was added
     * via login
     */

    @Test
    public void addNewUser(){
        //admin login
        driver.get("http://localhost:8888/wp-login.php");
        driver.findElement(By.id("user_login")).sendKeys("valeria");
        driver.findElement(By.id("user_pass")).sendKeys("ZCwiAhZ789");
        driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
        //click "user"
        driver.findElement(By.xpath(".//*[@id='menu-users']/a/div[3]")).click();
        //click "add new"
        driver.findElement(By.xpath(".//*[@id='wpbody-content']/div[3]/h1/a")).click();
        //enter username
        driver.findElement(By.xpath(".//*[@id='user_login']")).sendKeys("new user");
        //enter email
        driver.findElement(By.id("email")).sendKeys("user@example.com");
        //show password
        driver.findElement(By.xpath(".//*[@id='createuser']/table/tbody/tr[6]/td/button")).click();
        //String password;
        String password= driver.findElement(By.id("pass1-text")).getText();
        driver.findElement(By.xpath(".//*[@id='createusersub']")).click();
        //logout
        driver.get("http://localhost:8888/wp-login.php");
        //login new user
        driver.findElement(By.id("user_login")).sendKeys("new user");
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
        Assert.assertFalse(driver.getTitle().contains("Dashboard"));
    }

    /**
     * Simulating incorrect entering during
     * adding new user
     */

    @Test(description = "negative test")
    public void addInvalidUser(){
        //admin login
        driver.get("http://localhost:8888/wp-login.php");
        driver.findElement(By.id("user_login")).sendKeys("valeria");
        driver.findElement(By.id("user_pass")).sendKeys("ZCwiAhZ789");
        driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
        //click "user"
        driver.findElement(By.xpath(".//*[@id='menu-users']/a/div[3]")).click();
        //click "add new"
        driver.findElement(By.xpath(".//*[@id='wpbody-content']/div[3]/h1/a")).click();
        //enter username
        driver.findElement(By.xpath(".//*[@id='user_login']")).sendKeys("  ");
        //enter email
        driver.findElement(By.id("email")).sendKeys("    ");
        driver.findElement(By.xpath(".//*[@id='createusersub']")).click();

        Assert.assertFalse(driver.getTitle().contains("Users"));
    }
}
