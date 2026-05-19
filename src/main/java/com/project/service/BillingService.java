package com.project.service;

import org.hibernate.SessionFactory;

public interface BillingService {
	void savePatient();
    void getPatient();
    void updatePatient();
    void deletePatient();
	void saveBill();
	void getBill();
	void updateBill();
	void deleteBill();
	void saveBilling(SessionFactory sessionFactory);
	void getBilling(SessionFactory sessionFactory);
	void getAllBillings(SessionFactory sessionFactory);
	void updateBilling(SessionFactory sessionFactory);
	void deleteBilling(SessionFactory sessionFactory);


}
