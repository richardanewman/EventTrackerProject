package com.skilldistillery.bitfolio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bitfolio.entities.UserProfile;
import com.skilldistillery.bitfolio.repositories.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	UserProfileRepository userRepo;

	@Override
	public UserProfile getUserProfileById(int id) {
		UserProfile userProfile = null;
		Optional<UserProfile> opt = userRepo.findById(id);
		if (opt.isPresent()) {
			userProfile = opt.get();
		}
		return userProfile;
	}
}
