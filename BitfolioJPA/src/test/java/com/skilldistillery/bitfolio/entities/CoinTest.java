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

class CoinTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Coin coin;

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
		coin = em.find(Coin.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		coin = null;
	}

	@Test
	@DisplayName("Testing coin get name")
	void test1() {
		assertNotNull(coin);
		assertEquals("Bitcoin", coin.getName());
		
	}
	@Test
	@DisplayName("Testing coin get amount purchased")
	void test2() {
		assertNotNull(coin);
		assertEquals(1.0, coin.getAmountPurchased());
		assertEquals(1, coin.getAmountPurchased());

	}
	@Test
	@DisplayName("Testing coin buy price ")
	void test3() {
		assertNotNull(coin);
		assertEquals(7722.40, coin.getBuyPrice());
		
	}
	
	@Test
	@DisplayName("Testing coin exchange fee")
	void test4() {
		assertNotNull(coin);
		assertEquals(0.0012, coin.getExchangeFee());
		
	}
	@Test
	@DisplayName("Testing coin get portfolio id")
	void test5() {
		assertNotNull(coin);
		assertEquals(1, coin.getPortfolio().getId());
		
	}
	@Test
	@DisplayName("Testing coin get portfolio id")
	void test6() {
		assertNotNull(coin);
		assertEquals("Richard", coin.getPortfolio().getUser().getFirstName());
		
	}
	
}
