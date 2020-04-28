package com.luxoft.javabdd.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BankTest {

    @Nested
    @DisplayName("Given there is a economy credit offer")
    class EconomyCreditOfferTest {
        @Nested
        @DisplayName("When we have a regular customer")
        class UsualCustomer {
            @Test
            void thenClientCanAddCustomerToEconomyCreditOffer() {
                CreditOffer economyCreditOffer = new EconomyCreditOffer("1");
                economyCreditOffer.addCustomer(new Customer("Mike", false));

                assertAll("clientCanAddCustomerToEconomyCreditOffer",
                        () -> assertNotNull(economyCreditOffer.getCustomersList()),
                        () -> assertEquals(economyCreditOffer.getCustomersList().size(), 1),
                        () -> assertEquals(economyCreditOffer.getCreditOfferType(), "Economy"));
            }

            @Test
            void thenClientCanRemoveCustomerFromEconomyCreditOffer() {
                CreditOffer economyCreditOffer = new EconomyCreditOffer("1");
                Customer customer = new Customer("Mike", false);

                economyCreditOffer.addCustomer(customer);
                economyCreditOffer.removeCustomer(customer);

                assertAll("clientCanRemoveCustomerFromACreditOffer",
                        () -> assertNotNull(economyCreditOffer.getCustomersList()),
                        () -> assertEquals(economyCreditOffer.getCustomersList().size(), 0));
            }
        }

        @Nested
        @DisplayName("When we have a vip customer")
        class VipCustomer {
            @Test
            void thenClientCannotRemoveCustomerVipCustomer() {
                CreditOffer economyCreditOffer = new EconomyCreditOffer("1");
                Customer customer = new Customer("Mike", true);

                economyCreditOffer.addCustomer(customer);
                economyCreditOffer.removeCustomer(customer);

                assertAll("clientCanRemoveCustomerFromACreditOffer",
                        () -> assertNotNull(economyCreditOffer.getCustomersList()),
                        () -> assertEquals(economyCreditOffer.getCustomersList().size(), 1));
            }
        }

    }

    @Nested
    @DisplayName("Given there is a business credit offer")
    class BusinessCreditOfferTest {
        @Nested
        @DisplayName("When we have a vip customer")
        class VipCustomer {
            @Test
            void thenClientCanAddVipCustomerToBusinessCreditOffer() {
                CreditOffer businessCreditOffer = new BusinessCreditOffer("2");
                businessCreditOffer.addCustomer(new Customer("Mike", true));

                assertAll("clientCanAddCustomerToBusinessCreditOffer",
                        () -> assertNotNull(businessCreditOffer.getCustomersList()),
                        () -> assertEquals(businessCreditOffer.getCustomersList().size(), 1),
                        () -> assertEquals(businessCreditOffer.getCreditOfferType(), "Business"));
            }
        }

        @Nested
        @DisplayName("When we have a regular customer")
        class UsualCustomer {
            @Test
            void thenClientCannotAddRegularCustomerToBusinessCreditOffer() {
                CreditOffer businessCreditOffer = new BusinessCreditOffer("2");
                businessCreditOffer.addCustomer(new Customer("Mike", false));

                assertAll("clientCanAddCustomerToBusinessCreditOffer",
                        () -> assertNotNull(businessCreditOffer.getCustomersList()),
                        () -> assertEquals(businessCreditOffer.getCustomersList().size(), 0),
                        () -> assertEquals(businessCreditOffer.getCreditOfferType(), "Business"));
            }
        }
    }

    @Test
    void clientCanPrintListOfCustomersOnCreditOfferList() {
        BusinessCreditOffer businessCreditOffer = new BusinessCreditOffer("2");
        Customer customer1 = new Customer("Mike", false);
        Customer customer2 = new Customer("John", false);

        businessCreditOffer.addCustomer(customer1);
        businessCreditOffer.addCustomer(customer2);

        assertAll( "clientCanPrintListOfCustomersOnCreditOfferList",
                () -> assertNotNull(businessCreditOffer.getCustomersList()),
                () -> assertEquals(businessCreditOffer.getCustomersList().size(), 0));
    }

}