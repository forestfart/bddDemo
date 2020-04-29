package com.luxoft.javabdd.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PremiumCreditOffer extends CreditOffer {
    private String creditOfferType;
    private List<Customer> customersList = new ArrayList<Customer>();

    public PremiumCreditOffer(String id, BigDecimal amount) {
        super(id, amount);
        this.creditOfferType = "Premium";
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if (customer.isVip()) {
            return handleNewCustomer(customersList, customer);
        }
        return false;
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        return customersList.remove(customer);
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
