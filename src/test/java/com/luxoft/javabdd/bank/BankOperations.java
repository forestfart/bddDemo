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

    @Given("^a economy credit offer$")
    public void a_calculator() throws Throwable {
        creditOffer = new EconomyCreditOffer("1");
    }

    @When("^we add a regular customer$")
    public void we_add_a_regular_customer() throws Throwable {
        creditOffer.addCustomer(regularCustomer);
    }

    @When("^remove a regular customer$")
    public void remove_a_regular_customer() throws Throwable {
        creditOffer.removeCustomer(regularCustomer);
    }

    @Then("^you have new customer on economy credit offer list$")
    public void we_add_customer_to_economy_credit_offer() throws Throwable {
        assertAll("we check if new customer on the list",
                () -> assertNotNull(creditOffer.getCustomersList()),
                () -> Assertions.assertEquals( 1, creditOffer.getCustomersList().size()),
                () -> Assertions.assertEquals(creditOffer.getCreditOfferType(), "Economy"));
    }

    @Then("^you have nobody on credit offer list$")
    public void you_have_nobody_on_credit_offer_list() throws Throwable {
        assertAll("we check if customer disappeared from the list",
                () -> assertNotNull(creditOffer.getCustomersList()),
                () -> Assertions.assertEquals(0, creditOffer.getCustomersList().size()),
                () -> Assertions.assertEquals(creditOffer.getCreditOfferType(), "Economy"));
    }

}
