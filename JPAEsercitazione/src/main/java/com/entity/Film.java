package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Film.getNumFilmsPerOneCategory", query = "SELECT new com.vo.CategoryVO(c.name, COUNT(f.filmId)) FROM Film f JOIN f.categories c WHERE c.name = :categoryName GROUP BY c.categoryId"),
		@NamedQuery(name = "Film.getFilmsByCategoryDesc", query = "SELECT new com.vo.FilmVO(f.title, c.name) FROM Film f JOIN f.categories c WHERE c.name = :categoryName ORDER BY f.title DESC"),
		@NamedQuery(name = "Film.getFilmsByNumActors", query = "SELECT new com.vo.FilmVO(f.title, COUNT(a.actorId)) FROM Film f JOIN f.actors a GROUP BY f.title HAVING COUNT(a.actorId) = :numActs"),
		@NamedQuery(name = "Film.getFilmsByActor", query = "SELECT new com.vo.FilmVO(f.title, a.firstName, a.lastName) FROM Film f JOIN f.actors a WHERE a.firstName = :firstName AND a.lastName = :lastName") })
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private int filmId;

	@Lob
	private String description;

	@Column(name = "language_id")
	private byte languageId;

	@UpdateTimestamp
	@Column(name = "last_update")
	private Timestamp lastUpdate;

	private int length;

	@Column(name = "original_language_id")
	private byte originalLanguageId;

	private String rating;

	@Temporal(TemporalType.DATE)
	@Column(name = "release_year")
	private int releaseYear;

	@Column(name = "rental_duration")
	private byte rentalDuration;

	@Column(name = "rental_rate")
	private double rentalRate;

	@Column(name = "replacement_cost")
	private double replacementCost;

	@Column(name = "special_features")
	private Object specialFeatures;

	private String title;

	// bi-directional many-to-many association to Category
	@ManyToMany
	@JoinTable(name = "film_category", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;

	// bi-directional many-to-many association to Category
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private List<Actor> actors = new ArrayList<Actor>();

	public Film() {
	}

	public Film(String title, String description) {
		this.title = title;
		this.description = description;
		this.languageId = 1;
		this.length = 190;
		this.originalLanguageId = 1;
		this.rating = "R";
		this.releaseYear = 1980;
		this.rentalDuration = 3;
		this.rentalRate = 2.99;
		this.replacementCost = 10.99;
		this.specialFeatures = "Trailers";
		this.actors = new ArrayList<>();

	}

	public Film(String title) {
		this.title = title;
	}

	public int getFilmId() {
		return this.filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(byte languageId) {
		this.languageId = languageId;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public byte getOriginalLanguageId() {
		return this.originalLanguageId;
	}

	public void setOriginalLanguageId(byte originalLanguageId) {
		this.originalLanguageId = originalLanguageId;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public byte getRentalDuration() {
		return this.rentalDuration;
	}

	public void setRentalDuration(byte rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return this.rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public double getReplacementCost() {
		return this.replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Object getSpecialFeatures() {
		return this.specialFeatures;
	}

	public void setSpecialFeatures(Object specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

}