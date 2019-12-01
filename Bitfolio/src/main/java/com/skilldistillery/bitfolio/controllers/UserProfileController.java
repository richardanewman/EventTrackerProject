package com.skilldistillery.bitfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bitfolio.entities.UserProfile;
import com.skilldistillery.bitfolio.services.UserProfileService;

@RestController
@RequestMapping("api")
public class UserProfileController {
	
	@Autowired
	UserProfileService svc;
	
	@GetMapping("user/profile/{id}")
	public UserProfile getUserProfileById(@PathVariable int id) {
		UserProfile userProfile = svc.getUserProfileById(id);
		return userProfile;
	}
	

}
