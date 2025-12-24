package Tests;

import Base.BaseTest;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.SideBarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LinksTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        elementsPage = new ElementsPage();

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Elements");
        sideBarPage.clickOnSideBarElement("Links");
        sideBarPage.scrollDown();
    }
    String statusCode = "404";
    String statusText = "Not Found";



    @Test
    public void userCanOpenValidLinkInNewTab(){
        elementsPage.clickOnHomeLink();
        elementsPage.getTab(1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/");
        elementsPage.getTab(1);
        Assert.assertTrue(driver.getTitle().contains("DEMOQA"));
    }

    @Test
    public void userCanRecieveApiCallForNotFoundLink(){
        elementsPage.clickOnNotFoundLink();
        wait.until(ExpectedConditions.visibilityOf(elementsPage.responseMessage));
        Assert.assertTrue(elementsPage.responseMessage.isDisplayed());
        Assert.assertTrue(elementsPage.responseMessage.getText().contains(statusCode));
        Assert.assertTrue(elementsPage.responseMessage.getText().contains(statusText));
    }
}
