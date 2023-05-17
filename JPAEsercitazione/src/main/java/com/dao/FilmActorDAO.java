package com.dao;

import java.util.List;

import com.entity.Actor;
import com.entity.Film;
import com.vo.ActorVO;
import com.vo.FilmVO;

public interface FilmActorDAO {
	public List<ActorVO> getActorsByFilm(String title);

	public List<FilmVO> getFilmsByNumActors(Integer numActor);

	public List<FilmVO> getFilmsByActor(String firstName, String lastName);

	public void insertActorFilms(Actor actor, List<Film> films);
}
