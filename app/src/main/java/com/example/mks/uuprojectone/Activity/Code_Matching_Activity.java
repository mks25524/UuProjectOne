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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Code_Matching_Activity extends AppCompatActivity implements View.OnClickListener{

    private EditText date,securityCode,department,batch,section,subjectCode;
    private Button btMatch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code__matching_);
        date= (EditText) findViewById(R.id.datePickerSecurityMatch);
        securityCode= (EditText) findViewById(R.id.etSeciurityCodeStudentMatch);
        department= (EditText) findViewById(R.id.etDepartmentSeciurityStudentMatch);
        batch= (EditText) findViewById(R.id.etBatchSeciurityMatch);
        section= (EditText) findViewById(R.id.etSectionSeciurityMatch);
        subjectCode= (EditText) findViewById(R.id.etSubjectCodeMatch);
        btMatch= (Button) findViewById(R.id.btMatch);
        btMatch.setOnClickListener(this);
    }
    private void codeMatch(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Process Running...");
        progressDialog.show();

        String dateC=date.getText().toString().trim();
        String secCode=securityCode.getText().toString().trim();
        String dept=department.getText().toString().trim();
        String batchC=batch.getText().toString().trim();
        String sectionC=section.getText().toString().trim();
        String subCode=subjectCode.getText().toString().trim();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService service=retrofit.create(APIService.class);
        Call<Result>call=service.studentCodeMatching(dateC,secCode,dept,batchC,sectionC,subCode);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                progressDialog.dismiss();
                if(!response.body().getError()){
                    finish();
                    Toast.makeText(getApplicationContext(), "Code Match ", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),AttendanceMark_Activity.class));
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid code or other information", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {

        if(v==btMatch){
            codeMatch();
        }
    }
}
