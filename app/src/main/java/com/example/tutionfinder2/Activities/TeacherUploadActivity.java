package com.example.tutionfinder2.Activities;

import static com.example.tutionfinder2.App.ME;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tutionfinder2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class TeacherUploadActivity extends AppCompatActivity {
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    ImageButton imageButton;
    EditText fullName,subjects,qualification,descrition,contact,fee;
    Button buttonupload;
    Uri imageUrl;
    DatabaseReference databaseReference ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_upload);
        imageButton=findViewById(R.id.Imagebutton);
        fullName=findViewById(R.id.fullName);
        qualification=findViewById(R.id.id_qualification);
        descrition=findViewById(R.id.id_description);
        contact=findViewById(R.id.id_contact);
        fee=findViewById(R.id.id_fee);
        subjects=findViewById(R.id.subjects_taught);
        buttonupload=findViewById(R.id.uploadBtn);


        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference().child("Teacher_Upload");;
        mStorage=FirebaseStorage.getInstance();
        ProgressDialog progressDialog= new ProgressDialog(this);


        // Image Loc fetch
        ActivityResultLauncher<String> mGetcontent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                // akahne Uri er result
                if(result!=null)
                {
                    imageButton.setImageURI(result);
                    imageUrl=result;
                }
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetcontent.launch("image/*");

            }
        });

        buttonupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FullN= fullName.getText().toString().trim();
                String Subjects_taught= subjects.getText().toString().trim();
                String Qualification= qualification.getText().toString().trim();
                String Description= descrition.getText().toString().trim();
                String Contact= contact.getText().toString().trim();
                String Fee= fee.getText().toString().trim();

                if(!(FullN.isEmpty() && Subjects_taught.isEmpty() && Qualification.isEmpty() && Description.isEmpty() && Contact.isEmpty()&& Fee.isEmpty() &&imageUrl!=null ))
                {
                    progressDialog.setMessage("Uploding Please Wait...");
                    progressDialog.show();
                    StorageReference filepath = mStorage.getReference().child("imagePost").child(imageUrl.getLastPathSegment());
                    filepath.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUri = taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    String t = task.getResult().toString();
                                    DatabaseReference newPost = mRef.push();
                                  //  newPost.child("userId").setValue(ME.getID());
                                    newPost.child("FullName").setValue(FullN);
                                    newPost.child("Subjects").setValue(Subjects_taught);
                                    newPost.child("Qualification").setValue(Qualification);
                                    newPost.child("Description").setValue(Description);
                                    newPost.child("Contact").setValue(Contact);
                                    newPost.child("Fee").setValue(Fee);
                                    newPost.child("Image").setValue(task.getResult().toString());
                                    Toast.makeText(TeacherUploadActivity.this,"Credential has been Uploaded",Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();
                                }
                            });
                        }
                    });
                }
            }
        });
    }
}