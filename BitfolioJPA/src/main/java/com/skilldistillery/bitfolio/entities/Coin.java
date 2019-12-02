package com.skilldistillery.bitfolio.entities;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Coin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String logo;
	
	private String name;
	
	@Column(name="trading_pair")
	private String tradingPair;
	
	private String exchange;
	
	@Column(name="purchase_date")
	private LocalDate purchaseDate;
	
	@Column(name="purchase_time")
	private Time purchaseTime;
	
	@Column(name="buy_price")
	private Double buyPrice;
	
	@Column(name="amount_purchased")
	private Double amountPurchased;
	
	@Column(name="exchange_fee")
	private Double exchangeFee;
	
	private String notes;
	
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.PERSIST})
	@JoinColumn(name="portfolio_id")
	private Portfolio portfolio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getTradingPair() {
		return tradingPair;
	}

	public void setTradingPair(String tradingPair) {
		this.tradingPair = tradingPair;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Time getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Time purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getAmountPurchased() {
		return amountPurchased;
	}

	public void setAmountPurchased(Double amountPurchased) {
		this.amountPurchased = amountPurchased;
	}

	public double getExchangeFee() {
		return exchangeFee;
	}

	public void setExchangeFee(Double exchangeFee) {
		this.exchangeFee = exchangeFee;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	

	public Coin(int id, String logo, String name, String exchange, String tradingPair, LocalDate purchaseDate,
			Time purchaseTime, Double buyPrice, Double amountPurchased, Double exchangeFee, String notes,
			Portfolio portfolio) {
		super();
		this.id = id;
		this.logo = logo;
		this.name = name;
		this.exchange = exchange;
		this.tradingPair = tradingPair;
		this.purchaseDate = purchaseDate;
		this.purchaseTime = purchaseTime;
		this.buyPrice = buyPrice;
		this.amountPurchased = amountPurchased;
		this.exchangeFee = exchangeFee;
		this.notes = notes;
		this.portfolio = portfolio;
	}

	public Coin() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coin [id=");
		builder.append(id);
		builder.append(", logo=");
		builder.append(logo);
		builder.append(", name=");
		builder.append(name);
		builder.append(", tradingPair=");
		builder.append(tradingPair);
		builder.append(", exchange=");
		builder.append(exchange);
		builder.append(", purchaseDate=");
		builder.append(purchaseDate);
		builder.append(", purchaseTime=");
		builder.append(purchaseTime);
		builder.append(", buyPrice=");
		builder.append(buyPrice);
		builder.append(", amountPurchased=");
		builder.append(amountPurchased);
		builder.append(", exchangeFee=");
		builder.append(exchangeFee);
		builder.append(", notes=");
		builder.append(notes);
		builder.append(", portfolio=");
		builder.append(portfolio);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountPurchased == null) ? 0 : amountPurchased.hashCode());
		result = prime * result + ((buyPrice == null) ? 0 : buyPrice.hashCode());
		result = prime * result + ((exchange == null) ? 0 : exchange.hashCode());
		result = prime * result + ((exchangeFee == null) ? 0 : exchangeFee.hashCode());
		result = prime * result + id;
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((portfolio == null) ? 0 : portfolio.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((purchaseTime == null) ? 0 : purchaseTime.hashCode());
		result = prime * result + ((tradingPair == null) ? 0 : tradingPair.hashCode());
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
		Coin other = (Coin) obj;
		if (amountPurchased == null) {
			if (other.amountPurchased != null)
				return false;
		} else if (!amountPurchased.equals(other.amountPurchased))
			return false;
		if (buyPrice == null) {
			if (other.buyPrice != null)
				return false;
		} else if (!buyPrice.equals(other.buyPrice))
			return false;
		if (exchange == null) {
			if (other.exchange != null)
				return false;
		} else if (!exchange.equals(other.exchange))
			return false;
		if (exchangeFee == null) {
			if (other.exchangeFee != null)
				return false;
		} else if (!exchangeFee.equals(other.exchangeFee))
			return false;
		if (id != other.id)
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (portfolio == null) {
			if (other.portfolio != null)
				return false;
		} else if (!portfolio.equals(other.portfolio))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (purchaseTime == null) {
			if (other.purchaseTime != null)
				return false;
		} else if (!purchaseTime.equals(other.purchaseTime))
			return false;
		if (tradingPair == null) {
			if (other.tradingPair != null)
				return false;
		} else if (!tradingPair.equals(other.tradingPair))
			return false;
		return true;
	}
	
	
}
