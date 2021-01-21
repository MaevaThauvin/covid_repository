package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modele.Admin;

public class AdminTest {
	
	Admin admin;
	
	@Before
	public void init() {
		admin = new Admin("admin", "orsys");
	}

	@Test
	public void testValdiationLogin() {
		assertEquals(true, admin.ValidationLogin());
	}
	
	@Test
	public void testValdiationPassword() {
		assertEquals(true, admin.ValdiationPassword());
	}

}
