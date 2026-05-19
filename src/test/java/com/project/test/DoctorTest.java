package com.project.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import com.project.entity.Doctor;
import com.project.util.HibernateUtil;

public class DoctorTest {

	@Test
	public void saveDoctorTest() {

		Session session =
				HibernateUtil
				.getSessionFactory()
				.openSession();

		Transaction tx =
				session.beginTransaction();

		Doctor doctor = new Doctor();

		doctor.setName("Ramesh");

		doctor.setSpecialization("Cardiology");

		doctor.setPhone("9999999999");

		doctor.setExperience(10);

		session.persist(doctor);

		tx.commit();

		assertNotNull(doctor.getDoctorId());

		session.close();
	}
}
