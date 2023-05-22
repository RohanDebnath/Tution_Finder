package com.example.tutionfinder2.Activities;

import static com.example.tutionfinder2.App.ME;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tutionfinder2.R;
import com.example.tutionfinder2.databinding.ActivityChatBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class chatActivity extends AppCompatActivity {
EditText FullName_stu,age,gender,state,college_name,stream,current_sem,query,activeph,preferabletime;
Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        FullName_stu=findViewById(R.id.fullName_query);
        age=findViewById(R.id.age_Query);
        gender=findViewById(R.id.gender_query);
        state=findViewById(R.id.state_query);
        college_name=findViewById(R.id.query_CollegeName);
        stream=findViewById(R.id.stream_Query);
        current_sem=findViewById(R.id.sem_query);
        query=findViewById(R.id.query_text);
        activeph=findViewById(R.id.query_contact);
        preferabletime=findViewById(R.id.query_time);

        submitBtn=findViewById(R.id.query_submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,Object>map=new HashMap<>();
                map.put("FullNameStudent",FullName_stu.getText().toString().trim());
                map.put("Age",age.getText().toString().trim());
                map.put("Gender",gender.getText().toString().trim());
                map.put("State",state.getText().toString().trim());
                map.put("College_Name",college_name.getText().toString().trim());
                map.put("Stream",stream.getText().toString().trim());
                map.put("Current_Sem",current_sem.getText().toString().trim());
                map.put("Active_Ph",activeph.getText().toString().trim());
                map.put("PreferableTime",preferabletime.getText().toString().trim());
                map.put("Query",query.getText().toString().trim());

                FirebaseDatabase.getInstance().getReference().child("StudentData").push().setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(chatActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();


                    }
                }).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(chatActivity.this,"Success",Toast.LENGTH_SHORT).show();

                    }
                });
            }

        });


    }

}