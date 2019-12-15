package com.skilldistillery.bitfolio.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bitfolio.entities.Coin;
import com.skilldistillery.bitfolio.services.CoinService;
import com.skilldistillery.bitfolio.services.PortfolioService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4209" })
public class CoinController {
	
	@Autowired
	CoinService svc;
	
	@Autowired
	PortfolioService portSvc;
	
	
	@GetMapping("admin/coins")
	public List<Coin> getAllCoins() {
		return svc.getAllCoins();
	}
	
	@GetMapping("portfolio/{id}/coins")
	public List<Coin> getAllCoinsByPortfolioId(@PathVariable int id) {
		return svc.getAllCoinsByPortfolioId(id);
	}
	
	@GetMapping("portfolio/{pid}/coin/{cid}")
	public Coin getCoinByPortfolioIdAndCoinId(@PathVariable int pid,
			@PathVariable int cid,
			HttpServletResponse resp){
		Coin coin = null;
		if(portSvc.getPortfolioById(pid) != null) {
			if (svc.getAllCoinsByPortfolioId(pid).contains(svc.findCoinById(cid))) {
			System.out.println("Inside IF STATEMENT");
			coin = svc.findCoinById(cid);
			
			}
		}else {
			resp.setStatus(404);
			return null;
		}
		resp.setStatus(200);
		return coin;
	}
	
	
	
	@PostMapping("portfolio/{id}/coin")
	public Coin createCoin(@PathVariable int id, 
			@RequestBody Coin coin, 
			HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			coin = svc.createCoin(id, coin);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(coin.getId());
			resp.addHeader("Location", url.toString());
			return coin;
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return null;
		}
	
	}
	
	
	@PutMapping("portfolio/{pid}/coin/{cid}")
	public Coin updateCoin(@PathVariable int pid, 
			@PathVariable int cid,
			@RequestBody Coin coin, 
			HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			coin = svc.updateCoin(cid, coin);
		
			resp.setStatus(200);
			return coin;
	
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return null;
		}
	
	
		}
	
	
	@DeleteMapping("portfolio/{pid}/coin/{cid}")
	public boolean deleteCoin(@PathVariable int pid, 
			@PathVariable int cid,
			HttpServletRequest req,
			HttpServletResponse resp) {
		boolean result = false;
		if(portSvc.getPortfolioById(pid) != null) {
			
			result = svc.deleteCoin(pid);
			
			
		}else {
			resp.setStatus(404);
			return result;
		}
		resp.setStatus(200);
		return result;
	}
	
	
	
}

