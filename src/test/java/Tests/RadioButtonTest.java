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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/");

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
        elementsPage.assertThatYesRadioButtonIsEnabled();
        elementsPage.clickOnYesRadioButton();
        elementsPage.assertThatYesButtonIsSelected();
    }

    @Test
    public void userCanSelectImpressiveRadioButton(){
        elementsPage.assertThatImpressiveRadioButtonIsEnabled();
        elementsPage.clickOnImpressiveRadioButton();
        elementsPage.assertThatImpressiveButtonIsSelected();
    }
    @Test
    public void userCanNotSelectNoRadioButton(){
        Assert.assertFalse(elementsPage.noRadioButton.isEnabled());
        elementsPage.verifyThatCursorIsNotAllowedOverNoButton();
    }




}
