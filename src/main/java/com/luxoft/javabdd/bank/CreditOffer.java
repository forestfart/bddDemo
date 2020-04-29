package com.luxoft.javabdd.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public abstract class CreditOffer {
    private String id;
    private BigDecimal amount;

    protected CreditOffer(String id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    protected abstract List<Customer> getCustomersList();

    protected abstract boolean addCustomer(Customer customer);

    protected abstract boolean removeCustomer(Customer customer);

    protected abstract String getCreditOfferType();

    final protected boolean handleNewCustomer(List<Customer> customersList, Customer customer) {
        if (!customersList.contains(customer)) {
            customer.addBonusPoints(calculateBonusPoints(customer));
            return customersList.add(customer);
        }
        return false;
    }

    private int calculateBonusPoints(Customer customer) {
        if (customer.isVip()) {
            return amount.divide(BigDecimal.valueOf(10), 0, RoundingMode.HALF_EVEN).intValue();
        } else {
            return amount.divide(BigDecimal.valueOf(20), 0, RoundingMode.HALF_EVEN).intValue();
        }
    }

}

