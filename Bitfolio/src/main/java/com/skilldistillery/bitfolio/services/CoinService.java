package com.skilldistillery.bitfolio.services;

import java.util.List;

import com.skilldistillery.bitfolio.entities.Coin;

public interface CoinService {
	List<Coin> getAllCoins();
	boolean deleteCoin(int id);
	Coin findCoinById(int id);
	List<Coin> getAllCoinsByPortfolioId(int id);
	Coin createCoin(int id, Coin coin);
	Coin updateCoin(int id, Coin coin);

}
