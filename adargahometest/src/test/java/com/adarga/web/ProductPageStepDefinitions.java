package com.adarga.web;

import com.adarga.web.helper.DriverProvider;
import com.adarga.web.pages.JLProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;




public class ProductPageStepDefinitions {
    private final JLProductPage johnLewisProductPage;

    //Constructor
    public ProductPageStepDefinitions(){
        johnLewisProductPage = new JLProductPage(DriverProvider.getDriver());
    }

    @Given("user is on JohnLewis home page")
    public void user_Is_On_John_Lewis_Home_Page() {
        johnLewisProductPage.openStartPage();
    }

    @When("User allows essential cookies only")
    public void user_skip_cookie_selection() {
        johnLewisProductPage.manageEssentialCookiesOnly();
    }

    @And("user click the product type as {string}")
    public void user_click_the_product_type_as(String productType) {
        johnLewisProductPage.selectTheProductType(productType);
    }

    @And("user click the sub-product as {string}")
    public void user_click_the_sub_product_as(String subProduct) {
        johnLewisProductPage.selectTheSubProduct(subProduct);
    }

    @And("user sort the product as {string}")
    public void user_sort_the_product_as(String sortByValue) {
        johnLewisProductPage.sortBy(sortByValue);
    }

    @And("user selects the product as {string} from {string} page")
    public void userSelectsTheProductAs(String productName,String productPage) {
        johnLewisProductPage.selectProductName(productName, productPage);
    }

    @And("user adds the product in cart as {string} from {string} page")
    public void user_adds_the_product_in_cart_as_from(String addBasket,String productPage) {
        johnLewisProductPage.selectAddToBasket(addBasket,productPage);
    }

    @And("user verify the product added successfully as {string} from {string} page")
    public void user_verify_the_product_added_successfully_as(String addedToTheBasket, String productPage) {
        johnLewisProductPage.successfullyAddedToBasket(addedToTheBasket,productPage);
    }

    @And("user opens the basket - {string} from {string} page")
    public void user_opens_the_basket(String productName,String onPage) {
        johnLewisProductPage.opensBasket(productName, onPage);
    }

    @And("user clicks as {string}")
    public void user_clicks_as(String continueCheckout) {
        johnLewisProductPage.continueCheckout(continueCheckout);
    }
}
