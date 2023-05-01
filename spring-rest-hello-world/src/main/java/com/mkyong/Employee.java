package com.mkyong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;

    //private Date dob;
    private Long empId;
    private String emailId;

    // avoid this "No default constructor for entity"
    public Employee() {
    }

    public Employee(int id, String firstName, String lastName,Long empTd, String emailId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        //this.dob = new Date(dob.getYear(),dob.getMonth(),dob.getDate());
        this.empId = empTd;
        this.emailId = emailId;
    }

    public Employee(String firstName, String lastName, Long empId, String emailId) {
       // Date ds= new Date(dob.getYear(),dob.getMonth(),dob.getDate());
        this.firstName = firstName;
        this.lastName = lastName;
       // this.dob = dob;
        this.empId = empId;
        this.emailId = emailId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*public Date getDob() {
        Date dateWithoutTime =
                new Date(dob.getYear(),dob.getMonth(),dob.getDate());
        return dateWithoutTime;
    }*/

   // public void setDob(Date empId) {this.dob = dob;}

    public Long getEmpId() {return empId;}

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                //", dob='" + new SimpleDateFormat("yyyy-mm-dd").format(dob) + '\'' +
                ", empId='" + empId + '\'' +
                ", emailId=" + emailId +
                '}';
    }

}
