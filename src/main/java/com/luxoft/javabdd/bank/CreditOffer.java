package com.luxoft.javabdd.bank;

import java.util.List;

public abstract class CreditOffer {
    private String id;

    protected CreditOffer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    protected abstract List<Customer> getCustomersList();

    protected abstract boolean addCustomer(Customer customer);

    protected abstract boolean removeCustomer(Customer customer);

    protected abstract String getCreditOfferType();

    final protected boolean handleNewCustomer(List<Customer> customersList, Customer customer) {
        if (!customersList.contains(customer)) {
            return customersList.add(customer);
        }
        return false;
    }

}

