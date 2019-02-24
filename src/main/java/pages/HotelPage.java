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

    @FindBy (xpath = "//span[@class='ui-panel-title']")
    private WebElement dataSection;

    @FindBy (xpath = "//span[text()[contains(.,'Save')]]")
    private WebElement saveButton;

    @FindBy (xpath = "//input[@id='add_hotel:name']")
    private WebElement nameSection;

    @FindBy (xpath = "//div[@class='ui-rating']")
    private WebDriver asterisk;

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
        return nameSection.isDisplayed();
    }

    public String nameFieldEditable(){
        nameSection.sendKeys("Hilton");
        nameSection.clear();
        nameSection.sendKeys("Hayatt");
        String name = nameSection.getText();
        return name;
    }


}
