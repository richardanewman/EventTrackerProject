package com.skilldistillery.bitfolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bitfolio.entities.CoinWatch;
import com.skilldistillery.bitfolio.entities.UserProfile;
import com.skilldistillery.bitfolio.repositories.CoinWatchRepository;
import com.skilldistillery.bitfolio.repositories.UserProfileRepository;

@Service
public class CoinWatchServiceImpl implements CoinWatchService {

	@Autowired
	CoinWatchRepository watchRepo;
	
	@Autowired
	UserProfileRepository userRepo;
	

	@Override
	public List<CoinWatch> findAllCoinWatch() {
		return watchRepo.findAll();
	}
	
	@Override
	public CoinWatch findCoinWatchByWatchId(int id) {
		CoinWatch watch = null;
		Optional<CoinWatch> opt = watchRepo.findById(id);
		if(opt.isPresent()) {
			watch = opt.get();
		}
		return watch;
	}
	
	@Override
	public List<CoinWatch> findAllCoinWatchByUserId(int id){
		return userRepo.findById(id).get().getWatchLists();
	
	}
	
	@Override
	public CoinWatch createCoinWatch(int id, CoinWatch coinWatch) {
		UserProfile user = null;
		Optional<UserProfile> opt = userRepo.findById(id);
		if (opt.isPresent()) {
			user = opt.get();
		}
		coinWatch.setUser(user);
		watchRepo.saveAndFlush(coinWatch);
		return coinWatch;
	}
	
	
	@Override
	public CoinWatch updateCoinWatch(int id, CoinWatch coinWatch) {
		CoinWatch watch = null;
		Optional<CoinWatch> opt = watchRepo.findById(id);
		if (opt.isPresent()) {
			watch = opt.get();
		}
		
			watch.setCoinWatchName(coinWatch.getCoinWatchName());
			watch.setCoinName(coinWatch.getCoinName());
			watch.setTradingPair(coinWatch.getTradingPair());
			watch.setExchange(coinWatch.getExchange());
			watch.setAlertLow(coinWatch.getAlertLow());
			watch.setAlertHigh(coinWatch.getAlertHigh());
			watchRepo.saveAndFlush(watch);
			
		
		return watch;
	}
			
		
		
	
	@Override
	public boolean deleteCoinWatch(int wid) {
		CoinWatch watch = null;
		Optional<CoinWatch> opt = watchRepo.findById(wid);
		if (opt.isPresent()) {
			watch = opt.get();
		}
		
		watch.setUser(null);
		watchRepo.deleteById(wid);
		return true;
	}	
	
		
		
	
}
