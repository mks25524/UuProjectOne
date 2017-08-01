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
import com.example.mks.uuprojectone.Model.CodeForTeacher;
import com.example.mks.uuprojectone.Model.Result;
import com.example.mks.uuprojectone.R;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetAttendance_Activity extends AppCompatActivity implements View.OnClickListener{

    private EditText date,seciurityCode,department,batch,section,subjectCode;
    private Button btStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_attendance_);
        btStart= (Button) findViewById(R.id.btStartAteendence);
        date= (EditText) findViewById(R.id.datePickerSecurity);
        seciurityCode= (EditText) findViewById(R.id.etSeciurityCodeTeacher);
        department= (EditText) findViewById(R.id.etDepartmentSeciurityTeacher);
        batch= (EditText) findViewById(R.id.etBatchSeciurityTeacher);
        section= (EditText) findViewById(R.id.etSectionSeciurityTeacher);
        subjectCode= (EditText) findViewById(R.id.etSubjectCodeTeacher);
        btStart.setOnClickListener(this);

    }
    private void submitCode(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Submitting code...");
        progressDialog.show();
      String dateT=date.getText().toString().trim();
        String code=seciurityCode.getText().toString().trim();
        String dept=department.getText().toString().trim();
        String batchT=batch.getText().toString().trim();
        String sectionT=section.getText().toString().trim();
        String subjectCodeT=subjectCode.getText().toString().trim();

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService service=retrofit.create(APIService.class);
        CodeForTeacher codeForTeacher=new CodeForTeacher(dateT,code,dept,batchT,sectionT,subjectCodeT);

        Call<Result>call=service.submittCode(
                codeForTeacher.getDate(),
                codeForTeacher.getSecCode(),
                codeForTeacher.getDepartment(),
                codeForTeacher.getBatch(),
                codeForTeacher.getSection(),
                codeForTeacher.getSubjectCode()
        );
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                progressDialog.dismiss();
               // Toast.makeText(getApplicationContext(),"Submit success",Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

                progressDialog.dismiss();
              //Toast.makeText(getApplicationContext(),"Submit failor",Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

        if(v==btStart){
            submitCode();
        }
    }
}
