package com.skilldistillery.bitfolio.services;

import java.util.List;

import com.skilldistillery.bitfolio.entities.UserProfile;

public interface UserProfileService {
	List<UserProfile> getAllUserProfiles();
	UserProfile getUserProfileById(int id);
	UserProfile updateUserProfile(int id, UserProfile userProfile);

}
