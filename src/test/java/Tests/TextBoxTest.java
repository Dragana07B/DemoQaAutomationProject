package Tests;

import Base.BaseTest;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.SideBarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBoxTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        elementsPage = new ElementsPage();

        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Elements");
        sideBarPage.clickOnSideBarElement("Text Box");

    }
    String fullName = "Dzini Dz. Dzin";
    String eMail = "dzini@dz.com";
    String currentAddress = "Current Address Dzini 51";
    String permanentAddress = "Permanent Address Dzin 15";
    String invalidEMail = "dzini@dz";


    @Test
    public void userCanInputValidDataIntoTextBoxAndSubmit() {
        elementsPage.inputFullNameIntoFullNameField(fullName);
        elementsPage.inputEMailIntoEMailField(eMail);
        elementsPage.inputCurrentAddress(currentAddress);
        elementsPage.inputPermanentAddress(permanentAddress);
        sideBarPage.scrollDown();
        elementsPage.clickOnSubmitButton();
        Assert.assertTrue(elementsPage.outputField.getText().contains(fullName));
        Assert.assertTrue(elementsPage.outputField.getText().contains(eMail));
        Assert.assertTrue(elementsPage.outputField.getText().contains(currentAddress));
        Assert.assertTrue(elementsPage.outputField.getText().contains(permanentAddress));
    }
    @Test
    public void userCanNotSubmitTextBoxWithInvalidEmail(){
        elementsPage.inputFullNameIntoFullNameField(fullName);
        elementsPage.inputEMailIntoEMailField(invalidEMail);
        elementsPage.inputCurrentAddress(currentAddress);
        elementsPage.inputPermanentAddress(permanentAddress);
        sideBarPage.scrollDown();
        elementsPage.clickOnSubmitButton();
        Assert.assertTrue(elementsPage.outputField.getText().isEmpty());
        elementsPage.assertThatEmailFieldBorderColorIsRed();
        // u asertaciji prvo uzimam bassic boju ivice polja
        // nakon unosa pogresnog eMaila, uzimam novu boju nakon promene
        // onda ih poredim da nisu jednake preko assertFalse
    }
}
