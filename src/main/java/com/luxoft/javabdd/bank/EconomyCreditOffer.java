package com.luxoft.javabdd.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class EconomyCreditOffer extends CreditOffer {
    private String creditOfferType;
    private List<Customer> customersList = new ArrayList<Customer>();

    public EconomyCreditOffer(String id) {
        super(id);
        this.creditOfferType = "Economy";
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return handleNewCustomer(customersList, customer);
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        if (!customer.isVip()) {
            return customersList.remove(customer);
        }
        return false;
    }

	@Override
	public String getCreditOfferType() {
		return creditOfferType;
	}

	@Override
    public List<Customer> getCustomersList() {
        return Collections.unmodifiableList(customersList);
    }
}
