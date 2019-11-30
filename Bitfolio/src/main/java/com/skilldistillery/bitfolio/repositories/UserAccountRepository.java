package com.skilldistillery.bitfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bitfolio.entities.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>{

}
