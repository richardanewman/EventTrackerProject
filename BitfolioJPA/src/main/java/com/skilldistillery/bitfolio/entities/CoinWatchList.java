package com.skilldistillery.bitfolio.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="coin_watch_list")
public class CoinWatchList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="watch_list_name")
	private String watchListName;
	
	@ManyToOne(cascade = { CascadeType.PERSIST})
	@JoinColumn(name="user_profile_id")
	private UserProfile user;
	
	@Column(name="logo_url")
	private String logo;
	
	@Column(name="coin_name")
	private String coinName;
	
	@Column(name="trading_pair")
	private String tradingPair;
	
	private String exchange;
	
	@Column(name="alert_low")
	private double alertLow;
	
	@Column(name="alert_high")
	private double alertHigh;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWatchListName() {
		return watchListName;
	}

	public void setWatchListName(String watchListName) {
		this.watchListName = watchListName;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCoinName() {
		return coinName;
	}

	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}

	public String getTradingPair() {
		return tradingPair;
	}

	public void setTradingPair(String tradingPair) {
		this.tradingPair = tradingPair;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public double getAlertLow() {
		return alertLow;
	}

	public void setAlertLow(double alertLow) {
		this.alertLow = alertLow;
	}

	public double getAlertHigh() {
		return alertHigh;
	}

	public void setAlertHigh(double alertHigh) {
		this.alertHigh = alertHigh;
	}

	public CoinWatchList(int id, String watchListName, UserProfile user, String logo, String coinName,
			String tradingPair, String exchange, double alertLow, double alertHigh) {
		super();
		this.id = id;
		this.watchListName = watchListName;
		this.user = user;
		this.logo = logo;
		this.coinName = coinName;
		this.tradingPair = tradingPair;
		this.exchange = exchange;
		this.alertLow = alertLow;
		this.alertHigh = alertHigh;
	}

	public CoinWatchList() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoinWatchList [id=");
		builder.append(id);
		builder.append(", watchListName=");
		builder.append(watchListName);
		builder.append(", user=");
		builder.append(user);
		builder.append(", logo=");
		builder.append(logo);
		builder.append(", coinName=");
		builder.append(coinName);
		builder.append(", tradingPair=");
		builder.append(tradingPair);
		builder.append(", exchange=");
		builder.append(exchange);
		builder.append(", alertLow=");
		builder.append(alertLow);
		builder.append(", alertHigh=");
		builder.append(alertHigh);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(alertHigh);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(alertLow);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((coinName == null) ? 0 : coinName.hashCode());
		result = prime * result + ((exchange == null) ? 0 : exchange.hashCode());
		result = prime * result + id;
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((tradingPair == null) ? 0 : tradingPair.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((watchListName == null) ? 0 : watchListName.hashCode());
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
		CoinWatchList other = (CoinWatchList) obj;
		if (Double.doubleToLongBits(alertHigh) != Double.doubleToLongBits(other.alertHigh))
			return false;
		if (Double.doubleToLongBits(alertLow) != Double.doubleToLongBits(other.alertLow))
			return false;
		if (coinName == null) {
			if (other.coinName != null)
				return false;
		} else if (!coinName.equals(other.coinName))
			return false;
		if (exchange == null) {
			if (other.exchange != null)
				return false;
		} else if (!exchange.equals(other.exchange))
			return false;
		if (id != other.id)
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (tradingPair == null) {
			if (other.tradingPair != null)
				return false;
		} else if (!tradingPair.equals(other.tradingPair))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (watchListName == null) {
			if (other.watchListName != null)
				return false;
		} else if (!watchListName.equals(other.watchListName))
			return false;
		return true;
	}
	
	
	
	
	

}
