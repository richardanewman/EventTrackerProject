package com.skilldistillery.bitfolio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bitfolio.entities.Coin;
import com.skilldistillery.bitfolio.repositories.CoinRepository;
import com.skilldistillery.bitfolio.repositories.PortfolioRepository;

@Service
public class CoinServiceImpl implements CoinService {

	@Autowired
	CoinRepository coinRepo;
	
	@Autowired
	PortfolioRepository portRepo;
	
	@Override
	public boolean deleteCoin(int id) {
		Coin coin = null;
		Optional<Coin> opt = coinRepo.findById(id);
		if(opt.isPresent()) {
			coin = opt.get();
		}
		
		coin.setPortfolio(null);
		coinRepo.deleteById(id);
		
		return true;
		
		
	}
}
