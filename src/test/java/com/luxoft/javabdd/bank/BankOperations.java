package com.luxoft.javabdd.bank;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BankOperations {
    CreditOffer creditOffer;
    Customer regularCustomer = new Customer("Mike", false);
    Customer vipCustomer = new Customer("Moly", true);

    @Given("^a economy credit offer$")
    public void a_economy_credit_offer() throws Throwable {
        creditOffer = new EconomyCreditOffer("1");
    }

    @Given("^a business credit offer$")
    public void a_business_credit_offer() throws Throwable {
        creditOffer = new BusinessCreditOffer("2");
    }

    @When("^we add a regular customer$")
    public void we_add_a_regular_customer() throws Throwable {
        creditOffer.addCustomer(regularCustomer);
    }

    @When("^we add a vip customer$")
    public void we_add_a_vip_customer() throws Throwable {
        creditOffer.addCustomer(vipCustomer);
    }

    @When("^remove a regular customer$")
    public void remove_a_regular_customer() throws Throwable {
        creditOffer.removeCustomer(regularCustomer);
    }

    @When("^remove a vip customer$")
    public void remove__a_vip_customer() throws Throwable {
        creditOffer.removeCustomer(vipCustomer);
    }

    @Then("^we have the customer on economy credit offer list$")
    public void we_have_the_customer_on_economy_credit_offer_list() throws Throwable {
        assertAll("customer should be on the list",
                () -> assertNotNull(creditOffer.getCustomersList()),
                () -> Assertions.assertEquals( 1, creditOffer.getCustomersList().size()),
                () -> Assertions.assertEquals(creditOffer.getCreditOfferType(), "Economy"));
    }

    @Then("^we have the customer on business credit offer list$")
    public void we_have_the_customer_on_business_credit_offer_list() throws Throwable {
        assertAll("customer should be on the list",
                () -> assertNotNull(creditOffer.getCustomersList()),
                () -> Assertions.assertEquals( 1, creditOffer.getCustomersList().size()),
                () -> Assertions.assertEquals(creditOffer.getCreditOfferType(), "Business"));
    }

    @Then("^we have nobody on credit offer list$")
    public void you_have_nobody_on_credit_offer_list() throws Throwable {
        assertAll("we check if customer disappeared from the list",
                () -> assertNotNull(creditOffer.getCustomersList()),
                () -> Assertions.assertEquals(0, creditOffer.getCustomersList().size()),
                () -> Assertions.assertEquals(creditOffer.getCreditOfferType(), "Economy"));
    }

}
