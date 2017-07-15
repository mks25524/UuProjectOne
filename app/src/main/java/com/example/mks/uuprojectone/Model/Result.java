package com.example.mks.uuprojectone.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mks on 7/16/2017.
 */

public class Result {
    @SerializedName("error")
    private Boolean error;

    @SerializedName("message")
    private String message;
    @SerializedName("student")
    private Student student;

    public Result(Boolean error, String message, Student student) {
        this.error = error;
        this.message = message;
        this.student = student;
    }

    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Student getStudent() {
        return student;
    }
}
