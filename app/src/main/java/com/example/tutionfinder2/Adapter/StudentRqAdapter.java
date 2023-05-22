package com.example.tutionfinder2.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutionfinder2.Model.StudentRqModel;
import com.example.tutionfinder2.R;

import java.util.List;

public class StudentRqAdapter extends RecyclerView.Adapter<StudentRqAdapter.ViewHolder> {

     Context context;
     List<StudentRqModel>models;

    public StudentRqAdapter(Context context,List<StudentRqModel>models)
    {
        this.models=models;
        this.context=context;
    }

    @NonNull
    @Override
    public StudentRqAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_request,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentRqAdapter.ViewHolder holder, int position) {

        StudentRqModel model =models.get(position);
        holder.fName.setText(" Full Name-"+model.getFullNameStudent());
        holder.age.setText(" Age-"+model.getAge());
        holder.gender.setText(" Gender-"+model.getGender());
        holder.state.setText(" State-"+model.getState());
        holder.college.setText(" College Name-"+model.getCollege_Name());
        holder.sem.setText(" Current Sem-"+model.getCurrent_Sem());
        holder.query.setText(" Student's Query-"+model.getQuery());
        holder.active_ph.setText(" Student Contact-"+model.getActive_Ph());
        holder.preferableTime.setText(" Available Time For Call-"+model.getPreferableTime());
        holder.stream.setText(" Pursuing-"+model.getStream());


    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView fName,age ,gender,state,college,sem,query,active_ph,preferableTime,stream;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fName=itemView.findViewById(R.id.q_FNreceived);
            age=itemView.findViewById(R.id.q_ageReceived);
            gender=itemView.findViewById(R.id.q_genderReceived);
            state=itemView.findViewById(R.id.q_state);
            college=itemView.findViewById(R.id.q_CollegeNameRecieved);
            sem=itemView.findViewById(R.id.q_semReceived);
            query=itemView.findViewById(R.id.q_TextRecieved);
            active_ph=itemView.findViewById(R.id.q_PhoneReceived);
            preferableTime=itemView.findViewById(R.id.q_PreferableTimeRecieved);
            stream=itemView.findViewById(R.id.q_StreamRecieved);
        }
    }
}
