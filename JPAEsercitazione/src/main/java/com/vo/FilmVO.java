package com.vo;

import java.io.Serializable;

public class FilmVO implements Serializable {

	private static final long serialVersionUID = 2012566600648390506L;

	private String title;
	private Long count;
	private String filmCategory;
	private String actorFirstName;
	private String actorLastName;

	public FilmVO(String title, Long count, String filmCategory) {
		this.title = title;
		this.count = count;
		this.filmCategory = filmCategory;
	}

	public FilmVO(String title, String filmCategory) {
		this.title = title;
		this.filmCategory = filmCategory;
	}

	public FilmVO(String title, Long count) {
		this.title = title;
		this.count = count;
	}

	public FilmVO(String title, String actorFirstName, String actorLastName) {
		this.title = title;
		this.actorFirstName = actorFirstName;
		this.actorLastName = actorLastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getFilmCategory() {
		return filmCategory;
	}

	public void setFilmCategory(String filmCategory) {
		this.filmCategory = filmCategory;
	}

	public String getActorFirstName() {
		return actorFirstName;
	}

	public void setActorFirstName(String actorFirstName) {
		this.actorFirstName = actorFirstName;
	}

	public String getActorLastName() {
		return actorLastName;
	}

	public void setActorLastName(String actorLastName) {
		this.actorLastName = actorLastName;
	}

	@Override
	public String toString() {
		return "FilmVO [title=" + title + ", count=" + count + ", filmCategory=" + filmCategory + ", actorFirstName="
				+ actorFirstName + ", actorLastName=" + actorLastName + "]";
	}

}
