package com.dao;

import java.util.List;

import com.entity.Actor;
import com.entity.Film;
import com.provider.ProviderManager;
import com.vo.ActorVO;
import com.vo.FilmVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class FilmActorDAOImpl implements FilmActorDAO {
	private EntityManager em;
	private EntityManagerFactory emf;

	@Override
	public List<ActorVO> getActorsByFilm(String title) {
		initRoutine();

		List<ActorVO> results = em.createNamedQuery("Actor.getActorsByFilm", ActorVO.class).setParameter("title", title)
				.getResultList();

//		for (Object[] result : results) {
//			String firstName = (String) result[0];
//			String lastName = (String) result[1];
//			toReturn.add(new Actor(firstName, lastName));
//		}
		closingRoutine();

		return results;
	}

	@Override
	public List<FilmVO> getFilmsByNumActors(Integer numActor) {
		initRoutine();

//		List<Film> toReturn = new ArrayList<Film>();

		List<FilmVO> results = em.createNamedQuery("Film.getFilmsByNumActors", FilmVO.class)
				.setParameter("numActs", numActor).getResultList();

//		for (Object[] result : results) {
//			String title = (String) result[0];
//			toReturn.add(new Film(title));
//		}
		closingRoutine();

		return results;
	}

	@Override
	public List<FilmVO> getFilmsByActor(String firstName, String lastName) {
		initRoutine();

//		List<Film> toReturn = new ArrayList<Film>();

		List<FilmVO> results = em.createNamedQuery("Film.getFilmsByActor", FilmVO.class)
				.setParameter("firstName", firstName).setParameter("lastName", lastName).getResultList();

//		for (Object[] result : results) {
//			String title = (String) result[0];
//			toReturn.add(new Film(title));
//		}
		closingRoutine();

		return results;
	}

	@Override
	public void insertActorFilms(Actor actor, List<Film> films) {
		initRoutine();

		for (Film f : films) {
			f.getActors().add(actor);
			em.persist(f);
//			actor.getFilms().add(f);
		}

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
