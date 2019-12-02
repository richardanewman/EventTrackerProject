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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="coin_watch")
public class CoinWatch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="coin_watch_name")
	private String coinWatchName;
	
	@JsonIgnore
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
	private Double alertLow;
	
	@Column(name="alert_high")
	private Double alertHigh;

	public int getId() {
		return id;
	}

	public String getCoinWatchName() {
		return coinWatchName;
	}

	public void setCoinWatchName(String coinWatchName) {
		this.coinWatchName = coinWatchName;
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

	public Double getAlertLow() {
		return alertLow;
	}

	public void setAlertLow(Double alertLow) {
		this.alertLow = alertLow;
	}

	public Double getAlertHigh() {
		return alertHigh;
	}

	public void setAlertHigh(Double alertHigh) {
		this.alertHigh = alertHigh;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CoinWatch(int id, String coinWatchName, UserProfile user, String logo, String coinName, String tradingPair,
			String exchange, Double alertLow, Double alertHigh) {
		super();
		this.id = id;
		this.coinWatchName = coinWatchName;
		this.user = user;
		this.logo = logo;
		this.coinName = coinName;
		this.tradingPair = tradingPair;
		this.exchange = exchange;
		this.alertLow = alertLow;
		this.alertHigh = alertHigh;
	}

	public CoinWatch() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoinWatch [id=");
		builder.append(id);
		builder.append(", coinWatchName=");
		builder.append(coinWatchName);
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
		result = prime * result + ((alertHigh == null) ? 0 : alertHigh.hashCode());
		result = prime * result + ((alertLow == null) ? 0 : alertLow.hashCode());
		result = prime * result + ((coinName == null) ? 0 : coinName.hashCode());
		result = prime * result + ((coinWatchName == null) ? 0 : coinWatchName.hashCode());
		result = prime * result + ((exchange == null) ? 0 : exchange.hashCode());
		result = prime * result + id;
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((tradingPair == null) ? 0 : tradingPair.hashCode());
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
		CoinWatch other = (CoinWatch) obj;
		if (alertHigh == null) {
			if (other.alertHigh != null)
				return false;
		} else if (!alertHigh.equals(other.alertHigh))
			return false;
		if (alertLow == null) {
			if (other.alertLow != null)
				return false;
		} else if (!alertLow.equals(other.alertLow))
			return false;
		if (coinName == null) {
			if (other.coinName != null)
				return false;
		} else if (!coinName.equals(other.coinName))
			return false;
		if (coinWatchName == null) {
			if (other.coinWatchName != null)
				return false;
		} else if (!coinWatchName.equals(other.coinWatchName))
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
		return true;
	}
	
	

}