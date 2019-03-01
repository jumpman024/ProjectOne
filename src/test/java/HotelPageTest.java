
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HotelPage;
import pages.NavigationMenu;


public class HotelPageTest extends BaseTest {

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
    public void nameFieldDisplayed() {
        //Verify that Name field is editable
        Boolean expectedNameField = hotelPage.nameSectionDisplayed();
        Assert.assertTrue( expectedNameField);

        String expectedName = "Hayatt";
        String actualName = hotelPage.nameFieldEditable();
        Assert.assertEquals(actualName,expectedName);

    }

    @Test
    //Verify that Name field allows to input alphanumeric characters
    public void isPossibleToInputAlphanumericCharacters(){
        String expectedNameField = "1Name 2Name";
        String actualNameField = hotelPage.clearAndTypeAlphanumericName(expectedNameField)
                .getNameFieldValue();
        Assert.assertEquals(actualNameField,expectedNameField);


    }

    @Test
    public void nameFieldIsNotEmpty(){
        //Verify that it is not possible to save the empty Name field and a meaningful error message is displayed
        boolean actualNameErrorDisplayed = hotelPage.clearNameField()
                .clickSaveButton()
                .errorMessageIsDisplayed();
        Assert.assertTrue(actualNameErrorDisplayed);

        String expectedNameErrorText = "Name: Validation Error: Value is required.";
        String actualNameErrorText = hotelPage.getNameErrorText();
        Assert.assertEquals(actualNameErrorText, expectedNameErrorText);

    }

    @Test
    public void isPossibleToEnterValidNameField(){
        //Verify that it is possible to save the valid name field
        String dateOfConstruction = "10.10.19";
        hotelPage.clickNameField()
                .enterNameField()
                .selectDate(dateOfConstruction)
                .clickCitySelect()
                .selectCountry()
                .selectCity()
                .typeShortDiscription()
                .typeDiscription()
                .clickSaveButton();

    }



}
