package com.example.mks.uuprojectone.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mks.uuprojectone.Model.Student;
import com.example.mks.uuprojectone.Model.Teacher;

/**
 * Created by mks on 7/27/2017.
 */

public class SharePrefManagerForTeacher {
    private static SharePrefManagerForTeacher mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME="mySaveForTeacher";

    private static final String KEY_TEACHER_ID="Keyteacherid";
    private static final String KEY_TEACHER_NAME="Keyteachername";
    private static final String KEY_TEACHER_EMAIL="Keyteacheremail";
    private static final String KEY_TEACHER_DEPARTMENT="Keyteacherdepartment";


    private static final String KEY_TEACHER_DESIGNATION="Keyteacherdesignation";
    private static final String KEY_TEACHER_CONTACTNO="Keyteachercontactno";


    private SharePrefManagerForTeacher(Context context){
        mCtx=context;
    }
    public static synchronized SharePrefManagerForTeacher getInstance(Context context){
        if(mInstance==null){
            mInstance=new SharePrefManagerForTeacher(context);
        }
        return mInstance;
    }
    public boolean techerLogin(Teacher teacher){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(KEY_TEACHER_ID,teacher.getId());
        editor.putString(KEY_TEACHER_NAME,teacher.getName());
        editor.putString(KEY_TEACHER_EMAIL,teacher.getEmail());
        editor.putString(KEY_TEACHER_DEPARTMENT,teacher.getDepartment());
        editor.putString(KEY_TEACHER_DESIGNATION,teacher.getDesgination());
        editor.putString(KEY_TEACHER_CONTACTNO,teacher.getContactNo());

        editor.apply();
        return true;
    }
    public boolean isLoggedInT(){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_TEACHER_EMAIL,null)!=null)
            return true;
        return false;
    }
    public Teacher getTeacher(){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new Teacher(
                sharedPreferences.getInt(KEY_TEACHER_ID,0),
                sharedPreferences.getString(KEY_TEACHER_NAME,null),
                sharedPreferences.getString(KEY_TEACHER_EMAIL,null),
                sharedPreferences.getString(KEY_TEACHER_DEPARTMENT,null),
                sharedPreferences.getString(KEY_TEACHER_DESIGNATION,null),
                sharedPreferences.getString(KEY_TEACHER_CONTACTNO,null)


        );}
    public boolean logout(){
        SharedPreferences sharedPreferences1=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
        editor.clear();
        editor.apply();
        return  true;
    }
}
