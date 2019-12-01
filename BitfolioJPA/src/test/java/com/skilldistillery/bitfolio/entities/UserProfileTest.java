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

class UserProfileTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private UserProfile user;

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
		user = em.find(UserProfile.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	@DisplayName("Testing user profile get first and last name")
	void test1() {
		assertNotNull(user);
		assertEquals("Richard", user.getFirstName());
		assertEquals("Newman", user.getLastName());
	}
	@Test
	@DisplayName("Testing user profile get city")
	void test2() {
		assertNotNull(user);
		assertEquals("Denver", user.getCity());

	}
	@Test
	@DisplayName("Testing user profile get bio")
	void test3() {
		assertNotNull(user);
		assertEquals("Life, liberty, and crypto!", user.getBio());
		
	}
	
	@Test
	@DisplayName("Testing user profile get portfolio")
	void test4() {
		assertNotNull(user);
		assertEquals("primary", user.getPortfolios().get(0).getPortfolioName());
		
	}
	
}
