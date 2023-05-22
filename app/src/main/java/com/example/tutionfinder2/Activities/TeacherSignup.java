package com.example.tutionfinder2.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tutionfinder2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TeacherSignup extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://tutionfinder2-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_signup);
        final EditText firstName =findViewById(R.id.Teacher_Firstname_Input);
        final EditText lastName =findViewById(R.id.Teacher_LastnameInput);
        final EditText phone = findViewById(R.id.Teacher_PhoneInput);
        final EditText email = findViewById(R.id.Teacher_EmailInput);
        final EditText password = findViewById(R.id.Teacher_PasswordInput);
        final EditText confirmPassword = findViewById(R.id.Teacher_ConfirmPasswordInput);

        final Button registerbutton = findViewById(R.id.button_TeacherRegister);


        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String FirstName = firstName.getText().toString();
                final String EmailTXT = email.getText().toString();
                final String LastName = lastName.getText().toString();
                final String phoneTXT = phone.getText().toString();
                final String phoneNO = phone.getText().toString();
                final String passwordTXT = password.getText().toString();
                final String confirmPassTXT = confirmPassword.getText().toString();

                if(FirstName.isEmpty()|| EmailTXT.isEmpty() || LastName.isEmpty() || phoneTXT.isEmpty() || passwordTXT.isEmpty() || confirmPassTXT.isEmpty())
                {
                    Toast.makeText(TeacherSignup.this,"Please fill all credential",Toast.LENGTH_LONG).show();
                }
                else if(!passwordTXT.equals(confirmPassTXT))
                {
                    Toast.makeText(TeacherSignup.this,"Password not matching!!",Toast.LENGTH_LONG).show();
                }
                else
                {

                    databaseReference.child("Registered_User").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // Code to check the number is register before

                            if (snapshot.hasChild(phoneTXT))
                            {
                                Toast.makeText(TeacherSignup.this,"The Phone Number is already registered",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {

                                databaseReference.child("Registered_User").child(phoneTXT).child("Firstname").setValue(FirstName);
                                databaseReference.child("Registered_User").child(phoneTXT).child("Lastname").setValue(LastName);
                                databaseReference.child("Registered_User").child(phoneTXT).child("email").setValue(EmailTXT);
                                databaseReference.child("Registered_User").child(phoneTXT).child("Password").setValue(passwordTXT);
                                databaseReference.child("Registered_User").child(phoneTXT).child("ID").setValue(phoneNO);

                                Toast.makeText(TeacherSignup.this,"User Register Successfully",Toast.LENGTH_SHORT).show();

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