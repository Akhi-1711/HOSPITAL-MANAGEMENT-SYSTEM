package com.project.test;



import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import com.project.entity.Appointment;
import com.project.entity.Billing;
import com.project.util.HibernateUtil;

public class BillingTest {

	@Test
	public void saveBillingTest() {

		Session session =
				HibernateUtil
				.getSessionFactory()
				.openSession();

		Transaction tx =
				session.beginTransaction();

		Appointment appointment =
				session.get(Appointment.class, 1);

		Billing billing = new Billing();

		billing.setTotalAmount(5000);

		billing.setPaymentStatus("Paid");

		billing.setPaymentDate("2026-05-06");

		billing.setAppointment(appointment);

		session.persist(billing);

		tx.commit();

		assertNotNull(billing.getBillId());

		session.close();
	}
}