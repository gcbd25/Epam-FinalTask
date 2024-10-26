package utilities.locators;

import org.openqa.selenium.By;

public class locatorsCreateAccount {
    //Input First Name
    public By inpFirstName = By.xpath("//input[@id='firstname']");
    //Input Last Name
    public By inpLastName = By.xpath("//input[@id='lastname']");
    //Input Email
    public By inpEmail = By.xpath("//input[@id='email_address']");
    //Input Password
    public By inpPsw = By.xpath("//input[@id='password']");
    //Input Confirm Psw
    public By inpConfirmPsw = By.xpath("//input[@id='password-confirmation']");
    //Button Create Account
    public By btnCreateAccount = By.xpath("//button[@title='Create an Account']");
    //Password Strength
    public By txtStrength = By.xpath("//span[@id='password-strength-meter-label']");
    //Number of error messages
    public By numberMessages = By.xpath("//div[@class='mage-error']");

}