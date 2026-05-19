////package com.project.util;
////public class DoctorBusinessLogic {
////
////	public boolean validateSpecialization(
////			String specialization) {
////
////		if(specialization == null
////				|| specialization.isEmpty()) {
////
////			return false;
////		}
////
////		if(specialization.equalsIgnoreCase("Cardiology")
////				|| specialization.equalsIgnoreCase("Neurology")
////				|| specialization.equalsIgnoreCase("Orthopedic")
////				|| specialization.equalsIgnoreCase("Dermatology")
////				|| specialization.equalsIgnoreCase("Pediatrics")) {
////
////			return true;
////		}
////
////		return false;
////	}
////
////	public boolean validatePhone(String phone) {
////		// TODO Auto-generated method stub
////		return false;
////	}
////
////	public boolean validateExperience(int experience) {
////		// TODO Auto-generated method stub
////		return false;
////	}
////}
//package com.project.util;
//
//import java.util.List;
//
//import org.hibernate.Session;
//
//import com.project.entity.Doctor;
//
//public class DoctorBusinessLogic {
//
//	// DISPLAY DOCTORS BY SPECIALIZATION
//
//	public void displayDoctorsBySpecialization(
//			Session session,
//			String specialization) {
//
//		List<Doctor> doctors =
//				session.createQuery(
//				"from Doctor where specialization=:sp",
//				Doctor.class)
//				.setParameter("sp", specialization)
//				.list();
//
//		if(doctors.isEmpty()) {
//
//			System.out.println(
//					"No Doctors Found");
//
//		} else {
//
//			System.out.println(
//					"Doctors List");
//
//			for(Doctor doctor : doctors) {
//
//				System.out.println(
//						doctor.getName());
//			}
//		}
//	}
//}
package com.project.util;

import java.util.List;

import org.hibernate.Session;

import com.project.entity.Doctor;

public class DoctorBusinessLogic {

	// SPECIALIZATION VALIDATION

	public boolean validateSpecialization(
			String specialization) {

		if(specialization == null
				|| specialization.isEmpty()) {

			return false;
		}

		if(specialization.equalsIgnoreCase("Cardiology")
				|| specialization.equalsIgnoreCase("Neurology")
				|| specialization.equalsIgnoreCase("Orthopedic")
				|| specialization.equalsIgnoreCase("Dermatology")
				|| specialization.equalsIgnoreCase("Pediatrics")) {

			return true;
		}

		return false;
	}

	// PHONE VALIDATION

	public boolean validatePhone(
			String phone) {

		if(phone.length() == 10) {

			return true;
		}

		return false;
	}

	// EXPERIENCE VALIDATION

	public boolean validateExperience(
			int experience) {

		if(experience >= 0) {

			return true;
		}

		return false;
	}

	// DISPLAY DOCTORS BY SPECIALIZATION

	public void displayDoctorsBySpecialization(
			Session session,
			String specialization) {

		List<Doctor> doctors =
				session.createQuery(
				"from Doctor where specialization=:sp",
				Doctor.class)
				.setParameter("sp", specialization)
				.list();

		if(doctors.isEmpty()) {

			System.out.println(
					"No Doctors Found");

		} else {

			System.out.println(
					"Doctors List");

			for(Doctor doctor : doctors) {

				System.out.println(
						doctor.getName());
			}
		}
	}
}