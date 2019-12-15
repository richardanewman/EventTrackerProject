package com.skilldistillery.bitfolio.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bitfolio.entities.UserAccount;
import com.skilldistillery.bitfolio.entities.UserProfile;
import com.skilldistillery.bitfolio.services.UserAccountService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4209" })
public class AuthController {
	
	//Simple login controller - definitely not secure////////
	
	@Autowired
	UserAccountService svc;

		
	@PostMapping("login")
	public UserProfile validateLogin(@RequestBody UserAccount account, 
			HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			if(svc.validateUser(account)){
				resp.setStatus(200);
				StringBuffer url = req.getRequestURL();
				url.append("/").append(account.getId());
				resp.addHeader("Location", url.toString());
				UserProfile profile = svc.getUserAccountByEmail(account.getEmail()).getUser();
				return profile;
				
			}else {
				resp.setStatus(404);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return null;
		}
	
	}
	
}
		
		
	
