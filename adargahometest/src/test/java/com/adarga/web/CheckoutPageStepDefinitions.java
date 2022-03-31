package com.adarga.web;

import com.adarga.web.data.Userdata;
import com.adarga.web.helper.DriverProvider;
import com.adarga.web.pages.JLCheckoutPage;
import com.adarga.web.utils.DateUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class CheckoutPageStepDefinitions {
    private final JLCheckoutPage johnLewisCheckOutPage;

//Constructor
    public CheckoutPageStepDefinitions(){
        johnLewisCheckOutPage = new JLCheckoutPage(DriverProvider.getDriver());
    }

    @And("user lands on as {string}")
    public void user_lands_on_as(String signUporGuestPage) {
        johnLewisCheckOutPage.verifySignUporGuestPage(signUporGuestPage);
    }

    @And("user selects as {string} and {string}")
    public void userSelectsAsAnd(String userGuestOption, String userGuestEmail) {
        johnLewisCheckOutPage.selectAndEnter(userGuestOption,userGuestEmail);
    }

    @And("user click as {string}")
    public void user_click_as(String userGuestOption) {
        johnLewisCheckOutPage.continueGuestOption(userGuestOption);
    }

    @And("user select choose your delivery method as {string} from {string} page")
    public void user_select_choose_your_delivery_method_as_(String chooseYourDelivery,String onPage) {
        johnLewisCheckOutPage.chooseDelivery(chooseYourDelivery,onPage);
    }

    @And("user enters details on delivery page as")
    public void user_enters_details_on_delivery_page_as(io.cucumber.datatable.DataTable dataTable) {
        Userdata deliveryUser;
        List<Map<String, String>> mapList = dataTable.transpose().asMaps();
        Map<String, String> dataMap = mapList.iterator().next();
        deliveryUser=new ObjectMapper().convertValue(dataMap, Userdata.class);
        johnLewisCheckOutPage.fillDeliveryDetails(deliveryUser);
    }

    @And("user click the {string}")
    public void user_click_the(String useThisDeliveryAddress) {
        johnLewisCheckOutPage.selectUseThisDeliveryAddress(useThisDeliveryAddress);
    }

    @And("user select the delivery options available as {string}")
    public void user_select_the_delivery_options_available_as(String namedOrNextDelivery) {
        johnLewisCheckOutPage.selectNamedOrNextDelivery(namedOrNextDelivery);
    }

    @And("user select the date after {int} days")
    public void user_select_the_date_after_days(Integer daysToAdd) {
        Entry<String, String> deliveryDayFormatted = DateUtils.addDayToToday(daysToAdd);
        System.out.println(deliveryDayFormatted);
        johnLewisCheckOutPage.selectDeliveryDay(deliveryDayFormatted);
    }

    @And("use click as {string}")
    public void useClickAs(String continueToPayment) {
        johnLewisCheckOutPage.selectContinueToPayment(continueToPayment);
    }
}
