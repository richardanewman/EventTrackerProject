package com.skilldistillery.bitfolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bitfolio.entities.Portfolio;
import com.skilldistillery.bitfolio.entities.UserProfile;
import com.skilldistillery.bitfolio.repositories.PortfolioRepository;
import com.skilldistillery.bitfolio.repositories.UserProfileRepository;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	PortfolioRepository portRepo;
	
	@Autowired
	UserProfileRepository userRepo;
	
	public List<Portfolio> getAllPortfolios() {
		return portRepo.findAll();
	}
	
	public Portfolio getPortfolioById(int id) {
		Portfolio port = null;
		Optional<Portfolio> opt = portRepo.findById(id);
		if(opt.isPresent()) {
			port = opt.get();
		}
		return port;
	}
	
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
	public Portfolio updatePortfolio(int id, Portfolio portfolio) {
		UserProfile user = null;
		Optional<UserProfile> opt = userRepo.findById(id);
		if (opt.isPresent()) {
			user = opt.get();
		}
		if (user.getPortfolios().contains(portfolio)){
			portfolio.setPortfolioName(portfolio.getPortfolioName());
		}
		portRepo.saveAndFlush(portfolio);
		return portfolio;
	}
	@Override
	public boolean deletePortfolio(int uid, int pid) {
		UserProfile user = null;
		Optional<UserProfile> opt = userRepo.findById(uid);
		if (opt.isPresent()) {
			user = opt.get();
		}
		Portfolio port = null;
		Optional<Portfolio> portOpt = portRepo.findById(pid);
		if(opt.isPresent()) {
			port = portOpt.get();
		}
		if (user.getPortfolios().contains(port)){
			port.setUser(null);
			portRepo.delete(port);
			return true;
		}else {
			return false;
		}
		
	}
}
