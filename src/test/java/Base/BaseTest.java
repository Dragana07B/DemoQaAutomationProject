package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    // deklaracija webDriver, WebDriverWait i svih stranica kako bi bile vidljive u test
    // klasama koje nasledjuju BaseTest klasu

    public static WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public SideBarPage sideBarPage;
    public WidgetsPage widgetsPage;
    public InteractionsPage interactionsPage;
    public FormsPage formsPage;
    public ElementsPage elementsPage;
    public AlertsFrameAndWindowsPage alertsFrameAndWindowsPage;


    // u SetUp metodi se vrsi set up driver-a, kreiranje objekta drivera i navigacija na home page.
    // Ovako ce objekat driver biti vidljiv u svakoj klasi koja nasledjuje BaseTest klasu
    // ScrollToElemet metoda sluzi da se skroluje do elementa koji se fizicki ne vidi na stranici koja je ucitana
    // Ovim metodama smanjujem ponavljanje istog koda u ostalim klasama

    @BeforeClass
    public void setUp(){
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); */
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");


    }
    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //CloseDriver metodom zatvaram tab, ili ceo browser
    //zakomentarisano je da bih mogla da pratim testove i u slucaju greske da je lakse uocim

    @AfterClass
    public void closeDriver(){
    //    driver.close();
    //    driver.quit();
    }



}




