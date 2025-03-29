package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.BaseClass;
import utilities.locators.locators;
import utilities.pageHelper;

public class LoginPage extends BaseClass {
    //Constructor
    public LoginPage(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(driver, this);
        pgHelper = new pageHelper(driver);
        loc = new locators();
    }

    //Send information on User field
    public void sendUserName (String user) throws Exception {
        try {
            pgHelper.waitPresenceOfElementLocated(loc.inpUsername);
            pgHelper.sendTextOnField(loc.inpUsername,user);
            pgHelper.screenshot("Enter "+user+" on locator"+loc.inpUsername);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + loc.inpUsername);
            pgHelper.failStep("Error locating element: " + loc.inpUsername);
        }
    }
    //Send information on Password field
    public void sendPassword (String psw) throws Exception {
        try {
            pgHelper.waitPresenceOfElementLocated(loc.inpPassword);
            pgHelper.sendTextOnField(loc.inpPassword,psw);
            pgHelper.screenshot("Enter "+psw+" on locator"+loc.inpPassword);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + loc.inpPassword);
            pgHelper.failStep("Error locating element: " + loc.inpPassword);
        }
    }
    //Clear information on User field
    public void clearUserName () throws Exception {
        try {
            pgHelper.clearField(loc.inpUsername);
            pgHelper.waitTextOnElement(loc.inpUsername,"");
            pgHelper.screenshot("Cleared field with locator " + loc.inpUsername);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + loc.inpUsername);
            pgHelper.failStep("Error locating element: " + loc.inpUsername);
        }
    }
    //Clear information on Password field
    public void clearPassword () throws Exception {
        try {
            pgHelper.clearField(loc.inpPassword);
            pgHelper.waitTextOnElement(loc.inpPassword,"");
            pgHelper.screenshot("Cleared field with locator " + loc.inpPassword);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + loc.inpPassword);
            pgHelper.failStep("Error locating element: " + loc.inpPassword);
        }
    }
    //Click Login Button
    public void clickLogIn()throws Exception{
        try {
            pgHelper.clickElement(loc.btnLogIn);
            pgHelper.screenshot("Clicked element with locator " + loc.btnLogIn);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + loc.btnLogIn);
            pgHelper.failStep("Error locating element: " + loc.btnLogIn);
        }
    }
    //Validate error messages on LogIn Page
    public void validateErrorMsg (String text) throws Exception {
        try {
            pgHelper.waitPresenceOfElementLocated(loc.errorMsg);
            pgHelper.assertContains(pgHelper.getTextOfAnElement(loc.errorMsg),text);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error on Assertion");
            pgHelper.failStep("Error on Assertion");
        }
    }

}
