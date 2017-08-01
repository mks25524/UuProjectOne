package com.example.mks.uuprojectone.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mks.uuprojectone.R;

public class Student_Profile_Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btAttendance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__profile_);
        btAttendance= (Button) findViewById(R.id.btAttendanceByStudent);
        btAttendance.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==btAttendance){
            startActivity(new Intent(this,Code_Matching_Activity.class));
        }
    }
}
