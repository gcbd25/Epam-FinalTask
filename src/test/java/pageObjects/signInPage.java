package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.BaseClass;
import utilities.locators.locatorsCreateAccount;
import utilities.locators.locatorsSignIn;
import utilities.pageHelper;

public class signInPage extends BaseClass {
    public signInPage(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(driver, this);
        //Page Helper
        pgHelper = new pageHelper(driver);
        //Locators
        locSingIn = new locatorsSignIn();
    }

    public void sendEmail (String email) throws Exception {
        try {
            pgHelper.waitPresenceOfElementLocated(locSingIn.inpEmail);
            pgHelper.sendTextOnField(locSingIn.inpEmail,email);
            pgHelper.screenshot("Enter "+email+" on locator"+locSingIn.inpEmail);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + locSingIn.inpEmail);
            pgHelper.failStep("Error locating element: " + locSingIn.inpEmail);
        }
    }

    public void sendPsw (String psw) throws Exception {
        try {
            pgHelper.sendTextOnField(locSingIn.inpPsw,psw);
            pgHelper.screenshot("Enter "+psw+" on locator"+locSingIn.inpPsw);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + locSingIn.inpPsw);
            pgHelper.failStep("Error locating element: " + locSingIn.inpPsw);
        }
    }

    public void clickSignInButton () throws Exception {
        try {
            pgHelper.clickElement(locSingIn.btnSignIn);
            pgHelper.screenshot("Click element with locator "+locSingIn.btnSignIn);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + locSingIn.btnSignIn);
            pgHelper.failStep("Error locating element: " + locSingIn.btnSignIn);
        }
    }
}
