package com.dao;

import java.util.List;

import com.entity.Customer;
import com.provider.ProviderManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class CustomerDAOImpl implements CustomerDAO {

	private EntityManager em;
	private EntityManagerFactory emf;

	@Override
	public void insertBulkCustomers(List<Customer> customers) {
		initRoutine();

		customers.forEach(c -> em.persist(c));

		closingRoutine();

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