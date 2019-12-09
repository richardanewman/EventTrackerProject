package com.skilldistillery.bitfolio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.bitfolio.entities.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>{
	
	@Query("select u from UserAccount u where u.email = :email")
	Optional<UserAccount> findById(@Param("email") String email);
	
	

}
