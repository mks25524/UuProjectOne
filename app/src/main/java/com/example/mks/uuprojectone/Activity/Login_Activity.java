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
import com.example.mks.uuprojectone.R;
import com.example.mks.uuprojectone.helper.SharePrefManager;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {

    Button btSignUpSt, btSignInSt;
    EditText email, passwordq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        email = (EditText) findViewById(R.id.etEmail);
        passwordq = (EditText) findViewById(R.id.etPassword);

        btSignUpSt = (Button) findViewById(R.id.btSignup);
        btSignInSt = (Button) findViewById(R.id.btSignin);
        btSignUpSt.setOnClickListener(this);

        btSignInSt.setOnClickListener(this);

    }

    private void studentSignIn() {
         final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Signing In....");
        progressDialog.show();
     String studentEmail=email.getText().toString().trim();
        String studentPassword=passwordq.getText().toString().trim();
        //Toast.makeText(getApplicationContext(), "test"+studentPassword, Toast.LENGTH_LONG).show();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService service=retrofit.create(APIService.class);
        //Student log=new Student(studentEmail,studentPassword);
        Call<com.example.mks.uuprojectone.Model.Result>call=service.studentLogin(studentEmail,studentPassword);
        call.enqueue(new Callback<com.example.mks.uuprojectone.Model.Result>() {
            @Override
            public void onResponse(Call<com.example.mks.uuprojectone.Model.Result> call, Response<com.example.mks.uuprojectone.Model.Result> response) {
                progressDialog.dismiss();
                if (!response.body().getError()) {
                    finish();
                    SharePrefManager.getmInstance(getApplicationContext()).studentLogin(response.body().getStudent());
                    startActivity(new Intent(getApplicationContext(), Student_Profile_Activity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<com.example.mks.uuprojectone.Model.Result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    //
    @Override
    public void onClick(View v) {
        if (v == btSignUpSt) {
            startActivity(new Intent(this, Activity_student_signup.class));
        }else if(v==btSignInSt){
             studentSignIn();
            //startActivity(new Intent(this,Activity_Student_Profile.class));
        }
    }
}
