package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SideBarPage;
import Pages.WidgetsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccordianTest extends BaseTest {

    String headerTitle1;
    String headerTitle2;
    String headerTitle3;



    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

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
        widgetsPage.verifyThatFirstAccordianPannelIsExpand();
        widgetsPage.verifyThatOtherAccordianPannels2And3AreCollapsed();
        widgetsPage.clicOnPannelHeaderTitle(headerTitle1);
        wait.until(ExpectedConditions.invisibilityOf(widgetsPage.cardBody1));
        widgetsPage.verifyThatAllAccordianPannelsAreClosed();
    }

    @Test
    public void userCanOpenFirstAccordianPanel(){
        widgetsPage.clicOnPannelHeaderTitle(headerTitle1);
        widgetsPage.verifyThatFirstAccordianPannelIsExpand();

    }
    @Test
    public void userCanOpenSecondAccordianPanel(){
        widgetsPage.clicOnPannelHeaderTitle(headerTitle2);
        widgetsPage.verifyThatSecondAccordianPannelIsExpand();

    }
    @Test
    public void userCanOpenThirdAccordianPanel(){
        widgetsPage.clicOnPannelHeaderTitle(headerTitle3);
        widgetsPage.verifyThatThirdAccordianPannelIsExpand();
    }
    @Test
    public void serCanOpenOnlyOnePanelAtTheMoment(){
        widgetsPage.clicOnPannelHeaderTitle(headerTitle1);
        widgetsPage.verifyThatFirstAccordianPannelIsExpand();
        widgetsPage.verifyThatOtherAccordianPannels2And3AreCollapsed();
        widgetsPage.clicOnPannelHeaderTitle(headerTitle2);
        widgetsPage.verifyThatSecondAccordianPannelIsExpand();
        widgetsPage.verifyThatOtherAccordianPannels1And3AreCollapsed();
        widgetsPage.clicOnPannelHeaderTitle(headerTitle3);
        widgetsPage.verifyThatThirdAccordianPannelIsExpand();
        widgetsPage.verifyThatOtherAccordianPannels1And2AreCollapsed();


    }

}
