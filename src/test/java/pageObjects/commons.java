package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepDefinitions.BaseClass;
import utilities.locators.locatorsCommon;
import utilities.pageHelper;

import java.io.IOException;

public class commons extends BaseClass {

    public commons(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(driver, this);
        //Page Helper
        pgHelper = new pageHelper(driver);
        //Locators
        locCommon = new locatorsCommon();
    }

    public void clickCreateAccountLink () throws Exception {
        try {
            pgHelper.waitPresenceOfElementLocated(locCommon.lnkCreateAcc);
            pgHelper.clickElement(locCommon.lnkCreateAcc);
            pgHelper.screenshot("Click element: "+locCommon.lnkCreateAcc);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + locCommon.lnkCreateAcc);
            pgHelper.failStep("Error locating element: " + locCommon.lnkCreateAcc);

        }
    }

    public void assertPageTitle (String text) throws Exception {
        try {
            pgHelper.assertEquals(pgHelper.getPageTitle(),text);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error on Assertion");
            pgHelper.failStep("Error on Assertion");
        }
    }

    public void clickSignInLink () throws Exception {
        try {
            pgHelper.waitPresenceOfElementLocated(locCommon.lnkSignIn);
            pgHelper.clickElement(locCommon.lnkSignIn);
            pgHelper.screenshot("Click element: "+locCommon.lnkSignIn);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error locating element: " + locCommon.lnkSignIn);
            pgHelper.failStep("Error locating element: " + locCommon.lnkSignIn);

        }
    }

    public void assertSignInDdwn (String text) throws Exception {
        try {
            pgHelper.waitPresenceOfElementLocated(locCommon.ddwnSignIn);
            pgHelper.assertEquals(pgHelper.getTextOfAnElement(locCommon.ddwnSignIn),text);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error on Assertion");
            pgHelper.failStep("Error on Assertion");

        }
    }
}
