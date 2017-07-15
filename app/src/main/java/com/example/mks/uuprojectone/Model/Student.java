package com.example.mks.uuprojectone.Model;

/**
 * Created by mks on 7/16/2017.
 */

public class Student {
    private int id;
    private String name;
    private String email;
    private String stpasword;
    private String department;
    private String batch;
    private String section;
    private String sid;
    private String contactno;
    private String parentno;

    public Student(String name, String email, String stpasword, String department, String batch, String section, String sid, String contactno, String parentno) {
        this.name = name;
        this.email = email;
        this.stpasword = stpasword;
        this.department = department;
        this.batch = batch;
        this.section = section;
        this.sid = sid;
        this.contactno = contactno;
        this.parentno = parentno;
    }

    public Student(int id, String name, String email, String stpasword, String department, String batch, String section, String sid, String contactno, String parentno) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.stpasword = stpasword;
        this.department = department;
        this.batch = batch;
        this.section = section;
        this.sid = sid;
        this.contactno = contactno;
        this.parentno = parentno;
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

    public String getStpasword() {
        return stpasword;
    }

    public String getDepartment() {
        return department;
    }

    public String getBatch() {
        return batch;
    }

    public String getSection() {
        return section;
    }

    public String getSid() {
        return sid;
    }

    public String getContactno() {
        return contactno;
    }

    public String getParentno() {
        return parentno;
    }
}
