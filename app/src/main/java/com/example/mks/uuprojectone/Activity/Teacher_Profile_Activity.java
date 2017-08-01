package com.example.mks.uuprojectone.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mks.uuprojectone.R;

public class Teacher_Profile_Activity extends AppCompatActivity implements View.OnClickListener{
    Button btAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__profile_);
        btAttendance= (Button) findViewById(R.id.btAttendanceForTeacher);
        btAttendance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==btAttendance){
            startActivity(new Intent(this, GetAttendance_Activity.class));
        }
    }
}
