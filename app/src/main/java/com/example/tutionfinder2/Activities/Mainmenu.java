package com.example.tutionfinder2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tutionfinder2.R;

public class Mainmenu extends AppCompatActivity {
    Button signPhone,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        signPhone=findViewById(R.id.Button_signin_phone);
        register=findViewById(R.id.Button_register);

        signPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signphone= new Intent(Mainmenu.this,ChooseLogin.class);
                signphone.putExtra("Home","Phone");
                startActivity(signphone);
                finish();

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerUser= new Intent(Mainmenu.this,ChooseLogin.class);
                registerUser.putExtra("Home", "SignUp");
                startActivity(registerUser);
                finish();
            }
        });
    }
}