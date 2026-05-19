package com.project.service.impl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.entity.Doctor;
import com.project.entity.Patient;
import com.project.entity.Treatment;
import com.project.service.TreatmentService;

public class TreatmentServiceimpl
		implements TreatmentService {

	Scanner sc = new Scanner(System.in);

	@Override
	public void saveTreatment(
			SessionFactory sessionFactory) {

		Session session = sessionFactory
				.openSession();

		Transaction tx = session
				.beginTransaction();

		Treatment treatment = new Treatment();

		// Patient
		System.out.println(
				"Enter Patient Id:");

		int patientId = sc.nextInt();

		Patient patient = session.get(
				Patient.class,
				patientId);

		if (patient == null) {

			System.out.println(
					"Patient Not Found");

			session.close();

			return;
		}

		// Doctor Name
		System.out.println(
				"Enter Doctor Name:");

		sc.nextLine();

		String doctorName = sc.nextLine();

		Doctor doctor = session
				.createQuery(
						"from Doctor where name=:name",
						Doctor.class)
				.setParameter(
						"name",
						doctorName)
				.uniqueResult();

		if (doctor == null) {

			System.out.println(
					"Doctor Not Found");

			session.close();

			return;
		}

		// Diagnosis
		System.out.println(
				"Enter Diagnosis:");

		treatment.setDiagnosis(
				sc.nextLine());

		// Treatment Details
		System.out.println(
				"Enter Treatment Details:");

		treatment.setTreatmentDetails(
				sc.nextLine());

		// Treatment Date
		System.out.println(
				"Enter Treatment Date:");

		treatment.setTreatmentDate(
				sc.nextLine());

		// Set Relations
		treatment.setPatient(patient);

		treatment.setDoctor(doctor);

		// Save
		session.persist(treatment);

		tx.commit();

		session.close();

		System.out.println(
				"Treatment Saved Successfully");
	}

	@Override
	public void getTreatment(
			SessionFactory sessionFactory) {

		Session session = sessionFactory
				.openSession();

		System.out.println(
				"Enter Treatment Id:");

		int id = sc.nextInt();

		Treatment treatment = session.get(
				Treatment.class,
				id);

		if (treatment != null) {

			System.out.println(
					"Treatment Id : "
							+ treatment
									.getTreatmentId());

			System.out.println(
					"Diagnosis : "
							+ treatment
									.getDiagnosis());

			System.out.println(
					"Treatment Details : "
							+ treatment
									.getTreatmentDetails());

			System.out.println(
					"Treatment Date : "
							+ treatment
									.getTreatmentDate());

			System.out.println(
					"Patient Id : "
							+ treatment
									.getPatient()
									.getPatientId());

			System.out.println(
					"Doctor Name : "
							+ treatment
									.getDoctor()
									.getName());

		} else {

			System.out.println(
					"Treatment Not Found");
		}

		session.close();
	}

	@Override
	public void getAllTreatments(
			SessionFactory sessionFactory) {

		Session session = sessionFactory
				.openSession();

		List<Treatment> treatments = session
				.createQuery(
						"from Treatment",
						Treatment.class)
				.list();

		if (treatments.isEmpty()) {

			System.out.println(
					"No Treatments Found");
		}

		for (Treatment treatment : treatments) {

			System.out.println(
					"Treatment Id : "
							+ treatment
									.getTreatmentId());

			System.out.println(
					"Diagnosis : "
							+ treatment
									.getDiagnosis());

			System.out.println(
					"Treatment Details : "
							+ treatment
									.getTreatmentDetails());

			System.out.println(
					"Treatment Date : "
							+ treatment
									.getTreatmentDate());

			System.out.println(
					"Patient Id : "
							+ treatment
									.getPatient()
									.getPatientId());

			System.out.println(
					"Doctor Name : "
							+ treatment
									.getDoctor()
									.getName());

			System.out.println(
					"----------------------------");
		}

		session.close();
	}

	@Override
	public void updateTreatment(
			SessionFactory sessionFactory) {

		Session session = sessionFactory
				.openSession();

		Transaction tx = session
				.beginTransaction();

		System.out.println(
				"Enter Treatment Id:");

		int id = sc.nextInt();

		Treatment treatment = session.get(
				Treatment.class,
				id);

		if (treatment != null) {

			sc.nextLine();

			System.out.println(
					"Enter New Diagnosis:");

			treatment.setDiagnosis(
					sc.nextLine());

			System.out.println(
					"Enter New Treatment Details:");

			treatment.setTreatmentDetails(
					sc.nextLine());

			System.out.println(
					"Enter New Treatment Date:");

			treatment.setTreatmentDate(
					sc.nextLine());

			session.merge(treatment);

			tx.commit();

			System.out.println(
					"Treatment Updated Successfully");

		} else {

			System.out.println(
					"Treatment Not Found");
		}

		session.close();
	}

	@Override
	public void deleteTreatment(
			SessionFactory sessionFactory) {

		Session session = sessionFactory
				.openSession();

		Transaction tx = session
				.beginTransaction();

		System.out.println(
				"Enter Treatment Id:");

		int id = sc.nextInt();

		Treatment treatment = session.get(
				Treatment.class,
				id);

		if (treatment != null) {

			session.remove(treatment);

			tx.commit();

			System.out.println(
					"Treatment Deleted Successfully");

		} else {

			System.out.println(
					"Treatment Not Found");
		}

		session.close();
	}

	@Override
	public void saveTreatment() {

	}

	@Override
	public void getTreatment() {

	}

	@Override
	public void updateTreatment() {

	}
}