package com.deloitte.hux.netflix.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="netflix_show")
public class NetflixShow {
	
	@Id
//	@GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//        name = "UUID",
//    strategy = "org.hibernate.id.UUIDGenerator"
//    )
	@Column(name="show_id")
	private String showId;
	
	@Column(name="show_type")
	private String type;
	
	@Column(name="title")
	private String title;
	
	@Column(name="director")
	private String director;
	
	@Column(name="show_cast")
	private String cast;
	
	@Column(name="country")
	private String country;
	
	@Column(name="date_added")
	private String dateAdded;
	
	@Column(name="release_year")
	private String releaseYear;
	
	@Column(name="rating")
	private String rating;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="listed_in")
	private String listedIn;
	
	@Column(name="description")
	private String description;
	
	public NetflixShow() {
		
	}
	public String getShowId() {
		return showId;
	}
	public void setShowId(String showId) {
		this.showId = showId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getListedIn() {
		return listedIn;
	}
	public void setListedIn(String listedIn) {
		this.listedIn = listedIn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "NetflixShow [type=" + type + ", title=" + title + ", director=" + director
				+ ", cast=" + cast + ", country=" + country + ", dateAdded=" + dateAdded + ", releaseYear="
				+ releaseYear + ", rating=" + rating + ", duration=" + duration + ", listedIn=" + listedIn
				+ ", description=" + description + "]";
	}
	
	

}
