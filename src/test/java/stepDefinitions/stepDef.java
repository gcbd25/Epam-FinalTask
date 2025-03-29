package stepDefinitions;

import dataProvider.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageObjects.HomepagePage;
import pageObjects.LoginPage;
import utilities.locators.locators;
import utilities.pageHelper;

public class stepDef extends BaseClass{
    //Constructor for ConfigFileReader
    public stepDef() {
        configFileReader= new ConfigFileReader();
    }
    //Tear Up method to launch Browser specified on ConfigFileReader
    @Before
    public void  tearUp(){
        switch (configFileReader.getBrowser()) {
            case "Chrome": {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-autofill");
                options.addArguments("--disable-save-password-bubble");
                driver = new ChromeDriver(options);
                driver.manage().deleteAllCookies();
                break;
            }
            case "Edge": {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-autofill");
                options.addArguments("--disable-save-password-bubble");
                driver = new EdgeDriver(options);
                driver.manage().deleteAllCookies();
                break;
            }
            case "Firefox": {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--start-maximized");
                driver = new FirefoxDriver(options);
                driver.manage().deleteAllCookies();
                break;
            }
            default:
                driver.quit();
                break;
        }
        pgHelper = new pageHelper(driver);
        this.pgLogIn = new LoginPage(driver);
        this.pgHomepage = new HomepagePage(driver);
    }

    //Tear Down method to close browser after execution
    @After
    public void tearDown (){
        pgHelper.quitBrowser();
    }
    //================================================Features============================================================================
    @Given("User launch Sauce Demo website")
    public void user_launch_sauce_demo_website() {
        pgHelper.openWebsite(configFileReader.getURL());
    }

    @Given("User enter a Valid Username")
    public void user_enter_a_valid_username() throws Exception{
        pgLogIn.sendUserName(configFileReader.getUserName());
    }
    @Given("User enter a Valid Password")
    public void user_enter_a_valid_password() throws Exception{
        pgLogIn.sendPassword(configFileReader.getPassword());
    }
    @Given("User clear Username Field")
    public void user_clear_username_field() throws Exception{
        pgLogIn.clearUserName();
    }
    @Given("User clear Password Field")
    public void user_clear_password_field() throws Exception{
        pgLogIn.clearPassword();
    }
    @When("User click login button")
    public void user_click_login_button() throws Exception{
        pgLogIn.clickLogIn();
    }
    @Then("User should be able to see {string} error message")
    public void user_should_be_able_to_see_error_message(String error) throws Exception{
        pgLogIn.validateErrorMsg(error);
    }

    @Then("User should successfully logIn")
    public void user_should_successfully_log_in() throws Exception{
        pgHomepage.validateLogIn(configFileReader.getTitle());
    }


}
