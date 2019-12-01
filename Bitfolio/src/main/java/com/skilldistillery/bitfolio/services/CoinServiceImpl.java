package com.skilldistillery.bitfolio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bitfolio.entities.Coin;
import com.skilldistillery.bitfolio.entities.Portfolio;
import com.skilldistillery.bitfolio.repositories.CoinRepository;
import com.skilldistillery.bitfolio.repositories.PortfolioRepository;

@Service
public class CoinServiceImpl implements CoinService {

	@Autowired
	CoinRepository coinRepo;
	
	@Autowired
	PortfolioRepository portRepo;
	
	public boolean deleteCoin(int pid, int cid) {
		Coin coin = null;
		Optional<Coin> opt = coinRepo.findById(cid);
		if(opt.isPresent()) {
			coin = opt.get();
		}
		
		Portfolio port = null;
		Optional<Portfolio> portOpt = portRepo.findById(pid);
		if(opt.isPresent()) {
			port = portOpt.get();
		}
		port.getCoins().remove(coin);
		coin.setPortfolio(null);
		coinRepo.delete(coin);
		
		return true;
		
		
	}
}
