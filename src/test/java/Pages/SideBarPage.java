package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SideBarPage extends BaseTest {

    public SideBarPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "text")
    public List<WebElement> sideBarButtonsList;

    @FindBy(className = "header-text")
    public List<WebElement> sideBarCardsList;



    //--------------------------------


    public void scrollDown(){
        for(int i =0; i<sideBarCardsList.size(); i++){
            if(sideBarCardsList.get(i).getText().equals("Book Store Application")){
                scrollToElement(sideBarCardsList.get(i));
            }
        }

    }

    public void clickOnSideBarElement(String nameButton){
        for(WebElement element:sideBarButtonsList){
            if(element.getText().equals(nameButton)){
                element.click();
            }
        }
    }


}
