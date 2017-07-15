package com.example.mks.uuprojectone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mks.uuprojectone.Activity.Login_Activity;

public class MainActivity extends AppCompatActivity {

    Button btTeacher,btStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btStudent= (Button) findViewById(R.id.btStudent);
        btTeacher= (Button) findViewById(R.id.btTeacher);

        btStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(intent);
                setContentView(R.layout. activity_login_);
            }
        });
        btTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(intent);
                setContentView(R.layout. activity_login_);
            }
        });
    }
}
