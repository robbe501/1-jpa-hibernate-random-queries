package com.dao;

import java.util.List;

import com.provider.ProviderManager;
import com.vo.AddressVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class AddressStaffStoreDAOImpl implements AddressStaffStoreDAO {
	private EntityManager em;
	private EntityManagerFactory emf;

	@Override
	public List<AddressVO> getNumStaffPerStore() {
		initRoutine();

//		Map<Address, Long> toReturn = new HashMap<Address, Long>();

//		String jpql = "SELECT a.address, COUNT(st.firstName) FROM Store s JOIN s.staffs st JOIN s.address a GROUP BY a.address";

		List<AddressVO> results = em.createNamedQuery("Store.getNumStaffPerStore", AddressVO.class).getResultList();

//		for (Object[] result : results) {
//			String address = (String) result[0];
//			Long nStaff = (Long) result[1];
//
//			toReturn.put(new Address(address), nStaff);
//		}
		closingRoutine();

		return results;
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
