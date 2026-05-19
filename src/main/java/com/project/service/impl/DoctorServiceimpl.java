package com.project.service.impl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.entity.Doctor;
import com.project.service.DoctorService;
import com.project.util.DoctorBusinessLogic;

public class DoctorServiceimpl implements DoctorService {

	Scanner sc = new Scanner(System.in);

	@Override
	public void saveDoctor(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Doctor doctor = new Doctor();

		System.out.println("Enter Doctor Name:");
		doctor.setName(sc.next());

		System.out.println("Enter Specialization:");
		doctor.setSpecialization(sc.next());

		System.out.println("Enter Phone:");
		doctor.setPhone(sc.next());

		System.out.println("Enter Experience:");
		doctor.setExperience(sc.nextInt());

		session.persist(doctor);

		tx.commit();

		session.close();

		System.out.println("Doctor Saved Successfully");
	}

	@Override
	public void getDoctor(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		System.out.println("Enter Doctor Id:");

		int id = sc.nextInt();

		Doctor doctor = session.get(Doctor.class, id);

		if (doctor != null) {

			System.out.println("Doctor Id: " + doctor.getDoctorId());
			System.out.println("Name: " + doctor.getName());
			System.out.println("Specialization: " + doctor.getSpecialization());
			System.out.println("Phone: " + doctor.getPhone());
			System.out.println("Experience: " + doctor.getExperience());

		} else {

			System.out.println("Doctor Not Found");
		}

		session.close();
	}

	@Override
	public void getAllDoctors(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		List<Doctor> doctors = session
				.createQuery("from Doctor", Doctor.class)
				.list();

		for (Doctor doctor : doctors) {

			System.out.println(doctor.getDoctorId() + " "
					+ doctor.getName() + " "
					+ doctor.getSpecialization());
		}

		session.close();
	}

	@Override
	public void updateDoctor(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		System.out.println("Enter Doctor Id:");

		int id = sc.nextInt();

		Doctor doctor = session.get(Doctor.class, id);

		if (doctor != null) {

			System.out.println("Enter New Phone:");

			doctor.setPhone(sc.next());

			session.merge(doctor);

			tx.commit();

			System.out.println("Doctor Updated Successfully");

		} else {

			System.out.println("Doctor Not Found");
		}

		session.close();
	}

	@Override
	public void deleteDoctor(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		System.out.println("Enter Doctor Id:");

		int id = sc.nextInt();

		Doctor doctor = session.get(Doctor.class, id);

		if (doctor != null) {

			session.remove(doctor);

			tx.commit();

			System.out.println("Doctor Deleted Successfully");

		} else {

			System.out.println("Doctor Not Found");
		}

		session.close();
	}
	@Override
	public void getDoctorsBySpecialization(SessionFactory sessionFactory) {

		Session session =
				sessionFactory.openSession();

		System.out.println(
				"Enter Specialization:");

		String specialization =
				sc.next();

		DoctorBusinessLogic logic =
				new DoctorBusinessLogic();

		logic.displayDoctorsBySpecialization(
				session,
				specialization);

		session.close();
	}


	@Override
	public void saveDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDoctor() {
		// TODO Auto-generated method stub
		
	}
}
