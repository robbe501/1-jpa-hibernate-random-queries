package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Address;
import com.provider.ProviderManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class AddressStaffStoreDAOImpl implements AddressStaffStoreDAO {
	private EntityManager em;
	private EntityManagerFactory emf;

	@Override
	public Map<Address, Long> getNumStaffPerStore() {
		initRoutine();

		Map<Address, Long> toReturn = new HashMap<Address, Long>();

//		String jpql = "SELECT a.address, COUNT(st.firstName) FROM Store s JOIN s.staffs st JOIN s.address a GROUP BY a.address";

		List<Object[]> results = em.createNamedQuery("Store.getNumStaffPerStore", Object[].class).getResultList();

		for (Object[] result : results) {
			String address = (String) result[0];
			Long nStaff = (Long) result[1];

			toReturn.put(new Address(address), nStaff);
		}
		closingRoutine();

		return toReturn;
	}

	private void closingRoutine() {
		try {
			ProviderManager.commitTransaction(em);
		} catch (RollbackException rbe) {
			ProviderManager.rollbackTransaction(em);
		}

		ProviderManager.closeTransaction(em);
		ProviderManager.closeEntityManagerFactory(emf);
	}

	private void initRoutine() {
		emf = ProviderManager.getEntityManagerFactory();
		em = ProviderManager.getEntityManager(emf);

		ProviderManager.beginTransaction(em);
	}

}
