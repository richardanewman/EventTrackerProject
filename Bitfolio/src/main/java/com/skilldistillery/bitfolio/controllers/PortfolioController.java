package com.skilldistillery.bitfolio.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bitfolio.entities.Portfolio;
import com.skilldistillery.bitfolio.services.PortfolioService;

@RestController
@RequestMapping("api")
public class PortfolioController {
	
	@Autowired
	PortfolioService svc;
	
	
	@GetMapping("admin/portfolios")
	public List<Portfolio> getAllPortfolios() {
		return svc.getAllPortfolios();
	}
	
	@GetMapping("admin/portfolio/{id}")
	public Portfolio getPortfolioById(@PathVariable int id) {
		Portfolio port = svc.getPortfolioById(id);
		return port;
	}
	
	@GetMapping("user/{id}/portfolios")
	public List<Portfolio> getAllPortfoliosByUserId(@PathVariable int id) {
		return svc.getAllPortfoliosByUserId(id);
	
	}
	
	@PostMapping("user/{id}/portfolio")
	public Portfolio createPortfolio(@PathVariable int id, 
			@RequestBody Portfolio portfolio, 
			HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			portfolio = svc.createPortfolio(id, portfolio);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(portfolio.getId());
			resp.addHeader("Location", url.toString());
			return portfolio;
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return null;
		}
	
	}
	
		//******************************************//
		//Only allows user to update portfolio name //
		//******************************************//
	
	@PutMapping("user/{id}/portfolio")
	public Portfolio updatePortfolio(@PathVariable int id, 
			@RequestBody Portfolio portfolio, 
			HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			portfolio = svc.createPortfolio(id, portfolio);
			resp.setStatus(200);
			
			return portfolio;
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return null;
		}
		
	}
	
	@DeleteMapping("user/{uid}/portfolio/{pid}")
	public boolean deletePortfolio(@PathVariable int uid, 
			@PathVariable int pid, 
			HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			boolean delete = svc.deletePortfolio(uid, pid);
			if (delete) {
			resp.setStatus(204);
			return true;
			
			} else {
				resp.setStatus(400);
				return false;
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return false;
		}
		
	}
	
	
}

