package com.project.service;

import org.hibernate.SessionFactory;

public interface PatientService {

    void savePatient();
    void getPatient();
    void updatePatient();
    void deletePatient();
	void savePatient(SessionFactory sessionFactory);
	void getPatient(SessionFactory sessionFactory);
	void getAllPatients(SessionFactory sessionFactory);
	void updatePatient(SessionFactory sessionFactory);
	void deletePatient(SessionFactory sessionFactory);
	
}