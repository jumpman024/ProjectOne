import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HotelPage;
import pages.NavigationMenu;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class MainPageTest extends BaseTest{

    private NavigationMenu mainPage;
    private HotelPage hotelPage;


    @BeforeMethod
    public void startUp(){

        mainPage = new NavigationMenu(driver);
        hotelPage = new HotelPage(driver);

        mainPage.clickArticle();
        mainPage.clickNew();
        mainPage.clickHotel();
    }




    @Test
    public void navigateToHotelPage(){



        hotelPage.hotelTabDisplayed();
        VerifyThatHotelPageIsPresent("Register new Hotel");

        hotelPage.dataSectionDisplayed();
        VerifyThatDataSectionIsPresent("Data:");

        hotelPage.SaveButtonDisplayed();
        VerifyThatSaveButtonIsPresent("Save");
        }

        @Test
        public void DataSectionPresent(){



            hotelPage.dataSectionDisplayed();
            VerifyThatDataSectionIsPresent("Data:");
        }


    @Test
    public void SaveButtonPresent(){
        NavigationMenu mainPage = new NavigationMenu(driver);
        HotelPage hotelPage = new HotelPage(driver);

        mainPage.clickArticle();
        mainPage.clickNew();
        mainPage.clickHotel();


        hotelPage.SaveButtonDisplayed();
        VerifyThatSaveButtonIsPresent("Save");
    }

    @Test
    public void NameFieldPresent(){
        NavigationMenu mainPage = new NavigationMenu(driver);
        HotelPage hotelPage = new HotelPage(driver);

        mainPage.clickArticle();
        mainPage.clickNew();
        mainPage.clickHotel();


        hotelPage.nameSectionDisplayed();
        VerifyThatSaveButtonIsPresent("Save");


    }









    private void VerifyThatHotelPageIsPresent(String expectedPage){
        String actualPage = driver.findElement(By.xpath("//*[@id='title']/div/h2")).getText();
        Assert.assertEquals("The page is not present",expectedPage,actualPage);
    }

    private void VerifyThatDataSectionIsPresent(String  expectedSection){
        String actualSection = driver.findElement(By.xpath("//*[@id=add_hotel:j_idt40_header]/span")).getText();
        Assert.assertEquals("Data Section is not present",expectedSection,actualSection);
    }

    private void VerifyThatSaveButtonIsPresent(String  expectedButton){
        String actualButton = driver.findElement(By.xpath("//span[text()[contains(.,'Save')]]")).getText();
        Assert.assertEquals("The Save Button is not present",expectedButton,actualButton);
    }






}
