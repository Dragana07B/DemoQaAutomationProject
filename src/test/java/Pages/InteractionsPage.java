package Pages;

import Base.BaseTest;
import org.apache.commons.math3.optim.nonlinear.scalar.LineSearch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v142.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class InteractionsPage extends BaseTest {

    public InteractionsPage() {
        PageFactory.initElements(driver, this);
    }


    //  Sortable list
    @FindBy(id = "demo-tab-list")
    WebElement tabListButton;
    @FindBy(css = ".list-group-item.list-group-item-action")
    public List<WebElement> sortCardsList;

    //  Selectable grid
    @FindBy(id = "demo-tab-grid")
    WebElement tabGridButton;
    @FindBy(css = ".list-group-item.list-group-item-action")
    List<WebElement> gridButtonsList;


    //----------------------------------------------------------------------------


    //  Sortable list
    public void clickOnTabList() {
        tabListButton.click();
    }
    public void moveFirstElement(String moveTo) {
        Actions move = new Actions(driver);
        WebElement target = sortCardsList.getFirst();
        WebElement destination = null;
        for(WebElement card: sortCardsList){
            if(card.getText().equals(moveTo)) {
                destination = card;
            }
        }
        move.clickAndHold(target).moveToElement(destination).release().build().perform();
    }

    private List<String> sortedListElements;

    public  void assertSortedListElements(){
        sortedListElements = new ArrayList<>();
        for (WebElement el : sortCardsList) {
            sortedListElements.add(el.getText());
        }
        System.out.println(sortedListElements);
    }

    public void assertUnsortedListElements(){
        List<String> unSortedListElements = new ArrayList<>();
        for (WebElement el : sortCardsList) {
            unSortedListElements.add(el.getText());
        }
        Assert.assertNotEquals(sortedListElements, unSortedListElements);
        System.out.println(unSortedListElements);
    }



    //  Selectable Grid
    public void clickOnTabGrid() {
        tabGridButton.click();
    }
    public void clickOnGridButton(String buttonTitle) {
        for (WebElement buttons : gridButtonsList) {
            if (buttons.getText().equals(buttonTitle)) {
                buttons.click();
            }
        }
    }

    public void verifyThatGridButtonIsSelected(String buttonTitle) {
        for (WebElement button : gridButtonsList) {
            if (button.getText().equals(buttonTitle)) {
                String selection = button.getAttribute("class");
                Assert.assertTrue(selection.contains("active"));
            }
        }
    }
    public void clickOnAllGridButtons() {
        for (int i = 0; i < gridButtonsList.size(); i++) {
           if (gridButtonsList.get(i).isDisplayed() && gridButtonsList.get(i).isEnabled()) {
                gridButtonsList.get(i).click();
            }
        }

    }
    public void verifyThatAllGridButtonsAreSelected() throws InterruptedException {
        for (WebElement button : gridButtonsList) {
            if(button.isDisplayed()) {
                String selection = button.getAttribute("class");
                Assert.assertTrue(selection.contains("active"));
            }
        }
    }
    public void verifyThatAllGridButtonsAreNotSelected() throws InterruptedException {
        for (WebElement button : gridButtonsList) {
            if(button.isDisplayed()) {
                String selection = button.getAttribute("class");
                Assert.assertFalse(selection.contains("active"));
            }

        }
    }
}
