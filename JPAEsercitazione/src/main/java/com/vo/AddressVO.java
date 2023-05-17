package com.vo;

import java.io.Serializable;

public class AddressVO implements Serializable {

	private static final long serialVersionUID = -7292215826177102126L;

	private String address;
	private Long count;

	public AddressVO(String address, Long count) {
		this.address = address;
		this.count = count;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AddressVO [address=" + address + ", count=" + count + "]";
	}

}
