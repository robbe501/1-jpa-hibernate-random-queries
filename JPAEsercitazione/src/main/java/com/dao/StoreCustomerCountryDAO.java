package com.dao;

import java.util.List;

import com.entity.Store;

public interface StoreCustomerCountryDAO {
	public List<Store> getStorePerCustomerInCountry(String country);
}
