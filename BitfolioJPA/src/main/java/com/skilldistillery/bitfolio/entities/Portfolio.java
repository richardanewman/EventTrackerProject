package com.skilldistillery.bitfolio.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Portfolio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="portfolio_name")
	private String portfolioName;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name= "user_profile_id")
	private UserProfile user;
	
	@OneToMany(mappedBy="portfolio", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Coin> coins;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public List<Coin> getCoins() {
		return coins;
	}

	public void setCoins(List<Coin> coins) {
		this.coins = coins;
	}


	public Portfolio(int id, String portfolioName, UserProfile user, List<Coin> coins) {
		super();
		this.id = id;
		this.portfolioName = portfolioName;
		this.user = user;
		this.coins = coins;
	}

	public Portfolio() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Portfolio [id=");
		builder.append(id);
		builder.append(", portfolioName=");
		builder.append(portfolioName);
		builder.append(", user=");
		builder.append(user);
		builder.append(", coins=");
		builder.append(coins);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coins == null) ? 0 : coins.hashCode());
		result = prime * result + id;
		result = prime * result + ((portfolioName == null) ? 0 : portfolioName.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Portfolio other = (Portfolio) obj;
		if (coins == null) {
			if (other.coins != null)
				return false;
		} else if (!coins.equals(other.coins))
			return false;
		if (id != other.id)
			return false;
		if (portfolioName == null) {
			if (other.portfolioName != null)
				return false;
		} else if (!portfolioName.equals(other.portfolioName))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	

}
