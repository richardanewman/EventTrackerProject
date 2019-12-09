package com.skilldistillery.bitfolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bitfolio.entities.UserAccount;
import com.skilldistillery.bitfolio.repositories.UserAccountRepository;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	UserAccountRepository acctRepo;

	@Override
	public List<UserAccount> getAllUserAccounts() {
		return acctRepo.findAll();

	}

	@Override
	public UserAccount getUserAccountById(int id) {
		UserAccount userAccount = null;
		Optional<UserAccount> opt = acctRepo.findById(id);
		if (opt.isPresent()) {
			userAccount = opt.get();
		}
		return userAccount;
	}
	@Override
	public UserAccount getUserAccountByEmail(String email) {
		UserAccount userAccount = null;
		Optional<UserAccount> opt = acctRepo.findById(email);
		if (opt.isPresent()) {
			userAccount = opt.get();
		}
		return userAccount;
	}

	@Override
	public UserAccount createUser(UserAccount userAccount) {
		return acctRepo.saveAndFlush(userAccount);
	}

	@Override
	public UserAccount updateUserAccount(int id, UserAccount userAccount) {
		UserAccount update = null;
		Optional<UserAccount> opt = acctRepo.findById(id);
		if (opt.isPresent()) {
			update = opt.get();
		}
		update.setEmail(userAccount.getEmail());
		update.setPassword(userAccount.getPassword());
		acctRepo.saveAndFlush(update);
		return update;

	}

	@Override
	public boolean deactivateUserAccount(int id) {
		UserAccount deactivate = null;
		Optional<UserAccount> opt = acctRepo.findById(id);
		if (opt.isPresent()) {
			deactivate = opt.get();
		}
		deactivate.setActive(false);
		acctRepo.saveAndFlush(deactivate);
		return true;

	}
	
	@Override
	public boolean reactivateUserAccount(int id) {
		UserAccount reactivate = null;
		Optional<UserAccount> opt = acctRepo.findById(id);
		if (opt.isPresent()) {
			reactivate = opt.get();
		}
		reactivate.setActive(true);
		acctRepo.saveAndFlush(reactivate);
		return true;
		
	}
	@Override
	public boolean deleteUserAccount(int id) {
		UserAccount delete = null;
		Optional<UserAccount> opt = acctRepo.findById(id);
		if (opt.isPresent()) {
			delete = opt.get();
		}
		acctRepo.delete(delete);
		return true;
		
	}
	
	@Override
	public boolean validateUser(UserAccount account) {
		UserAccount check = null;
		Optional<UserAccount> opt = acctRepo.findById(account.getEmail());
		if (opt.isPresent()) {
			check = opt.get();
		}
	
		if(check.getPassword().equals(account.getPassword())) {
			return true;
		}else {
			return false;
		}
		
	}
}
	

