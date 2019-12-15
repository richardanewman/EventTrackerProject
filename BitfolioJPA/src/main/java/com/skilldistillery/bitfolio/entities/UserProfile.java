package com.skilldistillery.bitfolio.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user_profile")
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String city;
	
	private String state;
	
	@Column(name="profile_picture_url")
	private String photoURL;

	private String bio;
	
	private String images;
	@JsonIgnore
	@OneToMany(mappedBy="user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Portfolio> portfolios;
	
	@OneToMany(mappedBy="user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<CoinWatch> watchLists;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public List<Portfolio> getPortfolios() {
		return portfolios;
	}

	public void setPortfolios(List<Portfolio> portfolios) {
		this.portfolios = portfolios;
	}

	public List<CoinWatch> getWatchLists() {
		return watchLists;
	}

	public void setWatchLists(List<CoinWatch> watchLists) {
		this.watchLists = watchLists;
	}


	public UserProfile(int id, String firstName, String lastName, String city, String state, String photoURL,
			String bio, String images, List<Portfolio> portfolios, List<CoinWatch> watchLists) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.photoURL = photoURL;
		this.bio = bio;
		this.images = images;
		this.portfolios = portfolios;
		this.watchLists = watchLists;
	}

	public UserProfile() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserProfile [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", photoURL=");
		builder.append(photoURL);
		builder.append(", bio=");
		builder.append(bio);
		builder.append(", images=");
		builder.append(images);
		builder.append(", portfolios=");
		builder.append(portfolios);
		builder.append(", watchLists=");
		builder.append(watchLists);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bio == null) ? 0 : bio.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((photoURL == null) ? 0 : photoURL.hashCode());
		result = prime * result + ((portfolios == null) ? 0 : portfolios.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((watchLists == null) ? 0 : watchLists.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		if (bio == null) {
			if (other.bio != null)
				return false;
		} else if (!bio.equals(other.bio))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (photoURL == null) {
			if (other.photoURL != null)
				return false;
		} else if (!photoURL.equals(other.photoURL))
			return false;
		if (portfolios == null) {
			if (other.portfolios != null)
				return false;
		} else if (!portfolios.equals(other.portfolios))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (watchLists == null) {
			if (other.watchLists != null)
				return false;
		} else if (!watchLists.equals(other.watchLists))
			return false;
		return true;
	}
	
	
}
