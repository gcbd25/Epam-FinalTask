package utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.time.Duration;

public class pageHelper {
    public WebDriver driver;

    public pageHelper(WebDriver driver) {
        this.driver = driver;
    }
    /*----------------------Screenshot on Allure report Section------------------------------------------*/
    /*
    Author: Gerardo Bravo
    Function: Implemented to take an Screenshot and attach it to Allure report
     */
    public void screenshot (String name) throws WebDriverException, IOException {
        Allure.addAttachment(name, FileUtils.openInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE)));
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
    /*----------------------Actions on page Section------------------------------------------*/
    /*
    Author: Gerardo Bravo
    Function: Implemented to open an specific page on the website
     */
    public void openWebsite (String website) {
        driver.get(website);
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
    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to click an specific Element
     */
    public void clickElement (By element) {
        driver.findElement(element).click();
    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to get the title for the pages
     */
    public String getPageTitle () {
        return driver.getTitle();
    }
}
