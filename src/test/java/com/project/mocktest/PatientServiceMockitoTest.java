package com.project.mocktest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.project.entity.Patient;

public class PatientServiceMockitoTest {

	@Test
	public void patientMockTest() {

		Patient patient = mock(Patient.class);

		when(patient.getName())
				.thenReturn("Akhila");

		assertEquals(
				"Akhila",
				patient.getName());

		System.out.println(
				"Patient Mockito Successful");
	}
}