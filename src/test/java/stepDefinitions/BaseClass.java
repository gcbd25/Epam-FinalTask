package stepDefinitions;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import pageObjects.HomepagePage;
import pageObjects.LoginPage;
import utilities.locators.locators;
import utilities.pageHelper;

public class BaseClass {
    //Driver
    protected WebDriver driver;
    //File reader
    protected ConfigFileReader configFileReader;
    //Page Helper
    public pageHelper pgHelper;
    //Page Objects
    protected LoginPage pgLogIn;
    protected HomepagePage pgHomepage;
    //Locators
    protected static locators loc;
}