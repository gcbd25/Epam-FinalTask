package utilities.locators;

import org.openqa.selenium.By;

public class locators {
    /*-----------------------------------------------LogIn Locators-----------------------------------------------------------------*/
    public By inpUsername = By.xpath("//input[@id='user-name']");
    public By inpPassword = By.cssSelector("#password");
    public By btnLogIn = By.cssSelector("#login-button");
    public By errorMsg = By.cssSelector("h3[data-test='error']");
    /*---------------------------------------------Homepage Locators---------------------------------------------------------------*/
    public By pgTitle = By.xpath("//div[@class='app_logo']");
}
