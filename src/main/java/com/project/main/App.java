package com.project.main;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.project.service.AppointmentService;
import com.project.service.BillingService;
import com.project.service.DoctorService;
import com.project.service.PatientService;
import com.project.service.TreatmentService;

import com.project.service.impl.AppointmentServiceimpl;
import com.project.service.impl.BillingServiceimpl;
import com.project.service.impl.DoctorServiceimpl;
import com.project.service.impl.PatientServiceimpl;
import com.project.service.impl.TreatmentServiceimpl;
import com.project.util.HibernateUtil;

//import com.project.util.HibernateUtil;

public class App {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Scanner sc = new Scanner(System.in);

		PatientService patientService = new PatientServiceimpl();

		DoctorService doctorService = new DoctorServiceimpl();

		AppointmentService appointmentService = new AppointmentServiceimpl();

		BillingService billingService = new BillingServiceimpl();

		TreatmentService treatmentService = new TreatmentServiceimpl();

		while (true) {

			System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");

			System.out.println("1. Patient Management");
			System.out.println("2. Doctor Management");
			System.out.println("3. Appointment Management");
			System.out.println("4. Treatment Management");
			System.out.println("5. Billing Management");
			System.out.println("6. Exit");

			System.out.println("Enter Your Choice:");

			int choice = sc.nextInt();

			switch (choice) {

			// ================= PATIENT =================

			case 1:

				System.out.println("\n===== PATIENT CRUD OPERATIONS =====");

				System.out.println("1. Save Patient");
				System.out.println("2. Get Patient");
				System.out.println("3. Get All Patients");
				System.out.println("4. Update Patient");
				System.out.println("5. Delete Patient");

				System.out.println("Enter Choice:");

				int patientChoice = sc.nextInt();

				switch (patientChoice) {

				case 1:

					patientService.savePatient(sessionFactory);

					break;

				case 2:

					patientService.getPatient(sessionFactory);

					break;

				case 3:

					patientService.getAllPatients(sessionFactory);

					break;

				case 4:

					patientService.updatePatient(sessionFactory);

					break;

				case 5:

					patientService.deletePatient(sessionFactory);

					break;

				default:

					System.out.println("Invalid Choice");
				}

				break;

			// ================= DOCTOR =================

			case 2:

				System.out.println("\n===== DOCTOR CRUD OPERATIONS =====");

				System.out.println("1. Save Doctor");
				System.out.println("2. Get Doctor");
				System.out.println("3. Get All Doctors");
				System.out.println("4. Update Doctor");
				System.out.println("5. Delete Doctor");

				System.out.println("Enter Choice:");

				int doctorChoice = sc.nextInt();

				switch (doctorChoice) {

				case 1:

					doctorService.saveDoctor(sessionFactory);

					break;

				case 2:

					doctorService
					.getDoctorsBySpecialization(
							sessionFactory);

					break;

				case 3:

					doctorService.getAllDoctors(sessionFactory);

					break;

				case 4:

					doctorService.updateDoctor(sessionFactory);

					break;

				case 5:

					doctorService.deleteDoctor(sessionFactory);

					break;
				case 6:

					doctorService.getDoctorsBySpecialization(
							sessionFactory);

					break;

				default:

					System.out.println("Invalid Choice");
				}

				break;

			// ================= APPOINTMENT =================

			case 3:

				System.out.println("\n===== APPOINTMENT CRUD OPERATIONS =====");

				System.out.println("1. Save Appointment");
				System.out.println("2. Get Appointment");
				System.out.println("3. Get All Appointments");
				System.out.println("4. Update Appointment");
				System.out.println("5. Delete Appointment");

				System.out.println("Enter Choice:");

				int appointmentChoice = sc.nextInt();

				switch (appointmentChoice) {

				case 1:

					appointmentService.saveAppointment(sessionFactory);

					break;

				case 2:

					appointmentService.getAppointment(sessionFactory);

					break;

				case 3:

					appointmentService.getAllAppointments(sessionFactory);

					break;

				case 4:

					appointmentService.updateAppointment(sessionFactory);

					break;

				case 5:

					appointmentService.deleteAppointment(sessionFactory);

					break;

				default:

					System.out.println("Invalid Choice");
				}

				break;

			// ================= BILLING =================

			case 4:

				System.out.println("\n===== BILLING CRUD OPERATIONS =====");

				System.out.println("1. Save Billing");
				System.out.println("2. Get Billing");
				System.out.println("3. Get All Billings");
				System.out.println("4. Update Billing");
				System.out.println("5. Delete Billing");

				System.out.println("Enter Choice:");

				int billingChoice = sc.nextInt();

				switch (billingChoice) {

				case 1:

					billingService.saveBilling(sessionFactory);

					break;

				case 2:

					billingService.getBilling(sessionFactory);

					break;

				case 3:

					billingService.getAllBillings(sessionFactory);

					break;

				case 4:

					billingService.updateBilling(sessionFactory);

					break;

				case 5:

					billingService.deleteBilling(sessionFactory);

					break;

				default:

					System.out.println("Invalid Choice");
				}

				break;

			// ================= TREATMENT =================

			case 5:

				System.out.println("\n===== TREATMENT CRUD OPERATIONS =====");

				System.out.println("1. Save Treatment");
				System.out.println("2. Get Treatment");
				System.out.println("3. Get All Treatments");
				System.out.println("4. Update Treatment");
				System.out.println("5. Delete Treatment");

				System.out.println("Enter Choice:");

				int treatmentChoice = sc.nextInt();

				switch (treatmentChoice) {

				case 1:

					treatmentService.saveTreatment(sessionFactory);

					break;

				case 2:

					treatmentService.getTreatment(sessionFactory);

					break;

				case 3:

					treatmentService.getAllTreatments(sessionFactory);

					break;

				case 4:

					treatmentService.updateTreatment(sessionFactory);

					break;

				case 5:

					treatmentService.deleteTreatment(sessionFactory);

					break;

				default:

					System.out.println("Invalid Choice");
				}

				break;

			// ================= EXIT =================

			case 6:

				System.out.println("Project Closed Successfully");

				sessionFactory.close();

				sc.close();

				System.exit(0);

			default:

				System.out.println("Enter Valid Choice");
			}
		}
	}
}