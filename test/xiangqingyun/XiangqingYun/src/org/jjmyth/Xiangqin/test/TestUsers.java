package org.jjmyth.Xiangqin.test;

import org.jjmyth.DODAO.Users;

import junit.framework.TestCase;

public class TestUsers extends TestCase {
	Users users;
	protected void setUp() throws Exception {
		super.setUp();
		//users =new Users("sdf","fs","ÄÐ",24234,2);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testToJSONString() {
		String str=users.toJSONString();
		System.out.println(str);
	}

	public void testUsersStringStringStringIntegerInteger() {
		fail("Not yet implemented");
	}

}
