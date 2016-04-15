package com.pgs.soft.workshop.tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pgs.soft.workshop.backend.dao.Dao;
import com.pgs.soft.workshop.backend.dao.DaoImpl;
import com.pgs.soft.workshop.backend.model.Platform;

import junit.framework.TestCase;

public class DaoImplTestIT extends TestCase {

	private Dao dao;
	
	@Before
	public void setUp() throws Exception {
		this.dao = new DaoImpl(); 
	}

	@After
	public void tearDown() throws Exception {
		this.dao = null;
	}

	
	@Test
	public void testGetPlatforms() {
		// with
		assertNotNull(dao);
		
		// when
		List<Platform> platforms = dao.getPlatforms();

		// then
		assertNotNull(platforms);
	}

}
