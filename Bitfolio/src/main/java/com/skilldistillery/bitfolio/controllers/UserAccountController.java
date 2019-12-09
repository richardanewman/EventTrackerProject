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

import com.skilldistillery.bitfolio.entities.UserAccount;
import com.skilldistillery.bitfolio.services.UserAccountService;

@RestController
@RequestMapping("api")
public class UserAccountController {
	
	@Autowired
	UserAccountService svc;
	
	@GetMapping("admin/users")
	public List<UserAccount> getAllUserAccounts() {
		return svc.getAllUserAccounts();
	}
	
	@GetMapping("user/{id}")
	public UserAccount getUserAccountById(@PathVariable int id) {
		UserAccount userAccount = svc.getUserAccountById(id);
		return userAccount;
	}
	
	@GetMapping("user/email/{email}")
	public UserAccount getUserAccountByEmail(@PathVariable String email) {
		UserAccount userAccount = svc.getUserAccountByEmail(email);
		return userAccount;
	}
	
	@PostMapping("user")
	public UserAccount createUser(@RequestBody UserAccount userAccount, 
			HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			userAccount = svc.createUser(userAccount);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(userAccount.getEmail());
			resp.addHeader("Location", url.toString());
			return userAccount;
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return null;
		}
	
	}
	
	//**************************************************************//
	//Only allows user to update email and password on account table//
	//**************************************************************//
	
	@PutMapping("user/{id}")
	public UserAccount updateUserAccount(@PathVariable int id, @RequestBody UserAccount userAccount,
			HttpServletResponse resp) {
			
			try {
				userAccount = svc.updateUserAccount(id, userAccount);
				resp.setStatus(200);
				return userAccount;
			} catch (Exception e) {
				e.printStackTrace();
				resp.setStatus(400);
				return null;
			}
		
	}
	
	@PutMapping("user/deactivate/{id}")
	public boolean deactivateUserAccount(@PathVariable int id,
			HttpServletResponse resp) {
		
		try {
			svc.deactivateUserAccount(id);
			resp.setStatus(200);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return false;
		}
		
	}
	@PutMapping("user/reactivate/{id}")
	public boolean reactivateUserAccount(@PathVariable int id,
			HttpServletResponse resp) {
		
		try {
			svc.reactivateUserAccount(id);
			resp.setStatus(200);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return false;
		}
		
	}
	@DeleteMapping("admin/delete/{id}")
	public boolean deleteUserAccount(@PathVariable int id,
			HttpServletResponse resp) {
		
		try {
			svc.deleteUserAccount(id);
			resp.setStatus(204);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return false;
		}
		
	}

}
