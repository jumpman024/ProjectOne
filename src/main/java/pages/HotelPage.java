package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class HotelPage {

    private WebDriver driver;

    public HotelPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@id=\"title\"]")
    private WebElement hotelTab;

    @FindBy (xpath = "//*[@id=\"add_hotel:j_idt40_header\"]")
    private WebElement dataSection;

    @FindBy (xpath = "//span[text()[contains(.,'Save')]]")
    private WebElement saveButton;

    @FindBy (xpath = "//input[@id='add_hotel:name']")
    private WebElement nameField;

    @FindBy (id = "add_hotel:dateOfConstruction_input")
    private WebElement dateOfConstruction;

    @FindBy (xpath = "//button[@class='ui-datepicker-trigger ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only']")
    private WebElement dateOfConstructionButton;

    @FindBy (xpath = "//a[class='ui-state-default']")
    private WebElement calendarValue;

    @FindBy (id = "add_hotel:country")
    private WebElement countryValue;

    @FindBy (id = "add_hotel:city")
    private WebElement cityValue;

    @FindBy (xpath = "//input[@id='add_hotel:short_description']")
    private WebElement shortDiscription;

    @FindBy (xpath = "//textarea[@id='add_hotel:description']")
    private WebElement description;

    @FindBy (xpath = "//textarea[@id='add_hotel:notes']")
    private WebElement notes;

    @FindBy (xpath = "//div[@class='ui-rating']")
    private WebElement asterisk;

    @FindBy (xpath = "//span[@class='ui-message-error-detail']")
    private WebElement errorMessage;

    @FindBy (id = "add_hotel:city")
    private WebElement city;

    @FindBy (xpath = "//*[@id=\"add_hotel:country_panel\"]/div/ul/li[2]")
    private WebElement UkraineTab;

    @FindBy (xpath = "//*[@id=\"add_hotel:city_panel\"]/div/ul/li[2]")
    private WebElement kyivTab;

    @FindBy (xpath = "//*[@id=\"add_hotel:city_panel\"]/div/ul/li[3]")
    private WebElement lvivTab;

    @FindBy (xpath = "//form[@id='j_idt40']")
    private WebElement listOfHotelsTab;

    @FindBy (id = "add_hotel:j_idt44")
    private WebElement globalRatingTitle;

    @FindBy(className = "ui-rating-star")
    private List<WebElement> globalRateStarsList;

    @FindBy(className = "ui-rating-cancel")
    private WebElement globalRateCancel;

    @FindBy(id = "add_hotel:rate_input")
    private WebElement globalRateValue;

    @FindBy (id = "add_hotel:j_idt46")
    private WebElement dateOfConstructionField;

    @FindBy (xpath = "//span[@class='ui-outputlabel-rfi']")
    private WebElement dateOfConstructionFieldAsterisk;

    @FindBy (id = "add_hotel:j_idt47")
    private WebElement dateOfConstructionErrorMessage;

    @FindBy (id = "add_hotel:j_idt48")
    private WebElement countryField;

    @FindBy (xpath = "//label[@id='add_hotel:j_idt48']//span[@class='ui-outputlabel-rfi']")
    private WebElement countryFieldAsterisk;

    @FindBy(xpath = "//*[@id='add_hotel:city_panel']//li")
    private List<WebElement> countrySelectList;

    @FindBy(id = "add_hotel:country_label")
    private WebElement countryInput;

    @FindBy (xpath = "//*[@id=\"add_hotel:country_panel\"]/div/ul/li[4]")
    private WebElement usaTab;

    @FindBy (id = "add_hotel:j_idt51")
    private WebElement countryErrorMessage;

    @FindBy (xpath = "//*[@id=\"add_hotel:country_panel\"]/div/ul/li[1]")
    private WebElement selectOneTab;

    @FindBy (id = "add_hotel:j_idt52")
    private WebElement cityField;

    @FindBy (xpath = "//*[@id=\"add_hotel:j_idt52\"]/span")
    private WebElement cityAsterisk;

    @FindBy (id = "add_hotel:j_idt55")
    private WebElement cityErrorMessage;

    @FindBy (xpath = "//*[@id=\"add_hotel:city_panel\"]/div/ul/li[1]")
    private WebElement citySelectValue;

    @FindBy (id = "add_hotel:j_idt56")
    private WebElement shortDescriptionField;

    @FindBy (xpath = "//*[@id=\"add_hotel:j_idt56\"]/span")
    private WebElement shortDiscribtionAsterisk;

    @FindBy (id = "add_hotel:j_idt57")
    private WebElement shortDescriptionErrorMessage;

    @FindBy (id = "add_hotel:j_idt58")
    private WebElement descriptionField;

    @FindBy (xpath = "//*[@id=\"add_hotel:j_idt58\"]/span")
    private WebElement descriptionFieldAsterisk;

    @FindBy (id = "add_hotel:j_idt59")
    private WebElement descriptionErrorMessage;


    public String hotelTabDisplayed(){
        return hotelTab.getText();
    }

    public String dataSectionDisplayed(){
        return dataSection.getText();
    }

    public String SaveButtonDisplayed(){
        return saveButton.getText();
    }

    public Boolean nameSectionDisplayed(){
        return nameField.isDisplayed();
    }

    public String nameFieldEditable(){
        nameField.sendKeys("Hilton");
        nameField.clear();
        nameField.sendKeys("Hayatt");
        nameField.click();
        String name = nameField.getAttribute("value");
        return name;
    }


    public boolean errorMessageIsDisplayed(){
        return errorMessage.isDisplayed();
    }

    public String getNameErrorText() {
        return errorMessage.getText();
    }

    public HotelPage clearNameField(){
        nameField.clear();
        return this;
    }
    public HotelPage clickSaveButton(){
        saveButton.click();
        return this;
    }

    public HotelPage clearAndTypeAlphanumericName(String name){
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    public String getNameFieldValue(){
        JavascriptExecutor executor =(JavascriptExecutor) driver;
        return (String) executor.executeScript(" return arguments[0].value;", nameField);
    }

    public HotelPage clickNameField(){
        nameField.click();
        return this;
    }

    public HotelPage enterNameField(){
        nameField.sendKeys("Hayatt");
        return this;
    }

    public HotelPage selectDate(String dateValue){
       //dateOfConstructionButton.click();
        dateOfConstruction.sendKeys(dateValue);
        return this;
    }

    public HotelPage clickCitySelect(){
        city.click();
        return this;
    }

    public HotelPage selectCountry(){
        Actions builder = new Actions(driver);
        builder.moveToElement(UkraineTab).build().perform();
        UkraineTab.click();
//        WebElement dynamicElement = (new WebDriverWait(driver,10))
         //       .until(ExpectedConditions.presenceOfElementLocated(By.id("add_hotel:city")));
        return this;
    }

    public HotelPage clickCountrySelect(){
        countryValue.click();
        return this;
    }

    public HotelPage selectCity(){
        Actions builer = new Actions(driver);
        builer.moveToElement(kyivTab).build().perform();
        kyivTab.click();
        return this;
    }

    public HotelPage typeShortDiscription(String name){
        shortDiscription.clear();
        shortDiscription.sendKeys(name);
        return this;
    }
    public HotelPage typeDiscription(){
        description.sendKeys("some");
        return this;
    }

    public Boolean listOfHotelsTab(){
        return listOfHotelsTab.isDisplayed();
    }

    public String getGlobalRateTitle(){
        return globalRatingTitle.getText();

    }

    public HotelPage selectGlobalRateStars(int starsValue){
        int starValueIndex = starsValue - 1;
        if (starsValue <= 5 && starsValue >= 1){
            globalRateStarsList.get(starValueIndex).click();
        } else if (starsValue == 0) {
        cancelGlobalRateStar();
    }
        return this;
    }

    public HotelPage cancelGlobalRateStar() {
        globalRateCancel.click();
        return this;
    }

    public String getGlobalRateValue() {
        String globalRateValueString = globalRateValue.getAttribute("value");
        //for 0 stars parse to int
        if (globalRateValueString.equals("")) {
            globalRateValueString = "0";
        }
        return globalRateValueString;
    }

    public int getGlobalRateIntValue() {
        return Integer.parseInt(getGlobalRateValue());
    }

    public boolean dateOfConstruction(){
        return dateOfConstructionField.isDisplayed();
    }

    public boolean dateOfConstructionFieldAsterisk(){
        return dateOfConstructionFieldAsterisk.isDisplayed();
    }

    public HotelPage dateOfConstructionIsEditable(String dateValue){
        //dateOfConstruction.clear();
        //dateOfConstruction.sendKeys("10.10.19");
        dateOfConstruction.clear();
        dateOfConstruction.sendKeys(dateValue);
        return this;
    }

    public String getDateOfConstructionValue(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return (String) executor.executeScript(" return arguments[0].value;", dateOfConstruction);
    }

    public boolean getDateOfConstructionErrorMessage(){
        return dateOfConstructionErrorMessage.isDisplayed();
    }

    public HotelPage clearDateOdConstruction(){
        dateOfConstruction.clear();
        return this;
    }

    public String EnterValidDateOfConstruction(){
        dateOfConstruction.clear();
        dateOfConstruction.sendKeys("10.10.18");
        String date = dateOfConstruction.getAttribute("value");
        return date;
    }

    public boolean countryFieldIsDisplayed(){
        return countryField.isDisplayed();
    }

    public boolean countryFieldAsteriskIsDisplayed(){
        return countryFieldAsterisk.isDisplayed();
    }

    public HotelPage setCountrySelect(String selectValue) throws IOException{
        setSelect(selectValue, countrySelectList);
        return this;
    }

    public String getCountrySelectValue(){
        return countryInput.getText();
    }

    public void setSelect(String selectValue, List<WebElement> selectElement) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(selectElement.get(0)));

        boolean isClick = false;
        for (WebElement element : selectElement) {
            if (element.getText().equals(selectValue)) {
                selectElement.get(selectElement.indexOf(element)).click();
                isClick = true;
                break;
            }
        }
        if (!isClick) {
            throw new IOException("No such element: " + selectValue);
        }
    }

    public HotelPage countryFieldEditable(){
        Actions builder = new Actions(driver);
        builder.moveToElement(UkraineTab).build().perform();
        UkraineTab.click();
        countryValue.click();
        builder.moveToElement(usaTab).build().perform();
        usaTab.click();
        return this;
    }

    public boolean countryFieldErrorMessage(){
        return countryErrorMessage.isDisplayed();
    }

    public HotelPage countryFieldEmpty(){
        Actions actions = new Actions(driver);
        actions.moveToElement(selectOneTab).build().perform();
        selectOneTab.click();
        return this;
    }

    public HotelPage countryFieldValid(){
        Actions actions = new Actions(driver);
        actions.moveToElement(UkraineTab).build().perform();
        UkraineTab.click();
        return this;
    }

    public boolean cityFieldIsDisplayed(){
        return cityField.isDisplayed();
    }

    public boolean cityFieldAsteriskIsDisplayed(){
        return cityAsterisk.isDisplayed();
    }

    public HotelPage cityFieldEditable(){
        Actions actions = new Actions(driver);
        actions.moveToElement(kyivTab).build().perform();
        kyivTab.click();
        cityValue.click();
        actions.moveToElement(lvivTab).build().perform();
        lvivTab.click();
        return this;
    }

    public boolean cityFieldErrorMessage(){
        return cityErrorMessage.isDisplayed();
    }

    public HotelPage cityFieldIsEmpty(){
        Actions actions = new Actions(driver);
        actions.moveToElement(citySelectValue).build().perform();
        citySelectValue.click();
        return this;
    }

    public boolean shortDescriptionIsDisplayed(){
        return shortDescriptionField.isDisplayed();
    }

    public boolean shortDescriptionAsteriskIsDisplayed(){
        return shortDiscribtionAsterisk.isDisplayed();
    }

    public String getShortDescriptionValue(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return (String) executor.executeScript("return arguments[0].value;", shortDiscription);
    }

    public boolean shortDescriptionErrorIsDisplayed(){
        return shortDescriptionErrorMessage.isDisplayed();
    }

    public boolean descriptionIsDisplayed(){
        return descriptionField.isDisplayed();
    }

    public boolean descriptionAsteriskIsDisplayed(){
        return descriptionFieldAsterisk.isDisplayed();
    }

    public HotelPage clickDescription(){
        description.click();
        return this;
    }

    public HotelPage descriptionIsEditable(String name){
        description.clear();
        description.sendKeys(name);
        return this;
    }

    public String getDescriptionValue(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return (String) executor.executeScript("return arguments[0].value;", description);
    }

    public boolean descriptionErrorMessageIsDisplayed(){
        return descriptionErrorMessage.isDisplayed();
    }

    public boolean notesIsDisplayed(){
        return notes.isDisplayed();
    }

    public HotelPage clickNotes(){
        notes.click();
        return this;
    }

    public HotelPage notesIsEditable(String name){
        notes.clear();
        notes.sendKeys(name);
        return this;
    }

    public String getNotesValue(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return (String) executor.executeScript("return arguments[0].value", notes);
    }

}
