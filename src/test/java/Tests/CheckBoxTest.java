package Tests;

import Base.BaseTest;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.SideBarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        elementsPage = new ElementsPage();

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Elements");
        sideBarPage.clickOnSideBarElement("Check Box");

        elementsPage.assertThatNoteSelectionIsNotDisplayed();   // uradjeno sa try/catch
        sideBarPage.scrollDown();
    }

    @Test
    public void UserCanCheckWholeCheckBoxListWhileCollapsed(){

        elementsPage.clickOnHomeCheckBox();
        elementsPage.clickOnExpandAllButton();
        wait.until(ExpectedConditions.visibilityOf(elementsPage.toggleButtonsList.getLast()));
        Assert.assertTrue(elementsPage.selectionNote.isDisplayed());
        elementsPage.assertThatEverythingIsSelected();      //  asertaciju sam uradila u metodi jer je dugacka lista selekcije
    }
    @Test
    public void UserCanUncheckWholeCheckBoxListWhileCollapsed(){
        elementsPage.clickOnHomeCheckBox();
        elementsPage.clickOnExpandAllButton();
        wait.until(ExpectedConditions.visibilityOf(elementsPage.toggleButtonsList.getLast()));
        Assert.assertTrue(elementsPage.selectionNote.isDisplayed());
        elementsPage.assertThatEverythingIsSelected();
        elementsPage.clickOnCollapseAllButton();
        elementsPage.clickOnHomeCheckBox();
        elementsPage.assertThatNoteSelectionIsNotDisplayed();   // uradjeno sa try/catch
    }
    @Test
    public void UserCanSelectAllCheckBoxesByExpandingListUsingToggleButtons(){
        elementsPage.clickOnToggleButtonHome();
        elementsPage.clickOnToggleButtons();
        wait.until(ExpectedConditions.visibilityOf(elementsPage.toggleButtonsList.getLast()));
        elementsPage.clickOnHomeCheckBox();
        Assert.assertTrue(elementsPage.selectionNote.isDisplayed());
        elementsPage.assertThatEverythingIsSelected();
    }
    @Test
    public void UserCanUncheckAllCheckBoxesByExpandingListUsingToggleButtons(){
        elementsPage.clickOnToggleButtonHome();
        elementsPage.clickOnToggleButtons();
        wait.until(ExpectedConditions.visibilityOf(elementsPage.toggleButtonsList.getLast()));
        elementsPage.clickOnHomeCheckBox();
        Assert.assertTrue(elementsPage.selectionNote.isDisplayed());
        elementsPage.assertThatEverythingIsSelected();
        elementsPage.clickOnHomeCheckBox();
        elementsPage.assertThatNoteSelectionIsNotDisplayed();   // uradjeno sa try/catch
    }





}
