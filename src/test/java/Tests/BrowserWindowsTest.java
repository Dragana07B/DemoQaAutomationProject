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

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        alertsFrameAndWindowsPage = new AlertsFrameAndWindowsPage();

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Alerts, Frame & Windows");
        sideBarPage.clickOnSideBarElement("Browser Windows");
        Assert.assertEquals(driver.getWindowHandles().size(), 1);   //ocekujem jedan otvorern tab

    }
    @Test
    public void userCanOpenNewTab(){
        alertsFrameAndWindowsPage.clickOnNewTabButton();
        alertsFrameAndWindowsPage.assertThatTheNewTabIsOpen();  //uporedjujem  prethodni i ocekivani novi url
        Assert.assertTrue(alertsFrameAndWindowsPage.semplePageHeading.isDisplayed());   //proveravam da li je ucitana nova stranica sa Sample naslovom
    }
    @Test
    public void  userCanCloseNewTab(){
        alertsFrameAndWindowsPage.clickOnNewTabButton();
        alertsFrameAndWindowsPage.assertThatTheNewTabIsOpen();
        Assert.assertTrue(alertsFrameAndWindowsPage.semplePageHeading.isDisplayed());
        alertsFrameAndWindowsPage.closeNewTab();
        alertsFrameAndWindowsPage.verifyNewTabClose();  //proveravam ocekivani broj tabova(1) i stvaran broj tabova
        alertsFrameAndWindowsPage.verifyUserIsOnPreviousTabAndPage();
    }
    @Test
    public void userCanOpenNewWindow(){
        sideBarPage.scrollDown();
        alertsFrameAndWindowsPage.clickOnTheNewWindowButton();
        alertsFrameAndWindowsPage.assertThatNewWindowOpen();    //uporedjujem stvarni i ocekivani url
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
