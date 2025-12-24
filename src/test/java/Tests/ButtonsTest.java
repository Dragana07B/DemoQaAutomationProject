package Tests;

import Base.BaseTest;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.SideBarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ButtonsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        elementsPage = new ElementsPage();

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Elements");
        sideBarPage.scrollDown();
        sideBarPage.clickOnSideBarElement("Buttons");

    }

    @Test
    public void userCanDoubleClickOnButton(){
        elementsPage.clickTwiceOnDoubleClickMeButton();
        Assert.assertTrue(elementsPage.doubleInfo.isDisplayed());
        Assert.assertTrue(elementsPage.doubleInfo.getText().contains("double click"));
    }
    @Test
    public void userCanRightClickOnButton(){
        elementsPage.clickWithRightButtonOnRightClickMeButton();
        Assert.assertTrue(elementsPage.rightInfo.isDisplayed());
        Assert.assertTrue(elementsPage.rightInfo.getText().contains("right click"));
    }
    @Test
    public void userCanClickOnButton() {
        sideBarPage.scrollDown();
        elementsPage.clickOnClickMeButton();
        Assert.assertTrue(elementsPage.clickInfo.isDisplayed());
        Assert.assertTrue(elementsPage.clickInfo.getText().contains("dynamic click"));
    }









}
