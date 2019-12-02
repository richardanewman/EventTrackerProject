package com.skilldistillery.bitfolio.services;

import java.util.List;
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
	
	
	@Override
	public List<Coin> getAllCoins(){
		return coinRepo.findAll();
	}
	
	@Override
	public Coin findCoinById(int id) {
		Coin coin = null;
		Optional<Coin> opt = coinRepo.findById(id);
		if(opt.isPresent()) {
			coin = opt.get();
		}
		return coin;
	}
	
	@Override 
	public List<Coin> getAllCoinsByPortfolioId(int id){
		Portfolio port = null;
		Optional<Portfolio> opt = portRepo.findById(id);
		if (opt.isPresent()) {
			port = opt.get();
		}
		return port.getCoins();
		
	}
	
	@Override
	public Coin createCoin(int id, Coin coin) {
		Portfolio port = null;
		Optional<Portfolio> opt = portRepo.findById(id);
		if (opt.isPresent()) {
			port = opt.get();
		}
		coin.setPortfolio(port);
		port.getCoins().add(coin);
		coinRepo.saveAndFlush(coin);
		portRepo.saveAndFlush(port);
		return coin;
	}
	
	@Override
	public Coin updateCoin(int cid, Coin coin) {
		Coin update = null;
		Optional<Coin> opt = coinRepo.findById(cid);
		if (opt.isPresent()) {
			update = opt.get();
		}
		
			update.setName(coin.getName());
			update.setTradingPair(coin.getTradingPair());
			update.setExchange(coin.getExchange());
			update.setPurchaseDate(coin.getPurchaseDate());
			update.setPurchaseTime(coin.getPurchaseTime());
			update.setBuyPrice(coin.getBuyPrice());
			update.setAmountPurchased(coin.getAmountPurchased());
			update.setExchangeFee(coin.getExchangeFee());
			update.setNotes(coin.getNotes());
			coinRepo.saveAndFlush(update);
			
		
		return update;
	}
	
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
