package com.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;

    private double totalAmount;

    private String paymentStatus;

    private String paymentDate;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    public Billing() {
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

	public void setAmount(double amount) {
		// TODO Auto-generated method stub
		
	}

	public String getAmount() {
		// TODO Auto-generated method stub
		return null;
	}


	
}