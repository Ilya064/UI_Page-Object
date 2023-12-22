import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Booking {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[contains(@class, 'dp-1glhebn-root-textVisible') and text() = 'Управление бронированием']")
    private WebElement bookingManagementButton;
    @FindBy(css = "[placeholder='Фамилия клиента']")
    private WebElement surnameClient;
    @FindBy(css = "[placeholder='Номер заказа или билета']")
    private WebElement orderNumber;
    @FindBy(xpath = "//button[text()='Поиск']")
    private WebElement searchButton;
    @FindBy(xpath = "//div[text()='Некорректный номер']")
    private WebElement errorMessage;

    public Booking(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    private boolean errorMessageOnDisplay(){
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.isDisplayed();
    }

    private boolean searchButtonOnDisplay(){
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        return searchButton.isDisplayed();
    }

    private boolean surnameClientOnDisplay(){
        wait.until(ExpectedConditions.visibilityOf(surnameClient));
        return surnameClient.isDisplayed();
    }

    private boolean orderNumberOnDisplay(){
        wait.until(ExpectedConditions.visibilityOf(orderNumber));
        return orderNumber.isDisplayed();
    }

    private void surnameClientInput(String surname){
        surnameClient.sendKeys(surname);
    }

    private void orderNumberInput(String order){
        orderNumber.sendKeys(order);
    }


    public void clickBookingManagementPage() {
        bookingManagementButton.click();
    }

    public void bookingManagementPageIsOpen() {
        Assert.assertEquals(surnameClientOnDisplay(),true);
        Assert.assertEquals(orderNumberOnDisplay(),true);
        Assert.assertEquals(searchButtonOnDisplay(),true);
    }

    public void inputData() {
        surnameClientInput("qwerty");
        orderNumberInput("XXXXXXXX");
        searchButton.click();
    }

    public void checkErrorOnDisplay() {
        Assert.assertEquals(errorMessageOnDisplay(),true);
    }
}