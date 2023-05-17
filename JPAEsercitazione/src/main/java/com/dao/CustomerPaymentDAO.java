package com.dao;

import java.util.List;

import com.vo.CustomerVO;

public interface CustomerPaymentDAO {
	public List<CustomerVO> getTotalAmountPerCustomer();
}
