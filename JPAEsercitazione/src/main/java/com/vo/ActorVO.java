package com.vo;

import java.io.Serializable;

public class ActorVO implements Serializable {

	private static final long serialVersionUID = 5427410136493941505L;

	private String firstName;
	private String lastName;
	private Long count;
	private String filmTitle;

	public ActorVO(String firstName, String lastName, String filmTitle) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.filmTitle = filmTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getFilmTitle() {
		return filmTitle;
	}

	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}

	@Override
	public String toString() {
		return "ActorVO [firstName=" + firstName + ", lastName=" + lastName + ", count=" + count + ", filmTitle="
				+ filmTitle + "]";
	}

}
