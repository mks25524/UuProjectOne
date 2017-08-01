package com.example.mks.uuprojectone.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mks.uuprojectone.Api.APIService;
import com.example.mks.uuprojectone.Api.APIUrl;
import com.example.mks.uuprojectone.Model.AttendenceSheet;
import com.example.mks.uuprojectone.Model.Result;
import com.example.mks.uuprojectone.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AttendanceMark_Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText etDate,etDept,etBatch,etSect,etSid,etSubcode,etMark;
    private Button btSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_mark_);
        etDate= (EditText) findViewById(R.id.etDAteAtt);
        etDept= (EditText) findViewById(R.id.etDeptAtt);
        etBatch= (EditText) findViewById(R.id.etBatchAtt);
        etSect= (EditText) findViewById(R.id.etSectAtt);
        etSid= (EditText) findViewById(R.id.etSidAtt);
        etSubcode= (EditText) findViewById(R.id.etSubCodeAtt);
        etMark= (EditText) findViewById(R.id.etMarkAtt);
        btSubmit= (Button) findViewById(R.id.btMarked);
        btSubmit.setOnClickListener(this);

    }
    private void submitAttendence(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Submitting...");
        progressDialog.show();
        String date=etDate.getText().toString().trim();
        String dept=etDept.getText().toString().trim();
        String batch=etBatch.getText().toString().trim();
        String section=etSect.getText().toString().trim();
        String sid=etSid.getText().toString().trim();
        String subcode=etSubcode.getText().toString().trim();
        String mark=etMark.getText().toString().trim();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService service=retrofit.create(APIService.class);
        AttendenceSheet sheet=new AttendenceSheet(date,dept,batch,section,sid,subcode,mark);
        Call<Result>call=service.markAttendenced(
                sheet.getDate(),
                sheet.getDept(),
                sheet.getBatch(),
                sheet.getSect(),
                sheet.getSid(),

                sheet.getSubjectcode(),
                sheet.getMark()
        );
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Successfull", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
               // Toast.makeText(getApplicationContext(), "unsuccessfull", Toast.LENGTH_LONG).show();


            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v==btSubmit){
            submitAttendence();
        }

    }
}
