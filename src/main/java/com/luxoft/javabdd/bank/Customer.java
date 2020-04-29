package com.luxoft.javabdd.bank;

public class Customer {

	private String name;
	private boolean vip;
	private int bonusPoints;

	public Customer(String name, boolean vip) {
		this.name = name;
		this.vip = vip;
	}

	public String getName() {
		return name;
	}

	public boolean isVip() {
		return vip;
	}

	public int addBonusPoints(int bonusPoints) {
		return this.bonusPoints += bonusPoints;
	}

	public int getBonusPoints() {
		return bonusPoints;
	}
}
