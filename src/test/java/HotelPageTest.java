import org.junit.After;
import org.openqa.selenium.By;
import pages.HotelPage;
import pages.MainPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;




public class HotelPageTest {

    private WebDriver driver;

    @Before
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROMEDRIVER"));
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:8080/article/faces/welcome.xhtml");
    }

    @Test
    public void nameFieldDisplayed() {
        MainPage mainPage = new MainPage(driver);
        HotelPage hotelPage = new HotelPage(driver);

        mainPage.clickArticle();
        mainPage.clickNews();
        mainPage.clickHotel();
        Boolean expectedNameField = hotelPage.nameSectionDisplayed();
        Assert.assertTrue("The name is not present", expectedNameField);

        String expectedName = hotelPage.nameFieldEditable();
        String actualName = "Hayatt";
        verifyNameSectionEditable(expectedName,actualName);

    }


    @After
    public void finish() {
        driver.close();
    }

    private void verifyNameSectionEditable(String expectedName,String actualName){
        Assert.assertEquals(expectedName,actualName);
    }



}
