package utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class pageHelper {
    public WebDriver driver;
    private static final Logger logger = LogManager.getLogger(pageHelper.class);

    public pageHelper(WebDriver driver) {
        this.driver = driver;
    }
    /*----------------------Screenshot on Allure report Section------------------------------------------*/
    /*
    Author: Gerardo Bravo
    Function: Implemented to take an Screenshot and attach it to Allure report
     */
    public void screenshot (String name) throws Exception {
        Allure.addAttachment(name, FileUtils.openInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE)));
    }
    /*----------------------Exception Handler------------------------------------------*/
    /*
    Author: Gerardo Bravo
    Function: Implemented to handle Exceptions
     */
    public void exceptionHandler (Exception e, String message) throws Exception {
        logger.error("Step failed. " + message);
    }
    /*----------------------WAITS Section------------------------------------------*/
    /*
    Author: Gerardo Bravo
    Function: Implemented to wait for the visibility of an specific element
     */
    public void waitVisibilityOfElementLocated (By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofSeconds(5L)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to wait for an element to be clickable
     */
    public void waitElementToBeClickable (By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofSeconds(5L)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to wait for an element to be located
     */
    public void waitPresenceOfElementLocated (By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofSeconds(5L)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to wait for an element to have specific text
     */
    public void waitTextOnElement (By element,String text) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofSeconds(5L)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(element,text));
    }
    /*----------------------Actions on page Section------------------------------------------*/
    /*
    Author: Gerardo Bravo
    Function: Implemented to open an specific page on the website
     */
    public void openWebsite (String website) {
        driver.get(website);
        logger.info("Test has Started. Website opened");
    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to open an specific page on the website
     */
    public void quitBrowser () {
        driver.quit();
        logger.info("<------------------Test Completed------------------>");
    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to clear text on Input fields
     */
    public void clearField (By element) {
        driver.findElement(element).clear();
    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to input text on Input fields
     */
    public void sendTextOnField (By element,String Message) {
        driver.findElement(element).sendKeys(Message);
        logger.info("Step Passed. Sent " + Message + " on xpath: " + element);
    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to click an specific Element
     */
    public void clickElement (By element) {
        driver.findElement(element).click();
        logger.info("Step Passed. Clicked element on xpath: " + element);
    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to get the title for the pages
     */
    public String getPageTitle () {
        return driver.getTitle();
    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to get the title for the pages
     */
    public String getTextOfAnElement (By element) {
        return driver.findElement(element).getText();
    }
    /*----------------------Assertions------------------------------------------*/
    /*
    Author: Gerardo Bravo
    Function: Implemented to perform asserts
     */
    public void assertEquals (String text1, String text2){
        try {
            Assert.assertEquals(text1, text2);
            logger.info("Step Passed. Both texts match");
        }catch(Exception e) {
            logger.error("Step failed. Strings are different");
        }
    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to assert Multiple Xpath Locators
     */
    public void assertMultipleXpaths (By elements, String msgs){
        try {
            Assert.assertEquals(driver.findElements(elements).size(),Integer.parseInt(msgs));
            logger.info("Step Passed. There are " + msgs + " error messages displayed");
        }catch(Exception e) {
            logger.error("Step failed. Strings are different");
        }
    }
    /*----------------------Fail Method------------------------------------------*/
    /*
    Author: Gerardo Bravo
    Function: Created for failed steps
     */
    public void failStep (String msg){
        Assert.fail(msg);
    }
}
