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

class CoinWatchTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private CoinWatch coinWatch;

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
		coinWatch = em.find(CoinWatch.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		coinWatch = null;
	}

	@Test
	@DisplayName("Testing coin watch list get name")
	void test1() {
		assertNotNull(coinWatch);
		assertEquals("Possible Channel Forming", coinWatch.getCoinWatchName());
		
	}
	@Test
	@DisplayName("Testing coin watch list alert low and high double and int")
	void test2() {
		assertNotNull(coinWatch);
		assertEquals(125, coinWatch.getAlertLow());
		assertEquals(200, coinWatch.getAlertHigh());
		assertEquals(125.00, coinWatch.getAlertLow());
		assertEquals(200.00, coinWatch.getAlertHigh());

	}
	@Test
	@DisplayName("Testing coin watch list get coin name ")
	void test3() {
		assertNotNull(coinWatch);
		assertEquals("ETH", coinWatch.getCoinName());
		
	}
	
	@Test
	@DisplayName("Testing coin watch list get trading pair")
	void test4() {
		assertNotNull(coinWatch);
		assertEquals("ETH/USD", coinWatch.getTradingPair());
		
	}
	@Test
	@DisplayName("Testing coin watch list get user get first name")
	void test5() {
		assertNotNull(coinWatch);
		assertEquals("Richard", coinWatch.getUser().getFirstName());
		
	}
	
	
}
