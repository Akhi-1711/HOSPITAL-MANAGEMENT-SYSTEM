package com.project.mocktest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.project.entity.Appointment;

public class AppointmentMockitoTest {

	@Test
	public void appointmentMockTest() {

		Appointment appointment =
				mock(Appointment.class);

		when(appointment.getStatus())
				.thenReturn("Booked");

		assertEquals(
				"Booked",
				appointment.getStatus());

		System.out.println(
				"Appointment Mockito Successful");
	}
}