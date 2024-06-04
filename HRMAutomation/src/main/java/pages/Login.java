package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;



public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    // below are the xPath of all WebElements of Login Page
    @FindBy(xpath = Constant.DASH_BORD_TEXT)
    WebElement PageTextDashBord;
    @FindBy(xpath = Constant.USER_NAME)
    WebElement username;
    @FindBy(xpath = Constant.PASSWORD)
    WebElement password;
    @FindBy(xpath = Constant.LOGIN_BUTTON)
    WebElement loginButton;
    @FindBy(xpath = Constant.LOGIN_TEXT)
    WebElement loginText;
    @FindBy(xpath = Constant.FB_LINK)
    WebElement faceBookLink;
    @FindBy(xpath = Constant.LINKEDIN_LINK)
    WebElement linkedInLink;
    @FindBy(xpath = Constant.TWITTER_LINK)
    WebElement twitterLink;
    @FindBy(xpath = Constant.U_TUBE_LINK)
    WebElement youTubeLink;
    @FindBy(xpath = Constant.FORGOT_UR_PWD_LINK)
    WebElement forgotUrPwdLink;
    @FindBy(xpath = Constant.RESET_PWD_USER_NAME)
    WebElement resetPwdUserName;
    @FindBy(xpath = Constant.RESET_PWD_CANCLE_BUTTON)
    WebElement forgotPwdCancleButton;
    @FindBy(xpath = Constant.RESET_PWD_RESET_BUTTON)
    WebElement ResetPwdButton;
    @FindBy(xpath = Constant.RESET_PWD_SUCCESS_TEXT)
    WebElement resetPwdSuccessText;
    @FindBy(xpath = Constant.RESET_PWD_TITLE)
    WebElement resetPwdTitle;
    @FindBy(xpath = Constant.ERROR_MSG_FOR_BLANK_FIELD)
    WebElement errorMsgBlankField;

    @FindBy(xpath = Constant.ORANGE_HRM_INC_LINK)
    WebElement orangeHrmIncLINK;

    @FindBy(xpath = Constant.ERROR_MSG_FOR_BLANK_USERANDPWD)
    WebElement errorMsgForBlankFields;


    //.............
    // below are the functions/methods of all WebElements of Login Page

    //to get LoginPageTitle
    public String getBasePageTextDashboard(){
        return PageTextDashBord.getText();

    }


    // to input username on HRM homePage
    public void inputUserName(String userName) {
        username.sendKeys(userName);
    }

    //to input password
    public void inputPassword(String pwd) {
        password.sendKeys(pwd);
    }

    //to get text from home page
    public String getLoginTitleText() {
        return loginText.getText();
    }

    //to click on login button
    public void clickONLogin() {
        loginButton.click();
    }


    //To click FB-link and return the Page title
    public String openAndVerifyFbLink() {
        faceBookLink.click();
        String parentWindowId = switchWindows();
        String FBWindowTitle = driver.getTitle();
        driver.close();
        driver.switchTo().window(parentWindowId);
        System.out.println(FBWindowTitle);
        return FBWindowTitle;

    }

    //To click on UtubeLink and return the Page title
    public String openAndVerifyUtubeLink() {
        youTubeLink.click();
        String parentWindowId = switchWindows();
        String uTubeWindowTitle = driver.getTitle();
        driver.close();
        driver.switchTo().window(parentWindowId);
        System.out.println(uTubeWindowTitle);
        return uTubeWindowTitle;

    }

    //To click on TwitterLink and return the Page title
    public String openAndVerifyTwitterLink() {
        twitterLink.click();
        String parentWindowId = switchWindows();
        String TwitterWindowTitle = driver.getTitle();
        driver.close();
        driver.switchTo().window(parentWindowId);
        System.out.println(TwitterWindowTitle);
        return TwitterWindowTitle;

    }

    //To click on LinkedINLink and return the Page title
    public String openAndVerifyLinkedINLink() {
        linkedInLink.click();
        String parentWindowId = switchWindows();
        String linkedINWindowTitle = driver.getTitle();
        driver.close();
        driver.switchTo().window(parentWindowId);
        System.out.println(linkedINWindowTitle);
        return linkedINWindowTitle;

    }

    //To click on forget password and return the title
    public String clickONForgotPwd() {
        forgotUrPwdLink.click();
        return resetPwdTitle.getText();
    }

    //To check CancleButtonstate in resetPWD state
    public boolean isButtonEnabled() {
        boolean canclebuttonState = forgotPwdCancleButton.isEnabled();
        return canclebuttonState;
    }

    //to input username in resetpwd form
    public void inputuserNameInResetPwd(String userName) {
        resetPwdUserName.sendKeys(userName);
    }

    //to click on Cancle in forgotPWD window
    public void clickCancleButtonOnResettPasswordWindow() {
        forgotPwdCancleButton.click();
    }

    //click on  Reset Password Button
    public void clickOnResetPwdButton() {
        ResetPwdButton.click();
    }

    //return success message for reset pwd
    public String getPwdResetMessage() {
        return resetPwdSuccessText.getText();
    }

    //Click on Orange HRM INC Link and verify the page
    public  String clickONHRMLinkandGetTitle(){
        orangeHrmIncLINK.click();
        String parentWindowID = switchWindows();
        String orangeHRMIncTitle = driver.getTitle();
        driver.close();
        return orangeHRMIncTitle;
    }

    //returns error message for login with blank User/Pwd in HomePage OR blank user for Password reset
    public String getErrorMsgBlankField() {
        return errorMsgBlankField.getText();
    }

    //returns error message for Pwd field when both user and pwd are blank
    public String getErrorMsgForBlankFields(){
        return errorMsgForBlankFields.getText();
    }



    //To switch to new open window and return the parent window id to calling function
    public String switchWindows() {
        Set<String> windowIds = driver.getWindowHandles();
        Iterator idIterator = windowIds.iterator();
        String parentWindowID = (String) idIterator.next();
        String childWindowID = (String) idIterator.next();
        driver.switchTo().window(parentWindowID);
        driver.switchTo().window(childWindowID);
        return parentWindowID;

    }

}
