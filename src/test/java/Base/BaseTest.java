package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public SideBarPage sideBarPage;
    public WidgetsPage widgetsPage;
    public InteractionsPage interactionsPage;
    public FormsPage formsPage;
    public ElementsPage elementsPage;
    public AlertsFrameAndWindowsPage alertsFrameAndWindowsPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();

    }
    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }



}




