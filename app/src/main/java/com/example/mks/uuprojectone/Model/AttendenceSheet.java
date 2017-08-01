package com.example.mks.uuprojectone.Model;

/**
 * Created by mks on 8/1/2017.
 */

public class AttendenceSheet {
    private int id;
    private String date;
    private String dept;
    private String batch;
    private String sect;
    private String sid;
    private String subjectcode;
    private String mark;

    public AttendenceSheet(int id, String date, String dept, String batch, String sect, String sid, String subjectcode, String mark) {
        this.id = id;
        this.date = date;
        this.dept = dept;
        this.batch = batch;
        this.sect = sect;
        this.sid = sid;
        this.subjectcode = subjectcode;
        this.mark = mark;
    }

    public AttendenceSheet(String date, String dept, String batch, String sect, String sid, String subjectcode, String mark) {
        this.date = date;
        this.dept = dept;
        this.batch = batch;
        this.sect = sect;
        this.sid = sid;
        this.subjectcode = subjectcode;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getDept() {
        return dept;
    }

    public String getBatch() {
        return batch;
    }

    public String getSect() {
        return sect;
    }

    public String getSid() {
        return sid;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public String getMark() {
        return mark;
    }
}
