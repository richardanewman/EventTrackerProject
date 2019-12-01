package com.skilldistillery.bitfolio.services;

import java.util.List;
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
	public List<UserProfile> getAllUserProfiles() {
		return userRepo.findAll();

	}

	@Override
	public UserProfile getUserProfileById(int id) {
		UserProfile userProfile = null;
		Optional<UserProfile> opt = userRepo.findById(id);
		if (opt.isPresent()) {
			userProfile = opt.get();
		}
		return userProfile;
	}
	
	@Override
	public UserProfile updateUserProfile(int id, UserProfile userProfile) {
		UserProfile update = null;
		Optional<UserProfile> opt = userRepo.findById(id);
		if (opt.isPresent()) {
			update = opt.get();
		}
		update.setFirstName(userProfile.getFirstName());
		update.setLastName(userProfile.getLastName());
		update.setCity(userProfile.getCity());
		update.setState(userProfile.getState());
		update.setPhotoURL(userProfile.getPhotoURL());
		update.setBio(userProfile.getBio());
		userRepo.saveAndFlush(update);
		return update;

	}
}
