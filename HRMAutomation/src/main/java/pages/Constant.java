package pages;

public class Constant {
    //All valuses defined here should be static and final i.e. constant
    public static final int EXPLICIT_WAIT = 30;
    public static final int IMPLICIT_WAIT = 30;
   // public static  String BROWSER = property.getconfig("browserName");
    public static final String DASH_BORD_TEXT = "//span/h6[text()='Dashboard']";
    public static final String USER_NAME = "//div/input[@name='username']";
    public static final  String PASSWORD =  "//div/input[@name='password']";
    public static final  String LOGIN_BUTTON = "//div/button[@type='submit']";
    public static final  String LOGIN_TEXT = "//div/h5[text()='Login']";
    public static final  String FB_LINK = "//div/a[@href='https://www.facebook.com/OrangeHRM/']";
    public static final  String LINKEDIN_LINK = "//div/a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']";
    public static final  String U_TUBE_LINK = "//div/a[@href='https://www.youtube.com/c/OrangeHRMInc']";
    public static final  String TWITTER_LINK = "//div/a[@href='https://twitter.com/orangehrm?lang=en']";
    public static final  String FORGOT_UR_PWD_LINK = " //div/p[text()='Forgot your password? ']";
    public static final  String RESET_PWD_TITLE = " //div//h6[text()='Reset Password']";
    public static final  String RESET_PWD_USER_NAME = "//div/input[@name='username']";
    public static final  String RESET_PWD_CANCLE_BUTTON = "//div/button[text()=' Cancel ']";
    public static final  String RESET_PWD_RESET_BUTTON = "//div/button[text()=' Reset Password ']";
    public static final  String RESET_PWD_SUCCESS_TEXT = "//div/h6[text()='Reset Password link sent successfully']";
    public static final String ERROR_MSG_FOR_BLANK_FIELD ="//div//span[text()='Required']";
   public static final String ORANGE_HRM_INC_LINK = " //div/p/a[text()='OrangeHRM, Inc']";
    public static final String ERROR_MSG_FOR_BLANK_USERANDPWD ="//div//span[text()='Required']/../../following-sibling::div//span[text()='Required']";



}
