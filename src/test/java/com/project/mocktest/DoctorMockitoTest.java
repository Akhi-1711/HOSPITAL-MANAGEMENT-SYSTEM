package com.project.mocktest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.project.entity.Doctor;

public class DoctorMockitoTest {

	@Test
	public void doctorMockTest() {

		Doctor doctor = mock(Doctor.class);

		when(doctor.getName())
				.thenReturn("Ramesh");

		when(doctor.getSpecialization())
				.thenReturn("Cardiology");

		assertEquals(
				"Ramesh",
				doctor.getName());

		assertEquals(
				"Cardiology",
				doctor.getSpecialization());

		System.out.println(
				"Doctor Mockito Successful");
	}
}