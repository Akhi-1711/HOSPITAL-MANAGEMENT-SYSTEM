package com.project.service;

import org.hibernate.SessionFactory;

public interface TreatmentService {
	    void saveTreatment();
	    void getTreatment();
	    void updateTreatment();
	    void deleteTreatment(SessionFactory sessionFactory);
		void saveTreatment(SessionFactory sessionFactory);
		void getTreatment(SessionFactory sessionFactory);
		void getAllTreatments(SessionFactory sessionFactory);
		void updateTreatment(SessionFactory sessionFactory);
	}

