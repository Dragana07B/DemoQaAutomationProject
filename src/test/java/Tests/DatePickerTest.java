package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SideBarPage;
import Pages.WidgetsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerTest extends BaseTest {



    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        widgetsPage = new WidgetsPage();
    }

    @Test
    public void userCanSelectDateWithDatePicker() throws InterruptedException {
        scrollToElement(homePage.cardsList.getLast());
        homePage.clickOnCard("Widgets");
        sideBarPage.scrollDown();
        sideBarPage.clickOnSideBarElement("Date Picker");
        widgetsPage.clickOnSelectDateField();
        widgetsPage.clickOnMonthDropDown();
        widgetsPage.selectMonth("May");
        Assert.assertTrue(widgetsPage.monthDropDown.getText().contains("May"));
        widgetsPage.clikOnYearDropDown();
        widgetsPage.selectYear("1989");
        Assert.assertTrue((widgetsPage.yearDropDown.getText().contains("1989")));
        widgetsPage.selectDate("1");
        Assert.assertTrue(widgetsPage.selectDateField.getAttribute("value").contains("05/01/1989"));




    }
}
