package com.adarga.web;

import com.adarga.web.data.OrderItem;
import com.adarga.web.data.Userdata;
import com.adarga.web.helper.DriverProvider;
import com.adarga.web.pages.JLValidationPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ValidationPageStepDefinitions {
    private final JLValidationPage johnLewisReviewPaymentPage;

    //Constructor
    public ValidationPageStepDefinitions(){
        johnLewisReviewPaymentPage = new JLValidationPage(DriverProvider.getDriver());
    }


    @Then("user validate the delivery details on {string} with")
    public void userValidateTheDeliveryDetailsOnWith(String reviewAndPayElement, io.cucumber.datatable.DataTable dataTable) {

        Userdata expectedDeliveryUser, actualDeliveryUser;
        List<Map<String, String>> mapList = dataTable.transpose().asMaps();
        Map<String, String> dataMap = mapList.iterator().next();

        expectedDeliveryUser=new ObjectMapper().convertValue(dataMap, Userdata.class);
        System.out.println(expectedDeliveryUser.toString());

        HashMap<String,String> actualDeliveryUserMap = johnLewisReviewPaymentPage.verifyUserDeliveryDetails(reviewAndPayElement);
        actualDeliveryUser=new ObjectMapper().convertValue(actualDeliveryUserMap, Userdata.class);

        System.out.println(actualDeliveryUser.toString());
        Assert.assertTrue(Objects.equals(actualDeliveryUser,expectedDeliveryUser));
    }

    @And("user validates the order items as")
    public void userValidatesTheOrderItemsAs(io.cucumber.datatable.DataTable dataTable) {

        OrderItem expectedOrderItem, actualOrderItem;
        List<Map<String, String>> mapList = dataTable.transpose().asMaps();
        Map<String, String> dataMap = mapList.iterator().next();

        expectedOrderItem=new ObjectMapper().convertValue(dataMap, OrderItem.class);
        System.out.println(expectedOrderItem);

        HashMap<String,String> actualOrderItemMap = johnLewisReviewPaymentPage.verifyOrderItemDetails();
        actualOrderItem=new ObjectMapper().convertValue(actualOrderItemMap, OrderItem.class);

        System.out.println(actualOrderItem.toString());

        Assert.assertTrue(Objects.equals(actualOrderItem,expectedOrderItem));
    }
}
