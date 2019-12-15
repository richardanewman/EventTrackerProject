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

import com.skilldistillery.bitfolio.entities.CoinWatch;
import com.skilldistillery.bitfolio.services.CoinWatchService;
import com.skilldistillery.bitfolio.services.UserProfileService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4209" })
public class CoinWatchController {
	
	@Autowired
	CoinWatchService svc;
	
	@Autowired
	UserProfileService userSvc;
	
	
	@GetMapping("admin/watches")
	public List<CoinWatch> getAllCoinWatch() {
		return svc.findAllCoinWatch();
	}
	
	@GetMapping("admin/watch/{id}")
	public CoinWatch getCoinWatchByWatchId(@PathVariable int id) {
		CoinWatch watch = svc.findCoinWatchByWatchId(id);
		return watch;
	}
	
	@GetMapping("user/{id}/watches")
	public List<CoinWatch> getAllPortfoliosByUserId(@PathVariable int id) {
		return svc.findAllCoinWatchByUserId(id);
	
	}
	
	@PostMapping("user/{id}/watch")
	public CoinWatch createCoinWatch(@PathVariable int id, 
			@RequestBody CoinWatch coinWatch, 
			HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			coinWatch = svc.createCoinWatch(id, coinWatch);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(coinWatch.getId());
			resp.addHeader("Location", url.toString());
			return coinWatch;
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return null;
		}
	
	}
	
	
	@PutMapping("user/{uid}/watch/{wid}")
	public CoinWatch updateCoinWatch(@PathVariable int uid,
			@PathVariable int wid, 
			@RequestBody CoinWatch coinWatch, 
			HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			coinWatch = svc.updateCoinWatch(wid, coinWatch);
		
			resp.setStatus(200);
			return coinWatch;
			
		
		
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return null;
		}
	
	
		}
	
	
	@DeleteMapping("user/{uid}/watch/{wid}")
	public boolean deletePortfolio(@PathVariable int uid,
			@PathVariable int wid,
			HttpServletRequest req,
			HttpServletResponse resp) {
		boolean result = false;
		if(userSvc.getUserProfileById(uid) != null) {
			
			result = svc.deleteCoinWatch(wid);
			
			
		}else {
			resp.setStatus(404);
			return result;
		}
		resp.setStatus(200);
		return result;
	}
	
	
}

