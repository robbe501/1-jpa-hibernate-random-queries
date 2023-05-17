package com.dao;

import java.util.List;

import com.provider.ProviderManager;
import com.vo.CustomerVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class CustomerPaymentDAOImpl implements CustomerPaymentDAO {
	private EntityManager em;
	private EntityManagerFactory emf;

	@Override
	public List<CustomerVO> getTotalAmountPerCustomer() {
		initRoutine();

//		String jpql = "SELECT a.address, COUNT(st.firstName) FROM Store s JOIN s.staffs st JOIN s.address a GROUP BY a.address";

		List<CustomerVO> results = em.createNamedQuery("Customer.getTotalAmountPerCustomer", CustomerVO.class)
				.getResultList();

//		for (Object[] result : results) {
//			String firstName = (String) result[0];
//			String lastName = (String) result[1];
//			BigDecimal total = (BigDecimal) result[2];
//
//			toReturn.put(new Customer(firstName, lastName), total);
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
