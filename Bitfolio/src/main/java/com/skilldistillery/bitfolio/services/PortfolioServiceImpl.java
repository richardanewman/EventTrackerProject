package com.skilldistillery.bitfolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bitfolio.entities.Coin;
import com.skilldistillery.bitfolio.entities.Portfolio;
import com.skilldistillery.bitfolio.entities.UserProfile;
import com.skilldistillery.bitfolio.repositories.CoinRepository;
import com.skilldistillery.bitfolio.repositories.PortfolioRepository;
import com.skilldistillery.bitfolio.repositories.UserProfileRepository;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	PortfolioRepository portRepo;
	
	@Autowired
	UserProfileRepository userRepo;
	
	@Autowired
	CoinRepository coinRepo;
	
	@Override
	public List<Portfolio> getAllPortfolios() {
		return portRepo.findAll();
	}
	
	@Override
	public Portfolio getPortfolioById(int id) {
		Portfolio port = null;
		Optional<Portfolio> opt = portRepo.findById(id);
		if(opt.isPresent()) {
			port = opt.get();
		}
		return port;
	}
	
	@Override
	public List<Portfolio> getAllPortfoliosByUserId(int id){
		return userRepo.findById(id).get().getPortfolios();
	
	}
	
	@Override
	public Portfolio createPortfolio(int id, Portfolio portfolio) {
		UserProfile user = null;
		Optional<UserProfile> opt = userRepo.findById(id);
		if (opt.isPresent()) {
			user = opt.get();
		}
		portfolio.setUser(user);
		portRepo.saveAndFlush(portfolio);
		return portfolio;
	}
	
	
	@Override
	public UserProfile updatePortfolio(int id, Portfolio portfolio) {
		Portfolio port = null;
		Optional<Portfolio> opt = portRepo.findById(id);
		if (opt.isPresent()) {
			port = opt.get();
		}
		
			port.setPortfolioName(portfolio.getPortfolioName());
			portRepo.saveAndFlush(port);
			
			UserProfile user = port.getUser();
		
		return user;
	}
			
		
		
	
	@Override
	public boolean deletePortfolio(int pid) {
		Portfolio port = null;
		Optional<Portfolio> opt = portRepo.findById(pid);
		if (opt.isPresent()) {
			port = opt.get();
		}
		List<Coin> coins = port.getCoins();
		for (Coin coin : coins) {
			coin.setPortfolio(null);
		}
		
		port.setCoins(null);
		port.setUser(null);
		portRepo.deleteById(pid);
		coinRepo.deleteAll(coins);
		return true;
	}	
	
		
		
	
}
