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
    Call<Result>createStudent(
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
}
