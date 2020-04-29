package com.luxoft.javabdd.bank;

import java.math.BigDecimal;

public class Bank {

    public static void main(String[] args) {
        CreditOffer economyCreditOffer = new EconomyCreditOffer("1", BigDecimal.valueOf(100_000.00));
        CreditOffer businessCreditOffer = new BusinessCreditOffer("2", BigDecimal.valueOf(200_000.00));

        Customer john = new Customer("John", true);
        Customer mike = new Customer("Mike", false);

        businessCreditOffer.addCustomer(john);
        businessCreditOffer.removeCustomer(john);
        businessCreditOffer.addCustomer(mike);
        economyCreditOffer.addCustomer(mike);

        System.out.println("Business credit offer customers list:");
        for (Customer customer : businessCreditOffer.getCustomersList()) {
            System.out.println(customer.getName());
        }

        System.out.println("Economy credit offer customers list:");
        for (Customer customer : economyCreditOffer.getCustomersList()) {
            System.out.println(customer.getName());
        }
    }
}
