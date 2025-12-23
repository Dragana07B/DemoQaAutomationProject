package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ElementsPage extends BaseTest {

    public ElementsPage(){
        PageFactory.initElements(driver, this);
    }


    //  Broken Images
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/img[1]")
    public WebElement validImage;
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/img[2]")
    public WebElement brokenImage;

    //  Broken Links
    @FindBy(linkText = "Click Here for Valid Link")
    WebElement validLink;
    @FindBy(linkText = "Click Here for Broken Link")
    public WebElement brokenLink;
    @FindBy(id = "content")
    WebElement statusCode;

    //  Buttons
    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickMeButton;
    @FindBy(id = "doubleClickMessage")
    public WebElement doubleInfo;
    @FindBy(id = "rightClickBtn")
    WebElement rightClickMeButton;
    @FindBy(id = "rightClickMessage")
    public WebElement rightInfo;
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[3]/button")
    WebElement clickMeButton;
    @FindBy(id = "dynamicClickMessage")
    public WebElement clickInfo;

    //  Checkbox
    @FindBy(css = "button[aria-label='Expand all']")
    WebElement expandButton;
    @FindBy(css = "button[aria-label='Collapse all']")
    WebElement collapseAllButton;
    @FindBy(className = "rct-title")
    List<WebElement> checkBoxList;
    @FindBy(id = "result")
    WebElement selectionNote;
    @FindBy(css = "button[aria-label='Toggle']")
    public List<WebElement> toggleButtonsList;

    //  Dynamic Properties
    @FindBy(id = "enableAfter")
    public WebElement willEneble5SecondsButton;
    @FindBy(id = "colorChange")
    public WebElement colorChangeButton;
    @FindBy(id = "visibleAfter")
    public WebElement visibleAfter5SecondsButton;

    //  Links
    @FindBy(id = "simpleLink")
    WebElement homelink;
    @FindBy(id = "invalid-url")
    public WebElement notFoundLink;
    @FindBy(id = "linkResponse")
    public WebElement responseMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[2]/label")
    WebElement yesRadioButton;
    @FindBy(className = "text-success")
    WebElement selectionText;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/label")
    WebElement impressiveRadioButton;
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[4]/input")
    public WebElement noRadioButton;

    //TextBox
    @FindBy(id = "userName")
    WebElement userNameField;
    @FindBy(id = "userEmail")
    WebElement eMailField;
    @FindBy(id = "currentAddress")
    WebElement currentAddressField;
    @FindBy(id ="permanentAddress")
    WebElement permanentAddressField;
    @FindBy(id = "submit")
    public WebElement submitButton;
    @FindBy(id = "output")
    public WebElement outputField;




    //--------------------------------------------------


    //  Broken Images
    public void verifyThatValidImageSrcExistAndItIsValid(){
        String imageSrc = validImage.getAttribute("src");
        System.out.println(imageSrc);
        Assert.assertNotNull(imageSrc);
        Assert.assertFalse(imageSrc.isEmpty());
        Assert.assertTrue(imageSrc.contains("Toolsqa"));
    }
    public void verifyThatValidImageIsVisibleOnPage(){
        String width = validImage.getAttribute("naturalWidth");
        String height = validImage.getAttribute("naturalHeight");
        System.out.println(width);
        System.out.println(height);
        Assert.assertNotEquals(width, "0");
        Assert.assertNotEquals(height,"0");
    }
    public void verifyThatBrokenImageSrcExistAndItIsValid(){
        String imageSrc = brokenImage.getAttribute("src");
        System.out.println(imageSrc);
        Assert.assertNotNull(imageSrc);
        Assert.assertFalse(imageSrc.isEmpty());
        Assert.assertTrue(imageSrc.contains("Toolsqa"));
    }
    public void verifyThatBrokenImageIsNotVisibleOnPage(){
        String width = brokenImage.getAttribute("naturalWidth");
        String height = brokenImage.getAttribute("naturalHeight");
        System.out.println(width);
        System.out.println(height);
        Assert.assertEquals(width, "0");
        Assert.assertEquals(height,"0");
    }

    //  Broken Links
    public void clickOnValidLink(){
        validLink.click();
    }
    public void clickOnBrokenLink(){
        brokenLink.click();
    }
    public void assert500CodeStatus(){
        Assert.assertTrue(statusCode.getText().contains("500 status code"));
    }

    //  Butons
    public void clickTwiceOnDoubleClickMeButton(){
        Actions doubleClick = new Actions(driver);
        doubleClick.doubleClick(doubleClickMeButton).perform();
    }
    public void clickWithRightButtonOnRightClickMeButton(){
        Actions rightClick = new Actions(driver);
        rightClick.contextClick(rightClickMeButton).perform();
    }
    public void clickOnClickMeButton(){
        clickMeButton.click();

    }

    //  Checkbox
    public void clickOnExpandAllButton(){
        expandButton.click();
    }
    public void clickOnCollapseAllButton(){
        collapseAllButton.click();
    }
    public void clickOnHomeCheckBox(){
        checkBoxList.get(0).click();
    }
    public void clickOnCheckBoxItems(){
        for(int i =checkBoxList.size()-1;i>=0; i--){
            checkBoxList.get(i).click();
        }
    }
    public void assertThatNoteSelectionAppears(){
        Assert.assertTrue(selectionNote.isDisplayed());
    }

    public void assertThatEverythingIsSelected(){
        String allSelection = "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile";
        Assert.assertTrue(selectionNote.getText().contains(allSelection));
    }
    public void clickOnToggleButtonHome(){
        toggleButtonsList.getFirst().click();
    }
    public void clickOnToggleButtons(){
        for(int i =1; i< toggleButtonsList.size(); i++){
            toggleButtonsList.get(i).click();
        }
    }
    public void assertThatNoteSelectionIsNotDisplayed() {
        boolean notDisplayed = false;
        try {
            notDisplayed = selectionNote.isDisplayed();
        } catch (Exception e) {
            System.out.println("No message about selection");
        }
        Assert.assertFalse(notDisplayed);
    }

    //  Dynamic Properties
    public void assertWillEnable5SecondsButtonIsDisplayed(){
        Assert.assertTrue(willEneble5SecondsButton.isDisplayed());
    }
    public void assertThatButtonIsNotClickable(){
        Assert.assertFalse(willEneble5SecondsButton.isEnabled());
    }
    public void clickOnWillEnable5SecondsButton(){
        willEneble5SecondsButton.click();
    }

    private String baseColor;
    public void checkTheBasicColor() {
        baseColor = colorChangeButton.getCssValue("color");
        System.out.println("Basic color is: " + baseColor);
    }
    public void assertChangeOfColor(){
        String newColor = colorChangeButton.getCssValue("color");
        System.out.println("New color is: " + newColor);
        Assert.assertNotEquals(baseColor,newColor);
    }


    public void assertThatVisibleAfter5SecondsIsDisplayed(){
        Assert.assertTrue(visibleAfter5SecondsButton.isDisplayed(), "Button is visible");
    }
    public void assertThatVisibleAfter5SecondsIsNotDisplayed(){
        boolean isPresent = false;
        try{
            isPresent = visibleAfter5SecondsButton.isDisplayed();
        } catch(Exception e){
            System.out.println("Element is not displayed");
        }
        Assert.assertFalse(isPresent);
    }
    public void clickOnCloroChangeButton(){
        colorChangeButton.click();
    }
    public void clickOnVisibleAfter5SecondsButton(){
        visibleAfter5SecondsButton.click();
    }

    //  Links
    public void clickOnHomeLink(){
        homelink.click();
    }
    public void getTab(int number){
        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(number));
    }
    public void assertThatCorrectLinkIsOpenInNewTab(){
        getTab(1);
        String expectedUrl = "https://demoqa.com/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }
    public void assertThatTitleTabIsCorrect(){
        getTab(1);
        Assert.assertTrue(driver.getTitle().contains("DEMOQA"));
    }

    public void clickOnNotFoundLink(){
        notFoundLink.click();
    }
    public void assertThatInfoMessageIsDisplayed(){
        Assert.assertTrue(responseMessage.isDisplayed());
    }
    public void assertThatInfoMessageContainsStatusCode(String statusCode){
        Assert.assertTrue(responseMessage.getText().contains(statusCode));
    }
    public void assertThatInfoMessageContainsStatusText(String statusText) {
        Assert.assertTrue(responseMessage.getText().contains(statusText));
    }

    //  Radio Button
    public void assertThatYesRadioButtonIsEnabled(){
        Assert.assertTrue(yesRadioButton.isEnabled());
    }
    public void clickOnYesRadioButton(){
        yesRadioButton.click();
    }
    public void assertThatYesButtonIsSelected(){
        Assert.assertTrue(selectionText.getText().contains("Yes"));
        Assert.assertTrue(yesRadioButton.isEnabled());
    }
    public void assertThatImpressiveRadioButtonIsEnabled(){
        Assert.assertTrue(impressiveRadioButton.isEnabled());
    }
    public void clickOnImpressiveRadioButton(){
        impressiveRadioButton.click();
    }
    public void assertThatImpressiveButtonIsSelected(){
        Assert.assertTrue(selectionText.getText().contains("Impressive"));
    }
    public void verifyThatCursorIsNotAllowedOverNoButton(){
        String cursor = noRadioButton.getCssValue("cursor");
        Assert.assertEquals(cursor, "not-allowed");
    }

    //  Text Box
    public void inputFullNameIntoFullNameField(String name){
        userNameField.clear();
        userNameField.sendKeys(name);
    }
    public void inputEMailIntoEMailField(String mail){
        eMailField.clear();
        eMailField.sendKeys(mail);
    }
    public void inputCurrentAddress(String currentAddress){
        currentAddressField.clear();
        currentAddressField.sendKeys(currentAddress);
    }
    public void inputPermanentAddress(String permanentAddress){
        permanentAddressField.clear();
        permanentAddressField.sendKeys(permanentAddress);
    }
    public void clickOnSubmitButton(){
        submitButton.click();
    }
    private String basicColor; ;
    public void basicColor(){
        basicColor = eMailField.getCssValue("border-color");
    }
    public void assertThatEmailFieldBorderColorIsRed(){
        String borderError = eMailField.getCssValue("border-color");
        Assert.assertNotEquals(basicColor, borderError);
    }








}
