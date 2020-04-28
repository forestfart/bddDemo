package com.luxoft.javabdd.bank;

import java.util.ArrayList;
import java.util.Collections;
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

class EconomyCreditOffer extends CreditOffer {
    private String creditOfferType;
    private List<Customer> customersList = new ArrayList<Customer>();

    public EconomyCreditOffer(String id) {
        super(id);
        this.creditOfferType = "Economy";
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return customersList.add(customer);
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

class BusinessCreditOffer extends CreditOffer {
    private String creditOfferType;
    private List<Customer> customersList = new ArrayList<Customer>();

    public BusinessCreditOffer(String id) {
        super(id);
        this.creditOfferType = "Business";
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if (customer.isVip()) {
            return customersList.add(customer);
        }
        return false;
    }

    @Override
    public boolean removeCustomer(Customer customer) {
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