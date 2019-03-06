
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HotelPage;
import pages.NavigationMenu;
//import sun.jvm.hotspot.jdi.StackFrameImpl;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


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
                .clickCountrySelect()
                .selectCountry()
                .clickCitySelect()
                .selectCity()
                .typeShortDiscription("some")
                .typeDiscription()
                .clickSaveButton();
            boolean actualHotelTabDisplayed = hotelPage.listOfHotelsTab();
            Assert.assertTrue(actualHotelTabDisplayed);
    }

    @Test
    public void globalRatingFieldIsDisplayed(){
        //Verify that Global Rating field is displayed in Data section of Register new Hotel page
        String ExpectedGlobalRatingTitle = "Global Rating:";
        String ActualGlobalRatingTitle = hotelPage.getGlobalRateTitle();
        Assert.assertEquals(ActualGlobalRatingTitle,ExpectedGlobalRatingTitle);
    }

    @Test
    public void globalRatingFieldAllowsHotelRating(){
        //Verify that Global Rating field allows to rating of the hotel (0-5 stars)
        int expectedValue = 1;
        int actualValue = hotelPage.selectGlobalRateStars(expectedValue)
                .getGlobalRateIntValue();
        Assert.assertEquals(actualValue,expectedValue);


        expectedValue = 0;
        actualValue = hotelPage.selectGlobalRateStars(expectedValue)
                .getGlobalRateIntValue();
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test
    public void isPossibleToSaveGlobalRatingField() {
        //Verify that it is possible to save the Global Rating field
        int expuctedValue = 0;
        int actualValue = hotelPage.cancelGlobalRateStar()
                .clickSaveButton()
                .getGlobalRateIntValue();
        Assert.assertEquals(actualValue,expuctedValue);
    }

    @Test
    public void isPossibleToSaveValidRatingField(){
        int expectedValue = 3;
        int actualValue = hotelPage.selectGlobalRateStars(expectedValue)
                .clickSaveButton()
                .getGlobalRateIntValue();
        Assert.assertEquals(actualValue,expectedValue);

    }

    @Test
    public void dateOfConstructionFieldIsDisplayed() {
        //Verify that Date of Construction field is displayed in Data section of Register new Hotel page
        boolean expectedField = hotelPage.dateOfConstruction();
        Assert.assertTrue(expectedField);
    }

    @Test
    public void dateOfConstructionFieldIsMarkedAsterisk() {
        //Verify that Date of Construction field is marked with asterisk
        boolean expectedField = hotelPage.dateOfConstructionFieldAsterisk();
        Assert.assertTrue(expectedField);
    }

    @Test
    public void dateOfConstructionEditable() {
        //Verify that Date of Construction is editable
        //Verify Date of Construction field allows to input in date format
        String ExpectedDateOfConstruction = "10.10.19";
        String ActualDateOfConstruction = hotelPage.dateOfConstructionIsEditable(ExpectedDateOfConstruction)
                .getDateOfConstructionValue();
        Assert.assertEquals(ActualDateOfConstruction,ExpectedDateOfConstruction);

        String secondDateOfConstruction = "12.10.19";
        ExpectedDateOfConstruction = secondDateOfConstruction;
        ActualDateOfConstruction = hotelPage.dateOfConstructionIsEditable(ExpectedDateOfConstruction)
                .getDateOfConstructionValue();
        Assert.assertEquals(ActualDateOfConstruction,ExpectedDateOfConstruction);
    }

    @Test
    public void dateOfConstructionIncorrectMessage() {
        //Verify that it is not possible to save incorrect  date format value Date of Construction field and a meaningful error message is displayed
        boolean actualDateOfConstructionErrorIsDisplayed = hotelPage.dateOfConstructionIsEditable("1900.10.11")
                .clickSaveButton()
                .getDateOfConstructionErrorMessage();
        Assert.assertTrue(actualDateOfConstructionErrorIsDisplayed);
    }

    @Test
    //Verify that it is not possible to save the empty Date of Construction field and a meaningful error message is displayed
    public void dateOfConstructionEmptyFieldErrorMessage(){
        boolean actualDateOfConstructionErrorIsDisplayed = hotelPage.clearDateOdConstruction()
                .clickSaveButton()
                .getDateOfConstructionErrorMessage();
        Assert.assertTrue(actualDateOfConstructionErrorIsDisplayed);
    }

    @Test
    public void dateOfConstuctionValidField(){
        //Verify that it is possible to save valid Date of Construction field
        String expectedDateValue = "10.10.18";
        String actualDateValue = hotelPage.EnterValidDateOfConstruction();
                //.clickSaveButton();
        Assert.assertEquals(actualDateValue,expectedDateValue);
    }

    @Test
    public void countryFieldIsDisplayed() {
        //Verify that Country field is displayed in Data section of Register new Hotel page
        boolean actualCountryField = hotelPage.countryFieldIsDisplayed();
        Assert.assertTrue(actualCountryField);
    }

    @Test
    public void coutryFieldAsteriskIsDisplayed() {
        //Verify that Country fields is marked with asterisk
        boolean actualCountryFieldAsterisk = hotelPage.countryFieldAsteriskIsDisplayed();
        Assert.assertTrue(actualCountryFieldAsterisk);
    }

    @Test
    public void countryFieldIsEditable() {
        //Verify that Country field is editable
//        String expectedCountryValue = "USA";
//        String actualCountryValue = hotelPage.clickCountrySelect()
//                .setCountrySelect(expectedCountryValue)
//                .getCountrySelectValue();
//        Assert.assertEquals(actualCountryValue,expectedCountryValue);
        boolean actualCountryValue = hotelPage.clickCountrySelect()
                .countryFieldEditable()
                .clickSaveButton()
                .countryFieldErrorMessage();
        Assert.assertFalse(actualCountryValue);
    }

    @Test
    public void isNotPossibleToSaveEmptyField() {
        //Verify that it is not possible to save the empty (with default value “Select me’) Country field
        boolean actualCountryField = hotelPage.clickCountrySelect()
                .countryFieldEmpty()
                .clickSaveButton()
                .countryFieldErrorMessage();
        Assert.assertTrue(actualCountryField);
    }

    @Test
    public void isPossibleToSaveValidCountry() {
        //Verify that it is possible to save the valid Country field
        boolean actualCountryField = hotelPage.clickCountrySelect()
                .countryFieldValid()
                .clickSaveButton()
                .countryFieldErrorMessage();
        Assert.assertFalse(actualCountryField);
    }

    @Test (description = "Verify that user can add City of new hotel")
    public void cityFieldIsDisplayed() {
        //Verify that City field is displayed in Data section of Register new Hotel page
        boolean ActualCityField = hotelPage.cityFieldIsDisplayed();
        Assert.assertTrue(ActualCityField);
    }

    @Test
    public void cityFieldAsteriskIsDisplayed(){
        //Verify that City field is marked with asterisk
        boolean ActualCityAsterisk = hotelPage.cityFieldAsteriskIsDisplayed();
        Assert.assertTrue(ActualCityAsterisk);
    }

    @Test
    public void cityFieldIsEditable() {
        //Verify that City field is editable
        boolean cityFieldIsEditable = hotelPage.clickCountrySelect()
                .selectCountry()
                .clickCitySelect()
                .cityFieldEditable()
                .clickSaveButton()
                .cityFieldErrorMessage();
        Assert.assertFalse(cityFieldIsEditable);
    }

    @Test
    public void isNotPossibleToEnterEmptyCityField(){
        //Verify that it is not possible to save the empty
        // (with default value “Select me”) City field and a meaningful error message is displayed
        boolean actualCityField = hotelPage.clickCountrySelect()
                .selectCountry()
                .clickCitySelect()
                .cityFieldIsEmpty()
                .clickSaveButton()
                .cityFieldErrorMessage();
        Assert.assertTrue(actualCityField);
    }

    @Test
    public void isPossibleToSaveValidCity() {
        //Verify that it is possible to save the valid City field
        boolean actualCityValue = hotelPage.clickCountrySelect()
                .selectCountry()
                .clickCitySelect()
                .selectCity()
                .clickSaveButton()
                .cityFieldErrorMessage();
        Assert.assertFalse(actualCityValue);
    }

    @Test(description = "Verify that user can add Short Description of new hotel ")
    public void shortDescriptionIsDisplayed() {
        //Verify that Short Description field is displayed in Data section  of Register new Hotel
        boolean actualShortDescription = hotelPage.shortDescriptionIsDisplayed();
        Assert.assertTrue(actualShortDescription);
    }

    @Test
    public void shortDescriptionAsteriskIsDisplayed() {
        //Verify that Short Description field is marked with asterisk
        boolean actualShortDescription = hotelPage.shortDescriptionAsteriskIsDisplayed();
        Assert.assertTrue(actualShortDescription);
    }

    @Test
    public void shortDescriptionFieldIsEditable() {
        //Verify that Short Description field is editable
        String expectedDescription = "Short";
        String actualDescription = hotelPage.typeShortDiscription(expectedDescription)
                .getShortDescriptionValue();
        Assert.assertEquals(actualDescription,expectedDescription);

        String secondExpectedDescription = "Description";
               actualDescription = hotelPage.typeShortDiscription(secondExpectedDescription)
                .getShortDescriptionValue();
        Assert.assertEquals(actualDescription,secondExpectedDescription);
    }

    @Test
    public void shortDescriptionAlphanumericCharacters() {
        //Verify that Short Description field allows to input alphanumeric characters
        String expectedDescription = "1Name 2Names";
        String actualDescription = hotelPage.typeShortDiscription(expectedDescription)
                .getShortDescriptionValue();
        Assert.assertEquals(actualDescription,expectedDescription);
    }

    @Test
    public void isNotPossibleToSaveEmptyShortDescription() {
        //Verify that it is not possible to save the empty Short Description field and a meaningful error message is displayed
        boolean actualErrorMessage = hotelPage.clickSaveButton()
                .shortDescriptionErrorIsDisplayed();
        Assert.assertTrue(actualErrorMessage);
    }

    @Test
    public void isPossibleToSaveValidShortDescription() {
        //Verify that it is possible to save the valid Short Description field
        String expectedShortDescription = "Short Description";
        boolean actualShortDescription = hotelPage.typeShortDiscription(expectedShortDescription)
                .clickSaveButton()
                .shortDescriptionErrorIsDisplayed();
        Assert.assertFalse(actualShortDescription);
    }

    @Test (description = "Verify that user can add Description of new hotel")
    public void descriptionFieldIsDisplayed() {
        //Verify that  Description field is displayed in Data section  of Register new Hotel
        boolean actualDescribtion = hotelPage.descriptionIsDisplayed();
        Assert.assertTrue(actualDescribtion);
    }

    @Test
    public void descriptionFieldAsteriskIsDisplayed() {
        //Verify that Description field is marked with asterisk
        boolean actualAsteriskDiscription = hotelPage.descriptionAsteriskIsDisplayed();
        Assert.assertTrue(actualAsteriskDiscription);
    }

    @Test
    public void descriptionFieldIsEditable() {
        //Verify that Description field is editable
        String expectedDescriptionValue = "some";
        String actualDescriptionValue = hotelPage.clickDescription()
                .descriptionIsEditable(expectedDescriptionValue)
                .getDescriptionValue();
        Assert.assertEquals(actualDescriptionValue,expectedDescriptionValue);

        String SecondExpectedValue = "text";
        actualDescriptionValue = hotelPage
                .descriptionIsEditable(SecondExpectedValue)
                .getDescriptionValue();
        Assert.assertEquals(actualDescriptionValue,SecondExpectedValue);
    }

    @Test
    public void descriptionAlphanumericCharacters() {
        //Verify that Description field allows to input alphanumeric characters
        String expectedDescriptionValue = "1Name 2Names";
        String actualDescriptionValue = hotelPage.clickDescription()
                .descriptionIsEditable(expectedDescriptionValue)
                .getDescriptionValue();
        Assert.assertEquals(actualDescriptionValue,expectedDescriptionValue);
    }

    @Test
    public void isNotPossibleToSaveEmptyDescription() {
        //Verify that it is not possible to save the empty Description field and a meaningful error message is displayed
        boolean actualErrorMessage = hotelPage.clickSaveButton()
                .descriptionErrorMessageIsDisplayed();
        Assert.assertTrue(actualErrorMessage);
    }

    @Test
    public void isPossibleToSaveValidDescription() {
        //Verify that it is possible to save the valid Description field
        String expectedDescriptionValue = "Something";
        boolean actualDescriptionValue = hotelPage.clickDescription()
                .descriptionIsEditable(expectedDescriptionValue)
                .descriptionErrorMessageIsDisplayed();
        Assert.assertFalse(actualDescriptionValue);
    }

    @Test(description = "Verify that user can add Notes of new hotel")
    public void noteFieldIsDisplayed() {
        //Verify that  Notes field is displayed in Data section  of Register new Hotel
        boolean actualNoteField = hotelPage.notesIsDisplayed();
        Assert.assertTrue(actualNoteField);
    }

    @Test
    public void notesIsEditable() {
        //Verify that Notes field is editable
        String expectedNoteValue = "some";
        String actualNoteValue = hotelPage.clickNotes()
                .notesIsEditable(expectedNoteValue)
                .getNotesValue();
        Assert.assertEquals(actualNoteValue,expectedNoteValue);

        String secondExpectedValue = "text";
        actualNoteValue = hotelPage
                .notesIsEditable(secondExpectedValue)
                .getNotesValue();
        Assert.assertEquals(actualNoteValue,secondExpectedValue);
    }

    @Test
    public void noteAlphanumericCharacters() {
        //Verify that Notes field allows to input alphanumeric characters
        String expectedNoteValue = "1Name 2Names";
        String actualNoteValue = hotelPage.clickNotes()
                .notesIsEditable(expectedNoteValue)
                .getNotesValue();
        Assert.assertEquals(actualNoteValue,expectedNoteValue);
    }

    @Test
    public void isPossibleToSaveEmptyNote() {
        //Verify that it is possible to save the empty Notes field
        String expectedNoteValue = "";
        String actualNoteValue = hotelPage.clickNotes()
                .notesIsEditable(expectedNoteValue)
                .clickSaveButton()
                .getNotesValue();
        Assert.assertEquals(actualNoteValue,expectedNoteValue);
    }

    @Test
    public void isPossibleToSaveValidNotes() {
        //Verify that it is possible to save the valid Notes field
        String expectedNoteValue = "Something$5^%";
        String actualNoteValue = hotelPage.clickNotes()
                .notesIsEditable(expectedNoteValue)
                .clickSaveButton()
                .getNotesValue();
        Assert.assertEquals(actualNoteValue,expectedNoteValue);
    }

}
