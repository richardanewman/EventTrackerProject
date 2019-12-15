package com.skilldistillery.bitfolio.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bitfolio.entities.UserProfile;
import com.skilldistillery.bitfolio.services.UserProfileService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4209" })
public class UserProfileController {
	
	@Autowired
	UserProfileService svc;
	
	@GetMapping("profiles")
	public List<UserProfile> getAllUserProfiles() {
		return svc.getAllUserProfiles();
	}
	
	@GetMapping("profile/{id}")
	public UserProfile getUserProfileById(@PathVariable int id) {
		UserProfile userProfile = svc.getUserProfileById(id);
		return userProfile;
	}
	
	@PutMapping("profile/{id}")
	public UserProfile updateUserProfile(@PathVariable int id, @RequestBody UserProfile userProfile,
			HttpServletResponse resp) {
			
			try {
				userProfile = svc.updateUserProfile(id, userProfile);
				resp.setStatus(200);
				return userProfile;
			} catch (Exception e) {
				e.printStackTrace();
				resp.setStatus(400);
				return null;
			}
		
	}
	

}
