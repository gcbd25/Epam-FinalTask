package utilities.locators;

import org.openqa.selenium.By;

public class locatorsSignIn {
    //Input email
    public By inpEmail = By.xpath("//input[@id='email']");
    //Input Password
    public By inpPsw = By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']");
    //Button Sign In
    public  By btnSignIn = By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]");
    //Invalid Credentials Error Message
    public By txtInvalidCredentials = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");

}
