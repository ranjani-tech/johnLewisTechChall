package com.adarga.web.pages;

import org.openqa.selenium.WebDriver;
import com.adarga.web.base.BasePage;
import com.adarga.web.data.Userdata;
import com.adarga.web.helper.PropertiesProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class JLValidationPage extends JLCheckoutPage{




//constructor
    public JLValidationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//h1[@data-test='payment-title']")
    WebElement reviewAndPayElement;

    @FindBy(xpath = "//span[@data-test='addressee']")
    WebElement reviewAddresseElement;

    @FindBy(xpath ="//span[@data-test='address-address-line-1']")
    WebElement reviewAddresseLine1;

    @FindBy(xpath ="//span[@data-test='address-address-line-2']")
    WebElement reviewAddresseLine2;

    @FindBy(xpath ="//span[@data-test='address-town-or-city']")
    WebElement reviewAddresseTownOrCity;

    @FindBy(xpath ="//span[@data-test='address-postcode']")
    WebElement reviewAddressePostCode;

    @FindBy(xpath ="//span[@data-test='address-phone']")
    WebElement reviewAddressePhone;

    @FindBy(xpath ="//p[@data-test='delivery-details-user-email-text']")
    WebElement reviewAddresseEmail;

    @FindBy(xpath ="//p[@data-test='order-item-name']")
    WebElement reviewOrderItemName;

    @FindBy(xpath ="//p[@data-test='order-item-quantity']")
    WebElement reviewOrderQuantity;

    @FindBy(xpath ="(//div[@data-test='order-totals-balance'])[1]")
    WebElement reviewOrderTotalsBalance;



// Review And Pay Page Validation on User Details, Email Address
    public HashMap<String,String> verifyUserDeliveryDetails(String reviewAndPay) {
        waitUntilElementVisible(reviewAndPayElement);
        checkIfTextIsExpected(reviewAndPayElement,reviewAndPay);
        System.out.println("verifyReviewAndPay complete");

        HashMap<String,String> delieryUserDetails = new HashMap<>();
        delieryUserDetails.put("addresse",reviewAddresseElement.getText());
        delieryUserDetails.put("addressline1",reviewAddresseLine1.getText());
        delieryUserDetails.put("addressline2",reviewAddresseLine2.getText());
        delieryUserDetails.put("city",reviewAddresseTownOrCity.getText());
        delieryUserDetails.put("postcode",reviewAddressePostCode.getText());
        delieryUserDetails.put("phonenumber",reviewAddressePhone.getText());
        delieryUserDetails.put("email",reviewAddresseEmail.getText());
        return delieryUserDetails;

    }

// Validation on Product Name, Quantity, Total Balance:
    public HashMap<String,String> verifyOrderItemDetails() {
        HashMap<String,String> orderItemDetails = new HashMap<>();

        orderItemDetails.put("itemname",reviewOrderItemName.getText());
        orderItemDetails.put("itemcount",reviewOrderQuantity.getText().split(" ")[1]);
        orderItemDetails.put("totalcost",reviewOrderTotalsBalance.getText().split("£")[1]);
        return orderItemDetails;
    }
}
