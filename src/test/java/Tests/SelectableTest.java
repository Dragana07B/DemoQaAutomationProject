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
    // u metodi verifyThatAllGridButtonsAreSelected prolazim kroz listu dugmica i trazim odredjeno koje ima text
    // jednak onome koji sam ja prosledila. Onda uzimam atribut class i stavljam ga u string Selection
    // u asertaciji proveravam da je se u tom stringu nalazi rec active. Active ce se pojaviti onda kada je dugme
    // selektovano, a kad nije, rec active nije u stringu.

    @Test
    public void userCanSelectAllGridElements() throws InterruptedException {
        sideBarPage.scrollDown();
        interactionsPage.clickOnAllGridButtons();
        interactionsPage.verifyThatAllGridButtonsAreSelected();
    }
    // u metodi userCanSelectAllGridElements prolazim kroz listu dugmica i provaravam da li se u atributu class svakog
    // dugmica nalazi string koji sadrzi rec active.

    @Test
    public void userCanDeselectAllGridButtons() throws InterruptedException {
        sideBarPage.scrollDown();
        interactionsPage.clickOnAllGridButtons();
        interactionsPage.verifyThatAllGridButtonsAreSelected();
        interactionsPage.clickOnAllGridButtons();
        interactionsPage.verifyThatAllGridButtonsAreNotSelected();
    }
    // u ovoj metodi kad deselektujem sve dugmice, proveravam da li u stringu atributa class svakog dusmica
    // nema reci active. Ako je nema, znaci da dgume nije selektovano







}
