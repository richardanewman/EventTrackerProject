package com.skilldistillery.bitfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bitfolio.entities.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer>{

}
