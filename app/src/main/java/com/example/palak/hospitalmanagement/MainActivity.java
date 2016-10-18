package com.example.palak.hospitalmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class MainActivity extends AppCompatActivity {
    public Button button1;
    public Button button2;


    EditText ET_NAME,ET_PASS;
    String login_name,login_pass;

    String [] SPINNERLIST ={"DOCTOR" , "PATIENT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userReg();
      //  userLogin();
        patientmain();
        doctormain();


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,SPINNERLIST);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) findViewById(R.id.login_as);
        betterSpinner.setAdapter(arrayAdapter);



    }



  /*  public void userReg(View view)
    {

        startActivity(new Intent(getApplicationContext(),Register.class));
    }*/

    public  void userReg() {
        button1 = (Button)findViewById(R.id.register);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent say = new Intent(MainActivity.this , Register.class);
                startActivity(say);
            }
        });

    }

    public  void patientmain() {
        button2 = (Button)findViewById(R.id.loginpat);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent say = new Intent(MainActivity.this , mainpatient.class);
                startActivity(say);
            }
        });

    }

    public  void doctormain() {
        button2 = (Button)findViewById(R.id.logindoc);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent say = new Intent(MainActivity.this , maindoctor.class);
                startActivity(say);
            }
        });

    }



    public void userLogin(View view)
    {
        login_name = ET_NAME.getText().toString();
        login_pass = ET_PASS.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,login_name,login_pass);

    }



}
