package Tests;

import Base.BaseTest;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.SideBarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrokenLinksImagesTest extends BaseTest {

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
        sideBarPage.scrollDown();
        sideBarPage.clickOnSideBarElement("Broken Links - Images");
    }

    @Test
    public void userCanSeeDisplayedValidImage(){
        Assert.assertTrue(elementsPage.validImage.isDisplayed());
        elementsPage.verifyThatValidImageSrcExistAndItIsValid();
        elementsPage.verifyThatValidImageIsVisibleOnPage();
    }
    @Test
    public void userCanNotSeeBrokenImage(){
        Assert.assertTrue(elementsPage.brokenImage.isDisplayed());
        elementsPage.verifyThatBrokenImageSrcExistAndItIsValid();
        elementsPage.verifyThatBrokenImageIsNotVisibleOnPage();
    }

    @Test
    public void userCanOpenPageWithValidLink(){
        sideBarPage.scrollDown();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/broken");
        elementsPage.clickOnValidLink();
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/");
    }

    @Test
    public void userCanNotOpenPageWithBrokenLink() {
        sideBarPage.scrollDown();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/broken");
        elementsPage.clickOnBrokenLink();
        wait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/status_codes/500"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/500");
        elementsPage.assert500CodeStatus();


    }

}
