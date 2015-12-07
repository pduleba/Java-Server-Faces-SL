package com.pduleba.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pduleba.spring.dao.model.UserModel;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application*Context.xml")
@Transactional
public class UserDaoImplTestIT extends TestCase {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void testGetAllUsers() {
		// with
		// when
		List<UserModel> allUsers = userDao.getAllUsers();

		// then
		assertFalse(allUsers.isEmpty());
	}

	@Test
	public void testSave() {
		// with
		String userName = "JUnitUserName";
		UserModel user = new UserModel(userName, "");
		
		// when
		assertFalse(userDao.exists(userName));
		userDao.save(user);
		
		// then
		assertTrue(userDao.exists(userName));
	}

	@Test
	public void testExists() {
		// with
		// when
		String nameUnderTest = getAnyName();
		
		// then
		assertTrue(userDao.exists(nameUnderTest));
	}

	@Test
	public void testFindByName() {
		// with
		String nameUnderTest = getAnyName();
		// when
		UserModel user = userDao.findByName(nameUnderTest);
		
		// then
		assertNotNull(user);
		assertEquals(nameUnderTest, user.getName());
	}

	private String getAnyName() {
		List<UserModel> allUsers = userDao.getAllUsers();
		assertTrue(allUsers.size() > 0);
		
		return allUsers.get(0).getName();
	}}
