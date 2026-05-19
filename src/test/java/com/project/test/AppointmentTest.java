package com.project.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import com.project.entity.Appointment;
import com.project.entity.Doctor;
import com.project.entity.Patient;
import com.project.util.HibernateUtil;

public class AppointmentTest {

	@Test
	public void saveAppointmentTest() {

		Session session =
				HibernateUtil
				.getSessionFactory()
				.openSession();

		Transaction tx =
				session.beginTransaction();

		Patient patient =
				session.get(Patient.class, 1);

		Doctor doctor =
				session.get(Doctor.class, 1);

		Appointment appointment =
				new Appointment();

		appointment.setAppointmentDate("2026-05-06");

		appointment.setAppointmentTime("10AM");

		appointment.setStatus("Booked");

		appointment.setPatient(patient);

		appointment.setDoctor(doctor);

		session.persist(appointment);

		tx.commit();

		assertNotNull(
				appointment.getAppointmentId());

		session.close();
	}
}