
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.*;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    private final Properties config = Config.loadProperties("test.properties");

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", config.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/article/faces/welcome.xhtml");
    }


    @AfterMethod(alwaysRun = true)
    public void closeDown() {
        driver.close();
    }
}























//
//
//import pages.Config;
//import org.junit.After;
//import org.junit.Before;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//public abstract class BaseTest {
//
//    private WebDriver driver;
//    //private final Properties config = Config.loadProperties("test.properties");
//
//    @Before
//    public void getWebDriver(){
//        System.setProperty("webdriver.chrome.driver", System.getenv("CHROMEDRIVER"));
//        driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.navigate().to("http://localhost:8080/article/faces/welcome.xhtml");
//
//    }
//
//
//
//    @After
//    public void finish() {
//        driver.close();
//    }
//
//}
