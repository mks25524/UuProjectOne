package com.example.mks.uuprojectone.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mks.uuprojectone.R;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {

    Button btSignUpSt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        btSignUpSt= (Button) findViewById(R.id.btSignup);
         btSignUpSt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btSignUpSt)
            startActivity(new Intent(this,Activity_student_signup.class));
    }
}
