package com.example.mks.uuprojectone.Model;

import java.util.Date;

/**
 * Created by mks on 7/29/2017.
 */

public class CodeForTeacher {
    private int id;
    private String Date;
    private String secCode;
    private String department;
    private String batch;
    private String section;
    private String subjectCode;

    public CodeForTeacher(String date, String secCode, String department, String batch, String section, String subjectCode) {

        Date = date;
        this.secCode = secCode;
        this.department = department;
        this.batch = batch;
        this.section = section;
        this.subjectCode = subjectCode;
    }

    public int getId() {

        return id;
    }

    public String getDate() {
        return Date;
    }

    public String getSecCode() {
        return secCode;
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

    public String getSubjectCode() {
        return subjectCode;
    }
}
