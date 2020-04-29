package com.luxoft.javabdd.bank;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BankOperations {
    CreditOffer creditOffer;
    Customer regularCustomer = new Customer("Mike", false);
    Customer vipCustomer = new Customer("Moly", true);

    @Given("^a \\\"([^\\\"]*)\\\" credit offer of an \\\"([^\\\"]*)\\\"$")
    public void a_economy_credit_offer(String offerType, String amount) throws Throwable {
        if (offerType.equals("economy")) {
            creditOffer = new EconomyCreditOffer("1",  new BigDecimal(amount));
        } else if (offerType.equals("business")) {
            creditOffer = new BusinessCreditOffer("2", new BigDecimal(amount));
        } else if (offerType.equals("premium")) {
            creditOffer = new PremiumCreditOffer("3", new BigDecimal(amount));
        }
    }

    @When("^we add a \\\"([^\\\"]*)\\\" customer$")
    public void we_add_a_customer(String customerType) throws Throwable {
        if (customerType.equals("regular")) {
            creditOffer.addCustomer(regularCustomer);
        } else if (customerType.equals("vip")) {
            creditOffer.addCustomer(vipCustomer);
        }
    }

    @When("^remove a \\\"([^\\\"]*)\\\" customer$")
    public void remove_a_customer(String customerType) throws Throwable {
        if (customerType.equals("regular")) {
            creditOffer.removeCustomer(regularCustomer);
        } else if (customerType.equals("vip")) {
            creditOffer.removeCustomer(vipCustomer);
        }
    }

    @Then("^we have the (\\d+) customers on a credit offer list$")
    public void we_have_the_customer_on_credit_offer_list(int expectedCount) throws Throwable {
        assertAll("customer should be on the list",
                () -> assertNotNull(creditOffer.getCustomersList()),
                () -> Assertions.assertEquals(expectedCount, creditOffer.getCustomersList().size()));
    }

    @Then("^we have the (\\d+) customers on \\\"([^\\\"]*)\\\" credit offer list$")
    public void we_have_the_customer_on_credit_offer_list(int expectedCount, String offerType) throws Throwable {
        assertAll("customer should be on the list",
                () -> assertNotNull(creditOffer.getCustomersList()),
                () -> Assertions.assertEquals(expectedCount, creditOffer.getCustomersList().size()),
                () -> Assertions.assertEquals(creditOffer.getCreditOfferType(), offerType));
    }

    @Then("^\\\"([^\\\"]*)\\\" customer receives (\\d+)$")
    public void he_she_receives_bonus_points(String customerType, int bonusPoints) throws Throwable {
        Customer customer = customerType.equals("vip") ? vipCustomer : regularCustomer;
        assertAll("check bonus points vs. amount",
                () -> assertNotNull(creditOffer.getAmount()),
                () -> Assertions.assertEquals(bonusPoints, customer.getBonusPoints()));
    }

}
