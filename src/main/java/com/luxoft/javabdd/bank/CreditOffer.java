package com.luxoft.javabdd.bank;

import java.util.List;

public abstract class CreditOffer {
    private String id;

    public CreditOffer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract List<Customer> getCustomersList();

    public abstract boolean addCustomer(Customer customer);

    public abstract boolean removeCustomer(Customer customer);

    public abstract String getCreditOfferType();

}

