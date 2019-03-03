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




    @Test(description = "Verify that user can open New Hotel page:")
    public void registerHotelPageIsDisplayed() {
        //Verify that Register new Hotel page is displayed when user selects Article->New->Hotel
        String expectedHotelValue = "Register new Hotel";
        String actualHotelValue = hotelPage.hotelTabDisplayed();
        Assert.assertEquals(actualHotelValue,expectedHotelValue);
    }

    @Test
    public void dataSectionIsDisplayed() {
        //Verify that Data section is displayed on Register new Hotel
        String expectedDataValue = "Data:";
        String actualDataValue = hotelPage.dataSectionDisplayed();
        Assert.assertEquals(actualDataValue,expectedDataValue);
    }

    @Test
    public void saveButtonIsDisplayed() {
        //Verify that save button is displayed on Register new Hotel
        String expectedButtonValue = "Save";
        String actualDataValue = hotelPage.SaveButtonDisplayed();
        Assert.assertEquals(actualDataValue,expectedButtonValue);
    }








}
