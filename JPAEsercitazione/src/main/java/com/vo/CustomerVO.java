package com.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class CustomerVO implements Serializable {

	private static final long serialVersionUID = 6734456282361730936L;

	private String firstName;
	private String lastName;
	private BigDecimal sum;

	public CustomerVO(String firstName, String lastName, BigDecimal sum) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sum = sum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "CustomerVO [firstName=" + firstName + ", lastName=" + lastName + ", sum=" + sum + "]";
	}

}
