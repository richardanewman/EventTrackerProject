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

class CoinWatchListTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private CoinWatchList watchList;

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
		watchList = em.find(CoinWatchList.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		watchList = null;
	}

	@Test
	@DisplayName("Testing coin watch list get name")
	void test1() {
		assertNotNull(watchList);
		assertEquals("Wish List", watchList.getWatchListName());
		
	}
	@Test
	@DisplayName("Testing coin watch list alert low and high double and int")
	void test2() {
		assertNotNull(watchList);
		assertEquals(125, watchList.getAlertLow());
		assertEquals(200, watchList.getAlertHigh());
		assertEquals(125.00, watchList.getAlertLow());
		assertEquals(200.00, watchList.getAlertHigh());

	}
	@Test
	@DisplayName("Testing coin watch list get coin name ")
	void test3() {
		assertNotNull(watchList);
		assertEquals("ETH", watchList.getCoinName());
		
	}
	
	@Test
	@DisplayName("Testing coin watch list get trading pair")
	void test4() {
		assertNotNull(watchList);
		assertEquals("ETH/USD", watchList.getTradingPair());
		
	}
	@Test
	@DisplayName("Testing coin watch list get user get first name")
	void test5() {
		assertNotNull(watchList);
		assertEquals("Richard", watchList.getUser().getFirstName());
		
	}
	
	
}
