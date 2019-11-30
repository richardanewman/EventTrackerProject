package com.skilldistillery.bitfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bitfolio.repositories.UserAccountRepository;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	
	@Autowired
	UserAccountRepository acctRepo;

}
