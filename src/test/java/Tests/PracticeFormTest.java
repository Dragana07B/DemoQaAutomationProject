package Tests;

import Base.BaseTest;
import Pages.FormsPage;
import Pages.HomePage;
import Pages.SideBarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        formsPage = new FormsPage();
    }

    @Test
    public void userCanSubmitPracticeForm() {
        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Forms");
        sideBarPage.clickOnSideBarElement("Practice Form");
        formsPage.inputFirstName("Dzini");
        formsPage.inputLastName("Dzin");
        formsPage.inputEmail("dzini57@dzin.com");
        sideBarPage.scrollDown();
        formsPage.clickOnGednderButton("Female");
        formsPage.inputMobileNumber("006123456789");
        formsPage.clickOnDateOfBirthField();
        formsPage.clickOnMonthDropDownMenu();
        formsPage.selectMonth("Jun");
        formsPage.clickOnYearDropDownMenu();
        formsPage.selectYear("2000");
        formsPage.selectDate("6");
        formsPage.inputTextIntoSubjectsField("Comp");
        //formsPage.clickOnHobbiesRadioButton("Music");
        formsPage.clickOnAllHobbiesRadioButtons();
        formsPage.clickOnChooseFileButton();
        formsPage.inputCurrentAddress("Practice Form Street 951");
        formsPage.selectStateCustomDropdown("Raj");
        formsPage.selectCityCustomDropdown("Jais");
        formsPage.clickOnSubmitButton();
        formsPage.assertThatModalWindowIsOpen();
        formsPage.assertThatModalWindowTitleConfirmSubmitedForm();


    }
}
