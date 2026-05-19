package com.project.service.impl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.entity.Appointment;
import com.project.entity.Billing;
import com.project.service.BillingService;

public class BillingServiceimpl implements BillingService {

	Scanner sc = new Scanner(System.in);

	@Override
	public void saveBilling(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Billing billing = new Billing();

		System.out.println("Enter Appointment Id:");

		int appointmentId = sc.nextInt();

		Appointment appointment = session.get(Appointment.class, appointmentId);

		if (appointment == null) {

			System.out.println("Appointment Not Found");

			session.close();

			return;
		}

		System.out.println("Enter Total Amount:");

		billing.setTotalAmount(sc.nextDouble());

		System.out.println("Enter Payment Status:");

		billing.setPaymentStatus(sc.next());

		System.out.println("Enter Payment Date:");

		billing.setPaymentDate(sc.next());

		billing.setAppointment(appointment);

		session.persist(billing);

		tx.commit();

		session.close();

		System.out.println("Billing Saved Successfully");
	}

	@Override
	public void getBilling(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		System.out.println("Enter Billing Id:");

		int id = sc.nextInt();

		Billing billing = session.get(Billing.class, id);

		if (billing != null) {

			System.out.println("Bill Id: " + billing.getBillId());

			System.out.println("Amount: " + billing.getTotalAmount());

			System.out.println("Status: " + billing.getPaymentStatus());

			System.out.println("Date: " + billing.getPaymentDate());

		} else {

			System.out.println("Billing Not Found");
		}

		session.close();
	}

	@Override
	public void getAllBillings(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		List<Billing> billings = session
				.createQuery("from Billing", Billing.class)
				.list();

		for (Billing billing : billings) {

			System.out.println(
					billing.getBillId() + " "
					+ billing.getTotalAmount() + " "
					+ billing.getPaymentStatus());
		}

		session.close();
	}

	@Override
	public void updateBilling(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		System.out.println("Enter Billing Id:");

		int id = sc.nextInt();

		Billing billing = session.get(Billing.class, id);

		if (billing != null) {

			System.out.println("Enter New Payment Status:");

			billing.setPaymentStatus(sc.next());

			session.merge(billing);

			tx.commit();

			System.out.println("Billing Updated Successfully");

		} else {

			System.out.println("Billing Not Found");
		}

		session.close();
	}

	@Override
	public void deleteBilling(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		System.out.println("Enter Billing Id:");

		int id = sc.nextInt();

		Billing billing = session.get(Billing.class, id);

		if (billing != null) {

			session.remove(billing);

			tx.commit();

			System.out.println("Billing Deleted Successfully");

		} else {

			System.out.println("Billing Not Found");
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

	@Override
	public void saveBill() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getBill() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBill() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBill() {
		// TODO Auto-generated method stub
		
	}
}