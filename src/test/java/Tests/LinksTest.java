package Tests;

import Base.BaseTest;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.SideBarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LinksTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        elementsPage = new ElementsPage();

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Elements");
        sideBarPage.clickOnSideBarElement("Links");
    }

    @Test
    public void userCanOpenValidLinkInNewTab(){
        elementsPage.clickOnHomeLink();
        elementsPage.assertThatCorrectLinkIsOpenInNewTab();
        elementsPage.assertThatTitleTabIsCorrect();
    }

    @Test
    public void userCanRecieveApiCallForNotFoundLink(){
        sideBarPage.scrollDown();
        elementsPage.clickOnNotFoundLink();
        wait.until(ExpectedConditions.visibilityOf(elementsPage.responseMessage));
        elementsPage.assertThatInfoMessageIsDisplayed();
        elementsPage.assertThatInfoMessageContainsStatusCode("404");
        elementsPage.assertThatInfoMessageContainsStatusText("Not Found");
    }
}
