package com.dao;

import java.util.Map;

import com.entity.Address;

public interface AddressStaffStoreDAO {
	public Map<Address, Long> getNumStaffPerStore();
}
