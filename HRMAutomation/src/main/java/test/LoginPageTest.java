package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.Login;
import utils.DriverFactory;
import utils.Property;


public class LoginPageTest {

    WebDriver driver;
    BasePage basePage;
    Login login;

    @BeforeClass(alwaysRun = true)
    public void setup() {

        driver = DriverFactory.launcheBrowser(Property.getconfig("BROWSERNAME"));
        basePage = new BasePage(driver);
        login = new Login(driver);
        basePage.launchURL(Property.getconfig("url"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    // verifies navigating back to home page
//    @Test(priority =1)
//    public void NavigateBack(){
//        driver.navigate().back();
//        Assert.assertEquals(login.getLoginText(), "Login");
//    }

    //Verifies Fblink Base1
    @Test(priority = 2)
    public void verifyFbLink() {
        String actualFBpageTitle = login.openAndVerifyFbLink();
        Assert.assertEquals(actualFBpageTitle, "OrangeHRM - World's Most Popular Opensource HRIS | Secaucus NJ");
    }

    //Verify uTubelink Base2
    @Test(priority = 3)
    public void verifyUtubeLink() {
        String actualUtubepageTitle = login.openAndVerifyUtubeLink();
        Assert.assertEquals(actualUtubepageTitle, "OrangeHRM Inc - YouTube");
    }

    //Verify Twitterlink Base3
    @Test(priority = 4)
    public void verifyTwitterLink() {
        String actualTwitterpageTitle = login.openAndVerifyTwitterLink();
        Assert.assertEquals(actualTwitterpageTitle, "OrangeHRM (@orangehrm) / X");
    }

    //Verify LinkedINlink Base4
    @Test(priority = 5)
    public void verifyLinkedIN() {
        String actualLinkedINpageTitle = login.openAndVerifyLinkedINLink();
        Assert.assertEquals(actualLinkedINpageTitle, "OrangeHRM | LinkedIn");
    }

    // Verifies resetPassword link Base-5
    @Test(priority = 6)
    public void verifyForgotPwdLinkFunctionality() {
        String resetWindowTitle = login.clickONForgotPwd();
        Assert.assertEquals(resetWindowTitle, "Reset Password");
    }

    //Verifies cancle button on resetpasswordwindow
    @Test(priority = 7, dependsOnMethods = "verifyForgotPwdLinkFunctionality")
    public void verifyCancleButtonStatewithBlankUserName() {
        Boolean cancleButtonState = login.isButtonEnabled();
        Assert.assertTrue(cancleButtonState);
    }

    //Verifies error message on resetPasswordWindow
    @Test(priority = 8, dependsOnMethods = "verifyForgotPwdLinkFunctionality")
    public void verifyerrorMessageOnResetPwd() {
        login.clickOnResetPwdButton();
        String errorMsg = login.getErrorMsgBlankField();
        Assert.assertEquals(errorMsg, "Required");
    }

    //Verified Cancle button functionality in ResetPwd Form
    @Test(priority = 8, dependsOnMethods = "verifyForgotPwdLinkFunctionality")
    public void verifyCancleButtonFntInResetPwdWindow() {
        login.inputuserNameInResetPwd("Admin");
        login.clickCancleButtonOnResettPasswordWindow();
        String homePageText = login.getLoginTitleText();
        Assert.assertEquals(homePageText, "Login");
    }

    //Verified ResetPWD Button Functionality
    @Test(priority = 9, dependsOnMethods = "verifyForgotPwdLinkFunctionality")
    public void verifyResetPwdButtonFun() {
        login.inputuserNameInResetPwd("Admin");
        login.clickOnResetPwdButton();
        login.getPwdResetMessage();
    }


    //verified OrangeHRMLINCLink nevigation
     @Test(priority = 10)
    public void verifyNevigationToOrangeHrmInc(){
        Assert.assertEquals(login.clickONHRMLinkandGetTitle(), "Human Resources Management Software | OrangeHRM");
     }

     //Verifies Login with blank username
     @Test(priority = 11)
    public void verifyErrorMessageforLoginwithBlankUser(){
        login.inputPassword(Property.getconfig("password"));
        login.clickONLogin();
         Assert.assertEquals(login.getErrorMsgBlankField(),"Required");
    }

    //Verifies errorMessage when Login with Blank user
    @Test(priority = 12)
    public void verifyErrorMessageforLoginwithBlankPwd(){
        login.inputUserName(Property.getconfig("username"));
        login.clickONLogin();
       Assert.assertEquals(login.getErrorMsgBlankField(),"Required");
    }

    //Verifies Error message with blank user and password field
    @Test(priority = 13)
    public void verifyErrorMessageforLoginAllBlankFields(){
        login.clickONLogin();

    }

    //Verifies ResetPWD error messsage for blankUser
    @Test(priority = 14)
    public void verifiesErrorMessageForBlankUserInResetPWD (){
        login.clickONForgotPwd();
        login.clickOnResetPwdButton();
       Assert.assertEquals(login.getErrorMsgBlankField(), "Required");
    }

    // Verifies login to HRM with valid credentials
    @Test(priority = 20)
    public void verifyValidLogin() {
        login.inputUserName(Property.getconfig("username"));
        login.inputPassword(Property.getconfig("password"));
        login.clickONLogin();
        String pageText = login.getBasePageTextDashboard();
        Assert.assertEquals(pageText, "Dashboard");
    }


    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }
}