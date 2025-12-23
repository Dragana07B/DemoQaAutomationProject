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

public class DynamicPropertiesTest extends BaseTest {

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
        sideBarPage.clickOnSideBarElement("Dynamic Properties");

    }

    @Test
    public void userCanClickWillEnable5SecondsButtonAfter5Seconds(){
        elementsPage.assertWillEnable5SecondsButtonIsDisplayed();
        elementsPage.assertThatButtonIsNotClickable();
        wait.until(ExpectedConditions.elementToBeClickable(elementsPage.willEneble5SecondsButton));
        elementsPage.clickOnWillEnable5SecondsButton();
    }
    @Test
    public void userCanNoticeColorChangeButtonChangeTextColor(){
        elementsPage.checkTheBasicColor();
        wait.until(ExpectedConditions.elementToBeClickable(elementsPage.willEneble5SecondsButton));
        elementsPage.assertChangeOfColor();
        elementsPage.clickOnCloroChangeButton();
    }
    @Test
    public void userCanNotSeeVisibleAfter5SecondsButtonUntilItAppears(){
        elementsPage.assertThatVisibleAfter5SecondsIsNotDisplayed();
        wait.until(ExpectedConditions.visibilityOf(elementsPage.visibleAfter5SecondsButton));
        elementsPage.assertThatVisibleAfter5SecondsIsDisplayed();
        elementsPage.clickOnVisibleAfter5SecondsButton();
    }
}
