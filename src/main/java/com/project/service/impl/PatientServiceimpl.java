package com.project.service.impl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.entity.Patient;
import com.project.service.PatientService;

public class PatientServiceimpl implements PatientService {

	Scanner sc = new Scanner(System.in);

	@Override
	public void savePatient(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Patient patient = new Patient();

		System.out.println("Enter Patient Name:");
		patient.setName(sc.next());

		System.out.println("Enter Patient Age:");
		patient.setAge(sc.nextInt());

		System.out.println("Enter Patient Gender:");
		patient.setGender(sc.next());

		System.out.println("Enter Patient Phone:");
		patient.setPhone(sc.next());

		System.out.println("Enter Patient Address:");
		patient.setAddress(sc.next());

		session.persist(patient);

		tx.commit();

		session.close();

		System.out.println("Patient Saved Successfully");
	}

	@Override
	public void getPatient(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		System.out.println("Enter Patient Id:");

		int id = sc.nextInt();

		Patient patient = session.get(Patient.class, id);

		if (patient != null) {

			System.out.println("Patient Id: " + patient.getPatientId());
			System.out.println("Name: " + patient.getName());
			System.out.println("Age: " + patient.getAge());
			System.out.println("Gender: " + patient.getGender());
			System.out.println("Phone: " + patient.getPhone());
			System.out.println("Address: " + patient.getAddress());

		} else {

			System.out.println("Patient Not Found");
		}

		session.close();
	}

	@Override
	public void getAllPatients(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		List<Patient> patients = session
				.createQuery("from Patient", Patient.class)
				.list();

		for (Patient patient : patients) {

			System.out.println(patient.getPatientId() + " "
					+ patient.getName() + " "
					+ patient.getAge() + " "
					+ patient.getGender());
		}

		session.close();
	}

	@Override
	public void updatePatient(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		System.out.println("Enter Patient Id:");

		int id = sc.nextInt();

		Patient patient = session.get(Patient.class, id);

		if (patient != null) {

			System.out.println("Enter New Phone:");

			patient.setPhone(sc.next());

			session.merge(patient);

			tx.commit();

			System.out.println("Patient Updated Successfully");

		} else {

			System.out.println("Patient Not Found");
		}

		session.close();
	}

	@Override
	public void deletePatient(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		System.out.println("Enter Patient Id:");

		int id = sc.nextInt();

		Patient patient = session.get(Patient.class, id);

		if (patient != null) {

			session.remove(patient);

			tx.commit();

			System.out.println("Patient Deleted Successfully");

		} else {

			System.out.println("Patient Not Found");
		}

		session.close();
	}

	@Override
	public void savePatient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPatient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePatient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePatient() {
		// TODO Auto-generated method stub
		
	}
}