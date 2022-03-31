package com.adarga.web.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends BaseAction{

    private WebDriver driver;

//Cookies Element
    @FindBy(xpath = "//button[@data-test='manage-cookies' and @type='button' and text()='Manage cookies']")
    public WebElement manageCookiesButton;

    @FindBy(xpath = "//div[@data-test='group-toggle-analytics']//*//span[text()='Off']/preceding::input[@data-test='toggle-analytics']")
    public WebElement analyticsOff;

    @FindBy(xpath = "//div[@data-test='group-toggle-functional']//*//span[text()='Off']/preceding::input[@data-test='toggle-functional']")
    public WebElement funtionalOff;

    @FindBy(xpath = "//div[@data-test='group-toggle-advertising']//*//span[text()='Off']/preceding::input[@data-test='toggle-advertising']")
    public WebElement advertisingOff;

    @FindBy(xpath = "//div[@data-test='group-toggle-personalisation']//*//span[text()='Off']/preceding::input[@data-test='toggle-personalisation']")
    public WebElement personalisationOff;

    @FindBy(xpath = "//button[@data-test='save-preferences' and @type='submit' and text()='Save preferences']")
    public WebElement savePreferences;

    @FindBy(xpath = "//button[@data-test='modal-button-close' and @type='button']")
    public WebElement closeCookieButton;

    @FindBy(xpath = "//h2[@id='modal-header' and text()='Our cookies']")
    public WebElement ourCookiesHeader;

    //Constructor
    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}

