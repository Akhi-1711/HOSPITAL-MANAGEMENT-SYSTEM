package com.project.mocktest;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

public class PatientMockitoTest {

	@Test
	public void mockSessionFactoryTest() {

		SessionFactory sessionFactory =
				mock(SessionFactory.class);

		Session session =
				mock(Session.class);

		assertNotNull(sessionFactory);

		assertNotNull(session);

		System.out.println(
				"Mockito Test Passed");
	}
}