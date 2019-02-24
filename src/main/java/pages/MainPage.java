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

public class MainPage {

    private WebDriver driver;

    private static final String MAIN_URL = "http://localhost:8080/article/faces/welcome.xhtml";

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//span[text()[contains(.,'Article')]]")
    private WebElement article;

    @FindBy (xpath = "//span[text()[contains(.,'New')]]")
    private WebElement news;

    @FindBy (xpath = "//span[text()[contains(.,'View')]]")
    private WebElement view;

    @FindBy (xpath = "//span[text()[contains(.,'Import Data')]]")
    private WebElement importData;

    @FindBy (xpath = "//span[text()[contains(.,'Quit')]]")
    private WebElement quit;

    @FindBy (xpath = "//span[text()[contains(.,'Hotel')]]")
    private WebElement hotel;

    @FindBy (xpath = "//span[text()[contains(.,'Country')]]")
    private WebElement country;

    @FindBy (xpath = "//span[text()[contains(.,'City')]]")
    private WebElement city;

    @FindBy (xpath = "//span[text()[contains(.,'Other')]]")
    private WebElement other;

    @FindBy (xpath = "//span[text()[contains(.,'Hotels')]]")
    private WebElement hotels;

    @FindBy (xpath = "//span[text()[contains(.,'Countries')]]")
    private WebElement countries;

    @FindBy (xpath = "//span[text()[contains(.,'Cities')]]")
    private WebElement cities;

    @FindBy (xpath = "//span[text()[contains(.,'Statistic')]]")
    private WebElement statistic;

    @FindBy (xpath = "//span[text()[contains(.,'Edit')]]")
    private WebElement edit;

    @FindBy (xpath = "//span[text()[contains(.,'Undo')]]")
    private WebElement undo;

    @FindBy (xpath = "//span[text()[contains(.,'Redu')]]")
    private WebElement redu;

    @FindBy (xpath = "//span[text()[contains(.,'Help')]]")
    private WebElement help;

    @FindBy (xpath = "//span[text()[contains(.,'Contents')]]")
    private WebElement contents;

    @FindBy (xpath = "//span[text()[contains(.,'Search')]]")
    private WebElement search;

    @FindBy (xpath = "//span[text()[contains(.,'Text')]]")
    private WebElement text;

    @FindBy (xpath = "//span[text()[contains(.,'File')]]")
    private WebElement file;

    @FindBy (xpath = "//span[text()[contains(.,'Workspace')]]")
    private WebElement workspace;

    @FindBy (xpath = "//span[text()[contains(.,'Quit')]]")
    private WebElement quitButton;

    @FindBy (xpath = "//input[@id='header_form:j_idt34']")
    private WebElement searchField;

    @FindBy (xpath = "//button[@id='header_form:j_idt35']")
    private WebElement logOut;

    public void clickArticle(){
        Actions actions = new Actions(driver);
        actions.moveToElement(article).build().perform();

    }

    public void clickNews(){
        Actions actions = new Actions(driver);
        actions.moveToElement(news).build().perform();

    }

    public void clickView() {
        Actions actions = new Actions(driver);
        actions.moveToElement(view).build().perform();
    }


    public void clickQuit(){
        quit.click();
    }

    public void clickHotel(){
        hotel.click();
    }

    public void clickCountry(){
        country.click();
    }

    public void clickCity(){
        city.click();
    }

    public void clickOther(){
        other.click();
    }

    public void clickHotels(){
        hotels.click();
    }

    public void clickCountries(){
        countries.click();
    }

    public void clickCities(){
        cities.click();
    }

    public void clickStatistic(){
        statistic.click();
    }

    public void clickEdit(){
        Actions actions = new Actions(driver);
        actions.moveToElement(edit).build().perform();
    }

    public void clickUndo(){
        undo.click();
    }

    public void clickRedu(){
        redu.click();
    }

    public void clickHelp(){
        Actions actions = new Actions(driver);
        actions.moveToElement(help).build().perform();
    }

    public void clickContents(){
        contents.click();
    }

    public void clickSearch(){
        Actions actions = new Actions(driver);
        actions.moveToElement(search).build().perform();
    }

    public void clickText(){
        Actions actions = new Actions(driver);
        actions.moveToElement(text).build().perform();
    }

    public void clickFile(){
        file.click();
    }

    public void clickWorkspace(){
        workspace.click();
    }

    public void clickSearchField(){
        searchField.click();
    }

    public void clickLogOut(){
        logOut.click();
    }

}
