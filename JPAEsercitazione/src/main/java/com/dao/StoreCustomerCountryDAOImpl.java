package com.dao;

import java.util.List;

import com.provider.ProviderManager;
import com.vo.StoreVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class StoreCustomerCountryDAOImpl implements StoreCustomerCountryDAO {

	private EntityManager em;
	private EntityManagerFactory emf;

	@Override
	public List<StoreVO> getStorePerCustomerInCountry(String country) {
		initRoutine();

//		List<Store> toReturn = new ArrayList<Store>();

		List<StoreVO> results = em.createNamedQuery("Store.getStorePerCustomerInCountry", StoreVO.class)
				.setParameter("country", country).getResultList();

//		for (Object[] result : results) {
//			Integer storeId = (Integer) result[0];
//			toReturn.add(new Store(storeId));
//		}
		closingRoutine();

		return results;
	}

	private void closingRoutine() {
		try {
			ProviderManager.commitTransaction(em);
			System.out.println("Transazione Completata");
		} catch (RollbackException rbe) {
			rbe.printStackTrace();
			System.err.println("Transazione Fallita");
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
