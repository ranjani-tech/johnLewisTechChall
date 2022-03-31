package com.adarga.web.pages;

import com.adarga.web.base.BasePage;
import com.adarga.web.data.Userdata;
import com.adarga.web.helper.PropertiesProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class JLProductPage extends BasePage{

    @FindBy(xpath = "//a[text()='Home & Garden']")
    WebElement productTypeElement;

    @FindBy(xpath = "//a[text()='BBQs']")
    WebElement subProductElement;

    @FindBy(xpath = "//select[@id='sortBy']")
    WebElement sortByValueElement;

    //Generic ImgXpath creator for product selection
    String imgXpathPrefix = "//img[@alt='";
    String imgXpathSuffix = "']";
    String imgXpath = null;
    WebElement productImageElement;

   // @FindBy(xpath = "//button[@id='button--add-to-basket' and @type='submit']")
    WebElement addToBasketElement;

    @FindBy(xpath = "//h2[@class='add-to-basket-add-on-heading' and text()='Added to your basket:']")
    WebElement addedToTheBasketElement;

    @FindBy(xpath = "//a[text()='Go to your basket']")
    WebElement goToYourBasketElement;

    @FindBy(xpath = "//button[text()='Continue to checkout']")
    WebElement continueCheckoutElement;


    protected final String headerCookies = "OUR COOKIES";


//constructor
    public JLProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

// Navigate to HomePage:
    public void openStartPage() {
        goToWeb(PropertiesProvider.getProperties().getProperty("starturl"));
        waitUntilUrlContains(PropertiesProvider.getProperties().getProperty("starturl"));
    }

// CloseManageCookies:
    public void manageEssentialCookiesOnly() {
        waitUntilElementClickable(manageCookiesButton);
        clickOn(manageCookiesButton);
        checkIfTextIsExpected(ourCookiesHeader, headerCookies);
        focusAndClickElement(analyticsOff);
        focusAndClickElement(funtionalOff);
        focusAndClickElement(advertisingOff);
        focusAndClickElement(personalisationOff);
        waitUntilElementClickable(savePreferences);
        clickOn(savePreferences);
    }

// Select the Product category:
    public void selectTheProductType(String productType) {
        checkIfTextIsExpected(productTypeElement, productType);
        clickOn(productTypeElement);
        waitUntilUrlContains("home-garden");
    }

// Select the Product SubCategory:
    public void selectTheSubProduct(String subProduct) {
        checkIfTextIsExpected(subProductElement, subProduct);
        clickOn(subProductElement);
        waitUntilUrlContains("bbqs");
    }

// Sort the Product by Price Low to High:
    public void sortBy(String sortByValue) {
        waitUntilElementClickable(sortByValueElement);
        selectByVisibleTextInDropDown(sortByValueElement, sortByValue);
        waitUntilUrlContains("bbqs");
        waitUntilUrlContains("sortBy");
    }

// Select the Product(Item):
    public void selectProductName(String productName, String productPage) {
        imgXpath=imgXpathPrefix + productName + imgXpathSuffix;
        productImageElement=find_element_by_xpath(imgXpath);
        waitUntilElementClickable(productImageElement);
        clickOn(productImageElement);
        waitUntilUrlContains(productPage);
    }

// Add the selected product into the basket:
    public void selectAddToBasket(String addBasket, String productPage) {
        waitUntilElementClickable(addToBasketElement);
        waitUntilUrlContains(productPage);
        focusAndClickElement(addToBasketElement);
    }

// Verify the Successfully Added the Product:
    public void successfullyAddedToBasket(String addedToTheBasket, String productPage) {
        waitUntilElementVisible(addedToTheBasketElement);
        checkIfTextIsExpected(addedToTheBasketElement, addedToTheBasket);
        waitUntilUrlContains(productPage);
    }

// Open the Basket:
    public void opensBasket(String productName,String onPage) {
        checkIfTextIsExpected(goToYourBasketElement,"Go to your basket");
        focusAndClickElement(goToYourBasketElement);
        waitUntilUrlContains(onPage);
    }

// Click the Continue Checkout Button:
    public void continueCheckout(String continueCheckout) {
        checkIfTextIsExpected(continueCheckoutElement,continueCheckout);
        focusAndClickElement(continueCheckoutElement);
    }

}
