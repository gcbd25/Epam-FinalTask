package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepDefinitions.BaseClass;
import utilities.locators.locatorsCommon;
import utilities.pageHelper;

public class commons extends BaseClass {
    public commons(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(driver, this);
        //Page Helper
        pgHelper = new pageHelper(driver);
        //Locators
        locCommon = new locatorsCommon();
    }

    public void clickCreateAccountLink () {
        try {
            pgHelper.waitPresenceOfElementLocated(locCommon.lnkCreateAcc);
            pgHelper.clickElement(locCommon.lnkCreateAcc);
        }catch(Exception e) {
            e.getMessage();
        }
    }

    public void assertPageTitle (String text) {
        try {
            Assert.assertEquals(pgHelper.getPageTitle(),text);
        }catch(Exception e) {
            e.getMessage();
        }
    }
}
