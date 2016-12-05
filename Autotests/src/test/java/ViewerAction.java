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
 * Created by EVA on 05.12.2016.
 */
public class ViewerAction {
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
     * closes browser
     */
    @AfterMethod
    public void downDriver(){
        driver.quit();
        service.stop();
    }

    /**
     * Method checks that site visitor can leave
     * comment tp post and this comment really will add
     */
    @Test
    public void leaveComment(){
        driver.get("localhost:8888");
        driver.findElement(By.xpath(".//*[@id='post-53']/header/div/span[3]/a")).click();
        driver.findElement(By.xpath(".//*[@id='comment']")).sendKeys("test comment");
        driver.findElement(By.xpath(".//*[@id='author']")).sendKeys("viewerName");
        driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("email@example.com");
        //post comment
        driver.findElement(By.xpath(".//*[@id='submit']")).click();

        driver.findElement(By.xpath(".//*[@id='masthead']/div[1]/h1/a")).click();
        driver.findElement(By.xpath(".//*[@id='post-53']/header/div/span[3]/a")).click();

        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("test comment"));
    }
}


