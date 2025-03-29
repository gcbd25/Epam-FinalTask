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
    //==========================================Page Factory==========================================================
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement inpUserName;


    public void sendUserName (String user) throws Exception {
        try {
            pgHelper.waitPresenceOfElementLocated(loc.inpUsername);
            pgHelper.sendTextOnField(inpUserName,user);
            pgHelper.screenshot("Enter "+user+" on locator"+inpUserName);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + inpUserName);
            pgHelper.failStep("Error locating element: " + inpUserName);
        }
    }

}
