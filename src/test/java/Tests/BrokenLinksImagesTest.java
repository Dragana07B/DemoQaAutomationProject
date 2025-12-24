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
        Assert.assertNotNull(elementsPage.validImage.getAttribute("src"));
        Assert.assertFalse(elementsPage.validImage.getAttribute("src").isEmpty());
        Assert.assertTrue(elementsPage.validImage.getAttribute("src").contains("Toolsqa"));
        Assert.assertNotEquals(elementsPage.validImage.getAttribute("naturalWidth"), "0");
        Assert.assertNotEquals(elementsPage.validImage.getAttribute("naturalHeight"),"0");
        // u ovim asertacijama koristim atribute da bih proverila da li se slika stvarno vidi na stranici
        // naturalWidth i naturalHeight su JavaScript property i ako su vece od nule, to znaci da je slika
        // ucitana. U suprotnom, src moze da postoji, ali da slika nije ucitana -> broken image(sledeci test)
    }
    @Test
    public void userCanNotSeeBrokenImage(){
        Assert.assertTrue(elementsPage.brokenImage.isDisplayed());
        Assert.assertNotNull(elementsPage.brokenImage.getAttribute("src"));
        Assert.assertFalse(elementsPage.brokenImage.getAttribute("src").isEmpty());
        Assert.assertTrue(elementsPage.brokenImage.getAttribute("src").contains("Toolsqa"));
        Assert.assertEquals(elementsPage.brokenImage.getAttribute("naturalWidth"), "0");
        Assert.assertEquals(elementsPage.brokenImage.getAttribute("naturalHeight"),"0");
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
        Assert.assertTrue(elementsPage.statusCode.getText().contains("500 status code"));


    }

}
