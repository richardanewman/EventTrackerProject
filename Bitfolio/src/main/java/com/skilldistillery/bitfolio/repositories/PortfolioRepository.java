package com.skilldistillery.bitfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bitfolio.entities.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer>{

}
