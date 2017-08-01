package com.example.mks.uuprojectone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mks.uuprojectone.Activity.Activity_Teacher_Signup;
import com.example.mks.uuprojectone.Activity.Activity_Tlogin;
import com.example.mks.uuprojectone.Activity.Activity_student_signup;
import com.example.mks.uuprojectone.Activity.Login_Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btTeacher,btStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btStudent= (Button) findViewById(R.id.btStudent);
        btTeacher= (Button) findViewById(R.id.btTeacher);

        btStudent.setOnClickListener(this);
        btTeacher.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v==btStudent)
        {
            startActivity(new Intent(this, Login_Activity.class));
        }else if(v==btTeacher)
        {
            startActivity(new Intent(this, Activity_Tlogin.class));
        }
    }
}
