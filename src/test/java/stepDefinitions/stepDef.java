package stepDefinitions;

import dataProvider.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
                driver = new ChromeDriver(options);
                break;
            }
            case "Edge": {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--start-maximized");
                driver = new EdgeDriver(options);
                break;
            }
            case "Firefox": {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--start-maximized");
                driver = new FirefoxDriver(options);
                break;
            }
            default:
                driver.quit();
                break;
        }
        pgHelper = new pageHelper(driver);
        this.pgLogIn = new LoginPage(driver);
        this.loc = new locators();
    }

    //Tear Down method to close browser after execution
    @After
    public void tearDown (){
        System.out.println("Completado");
        //pgHelper.quitBrowser();
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
    public void user_enter_a_valid_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("User clear Username Field")
    public void user_clear_username_field() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
