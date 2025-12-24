package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.InteractionsPage;
import Pages.SideBarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortableTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        interactionsPage = new InteractionsPage();

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Interactions");
        sideBarPage.scrollDown();
        sideBarPage.clickOnSideBarElement("Sortable");
        interactionsPage.clickOnTabList();
        sideBarPage.scrollDown();

    }

    @Test
    public void userCanRepositionFirstElementInSortableList() {
        interactionsPage.assertSortedListElements();    //  Napravljena lista sa prvobinto sortiranim elementima
        interactionsPage.moveFirstElement("Six");
        interactionsPage.assertUnsortedListElements();
        // Napravljena lista sa izmenjenim redosledom elemenata
        // i uradjena je assertacija, poredjenje prvobitne i izmenjene liste elemenata da nisu jednake
    }
}



