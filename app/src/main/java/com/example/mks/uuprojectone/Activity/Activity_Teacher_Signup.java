package com.example.mks.uuprojectone.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mks.uuprojectone.Api.APIService;
import com.example.mks.uuprojectone.Api.APIUrl;
import com.example.mks.uuprojectone.Model.Teacher;
import com.example.mks.uuprojectone.R;
import com.example.mks.uuprojectone.helper.SharePrefManager;
import com.example.mks.uuprojectone.helper.SharePrefManagerForTeacher;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activity_Teacher_Signup extends AppCompatActivity implements View.OnClickListener {

    private Button btSignUp;
    private EditText etname,etemail,etPass,etDepartment,etDesignation,etContactNO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__teacher__signup);

        btSignUp= (Button) findViewById(R.id.btTeacherSignUp);
        etname= (EditText) findViewById(R.id.etTeacherName);
        etemail= (EditText) findViewById(R.id.etTeacherEmail);
        etPass= (EditText) findViewById(R.id.etTeacherPassword);
        etDepartment= (EditText) findViewById(R.id.etTeacherDeaprtment);
        etDesignation= (EditText) findViewById(R.id.etTeacherDesignation);
        etContactNO= (EditText) findViewById(R.id.etTeacherContactNo);
        btSignUp.setOnClickListener(this);

    }
    private void teacherSignUp(){
        //defining a progress dialog to show while signing up
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        String  name=etname.getText().toString().trim();
        String  email=etemail.getText().toString().trim();
        String  passwrod=etPass.getText().toString().trim();
        String  department=etDepartment.getText().toString().trim();
        String  designation=etDesignation.getText().toString().trim();
        String  contactNo=etContactNO.getText().toString().trim();
        //retrofit api service
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //retrofit api service
        APIService service=retrofit.create(APIService.class);
        //define object
        Teacher teacher=new Teacher(name,email,passwrod,department,designation,contactNo);
        //make call
        Call<com.example.mks.uuprojectone.Model.Result>call=service.createTeacher(
                teacher.getName(),
                teacher.getEmail(),
                teacher.getTpasword(),
                teacher.getDepartment(),
                teacher.getDesgination(),
                teacher.getContactNo()
        );
        // call api
        call.enqueue(new Callback<com.example.mks.uuprojectone.Model.Result>() {
            @Override
            public void onResponse(Call<com.example.mks.uuprojectone.Model.Result> call, Response<com.example.mks.uuprojectone.Model.Result> response) {
                 progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                if (!response.body().getError()) {
                    //starting profile activity
                    finish();
                    SharePrefManagerForTeacher.getInstance(getApplicationContext()).techerLogin(response.body().getTeacher());
                    startActivity(new Intent(getApplicationContext(), Teacher_Profile_Activity.class));
                }
            }

            @Override
            public void onFailure(Call<com.example.mks.uuprojectone.Model.Result> call, Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

        if(v==btSignUp){
            teacherSignUp();
        }
    }
}
