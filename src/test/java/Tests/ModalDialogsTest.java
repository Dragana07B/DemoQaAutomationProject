package Tests;

import Base.BaseTest;
import Pages.AlertsFrameAndWindowsPage;
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

public class ModalDialogsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        alertsFrameAndWindowsPage = new AlertsFrameAndWindowsPage();

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Alerts, Frame & Windows");
        sideBarPage.scrollDown();
        sideBarPage.clickOnSideBarElement("Modal Dialogs");
        sideBarPage.scrollDown();
    }

    @Test
    public void userCanOpenSmallModal(){
        alertsFrameAndWindowsPage.clickOnSmallModalButton();
        Assert.assertTrue(alertsFrameAndWindowsPage.smallModalTitle.isDisplayed());
        Assert.assertTrue(alertsFrameAndWindowsPage.smallModalTitle.getText().contains("Small Modal"));
        Assert.assertTrue(alertsFrameAndWindowsPage.smallModalText.getText().contains("small modal"));
    }
    @Test
    public void userCanCloseSmallModal() {

        alertsFrameAndWindowsPage.clickOnSmallModalButton();
        Assert.assertTrue(alertsFrameAndWindowsPage.smallModalTitle.isDisplayed());
        Assert.assertTrue(alertsFrameAndWindowsPage.smallModalTitle.getText().contains("Small Modal"));
        Assert.assertTrue(alertsFrameAndWindowsPage.smallModalText.getText().contains("small modal"));
        wait.until(ExpectedConditions.elementToBeClickable(alertsFrameAndWindowsPage.smallModalCloseButton));
        alertsFrameAndWindowsPage.clickOnSmallModalCloseButton();
        wait.until(ExpectedConditions.invisibilityOf(alertsFrameAndWindowsPage.smallModalCloseButton));
        alertsFrameAndWindowsPage.assertSmallModalDialogClose();    //sa try/catch proveravam da li je close button vidljiv
    }

    @Test
    public void userCanOpenLargeModal(){
        alertsFrameAndWindowsPage.clickOnLargeModalButton();
        Assert.assertTrue(alertsFrameAndWindowsPage.largeModalTitle.isDisplayed());
        Assert.assertTrue(alertsFrameAndWindowsPage.largeModalTitle.getText().contains("Large Modal"));
            }

    @Test
    public void userCanCloseLargeModal(){
        alertsFrameAndWindowsPage.clickOnLargeModalButton();
        Assert.assertTrue(alertsFrameAndWindowsPage.largeModalTitle.isDisplayed());
        Assert.assertTrue(alertsFrameAndWindowsPage.largeModalTitle.getText().contains("Large Modal"));
        wait.until(ExpectedConditions.elementToBeClickable(alertsFrameAndWindowsPage.largeModalCloseButton));
        alertsFrameAndWindowsPage.clickOnLargeModalCloseButton();
        wait.until(ExpectedConditions.invisibilityOf(alertsFrameAndWindowsPage.largeModalCloseButton));
        alertsFrameAndWindowsPage.assertLargeModalDialogsClose();   //sa try/catch proveravam da li je close button vidljiv
    }





}
