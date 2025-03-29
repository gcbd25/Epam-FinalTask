package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.BaseClass;
import utilities.locators.locators;
import utilities.pageHelper;

public class HomepagePage extends BaseClass {
    //Constructor
    public HomepagePage(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(driver, this);
        pgHelper = new pageHelper(driver);
        loc = new locators();
    }

    public void validateLogIn (String title) throws Exception {
        try {
            pgHelper.waitPresenceOfElementLocated(loc.pgTitle);
            pgHelper.assertContains(pgHelper.getTextOfAnElement(loc.pgTitle),title);
        }catch(Exception e) {
            pgHelper.exceptionHandler(e, "Error on Assertion");
            pgHelper.failStep("Error on Assertion");
        }
    }
}
