package com.skilldistillery.bitfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bitfolio.repositories.CoinRepository;

@Service
public class CoinServiceImpl implements CoinService {

	@Autowired
	CoinRepository coinRepo;
}
