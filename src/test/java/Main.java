import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement exampleElement;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/IKHalizov/Desktop/AT-Cource/UI/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofMillis(10));
        driver.get("https://pobeda.aero/");
    }
    @Test
    public void testInformationMenu(){
        PobedaPage mainPage = new PobedaPage(driver);
        Information infoPage = new Information(driver);
        mainPage.siteIsOpen();
        infoPage.informationMenuIsOpen();
    }

    @Test
    public void testTicketSearch(){
        PobedaPage mainPage = new PobedaPage(driver);
        OrderTickets orderTicket = new OrderTickets(driver, wait);

        mainPage.siteIsOpen();
        orderTicket.searchTiketIsOpen();
        orderTicket.enterSearchCriteria();
        orderTicket.clickButtonSearch();
        orderTicket.checkFieldThere();
    }

    @Test
    public void testBookingManagement(){
        PobedaPage mainPage = new PobedaPage(driver);
        Booking bookingManagementPage = new Booking(driver, wait);
        mainPage.siteIsOpen();
        bookingManagementPage.clickBookingManagementPage();
        bookingManagementPage.bookingManagementPageIsOpen();
        bookingManagementPage.inputData();
        bookingManagementPage.checkErrorOnDisplay();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}