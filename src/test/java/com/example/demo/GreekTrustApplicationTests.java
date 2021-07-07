package com.example.demo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GreekTrustApplicationTests {

	@Test
	public void userTest() {
		User user = new User("Dale");
		user.loan("IDIDI", 5000L, 6, 1);     //LOAN IDIDI Dale 5000 1 6
		user.payment("IDIDI", 1000L, 5);     //PAYMENT IDIDI Dale 1000 5
		BalanceReturn balance1 = user.balance("IDIDI", 3); //BALANCE IDIDI Dale 3
		BalanceReturn balance2	= user.balance("IDIDI", 6); //BALANCE IDIDI Dale 6

		assertEquals("BALANCE IDIDI Dale 3 should be 1326",Long.valueOf(1326), balance1.getAmount());
		assertEquals("BALANCE IDIDI Dale 6 should be 3652", Long.valueOf(3652),balance2.getAmount());
		assertEquals("EMI left for  IDIDI Dale 3 should be 9",Integer.valueOf(9), balance1.getNumber());
		assertEquals("EMI left for  IDIDI Dale 3 should be 4", Integer.valueOf(4),balance2.getNumber());

	}

}
