package com.project.service;

import org.hibernate.SessionFactory;

public interface DoctorService {

	    void saveDoctor();     // ❌ remove static
	    void getDoctor();
	    void updateDoctor();
	    void deleteDoctor();
		void saveDoctor(SessionFactory sessionFactory);
		void getDoctor(SessionFactory sessionFactory);
		void getAllDoctors(SessionFactory sessionFactory);
		void updateDoctor(SessionFactory sessionFactory);
		void deleteDoctor(SessionFactory sessionFactory);
		void getDoctorsBySpecialization(SessionFactory sessionFactory);
	}

