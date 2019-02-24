import pages.HotelPage;
import pages.MainPage;

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


public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void getWebDriver(){
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROMEDRIVER"));
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:8080/article/faces/welcome.xhtml");
    }

    @Test
    public void navigateToHotelPage(){

        MainPage mainPage = new MainPage(driver);
        HotelPage hotelPage = new HotelPage(driver);


        mainPage.clickArticle();
        mainPage.clickNews();
        mainPage.clickHotel();

        hotelPage.hotelTabDisplayed();
        VerifyThatHotelPageIsPresent("Register new Hotel");

        hotelPage.dataSectionDisplayed();
        VerifyThatDataSectionIsPresent("Data:");

        hotelPage.SaveButtonDisplayed();
        VerifyThatSaveButtonIsPresent("Save");
        }

        @Test
        public void DataSectionPresent(){
            MainPage mainPage = new MainPage(driver);
            HotelPage hotelPage = new HotelPage(driver);

            mainPage.clickArticle();
            mainPage.clickNews();
            mainPage.clickHotel();


            hotelPage.dataSectionDisplayed();
            VerifyThatDataSectionIsPresent("Data:");
        }


    @Test
    public void SaveButtonPresent(){
        MainPage mainPage = new MainPage(driver);
        HotelPage hotelPage = new HotelPage(driver);

        mainPage.clickArticle();
        mainPage.clickNews();
        mainPage.clickHotel();


        hotelPage.SaveButtonDisplayed();
        VerifyThatSaveButtonIsPresent("Save");
    }

    @Test
    public void NameFieldPresent(){
        MainPage mainPage = new MainPage(driver);
        HotelPage hotelPage = new HotelPage(driver);

        mainPage.clickArticle();
        mainPage.clickNews();
        mainPage.clickHotel();


        hotelPage.nameSectionDisplayed();
        VerifyThatSaveButtonIsPresent("Save");
    }




    @After
    public void finish() {
        driver.close();
    }

    private void VerifyThatHotelPageIsPresent(String expectedPage){
        String actualPage = driver.findElement(By.xpath("//*[@id='title']/div/h2")).getText();
        Assert.assertEquals("The page is not present",expectedPage,actualPage);
    }

    private void VerifyThatDataSectionIsPresent(String  expectedSection){
        String actualSection = driver.findElement(By.xpath("//span[@class='ui-panel-title']")).getText();
        Assert.assertEquals("Data Section is not present",expectedSection,actualSection);
    }

    private void VerifyThatSaveButtonIsPresent(String  expectedButton){
        String actualButton = driver.findElement(By.xpath("//span[text()[contains(.,'Save')]]")).getText();
        Assert.assertEquals("The Save Button is not present",expectedButton,actualButton);
    }


}
