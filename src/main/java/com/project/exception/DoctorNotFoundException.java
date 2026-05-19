package com.project.exception;

public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException (String msg) {
        super(msg);
    }
}
