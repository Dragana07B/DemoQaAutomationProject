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
            //na kraju proveravam da li sacuvana vrednost u value odgovara onoj koju sam ja unela
            //value predstavlja moju unetu vrednost i to je atribut input-a i zato ga hvatam sa getAttribut
            // podsetnik: sa getText hvatam text izmedju dva taga
    }
}
