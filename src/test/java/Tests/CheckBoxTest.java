package Tests;

import Base.BaseTest;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.SideBarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxTest extends BaseTest {


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
        sideBarPage.clickOnSideBarElement("Check Box");
    }

    @Test
    public void UserCanCheckWholeCheckBoxListWhileCollapsed(){
        sideBarPage.scrollDown();
        elementsPage.assertThatNoteSelectionIsNotDisplayed();
        elementsPage.clickOnHomeCheckBox();
        elementsPage.clickOnExpandAllButton();
        wait.until(ExpectedConditions.visibilityOf(elementsPage.toggleButtonsList.getLast()));
        elementsPage.assertThatNoteSelectionAppears();
        elementsPage.assertThatEverythingIsSelected();
    }
    @Test
    public void UserCanUncheckWholeCheckBoxListWhileCollapsed(){
        sideBarPage.scrollDown();
        elementsPage.assertThatNoteSelectionIsNotDisplayed();
        elementsPage.clickOnHomeCheckBox();
        elementsPage.clickOnExpandAllButton();
        wait.until(ExpectedConditions.visibilityOf(elementsPage.toggleButtonsList.getLast()));
        elementsPage.assertThatNoteSelectionAppears();
        elementsPage.assertThatEverythingIsSelected();
        elementsPage.clickOnCollapseAllButton();
        elementsPage.clickOnHomeCheckBox();
        elementsPage.assertThatNoteSelectionIsNotDisplayed();
    }
    @Test
    public void UserCanSelectAllCheckBoxesByExpandingListUsingToggleButtons(){
        elementsPage.assertThatNoteSelectionIsNotDisplayed();
        elementsPage.clickOnToggleButtonHome();
        sideBarPage.scrollDown();
        elementsPage.clickOnToggleButtons();
        wait.until(ExpectedConditions.visibilityOf(elementsPage.toggleButtonsList.getLast()));
        elementsPage.clickOnHomeCheckBox();
        elementsPage.assertThatNoteSelectionAppears();
        elementsPage.assertThatEverythingIsSelected();
    }
    @Test
    public void UserCanUncheckAllCheckBoxesByExpandingListUsingToggleButtons(){
        elementsPage.assertThatNoteSelectionIsNotDisplayed();
        elementsPage.clickOnToggleButtonHome();
        sideBarPage.scrollDown();
        elementsPage.clickOnToggleButtons();
        wait.until(ExpectedConditions.visibilityOf(elementsPage.toggleButtonsList.getLast()));
        elementsPage.clickOnHomeCheckBox();
        elementsPage.assertThatNoteSelectionAppears();
        elementsPage.assertThatEverythingIsSelected();
        elementsPage.clickOnHomeCheckBox();
        elementsPage.assertThatNoteSelectionIsNotDisplayed();
    }



}
