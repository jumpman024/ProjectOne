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

public class HotelPage {

    private WebDriver driver;

    public HotelPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@id='title']/div/h2")
    private WebElement hotelTab;

    @FindBy (xpath = "//*[@id=add_hotel:j_idt40_header]/span")
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

    @FindBy (name = "add_hotel:country_input")  // "//div[@class='ui-helper-hidden-accessible']"
    private WebElement countryValue;

    @FindBy (xpath = "//label[id='add_hotel:city_label']")
    private WebElement cityValue;

    @FindBy (xpath = "//input[@id='add_hotel:short_description']")
    private WebElement shortDiscribtion;

    @FindBy (xpath = "//textarea[@id='add_hotel:description']")
    private WebElement discription;

    @FindBy (xpath = "//textarea[@id='add_hotel:notes']")
    private WebElement notes;

    @FindBy (xpath = "//div[@class='ui-rating']")
    private WebElement asterisk;

    @FindBy (xpath = "//span[@class='ui-message-error-detail']")
    private WebElement errorMessage;

    @FindBy (id = "add_hotel:city_label")
    private WebElement city;


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

    public HotelPage selectCountry(){
        Select value = new Select(countryValue);

//        new WebDriverWait(driver, 15)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Continue shopping']")));
        value.selectByIndex(2);
        return this;
    }

    public HotelPage clickCitySelect(){
        city.click();
        return this;
    }

    public HotelPage selectCity(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cityValue));

        Select value = new Select(cityValue);
        value.selectByVisibleText("USA");
        return this;
    }

    public HotelPage typeShortDiscription(){
        shortDiscribtion.sendKeys("some");
        return this;
    }
    public HotelPage typeDiscription(){
        discription.sendKeys("some");
        return this;
    }



}
