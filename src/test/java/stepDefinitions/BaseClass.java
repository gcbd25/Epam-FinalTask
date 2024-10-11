package stepDefinitions;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import pageObjects.commons;
import pageObjects.createAccountPage;
import utilities.locators.locatorsCommon;
import utilities.locators.locatorsCreateAccount;
import utilities.pageHelper;

public class BaseClass {
    //Driver
    public WebDriver driver;
    //File reader
    public ConfigFileReader configFileReader;
    //Page Helper
    public pageHelper pgHelper;
    //Locators
    public locatorsCommon locCommon;
    public locatorsCreateAccount locCreateAcc;
    //Page Objects
    public commons common;
    public createAccountPage createAccPage;
}