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

public class DynamicPropertiesTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        elementsPage = new ElementsPage();

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Elements");
        sideBarPage.scrollDown();
        sideBarPage.clickOnSideBarElement("Dynamic Properties");
    }

    @Test
    public void userCanClickWillEnable5SecondsButtonAfter5Seconds(){
        Assert.assertTrue(elementsPage.willEneble5SecondsButton.isDisplayed());
        Assert.assertFalse(elementsPage.willEneble5SecondsButton.isEnabled());
        wait.until(ExpectedConditions.elementToBeClickable(elementsPage.willEneble5SecondsButton));
        elementsPage.clickOnWillEnable5SecondsButton();
    }
    @Test
    public void userCanNoticeColorChangeButtonChangeTextColor(){
        elementsPage.checkTheBasicColor();                  // uzela sam CSS value color pre promene
        wait.until(ExpectedConditions.elementToBeClickable(elementsPage.willEneble5SecondsButton));
        elementsPage.assertChangeOfColor();                 // uzela sam CSS value color posle promene. U asertaciji notEquals sam uporedila boje
        elementsPage.clickOnCloroChangeButton();
    }
    @Test
    public void userCanNotSeeVisibleAfter5SecondsButtonUntilItAppears(){
        elementsPage.assertThatVisibleAfter5SecondsIsNotDisplayed();        // uradjeno sa try/catch
        wait.until(ExpectedConditions.visibilityOf(elementsPage.visibleAfter5SecondsButton));
        Assert.assertTrue(elementsPage.visibleAfter5SecondsButton.isDisplayed(), "Button is visible after 5 seconds");

    }
}
