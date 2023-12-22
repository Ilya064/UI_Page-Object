import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Information {
    private WebDriver driver;
    @FindBy(css = "[href='/information']")
    private WebElement information;
    @FindBy(css = "[href='/information#flight']")
    private WebElement flyInformation;
    @FindBy(css = "[href='/information#useful']")
    private WebElement informationUseful;
    @FindBy(css = "[href='/information#company']")
    private WebElement companyInformation;
    public Information(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void moveMouseInformation(){
        Actions action = new Actions(driver);
        action.moveToElement(information).build().perform();
    }

    private boolean flyInformationOnDisplay(){
        return flyInformation.isDisplayed();
    }

    private boolean informationUsefulOnDisplay(){
        return informationUseful.isDisplayed();
    }

    private boolean companyInformationOnDisplay(){
        return companyInformation.isDisplayed();
    }

    public void informationMenuIsOpen(){
        this.moveMouseInformation();
        Assert.assertEquals(this.flyInformationOnDisplay(),true);
        Assert.assertEquals(this.informationUsefulOnDisplay(),true);
        Assert.assertEquals(this.companyInformationOnDisplay(),true);
    }
}