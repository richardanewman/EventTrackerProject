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

class UserAccountTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private UserAccount UA;

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
		UA = em.find(UserAccount.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		UA = null;
	}

	@Test
	@DisplayName("Testing user account user name and id")
	void test1() {
		assertNotNull(UA);
		assertEquals("rick", UA.getUsername());
		assertEquals(1, UA.getId());
	}
	@Test
	@DisplayName("Testing user account get pass")
	void test2() {
		assertNotNull(UA);
		assertEquals("123", UA.getSaltedPassword());

	}
	@Test
	@DisplayName("Testing user account get email")
	void test3() {
		assertNotNull(UA);
		assertEquals("rick@richardnewman.dev", UA.getEmail());
		
	}
	@Test
	@DisplayName("Testing user account active")
	void test4() {
		assertNotNull(UA);
		assertEquals(true, UA.isActive());
		
	}
	@Test
	@DisplayName("Testing user account get UserProfile firstName")
	void test5() {
		assertNotNull(UA);
		assertEquals("Richard", UA.getUser().getFirstName());
		
	}
}
