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
import com.example.mks.uuprojectone.Model.Result;
import com.example.mks.uuprojectone.R;
import com.example.mks.uuprojectone.helper.SharePrefManagerForTeacher;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activity_Tlogin extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmail,etPassword;
    private Button btSignIn,btSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__tlogin);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etPassword= (EditText) findViewById(R.id.etPassword);
        btSignIn= (Button) findViewById(R.id.btSignin);
        btSignUp= (Button) findViewById(R.id.btSignup);
        btSignUp.setOnClickListener(this);
        btSignIn.setOnClickListener(this);
    }
    private void teacherLogin(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();
        String email=etEmail.getText().toString().trim();
        String password=etPassword.getText().toString().trim();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);


        Call<Result> call = service.teacherLogin(email, password);

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                progressDialog.dismiss();
                if (!response.body().getError()) {
                    finish();
                    SharePrefManagerForTeacher.getInstance(getApplicationContext()).techerLogin(response.body().getTeacher());
                    startActivity(new Intent(getApplicationContext(), Teacher_Profile_Activity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

        if(v==btSignIn){
            teacherLogin();
        }else if(v==btSignUp){
            startActivity(new Intent(this, Activity_Teacher_Signup.class));
        }
    }
}
