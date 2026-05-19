package com.project.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import com.project.entity.Patient;
import com.project.util.HibernateUtil;

public class PatientTest {

	@Test
	public void savePatientTest() {

		Session session =
				HibernateUtil
				.getSessionFactory()
				.openSession();

		Transaction tx =
				session.beginTransaction();

		Patient patient = new Patient();

		patient.setName("Akhila");

		patient.setAge(22);

		patient.setGender("Female");

		patient.setPhone("9876543210");

		patient.setAddress("Hyderabad");

		session.persist(patient);

		tx.commit();

		assertNotNull(patient.getPatientId());

		session.close();
	}
}
