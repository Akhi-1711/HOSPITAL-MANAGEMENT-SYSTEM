package com.project.service.impl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.entity.Appointment;
import com.project.entity.Doctor;
import com.project.entity.Patient;
import com.project.service.AppointmentService;

public class AppointmentServiceimpl implements AppointmentService {

	Scanner sc = new Scanner(System.in);

	@Override
	public void saveAppointment(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Appointment appointment = new Appointment();

		System.out.println("Enter Patient Id:");

		int patientId = sc.nextInt();

		Patient patient = session.get(Patient.class, patientId);

		if (patient == null) {

			System.out.println("Patient Not Found");

			session.close();

			return;
		}

		System.out.println("Enter Doctor Id:");

		int doctorId = sc.nextInt();

		Doctor doctor = session.get(Doctor.class, doctorId);

		if (doctor == null) {

			System.out.println("Doctor Not Found");

			session.close();

			return;
		}

		System.out.println("Enter Appointment Date:");

		appointment.setAppointmentDate(sc.next());

		System.out.println("Enter Appointment Time:");

		appointment.setAppointmentTime(sc.next());

		System.out.println("Enter Status:");

		appointment.setStatus(sc.next());

		appointment.setPatient(patient);

		appointment.setDoctor(doctor);

		session.persist(appointment);

		tx.commit();

		session.close();

		System.out.println("Appointment Saved Successfully");
	}

	@Override
	public void getAppointment(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		System.out.println("Enter Appointment Id:");

		int id = sc.nextInt();

		Appointment appointment = session.get(Appointment.class, id);

		if (appointment != null) {

			System.out.println("Appointment Id: "
					+ appointment.getAppointmentId());

			System.out.println("Date: "
					+ appointment.getAppointmentDate());

			System.out.println("Time: "
					+ appointment.getAppointmentTime());

			System.out.println("Status: "
					+ appointment.getStatus());

		} else {

			System.out.println("Appointment Not Found");
		}

		session.close();
	}

	@Override
	public void getAllAppointments(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		List<Appointment> appointments = session
				.createQuery("from Appointment", Appointment.class)
				.list();

		for (Appointment appointment : appointments) {

			System.out.println(
					appointment.getAppointmentId() + " "
					+ appointment.getAppointmentDate() + " "
					+ appointment.getStatus());
		}

		session.close();
	}

	@Override
	public void updateAppointment(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		System.out.println("Enter Appointment Id:");

		int id = sc.nextInt();

		Appointment appointment = session.get(Appointment.class, id);

		if (appointment != null) {

			System.out.println("Enter New Status:");

			appointment.setStatus(sc.next());

			session.merge(appointment);

			tx.commit();

			System.out.println("Appointment Updated Successfully");

		} else {

			System.out.println("Appointment Not Found");
		}

		session.close();
	}

	@Override
	public void deleteAppointment(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		System.out.println("Enter Appointment Id:");

		int id = sc.nextInt();

		Appointment appointment = session.get(Appointment.class, id);

		if (appointment != null) {

			session.remove(appointment);

			tx.commit();

			System.out.println("Appointment Deleted Successfully");

		} else {

			System.out.println("Appointment Not Found");
		}

		session.close();
	}

	@Override
	public void saveAppointment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAppointment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAppointment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAppointment() {
		// TODO Auto-generated method stub
		
	}
}