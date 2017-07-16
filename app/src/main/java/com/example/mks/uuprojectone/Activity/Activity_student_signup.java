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
import com.example.mks.uuprojectone.Model.Student;
import com.example.mks.uuprojectone.R;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activity_student_signup extends AppCompatActivity implements View.OnClickListener {

    private Button btSignup;
    private EditText etName,etEmail,etPassword,etDepartment,etBatch,etSection,etSid,etContactNo,etParentNO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_signup);

        btSignup= (Button) findViewById(R.id.btSignupSt);
        etName= (EditText) findViewById(R.id.etNameSt);
        etEmail= (EditText) findViewById(R.id.etEmailSt);
        etPassword= (EditText) findViewById(R.id.etPasswordSt);
        etDepartment= (EditText) findViewById(R.id.etDepartmentSt);
        etBatch= (EditText) findViewById(R.id.etBatch);
        etSection= (EditText) findViewById(R.id.etSection);
        etSid= (EditText) findViewById(R.id.etSid);
        etContactNo= (EditText) findViewById(R.id.etContactNoSt);
        etParentNO= (EditText) findViewById(R.id.etParentNo);

        btSignup.setOnClickListener(this);
    }
    private void studentSignUp(){
        //defining a progress dialog to show while signing up
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Signing Up....");
        progressDialog.show();
        // getting values
        String name=etName.getText().toString().trim();
        String email=etEmail.getText().toString().trim();
        String password=etPassword.getText().toString().trim();
        String department=etDepartment.getText().toString().trim();
        String batch=etBatch.getText().toString().trim();
        String section=etSection.getText().toString().trim();
        String sid=etSid.getText().toString().trim();
        String contactNo=etContactNo.getText().toString().trim();
        String parentNO=etParentNO.getText().toString().trim();

        //building retrofit object
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //defining retrofit api service
        APIService service=retrofit.create(APIService.class);
        //Defining the user object as we need to pass it with the call
        Student student=new Student(name,email,password,department,batch,section,sid,contactNo,parentNO);
        //definging the call
        Call<Result>call=service.createStudent(
                student.getName(),
                student.getEmail(),
                student.getStpasword(),
                student.getDepartment(),
                student.getBatch(),
                student.getSection(),
                student.getSid(),
                student.getContactno(),
                student.getParentno()
        );
        //calling the api
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                //hiding the progress dialog
                progressDialog.dismiss();
                //displaying the message from the response as toast
             Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();


                //if there is no error
               // if(!response.body().)
            }


            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();


            }
        });

    }

    @Override
    public void onClick(View v) {

        if(v==btSignup){
            studentSignUp();
        }
    }
}
