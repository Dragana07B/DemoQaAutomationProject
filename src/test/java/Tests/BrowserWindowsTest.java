package Tests;

import Base.BaseTest;
import Pages.AlertsFrameAndWindowsPage;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.SideBarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrowserWindowsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        alertsFrameAndWindowsPage = new AlertsFrameAndWindowsPage();

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Alerts, Frame & Windows");
        sideBarPage.clickOnSideBarElement("Browser Windows");
        Assert.assertEquals(driver.getWindowHandles().size(), 1);

    }
    @Test
    public void userCanOpenNewTab(){
        alertsFrameAndWindowsPage.clickOnNewTabButton();
        alertsFrameAndWindowsPage.assertThatTheNewTabIsOpen();
        alertsFrameAndWindowsPage.verifyNewPageLoadInNewTab();
    }
    @Test
    public void  userCanCloseNewTab(){
        alertsFrameAndWindowsPage.clickOnNewTabButton();
        alertsFrameAndWindowsPage.assertThatTheNewTabIsOpen();
        alertsFrameAndWindowsPage.verifyNewPageLoadInNewTab();
        alertsFrameAndWindowsPage.closeNewTab();
        alertsFrameAndWindowsPage.verifyNewTabClose();
        alertsFrameAndWindowsPage.verifyUserIsOnPreviousTabAndPage();
    }
    @Test
    public void userCanOpenNewWindow(){
        sideBarPage.scrollDown();
        alertsFrameAndWindowsPage.clickOnTheNewWindowButton();
        alertsFrameAndWindowsPage.assertThatNewWindowOpen();
    }

    @Test
    public void userCanOpenNewWindowMessage(){
        sideBarPage.scrollDown();
        alertsFrameAndWindowsPage.clickOnNewWindowMessageButton();

    }
    @AfterMethod
    public void assertNumberOfOpenBrowserTabs(){
        Assert.assertEquals(driver.getWindowHandles().size(), 2);
    }

}
