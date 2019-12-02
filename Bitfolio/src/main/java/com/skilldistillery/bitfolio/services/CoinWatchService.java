package com.skilldistillery.bitfolio.services;

import java.util.List;

import com.skilldistillery.bitfolio.entities.CoinWatch;

public interface CoinWatchService {
	List<CoinWatch> findAllCoinWatch();
	CoinWatch findCoinWatchByWatchId(int id);
	List<CoinWatch> findAllCoinWatchByUserId(int id);
	CoinWatch createCoinWatch(int id, CoinWatch coinWatch);
	CoinWatch updateCoinWatch(int wid, CoinWatch coinWatch);
	boolean deleteCoinWatch(int wid);

}
