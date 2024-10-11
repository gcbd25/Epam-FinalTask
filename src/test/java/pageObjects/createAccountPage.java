package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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

    public void sendFirstName (String name) {
        try {
            pgHelper.waitPresenceOfElementLocated(locCreateAcc.inpFirstName);
            pgHelper.sendTextOnField(locCreateAcc.inpFirstName,name);
        }catch(Exception e) {
            e.getMessage();
        }
    }

    public void sendLastName (String lastName) {
        try {
            pgHelper.sendTextOnField(locCreateAcc.inpLastName,lastName);
        }catch(Exception e) {
            e.getMessage();
        }
    }

    public void sendEmail (String email) {
        try {
            pgHelper.sendTextOnField(locCreateAcc.inpEmail,Math.random()*100000+email);
        }catch(Exception e) {
            e.getMessage();
        }
    }

    public void sendPsw (String psw) {
        try {
            pgHelper.sendTextOnField(locCreateAcc.inpPsw,psw);
        }catch(Exception e) {
            e.getMessage();
        }
    }

    public void sendConfirmPsw (String psw) {
        try {
            pgHelper.sendTextOnField(locCreateAcc.inpConfirmPsw,psw);
        }catch(Exception e) {
            e.getMessage();
        }
    }

    public void clickCreateAccountButton () {
        try {
            pgHelper.clickElement(locCreateAcc.btnCreateAccount);
        }catch(Exception e) {
            e.getMessage();
        }
    }
}
