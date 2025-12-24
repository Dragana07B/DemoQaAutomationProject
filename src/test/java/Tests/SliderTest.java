package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SideBarPage;
import Pages.WidgetsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        widgetsPage = new WidgetsPage();

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Widgets");
        sideBarPage.scrollDown();
        sideBarPage.clickOnSideBarElement("Slider");
        Assert.assertEquals(widgetsPage.sliderValue.getAttribute("value"),"25");
    }

    @Test
    public void userCanMoveSliderToTheRight(){
        widgetsPage.moveSliderToTheRight(45);
        Assert.assertEquals(widgetsPage.sliderValue.getAttribute("value"),"70");
    }
    @Test
    public void userCanMoveSliderToTheLeft() {
        widgetsPage.moveSliderToTheLeft(21);
        Assert.assertEquals(widgetsPage.sliderValue.getAttribute("value"),"4");
    }

    @AfterMethod
    public void SliderValueIsDisplayed(){
        Assert.assertTrue(widgetsPage.sliderValue.isDisplayed());
        Assert.assertTrue(widgetsPage.sliderValue.isDisplayed());
    }
}
