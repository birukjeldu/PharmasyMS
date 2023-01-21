package com.pharmacy;

public class Customer extends Users{
    private String prescription;
    private String doctorName;
    private String hospitalName;
    Customer(String fullName, String email, char sex,String phoneNumber,String prescription,String doctorName,String hospitalName){
        super(fullName,email,sex,phoneNumber);
        this.prescription = prescription;
        this.doctorName = doctorName;
        this.hospitalName = hospitalName;
    }
    public Customer(){

    }


    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
