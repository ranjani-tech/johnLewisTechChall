package com.adarga.web.pages;

import com.adarga.web.base.BasePage;
import com.adarga.web.data.Userdata;
import com.adarga.web.helper.PropertiesProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;


public class JLCheckoutPage extends JLProductPage{


    @FindBy(xpath = "//h1[text()='Welcome to secure checkout']")
    WebElement checkOutHeadingElement;

    @FindBy(xpath ="//div[text()='Guest checkout']")
    WebElement guestElement;

    @FindBy(xpath ="//div[text()='Guest checkout']//parent::label")
    WebElement guestInputElement;

    @FindBy(xpath ="//input[@id='email']")
    WebElement emailInputElement;

    @FindBy(xpath ="//button[text()='Continue as guest']")
    WebElement guestButtonElement;

    @FindBy(xpath ="//button[@data-id='delivery']")
    WebElement deliveryButton;

    @FindBy(xpath = "//p[@data-test='delivery-details-user-email-text']")
    WebElement  deliveryUserEmail;

    @FindBy(xpath = "//input[@id='title']")
    WebElement  deliveryUserTitle;

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement  deliveryUserFirstname;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement  deliveryUserLastname;

    @FindBy(xpath = "//input[@id='phoneNumber']")
    WebElement  deliveryUserPhonenumber;

    @FindBy(xpath = "//input[@id='address-search-input']")
    WebElement  deliveryUserAddress;

    @FindBy(xpath = "(//button[@data-test='address-search-result'])[1]")
    WebElement  deliveryUserAddressSelected;

    @FindBy(xpath = "//button[@data-test='delivery-address-use-address']")
    WebElement  useThisAddressElement;

    @FindBy(xpath ="//span[text()='Next or named day UK delivery']//parent::h4//parent::div//parent::label")
    WebElement  nextOrNamedDayDeliveryElement;

    // Generic DateXPath
    String dateXpathPrefix = "//button[@name='5:5']//span[@aria-label='";
    String dateXpathSuffix = "']";
    String dateXpath = null;
    WebElement deliveryDateElement;

    @FindBy(xpath ="//button[text()='Continue to payment']")
    WebElement continuePaymentButton;


// Constructor:
    public JLCheckoutPage(WebDriver driver) {
        super(driver);
    }


// Checkout as a Guest User:
    public void verifySignUporGuestPage(String signUporGuestPage) {
        waitUntilUrlContains("login");
        waitUntilElementVisible(checkOutHeadingElement);
    }

// Input the Email Address in Guest User Field:
    public void selectAndEnter(String userGuestOption, String userGuestEmail) {
        checkIfTextIsExpected(guestElement,userGuestOption);
        waitUntilElementClickable(guestInputElement);
        clickOn(guestInputElement);
        waitUntilElementClickable(emailInputElement);
        waitUntilElementVisible(emailInputElement);
        focusAndClickElement(emailInputElement);
        inputTextBox(emailInputElement,userGuestEmail);
    }

// ClickOn Continue as Guest Button:
    public void continueGuestOption(String userGuestOption) {
        checkIfTextIsExpected(guestButtonElement,userGuestOption);
        clickOn(guestButtonElement);
    }

// Select the Delivery option:
    public void chooseDelivery(String chooseYourDelivery, String onPage) {
        waitUntilUrlContains(onPage);
        clickOn(deliveryButton);
    }

// Input the values on Delivery Details Page:
    public void fillDeliveryDetails(Userdata user) {
        System.out.println(user.toString());
        checkIfTextIsExpected(deliveryUserEmail,user.getEmail());
        inputTextBox(deliveryUserTitle,user.getTitle());
        inputTextBox(deliveryUserFirstname,user.getFirstname());
        inputTextBox(deliveryUserLastname,user.getLastname());
        inputTextBox(deliveryUserPhonenumber,user.getPhonenumber());
        inputTextBox(deliveryUserAddress,user.getShortaddress());
        waitUntilElementClickable(deliveryUserAddressSelected);
        focusAndClickElement(deliveryUserAddressSelected);
        System.out.println("fillDeliveryDetails complete");
    }

// Select the Use this Address Button to navigate next page:
    public void selectUseThisDeliveryAddress(String useThisDeliveryAddress) {
        waitUntilElementClickable(useThisAddressElement);
        checkIfTextIsExpected(useThisAddressElement,useThisDeliveryAddress);
        clickOn(useThisAddressElement);
        System.out.println("selectUseThisDeliveryAddress complete");
    }

// Select the Named or Next Day Delivery Option:
    public void selectNamedOrNextDelivery(String namedOrNextDelivery) {
        waitUntilElementVisible(nextOrNamedDayDeliveryElement);
        checkIfTextContainsExpected(nextOrNamedDayDeliveryElement,namedOrNextDelivery);
        clickOn(nextOrNamedDayDeliveryElement);
        System.out.println("selectNamedOrNextDelivery complete");
    }

// Choose the Delivery Date:
    public void selectDeliveryDay(Map.Entry<String, String> addDayToToday) {
        dateXpath=dateXpathPrefix + addDayToToday.getKey() + dateXpathSuffix;
        deliveryDateElement=find_element_by_xpath(dateXpath);

        waitUntilElementVisible(deliveryDateElement);
        List<String> wordList = Arrays.asList(addDayToToday.getValue().split(" "));
        for(String eachWord: wordList){
            checkIfTextContainsExpected(deliveryDateElement,eachWord);
        }
        clickOn(deliveryDateElement);
        System.out.println("selectDeliveryDay complete");
    }

// Select Continue Payment Button:
    public void selectContinueToPayment(String continueToPayment) {
        waitUntilElementVisible(continuePaymentButton);
        checkIfTextIsExpected(continuePaymentButton,continueToPayment);
        clickOn(continuePaymentButton);
        System.out.println("selectContinueToPayment complete");
    }
}
