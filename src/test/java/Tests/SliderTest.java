package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SideBarPage;
import Pages.WidgetsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        widgetsPage = new WidgetsPage();

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Widgets");
        sideBarPage.scrollDown();
        sideBarPage.clickOnSideBarElement("Slider");
        widgetsPage.assertBasicValue();

    }

    @Test
    public void userCanMoveSliderToTheRight(){
        widgetsPage.moveSliderToTheRight(25);
        widgetsPage.assertNewValueOfRangeSliderIsDisplayed();
        widgetsPage.assertDisplayedValueIsCorrect("50");
    }
    @Test
    public void userCanMoveSliderToTheLeft() {
        widgetsPage.moveSliderToTheLeft(25);
        widgetsPage.assertNewValueOfRangeSliderIsDisplayed();
        widgetsPage.assertDisplayedValueIsCorrect("0");
    }
}
