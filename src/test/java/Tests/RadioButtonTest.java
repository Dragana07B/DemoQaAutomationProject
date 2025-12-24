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

public class RadioButtonTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        elementsPage = new ElementsPage();

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Elements");
        sideBarPage.clickOnSideBarElement("Radio Button");
        sideBarPage.scrollDown();
    }

    @Test
    public void userCanSelectYesRadioButton(){
        Assert.assertTrue(elementsPage.yesRadioButton.isEnabled());
        elementsPage.clickOnYesRadioButton();
        Assert.assertTrue(elementsPage.selectionText.getText().contains("Yes"));
        Assert.assertTrue(elementsPage.yesRadioButton.isEnabled());
    }

    @Test
    public void userCanSelectImpressiveRadioButton(){
        Assert.assertTrue(elementsPage.impressiveRadioButton.isEnabled());
        elementsPage.clickOnImpressiveRadioButton();
        Assert.assertTrue(elementsPage.selectionText.getText().contains("Impressive"));
    }
    @Test
    public void userCanNotSelectNoRadioButton(){
        Assert.assertFalse(elementsPage.noRadioButton.isEnabled());
        Assert.assertEquals(elementsPage.noRadioButton.getCssValue("cursor"), "not-allowed");
        // CssValue cursor je Css property koji govori browseru kako kursor misa teba da izgleda na nekom polju
    }




}
