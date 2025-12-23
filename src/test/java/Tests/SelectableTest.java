package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.InteractionsPage;
import Pages.SideBarPage;
import Pages.WidgetsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectableTest extends BaseTest {

    @BeforeMethod
    public void PageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        interactionsPage = new InteractionsPage();

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Interactions");
        sideBarPage.scrollDown();
        sideBarPage.clickOnSideBarElement("Selectable");
        interactionsPage.clickOnTabGrid();
    }

    @Test
    public void userCanSelectOneGridElement(){
        interactionsPage.clickOnGridButton("Two");
        interactionsPage.verifyThatGridButtonIsSelected("Two");
    }

    @Test
    public void userCanSelectAllGridElements() throws InterruptedException {
        sideBarPage.scrollDown();
        interactionsPage.clickOnAllGridButtons();
        interactionsPage.verifyThatAllGridButtonsAreSelected();
    }
    @Test
    public void userCanDeselectAllGridButtons() throws InterruptedException {
        sideBarPage.scrollDown();
        interactionsPage.clickOnAllGridButtons();
        interactionsPage.verifyThatAllGridButtonsAreSelected();
        interactionsPage.clickOnAllGridButtons();
        interactionsPage.verifyThatAllGridButtonsAreNotSelected();
    }







}
