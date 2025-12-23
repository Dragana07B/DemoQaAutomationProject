package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.InteractionsPage;
import Pages.SideBarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortableTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        interactionsPage = new InteractionsPage();

    }
    @Test
    public void userCanRepositionFirstElementInSortableList()  {
        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Interactions");
        sideBarPage.scrollDown();
        sideBarPage.clickOnSideBarElement("Sortable");
        interactionsPage.clickOnTabList();
        interactionsPage.assertSortedListElements();
        interactionsPage.moveFirstElement(4);
        interactionsPage.assertUnsortedListElements();


    }
    @Test
    public void userCanRepositionElementThroughSortableList() throws InterruptedException {
        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Interactions");
        sideBarPage.scrollDown();
        sideBarPage.clickOnSideBarElement("Sortable");
        interactionsPage.clickOnTabList();
        sideBarPage.scrollDown();
        Thread.sleep(2000);
        interactionsPage.moveElementThroughList(2);
    }
}
