package com.skilldistillery.bitfolio.services;

import java.util.List;

import com.skilldistillery.bitfolio.entities.UserAccount;

public interface UserAccountService {
	
	List<UserAccount> getAllUserAccounts();
	UserAccount getUserAccountById(int id);
	UserAccount getUserAccountByEmail(String email);
	UserAccount createUser(UserAccount userAccount);
	UserAccount updateUserAccount(int id, UserAccount userAccount);
	boolean deactivateUserAccount(int id);
	boolean reactivateUserAccount(int id);
	boolean deleteUserAccount(int id);
	boolean validateUser(UserAccount account);
	
}
