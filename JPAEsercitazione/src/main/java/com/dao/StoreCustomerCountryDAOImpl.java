package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.entity.Store;
import com.provider.ProviderManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class StoreCustomerCountryDAOImpl implements StoreCustomerCountryDAO {

	private EntityManager em;
	private EntityManagerFactory emf;

	@Override
	public List<Store> getStorePerCustomerInCountry(String country) {
		initRoutine();

		List<Store> toReturn = new ArrayList<Store>();

		List<Object[]> results = em.createNamedQuery("Store.getStorePerCustomerInCountry", Object[].class)
				.setParameter("country", country).getResultList();

		for (Object[] result : results) {
			Integer storeId = (Integer) result[0];
			toReturn.add(new Store(storeId));
		}
		closingRoutine();

		return toReturn;
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
