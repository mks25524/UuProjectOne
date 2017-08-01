package com.example.mks.uuprojectone.Api;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by mks on 7/16/2017.
 */

public interface APIService {
    // for regisetStudent call
    @FormUrlEncoded
    @POST("registerStudent")
    Call<com.example.mks.uuprojectone.Model.Result> createStudent(
            @Field("name")String name,
            @Field("email")String email,
            @Field("stpasword")String stpasword,
            @Field("department")String department,
            @Field("batch")String batch,
            @Field("section")String section,
            @Field("sid")String sid,
            @Field("contactno")String contactno,
            @Field("parentno")String parentno
    );
    // for regisetTeacher call
    @FormUrlEncoded
    @POST("registerTeacher")
    Call<com.example.mks.uuprojectone.Model.Result> createTeacher(
            @Field("name")String name,
            @Field("email")String email,
            @Field("tpasword")String tpasword,
            @Field("department")String department,
            @Field("designation")String designation,
            @Field("contactno")String contactno


    );
    //student login
    @FormUrlEncoded
    @POST("studentLogin")
    Call<com.example.mks.uuprojectone.Model.Result> studentLogin(

            @Field("email")String email,
            @Field("stpasword")String stpasword
    );
    //teacher login
    @FormUrlEncoded
    @POST("teacherLogin")
    Call<com.example.mks.uuprojectone.Model.Result> teacherLogin(

            @Field("email")String email,
            @Field("tpasword")String tpasword
    );
    // for seciurity code table
    @FormUrlEncoded
    @POST("seciurityPattern")
    Call<com.example.mks.uuprojectone.Model.Result> submittCode(
            @Field("date")String date,
            @Field("seciuritycode")String seciuritycode,

            @Field("department")String department,
            @Field("batch")String batch,
            @Field("section")String section,

            @Field("subjectcode")String subjectCode

    );

    //student securityCode matching
    @FormUrlEncoded
    @POST("studentCodeMatching")
    Call<com.example.mks.uuprojectone.Model.Result> studentCodeMatching(

            @Field("date")String date,
            @Field("seciurityCode")String seciurityCode,
            @Field("department")String department,
            @Field("batch")String batch,
            @Field("section")String section,
            @Field("subjectcode")String subjectcode
    );
    //for marked attendence
    @FormUrlEncoded
    @POST("markAttendenced")
    Call<com.example.mks.uuprojectone.Model.Result> markAttendenced(
            @Field("date")String date,
            @Field("dept")String department,
            @Field("batch")String batch,
            @Field("sect")String section,
            @Field("sid")String sid,
            @Field("subjectcode")String subjectCode,
            @Field("mark")String marked

    );
}
