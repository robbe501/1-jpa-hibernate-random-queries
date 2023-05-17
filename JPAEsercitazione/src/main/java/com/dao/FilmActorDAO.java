package com.dao;

import java.util.List;

import com.entity.Actor;
import com.entity.Film;
import com.vo.ActorVO;

public interface FilmActorDAO {
	public List<ActorVO> getActorsByFilm(String title);

	public List<Film> getFilmsByNumActors(Integer numActor);

	public List<Film> getFilmsByActor(String firstName, String lastName);

	public void insertActorFilms(Actor actor, List<Film> films);
}
