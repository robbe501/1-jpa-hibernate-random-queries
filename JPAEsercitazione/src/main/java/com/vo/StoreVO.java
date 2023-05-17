package com.vo;

import java.io.Serializable;

public class StoreVO implements Serializable {

	private static final long serialVersionUID = -1749118984757719617L;

	private Integer storeId;
	private String country;

	public StoreVO(Integer storeId, String country) {
		this.storeId = storeId;
		this.country = country;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "StoreVO [storeId=" + storeId + ", country=" + country + "]";
	}

}
