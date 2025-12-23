package Pages;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class WidgetsPage extends BaseTest {

    public WidgetsPage(){
        PageFactory.initElements(driver, this);
    }


    //  DATE PICKER
    @FindBy(id = "datePickerMonthYearInput")
    public WebElement selectDateField;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthDropDown;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearDropDown;

    @FindBy(css = ".react-datepicker__day.react-datepicker__day")
    List <WebElement> dateMonth;


    //  SLIDER
    @FindBy(css = "input.range-slider")
    WebElement rangeSlider;
    @FindBy(id = "sliderValue")
    WebElement sliderValue;


    //  Accordian
    @FindBy(id = "section1Content")
    public WebElement cardBody1;
    @FindBy(id = "section2Content")
    public WebElement cardBody2;
    @FindBy(id = "section3Content")
    public WebElement cardBody3;
    @FindBy(className = "card-header")
    List<WebElement> listPannelsHeader;
    @FindBy(className = "card-body")
    List<WebElement> listPannelBodies;





    //---------------------------------------------



    //  DATE PICKER
    public void clickOnSelectDateField(){
        selectDateField.click();
    }
    public void clickOnMonthDropDown(){
        monthDropDown.click();
    }
    public void selectMonth(String m){
        Select month = new Select(monthDropDown);
        month.selectByContainsVisibleText(m);
    }
    public void clikOnYearDropDown(){
        yearDropDown.click();
    }
    public void selectYear(String y){
        Select year = new Select(yearDropDown);
        year.selectByValue(y);
    }
    public void selectDate(String day){
            for(int i =0; i<dateMonth.size(); i++){
                if(dateMonth.get(i).getText().equals(day)){
                    dateMonth.get(i).click();
                }
            }
    }


    //  SLIDER
    public void moveSliderToTheRight(int num){
        for(int i=0; i<num; i++){
            rangeSlider.sendKeys(Keys.ARROW_RIGHT);
        }
    }
    public void moveSliderToTheLeft(int num){
        for(int i=0; i<num; i++){
            rangeSlider.sendKeys(Keys.ARROW_LEFT);
        }
    }
    public void assertBasicValue(){
        Assert.assertEquals(sliderValue.getAttribute("value"),"25");
    }
    public void assertNewValueOfRangeSliderIsDisplayed(){
        Assert.assertTrue(sliderValue.isDisplayed());
    }
    public void assertDisplayedValueIsCorrect(String expValue){
        Assert.assertEquals(sliderValue.getAttribute("value"),expValue);
    }


    //  Accordian

    public void verifyThatFirstAccordianPannelIsExpand(){
        Assert.assertTrue(listPannelBodies.getFirst().isDisplayed());
    }
    public void verifyThatSecondAccordianPannelIsExpand(){
        Assert.assertTrue(listPannelBodies.get(1).isDisplayed());
    }
    public void verifyThatThirdAccordianPannelIsExpand(){
        Assert.assertTrue(listPannelBodies.get(2).isDisplayed());
    }
    public void verifyThatOtherAccordianPannels2And3AreCollapsed(){
        Assert.assertFalse(cardBody2.isDisplayed());
        Assert.assertFalse(cardBody3.isDisplayed());
    }
    public void verifyThatOtherAccordianPannels1And3AreCollapsed() {
        Assert.assertFalse(cardBody1.isDisplayed());
        Assert.assertFalse(cardBody3.isDisplayed());
    }
    public void verifyThatOtherAccordianPannels1And2AreCollapsed() {
        Assert.assertFalse(cardBody1.isDisplayed());
        Assert.assertFalse(cardBody2.isDisplayed());
    }
    public void verifyThatAllAccordianPannelsAreClosed(){
        for(WebElement pannel: listPannelBodies){
            Assert.assertFalse(pannel.isDisplayed());
        }
    }
    public void clicOnPannelHeaderTitle(String title){
        for(WebElement head: listPannelsHeader){
            if(head.getText().equals(title)){
                head.click();
            }
        }
    }










}
