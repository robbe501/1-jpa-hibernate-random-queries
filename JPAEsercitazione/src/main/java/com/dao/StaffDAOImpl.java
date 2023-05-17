package com.dao;

import com.entity.Staff;
import com.provider.ProviderManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class StaffDAOImpl implements StaffDAO {
	private EntityManager em;
	private EntityManagerFactory emf;

	@Override
	public void insertStaff(Staff staff) {
		initRoutine();

		em.persist(staff);

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
