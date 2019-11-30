package com.skilldistillery.bitfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bitfolio.repositories.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	UserProfileRepository userRepo;

}
