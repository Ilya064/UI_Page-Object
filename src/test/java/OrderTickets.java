import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderTickets {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//div[contains(@class, 'dp-1glhebn-root-textVisible') and text() = 'Поиск билета']")
    private WebElement searchTicketButton;
    @FindBy(css = "[placeholder='Откуда'][autocomplete='off']")
    private WebElement cityFrom;
    @FindBy(css = "[placeholder='Куда'][autocomplete='off']")
    private WebElement cityIn;
    @FindBy(css = "[placeholder='Туда']")
    private WebElement departureDateThere;
    @FindBy(css = "[placeholder='Обратно']")
    private WebElement departureDateReturn;
    @FindBy(css = ".dp-ew66p9-root-root[type='submit']")
    private WebElement searchButton;

    @FindBy(css = "[data-errored='true'] [placeholder='Туда']")
    private WebElement dataErrorThere;

    public OrderTickets(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    private boolean searchTicketButtonOnDisplay(){
        wait.until(ExpectedConditions.visibilityOf(searchTicketButton));
        return searchTicketButton.isDisplayed();
    }

    private boolean cityFromOnDisplay(){
        wait.until(ExpectedConditions.visibilityOf(cityFrom));
        return cityFrom.isDisplayed();
    }
    private void cityFromInput(String city){
        wait.until(ExpectedConditions.visibilityOf(cityFrom));
        cityFrom.sendKeys("Москва");
        cityFrom.sendKeys(Keys.ENTER);
    }


    private boolean cityInOnDisplay(){
        wait.until(ExpectedConditions.visibilityOf(cityIn));
        return cityIn.isDisplayed();
    }

    private void cityInInput(String city){
        wait.until(ExpectedConditions.visibilityOf(cityFrom));
        cityIn.sendKeys("Санкт-Петербург");
        cityIn.sendKeys(Keys.ENTER);
    }

    private boolean departureDateThereOnDisplay(){
        wait.until(ExpectedConditions.visibilityOf(departureDateThere));
        return departureDateThere.isDisplayed();
    }

    private boolean departureDateReturnOnDisplay(){
        wait.until(ExpectedConditions.visibilityOf(departureDateReturn));
        return departureDateReturn.isDisplayed();
    }

    private boolean dataErrorThereOnDisplay(){
        wait.until(ExpectedConditions.visibilityOf(dataErrorThere));
        return dataErrorThere.isDisplayed();
    }

    public void searchTiketIsOpen() {
        Assert.assertEquals(this.searchTicketButtonOnDisplay(),true);
        Assert.assertEquals(this.cityFromOnDisplay(),true);
        Assert.assertEquals(this.cityInOnDisplay(),true);
        Assert.assertEquals(this.departureDateThereOnDisplay(),true);
        Assert.assertEquals(this.departureDateReturnOnDisplay(),true);
    }

    public void enterSearchCriteria() {
        cityFromInput("Москва");
        cityInInput("Санкт-Петербург");
    }

    public void clickButtonSearch() {
        searchButton.click();
    }

    public void checkFieldThere() {
        Assert.assertEquals(dataErrorThereOnDisplay(),true);
    }
}