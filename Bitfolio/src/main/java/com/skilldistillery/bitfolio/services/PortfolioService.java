package com.skilldistillery.bitfolio.services;

import java.util.List;

import com.skilldistillery.bitfolio.entities.Portfolio;

public interface PortfolioService {
	List<Portfolio> getAllPortfolios();
	Portfolio getPortfolioById(int id);
	List<Portfolio> getAllPortfoliosByUserId(int id);
	Portfolio createPortfolio(int id, Portfolio portfolio);
	Portfolio updatePortfolio(int id, Portfolio portfolio);
	boolean deletePortfolio(int pid);


}
