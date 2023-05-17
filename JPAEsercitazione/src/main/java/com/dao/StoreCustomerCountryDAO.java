package com.dao;

import java.util.List;

import com.vo.StoreVO;

public interface StoreCustomerCountryDAO {
	public List<StoreVO> getStorePerCustomerInCountry(String country);
}
