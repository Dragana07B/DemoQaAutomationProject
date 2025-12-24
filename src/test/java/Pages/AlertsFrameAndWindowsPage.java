package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.ArrayList;

public class AlertsFrameAndWindowsPage extends BaseTest {

    public AlertsFrameAndWindowsPage(){
        PageFactory.initElements(driver,this);
    }

    // Browser windows
    @FindBy(id = "tabButton")
    WebElement tabButton;
    @FindBy(css = "h1[id='sampleHeading']")
    public WebElement semplePageHeading;
    @FindBy(id = "windowButton")
    public WebElement newWindowButton;
    @FindBy(id = "messageWindowButton")
    WebElement newWindowMessageButton;


    //  Modal dialog
    @FindBy(id = "showSmallModal")
    WebElement smallModalButton;
    @FindBy(id = "example-modal-sizes-title-sm")
    public WebElement smallModalTitle;
    @FindBy(id = "closeSmallModal")
    public WebElement smallModalCloseButton;
    @FindBy(className = "modal-body")
    public WebElement smallModalText;
    @FindBy(id = "showLargeModal")
    WebElement largeModalButton;
    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement largeModalTitle;
    @FindBy(id = "closeLargeModal")
    public WebElement largeModalCloseButton;

    //-----------------------------------------

    //  Browser Windows
    public void clickOnNewTabButton(){
        tabButton.click();
    }
    public void getTab(int tab){
        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(tab));
    }
    public void assertThatTheNewTabIsOpen() {
        getTab(1);
        String newTabUrl = "https://demoqa.com/sample";
        Assert.assertEquals(driver.getCurrentUrl(),newTabUrl);
    }

    public void clickOnTheNewWindowButton(){
        newWindowButton.click();
    }
    public void assertThatNewWindowOpen(){
        getTab(1);
        String expectedUrl = "https://demoqa.com/sample";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    public void clickOnNewWindowMessageButton(){
        newWindowMessageButton.click();
    }

    public void closeNewTab(){
        driver.close();
    }
    public void verifyNewTabClose(){
        int expectedTabNum = 1;
        int actualTabNum = driver.getWindowHandles().size();
        Assert.assertEquals(actualTabNum,expectedTabNum);
    }
    public void verifyUserIsOnPreviousTabAndPage(){
        getTab(0);
        String expectedUrl = "https://demoqa.com/browser-windows";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }


    //  Modal Dialog
    public void clickOnSmallModalButton(){
        smallModalButton.click();
    }
    public void clickOnSmallModalCloseButton(){
        smallModalCloseButton.click();
    }
    public void clickOnLargeModalButton(){
        largeModalButton.click();
    }

    public void clickOnLargeModalCloseButton(){
        largeModalCloseButton.click();
    }
    public void assertSmallModalDialogClose(){
        boolean closeVisible = false;
        try{
            closeVisible = smallModalCloseButton.isDisplayed();
        } catch (Exception e) {
            System.out.println("Close button is not visible");
        }
        Assert.assertFalse(closeVisible);
    }
    public void assertLargeModalDialogsClose(){
        boolean closeVisible = false;
        try{
            closeVisible = largeModalCloseButton.isDisplayed();
        } catch (Exception e){
            System.out.println("Close button is not vissible");
        }
        Assert.assertFalse(closeVisible);
    }



}
