package com.skilldistillery.bitfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bitfolio.entities.Coin;

public interface CoinRepository extends JpaRepository<Coin, Integer>{

}
