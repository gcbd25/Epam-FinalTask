package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepDefinitions.BaseClass;
import utilities.locators.locatorsCommon;
import utilities.locators.locatorsCreateAccount;
import utilities.pageHelper;

public class createAccountPage extends BaseClass {
    public createAccountPage(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(driver, this);
        //Page Helper
        pgHelper = new pageHelper(driver);
        //Locators
        locCreateAcc = new locatorsCreateAccount();
    }

    public void sendFirstName (String name) throws Exception {
        try {
            pgHelper.waitPresenceOfElementLocated(locCreateAcc.inpFirstName);
            pgHelper.sendTextOnField(locCreateAcc.inpFirstName,name);
            pgHelper.screenshot("Enter "+name+" on locator"+locCreateAcc.inpFirstName);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + locCreateAcc.inpFirstName);
            pgHelper.failStep("Error locating element: " + locCreateAcc.inpFirstName);
        }
    }

    public void sendLastName (String lastName) throws Exception {
        try {
            pgHelper.sendTextOnField(locCreateAcc.inpLastName,lastName);
            pgHelper.screenshot("Enter "+lastName+" on locator"+locCreateAcc.inpLastName);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + locCreateAcc.inpLastName);
            pgHelper.failStep("Error locating element: " + locCreateAcc.inpLastName);
        }
    }

    public void sendEmail (String email) throws Exception {
        try {
            pgHelper.sendTextOnField(locCreateAcc.inpEmail,Math.random()*100000+email);
            pgHelper.screenshot("Enter "+email+" on locator"+locCreateAcc.inpEmail);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + locCreateAcc.inpEmail);
            pgHelper.failStep("Error locating element: " + locCreateAcc.inpEmail);
        }
    }

    public void sendPsw (String psw)  throws Exception {
        try {
            pgHelper.sendTextOnField(locCreateAcc.inpPsw,psw);
            pgHelper.screenshot("Enter "+psw+" on locator"+locCreateAcc.inpPsw);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + locCreateAcc.inpPsw);
            pgHelper.failStep("Error locating element: " + locCreateAcc.inpPsw);
        }
    }

    public void sendConfirmPsw (String psw) throws Exception {
        try {
            pgHelper.sendTextOnField(locCreateAcc.inpConfirmPsw,psw);
            pgHelper.screenshot("Enter "+psw+" on locator"+locCreateAcc.inpConfirmPsw);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + locCreateAcc.inpConfirmPsw);
            pgHelper.failStep("Error locating element: " + locCreateAcc.inpConfirmPsw);
        }
    }

    public void clickCreateAccountButton () throws Exception {
        try {
            pgHelper.clickElement(locCreateAcc.btnCreateAccount);
            pgHelper.screenshot("Click element with locator "+locCreateAcc.btnCreateAccount);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + locCreateAcc.btnCreateAccount);
            pgHelper.failStep("Error locating element: " + locCreateAcc.btnCreateAccount);
        }
    }

    public void assertPasswordStrength (String text) throws Exception {
        try {
            pgHelper.waitTextOnElement(locCreateAcc.txtStrength,text);
            pgHelper.assertEquals(pgHelper.getTextOfAnElement(locCreateAcc.txtStrength),text);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error on Assertion");
            pgHelper.failStep("Error on Assertion");
        }
    }
}
