package stepDefinitions;

import dataProvider.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageObjects.commons;
import pageObjects.createAccountPage;
import pageObjects.signInPage;
import utilities.locators.locatorsCommon;
import utilities.locators.locatorsCreateAccount;
import utilities.locators.locatorsSignIn;
import utilities.pageHelper;

import java.io.File;
import java.io.IOException;

public class stepDef extends BaseClass{
    @Given("User Launch {string} Browser")
    public void user_launch_browser(String browser) {
        switch (browser) {
            case "Chrome": {
                //Ubicacion del driver Por si se necesita
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addExtensions(new File("./Extensions/uBlock.crx"));
                driver = new ChromeDriver(options);
                break;
            }
            case "Edge": {
                //Ubicacion del driver
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--start-maximized");
                options.addExtensions(new File("./Extensions/uBlock.crx"));
                driver = new EdgeDriver(options);
                break;
            }
            case "Firefox": {
                //Ubicacion del driver
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--start-maximized");
                driver = new FirefoxDriver(options);
                break;
            }
            default:
                driver.quit();
                break;
        }
        //Utilerias
        configFileReader= new ConfigFileReader();
        //Page Helper
        pgHelper = new pageHelper(driver);
        //Locators
        locCommon = new locatorsCommon();
        locCreateAcc = new locatorsCreateAccount();
        locSingIn = new locatorsSignIn();
        //Page Objects
        common = new commons(driver);
        createAccPage = new createAccountPage(driver);
        signInPg = new signInPage(driver);
    }

    @When("User Opens URL")
    public void userOpensURL() {
        pgHelper.openWebsite(configFileReader.getURL());
    }

    @And("User click Create Account Link")
    public void userClickCreateAccountLink() throws Exception {
        common.clickCreateAccountLink();
    }

    @Then("User validate page title as {string}")
    public void userValidatePageTitleAs(String pageName) throws Exception{
        common.assertPageTitle(pageName);
    }

    @Then("User enters First Name on Crate Account Page")
    public void user_enters_first_name_on_crate_account_page() throws Exception {
        createAccPage.sendFirstName(configFileReader.getFirstName());
    }

    @Then("User enters Last Name on Crate Account Page")
    public void user_enters_last_name_on_crate_account_page() throws Exception {
        createAccPage.sendLastName(configFileReader.getLastName());
    }

    @Then("User enters Email on Crate Account Page")
    public void user_enters_email_on_crate_account_page() throws Exception {
        createAccPage.sendEmail(configFileReader.getEmail());
    }

    @Then("User enters Password on Crate Account Page")
    public void user_enters_password_on_crate_account_page()  throws Exception {
        createAccPage.sendPsw(configFileReader.getValidCreateAccountPsw());
    }

    @Then("User enters Confirms Password on Crate Account Page")
    public void user_enters_confirms_password_on_crate_account_page() throws Exception {
        createAccPage.sendConfirmPsw(configFileReader.getValidCreateAccountPsw());
    }

    @And("User click Create Account Button")
    public void userClickCreateAccountButton() throws Exception {
        createAccPage.clickCreateAccountButton();
    }

    @After
    public void quitBrowser(){
        pgHelper.quitBrowser();
    }

    @And("User enters {string} on Create Account Page")
    public void userEntersOnCreateAccountPage(String psw) throws Exception{
        createAccPage.sendPsw(psw);
    }

    @Then("User validate password strength as {string}")
    public void userValidateValidatePasswordStrengthAs(String Str) throws Exception{
        createAccPage.assertPasswordStrength(Str);
    }

    @Then("User validate {string} error messages on Create Account Page")
    public void userValidateErrorMessagesOnCreateAccountPage(String msgs) throws Exception{
        createAccPage.assertNumberOfMessages(msgs);
    }

    @When("User click Sign In Link")
    public void user_click_sign_in_link() throws Exception{
        common.clickSignInLink();
    }
    @Then("User enters Valid Email on Sign In Page")
    public void user_enters_valid_email_on_sign_in_page() throws Exception{
        signInPg.sendEmail(configFileReader.getValidSignInEmail());
    }
    @Then("User enters Valid Password on Sign In Page")
    public void user_enters_valid_password_on_sign_in_page() throws Exception{
        signInPg.sendPsw(configFileReader.getValidSignInPsw());
    }
    @Then("User click Sign In Button")
    public void user_click_sign_in_button() throws Exception{
        signInPg.clickSignInButton();
    }

    @Then("User validate login dropdown message")
    public void userValidateLoginDropdownMessage() throws Exception{
        common.assertSignInDdwn(configFileReader.getDropdownText());
    }
}
