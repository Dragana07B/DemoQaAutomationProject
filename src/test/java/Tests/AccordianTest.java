package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SideBarPage;
import Pages.WidgetsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccordianTest extends BaseTest {

    String headerTitle1;
    String headerTitle2;
    String headerTitle3;



    @BeforeMethod
    public void pageSetUp(){


        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        widgetsPage = new WidgetsPage();

        headerTitle1 = "What is Lorem Ipsum?";
        headerTitle2 = "Where does it come from?";
        headerTitle3 = "Why do we use it?";

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Widgets");
        sideBarPage.scrollDown();
        sideBarPage.clickOnSideBarElement("Accordian");
        sideBarPage.scrollDown();
        Assert.assertTrue(widgetsPage.listPannelBodies.getFirst().isDisplayed());   //prvo proveravam da li je po
        Assert.assertFalse(widgetsPage.cardBody2.isDisplayed());                    //default-u otvoren prvi panel
        Assert.assertFalse(widgetsPage.cardBody3.isDisplayed());
        widgetsPage.clicOnPannelHeaderTitle(headerTitle1);                      // ovde zatvaram prvi panel
        wait.until(ExpectedConditions.invisibilityOf(widgetsPage.cardBody1));   // da bih testiranje pocela sa
        widgetsPage.verifyThatAllAccordianPannelsAreClosed();                   // svim zatvorenim panelima
    }

    @Test
    public void userCanOpenFirstAccordianPanel(){
        widgetsPage.clicOnPannelHeaderTitle(headerTitle1);                              //testiram otvaranje prvog panela
        Assert.assertTrue(widgetsPage.listPannelBodies.getFirst().isDisplayed());
    }
    @Test
    public void userCanOpenSecondAccordianPanel(){
        widgetsPage.clicOnPannelHeaderTitle(headerTitle2);                      // testiram otvaranje drugog panela
        Assert.assertTrue(widgetsPage.listPannelBodies.get(1).isDisplayed());
    }
    @Test
    public void userCanOpenThirdAccordianPanel(){
        widgetsPage.clicOnPannelHeaderTitle(headerTitle3);                      // testiram otvaranje treceg panela
        Assert.assertTrue(widgetsPage.listPannelBodies.get(2).isDisplayed());
    }
    @Test
    public void userCanOpenOnlyOnePanelAtTheMoment() throws InterruptedException {
        widgetsPage.clicOnPannelHeaderTitle(headerTitle1);                      // testiram naizmenicno otvaranje panela
        Assert.assertTrue(widgetsPage.cardBody1.isDisplayed());                 // i ocekujem da mi je uvek otvoren
        Assert.assertFalse(widgetsPage.cardBody2.isDisplayed());                // samo jedan, nikad vise njih u isto vreme
        Assert.assertFalse(widgetsPage.cardBody3.isDisplayed());
        widgetsPage.clicOnPannelHeaderTitle(headerTitle2);
        Assert.assertTrue(widgetsPage.cardBody2.isDisplayed());
        wait.until(ExpectedConditions.invisibilityOf(widgetsPage.cardBody1));
        Assert.assertFalse(widgetsPage.cardBody1.isDisplayed());
        Assert.assertFalse(widgetsPage.cardBody3.isDisplayed());
        widgetsPage.clicOnPannelHeaderTitle(headerTitle3);
        Assert.assertTrue(widgetsPage.cardBody3.isDisplayed());
        wait.until(ExpectedConditions.invisibilityOf(widgetsPage.cardBody2));
        Assert.assertFalse(widgetsPage.cardBody1.isDisplayed());
        Assert.assertFalse(widgetsPage.cardBody2.isDisplayed());

    }

}
