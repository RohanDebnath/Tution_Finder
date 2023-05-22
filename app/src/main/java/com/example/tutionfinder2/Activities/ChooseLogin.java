package com.example.tutionfinder2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tutionfinder2.R;

public class ChooseLogin extends AppCompatActivity {
    Button student, teacher;
    Intent intent;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_login);
        student=findViewById(R.id.Button_Student);
        teacher=findViewById(R.id.Button_Teacher);
        intent=getIntent();
        type= intent.getStringExtra("Home").toString().trim();

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("Phone"))
                {
                    Intent loginphone = new Intent(ChooseLogin.this, StudentLoginphone.class);
                    startActivity(loginphone);
                }  if(type.equals("SignUp"))
                {
                    Intent register = new Intent(ChooseLogin.this, StudentSignUp.class);
                    startActivity(register);
                }
            }
        });
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(type.equals("Phone"))
                {
                    Intent loginphoneTut = new Intent(ChooseLogin.this, TeacherLoginphone.class);
                    startActivity(loginphoneTut);
                }  if(type.equals("SignUp"))
                {
                    Intent registerTut = new Intent(ChooseLogin.this, TeacherSignup.class);
                    startActivity(registerTut);
                    finish();
                }
            }
        });
    }
}