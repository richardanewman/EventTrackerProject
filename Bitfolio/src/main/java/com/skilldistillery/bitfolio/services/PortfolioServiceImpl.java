package com.skilldistillery.bitfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bitfolio.repositories.PortfolioRepository;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	PortfolioRepository portRepo;
}
