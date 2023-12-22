import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PobedaPage {
    private WebDriver driver;
    @FindBy(xpath = "//img[contains(@src, 'logo-rus-white')]")
    private WebElement logo;

    private String titleTextExpected = "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками";

    public PobedaPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PobedaPage(WebDriver driver, WebDriverWait wait) {
    }

    private String titleText(){
        return driver.getTitle();
    }

    private boolean logoOnDisplay(){
        return logo.isDisplayed();
    }

    public void siteIsOpen(){
        Assert.assertEquals(this.titleText(),titleTextExpected);
        Assert.assertEquals(this.logoOnDisplay(),true);
    }
}