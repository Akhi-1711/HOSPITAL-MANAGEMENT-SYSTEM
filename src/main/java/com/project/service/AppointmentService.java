package com.project.service;

import org.hibernate.SessionFactory;

public interface AppointmentService {
	void saveAppointment();
	void getAppointment();
	void updateAppointment();
	void deleteAppointment();
	void saveAppointment(SessionFactory sessionFactory);
	void getAppointment(SessionFactory sessionFactory);
	void getAllAppointments(SessionFactory sessionFactory);
	void updateAppointment(SessionFactory sessionFactory);
	void deleteAppointment(SessionFactory sessionFactory);

}
