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
        for(int i =0; i<sideBarCardsList.size(); i++){                                  // ovom metodom mogu da skorlujem
            if(sideBarCardsList.get(i).getText().equals("Book Store Application")){     // svaku stranicu. Ne moram da ponavljam
                scrollToElement(sideBarCardsList.get(i));                               // kod u svakoj page klasi
            }
        }

    }

    public void clickOnSideBarElement(String nameButton){      // ovom metodom biram sekcije, odnosno funkcionalnosti iz side bara
        for(WebElement element:sideBarButtonsList){            // ne moram da ponavljam kod u svakoj klasi pre pocetka
            if(element.getText().equals(nameButton)){          // pisanja metoda i rada na funkcionalonsti
                element.click();
            }
        }
    }


}
