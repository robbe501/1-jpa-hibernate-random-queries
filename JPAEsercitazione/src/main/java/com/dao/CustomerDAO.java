package com.dao;

import java.util.List;

import com.entity.Customer;

public interface CustomerDAO {
	public void insertBulkCustomers(List<Customer> customers);
}
