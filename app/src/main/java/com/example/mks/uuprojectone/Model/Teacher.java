package com.example.mks.uuprojectone.Model;

/**
 * Created by mks on 7/19/2017.
 */

public class Teacher {
    private int id;
    private String name;
    private String email;
    private String tpasword;
    private String department;
    private String desgination;
    private String contactNo;

    public Teacher(int id, String name, String email, String tpasword, String department, String desgination, String contactNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tpasword = tpasword;
        this.department = department;
        this.desgination = desgination;
        this.contactNo = contactNo;
    }

    public Teacher(String name, String email, String tpasword, String department, String desgination, String contactNo) {

        this.name = name;
        this.email = email;
        this.tpasword = tpasword;
        this.department = department;
        this.desgination = desgination;
        this.contactNo = contactNo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTpasword() {
        return tpasword;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesgination() {
        return desgination;
    }

    public String getContactNo() {
        return contactNo;
    }

    public Teacher(int id, String name, String email, String department, String desgination, String contactNo) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.desgination = desgination;
        this.contactNo = contactNo;
    }
}
