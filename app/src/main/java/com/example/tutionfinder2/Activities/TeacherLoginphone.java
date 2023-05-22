package com.example.tutionfinder2.Activities;

import static com.example.tutionfinder2.App.ME;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tutionfinder2.Model.UserModel;
import com.example.tutionfinder2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class TeacherLoginphone extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://tutionfinder2-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_loginphone);

        final EditText phone = findViewById(R.id.teacher_loginPhoneumber);
        final EditText password = findViewById(R.id.teacher_loginpassword);
        final Button login_ph_button = findViewById(R.id.button_TeacherPhoneloginbutton);
//        Button button =findViewById(R.id.gateway);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(TeacherLoginphone.this,Teacher_Activity.class));
//            }
//        });

        login_ph_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String phoneTxt = phone.getText().toString();
                final String passwordTxt = password.getText().toString();

                if(phoneTxt.isEmpty() || passwordTxt.isEmpty())
                {
                    Toast.makeText(TeacherLoginphone.this,"Please Enter your mobile or password",Toast.LENGTH_SHORT).show();
                }
                else
                {
//                    databaseReference.child("Registered_Teachers").child(phoneTxt).get().addOnCompleteListener(task -> {
//                        if (task.isSuccessful()) {
//                            UserModel tmp = task.getResult().getValue(UserModel.class);
//                            if (tmp != null && Objects.equals(tmp.getPassword(), passwordTxt)) {
//                                ME = tmp;
//                                Toast.makeText(TeacherLoginphone.this,"Login has been Successful",Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(TeacherLoginphone.this, Student_Activity.class));
//                                finish();
//                            } else {
//                                Toast.makeText(TeacherLoginphone.this,"Wrong Password",Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Toast.makeText(TeacherLoginphone.this,"User not found!",Toast.LENGTH_SHORT).show();
//                        }
//                    });

                    databaseReference.child("Registered_User").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(phoneTxt))
                            {
                                final String getpassword=snapshot.child(phoneTxt).child("Password").getValue(String.class); // Real time er nam wala password.. P boro
                                if(getpassword.equals(passwordTxt))
                                {
                                    Toast.makeText(TeacherLoginphone.this,"Login has been Successful",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(TeacherLoginphone.this,Teacher_Activity.class));
                                    Log.d("Tag","Here");
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(TeacherLoginphone.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                                }

                            }
                            else {
                                Toast.makeText(TeacherLoginphone.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }
}