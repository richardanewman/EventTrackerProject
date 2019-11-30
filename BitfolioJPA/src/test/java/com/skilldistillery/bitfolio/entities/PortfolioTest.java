package com.skilldistillery.bitfolio.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PortfolioTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Portfolio portfolio;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("Bitfolio");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		portfolio = em.find(Portfolio.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		portfolio = null;
	}

	@Test
	@DisplayName("Testing portfolio get id")
	void test1() {
		assertNotNull(portfolio);
		assertEquals(1, portfolio.getId());
	
	}
	@Test
	@DisplayName("Testing portfolio get user get city")
	void test2() {
		assertNotNull(portfolio);
		assertEquals("Denver", portfolio.getUser().getCity());

	}
	@Test
	@DisplayName("Testing portfolio get coins list get name from first index")
	void test3() {
		assertNotNull(portfolio);
		assertEquals("Bitcoin", portfolio.getCoins().get(0).getName());
		
	}
	
}
