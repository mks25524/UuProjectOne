package com.example.mks.uuprojectone.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mks.uuprojectone.Model.Student;

/**
 * Created by mks on 7/20/2017.
 */

public class SharePrefManager {
    private static SharePrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME="mySave";

    private static final String KEY_STUDENT_ID="Keystudentid";
    private static final String KEY_STUDENT_NAME="Keystudentname";
    private static final String KEY_STUDENT_EMAIL="Keystudentemail";
    private static final String KEY_STUDENT_DEPARTMENT="Keystudentdepartment";
    private static final String KEY_STUDENT_BATCH="Keystudentbatch";
    private static final String KEY_STUDENT_SECTION="Keystudentsection";
    private static final String KEY_STUDENT_SID="Keystudentsid";
    private static final String KEY_STUDENT_CONTACTNO="Keystudentcontactno";
    private static final String KEY_STUDENT_PARENTNO="Keystudentparentno";

    private SharePrefManager(Context context){
        mCtx=context;
    }
    public static synchronized SharePrefManager getmInstance(Context context){
        if(mInstance==null){
            mInstance=new SharePrefManager(context);
        }
        return mInstance;
    }
    public boolean studentLogin(Student student){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(KEY_STUDENT_ID,student.getId());
        editor.putString(KEY_STUDENT_NAME,student.getName());
        editor.putString(KEY_STUDENT_EMAIL,student.getEmail());
        editor.putString(KEY_STUDENT_DEPARTMENT,student.getDepartment());
        editor.putString(KEY_STUDENT_BATCH,student.getBatch());
        editor.putString(KEY_STUDENT_SECTION,student.getSection());
        editor.putString(KEY_STUDENT_SID,student.getSid());
        editor.putString(KEY_STUDENT_CONTACTNO,student.getContactno());
        editor.putString(KEY_STUDENT_PARENTNO,student.getParentno());
        editor.apply();
        return true;
    }
    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_STUDENT_EMAIL,null)!=null)
            return true;
        return false;
    }
    public Student getStudent(){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new Student(
                sharedPreferences.getInt(KEY_STUDENT_ID,0),
                sharedPreferences.getString(KEY_STUDENT_NAME,null),
                sharedPreferences.getString(KEY_STUDENT_EMAIL,null),
                sharedPreferences.getString(KEY_STUDENT_DEPARTMENT,null),
                sharedPreferences.getString(KEY_STUDENT_BATCH,null),
                sharedPreferences.getString(KEY_STUDENT_SECTION,null),
                sharedPreferences.getString(KEY_STUDENT_SID,null),
                sharedPreferences.getString(KEY_STUDENT_CONTACTNO,null),
                sharedPreferences.getString(KEY_STUDENT_PARENTNO,null)

        );}
        public boolean logout(){
        SharedPreferences sharedPreferences1=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
            editor.clear();
            editor.apply();
            return  true;
    }
    }


