package Pages;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class HomePage extends BaseTest {
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "card-body")
    public List<WebElement> cardsList;



    //---------------------------------------

    public void clickOnCard(String cardName) {
        for(WebElement card : cardsList){
            if(card.getText().equals(cardName)){
                card.click();
                break;
            }
        }
    }



}
