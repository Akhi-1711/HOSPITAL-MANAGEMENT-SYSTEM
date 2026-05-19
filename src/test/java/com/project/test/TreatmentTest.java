package com.project.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import com.project.entity.Doctor;
import com.project.entity.Patient;
import com.project.entity.Treatment;
import com.project.util.HibernateUtil;

public class TreatmentTest {

	@Test
	public void saveTreatmentTest() {

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

		Treatment treatment =
				new Treatment();

		treatment.setDiagnosis("Fever");

		treatment.setTreatmentDetails("Medicine");

		treatment.setTreatmentDate("2026-05-06");

		treatment.setPatient(patient);

		treatment.setDoctor(doctor);

		session.persist(treatment);

		tx.commit();

		assertNotNull(
				treatment.getTreatmentId());

		session.close();
	}
}