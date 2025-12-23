package Pages;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class FormsPage extends BaseTest {

    public FormsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstNameField;
    @FindBy(id = "lastName")
    WebElement lastNameField;
    @FindBy(id = "userEmail")
    WebElement eMailField;
    @FindBy(className = "custom-control-label")
    List<WebElement> genderList;
    @FindBy(id = "userNumber")
    WebElement mobNumField;
    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthField;
    @FindBy(className = "react-datepicker__month-select")
    WebElement monthDropDown;
    @FindBy(className = "react-datepicker__year-select")
    WebElement yearDropDown;
    @FindBy(css = ".react-datepicker__day.react-datepicker__day")
    List<WebElement> datePicker;
    @FindBy(id = "subjectsInput")
    WebElement subjectField;
    @FindBy(css = "#hobbiesWrapper .custom-control-label")
    List<WebElement> hobbiesList;
    @FindBy(id = "uploadPicture")
    WebElement chooseFileButton;
    @FindBy(id = "currentAddress")
    WebElement currentAddressField;
    @FindBy(id = "react-select-3-input")
    WebElement stateCustomDropDown;
    @FindBy(id = "react-select-4-input")
    WebElement cityCustomDropDown;
    @FindBy(id = "submit")
    WebElement submitButton;
    @FindBy(className = "modal-content")
    WebElement modalWindow;
    @FindBy(css = ".modal-title.h4")
    WebElement modalTitle;



    //------------------------------------------------------------------------------

    public void inputFirstName(String name){
        firstNameField.clear();
        firstNameField.sendKeys(name);
    }
    public void inputLastName(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }
    public void inputEmail(String mail){
        eMailField.clear();
        eMailField.sendKeys(mail);
    }

    public void clickOnGednderButton(String gen){
        for(WebElement gender:genderList){
            if(gender.getText().equals(gen))
            gender.click();
        }
    }
    public void inputMobileNumber(String num){
        mobNumField.clear();
        mobNumField.sendKeys(num);
    }
    public void clickOnDateOfBirthField(){
        dateOfBirthField.click();
    }
    public void clickOnMonthDropDownMenu(){
        monthDropDown.click();
    }
    public void selectMonth(String m){
        Select month = new Select(monthDropDown);
        month.selectByContainsVisibleText(m);
    }
    public void clickOnYearDropDownMenu(){
        yearDropDown.click();
    }
    public void selectYear(String y){
        Select year = new Select(yearDropDown);
        year.selectByContainsVisibleText(y);
    }
    public void selectDate(String day){
        for(int i =0; i<datePicker.size(); i++){
            if(datePicker.get(i).getText().equals(day)){
                datePicker.get(i).click();
            }
        }
    }
    public void inputTextIntoSubjectsField(String text){
        subjectField.click();
        subjectField.sendKeys(text);
        subjectField.sendKeys(Keys.ENTER);
    }
    public void clickOnHobbiesRadioButton(String hobb){
        for(WebElement hobbie:hobbiesList){
            if(hobbie.getText().equals(hobb)){
                hobbie.click();
            }
        }
    }
    public void clickOnAllHobbiesRadioButtons() {
        for (int i = 0; i < hobbiesList.size(); i++) {
            hobbiesList.get(i).click();
        }
    }

    public void clickOnChooseFileButton(){
        String path = "C:\\Users\\Dragana\\Desktop\\Untitled.jpg";
        chooseFileButton.sendKeys(path);
    }
    public void inputCurrentAddress(String address){
        currentAddressField.clear();
        currentAddressField.sendKeys(address);
    }

    public void selectStateCustomDropdown(String state){
        stateCustomDropDown.sendKeys(state);
        stateCustomDropDown.sendKeys(Keys.ENTER);
    }

    public void selectCityCustomDropdown(String city){
        cityCustomDropDown.sendKeys(city);
        cityCustomDropDown.sendKeys(Keys.ENTER);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }
    public void assertThatModalWindowIsOpen(){
        Assert.assertTrue(modalWindow.isDisplayed());
    }
    public void assertThatModalWindowTitleConfirmSubmitedForm(){
        Assert.assertTrue(modalTitle.isDisplayed());
        Assert.assertTrue(modalTitle.getText().equals("Thanks for submitting the form"));
    }






}
