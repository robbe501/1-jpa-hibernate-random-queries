package com.dao;

import java.util.List;

import com.provider.ProviderManager;
import com.vo.CategoryVO;
import com.vo.FilmVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class FilmCategoryDAOImpl implements FilmCategoryDAO {
	private EntityManager em;
	private EntityManagerFactory emf;

	@Override
	public List<CategoryVO> getNumFilmsPerOneCategory(String categoryName) {
		initRoutine();

//		Map<Category, Long> toReturn = new HashMap<Category, Long>();

		List<CategoryVO> results = em.createNamedQuery("Film.getNumFilmsPerOneCategory", CategoryVO.class)
				.setParameter("categoryName", categoryName).getResultList();

//		for (Object[] result : results) {
//			String name = (String) result[0];
//			Long numFilms = (Long) result[1];
//			toReturn.put(new Category(name), numFilms);
//		}
		closingRoutine();

		return results;
	}

	@Override
	public List<FilmVO> getFilmsByCategoryDesc(String categoryName) {
		initRoutine();

//		List<Film> toReturn = new ArrayList<Film>();

		List<FilmVO> results = em.createNamedQuery("Film.getFilmsByCategoryDesc", FilmVO.class)
				.setParameter("categoryName", categoryName).getResultList();

//		for (Object[] result : results) {
//			String title = (String) result[0];
//			toReturn.add(new Film(title));
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
