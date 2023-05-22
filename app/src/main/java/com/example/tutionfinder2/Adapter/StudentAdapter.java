package com.example.tutionfinder2.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutionfinder2.Model.CourseModel;
import com.example.tutionfinder2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> implements Filterable {
    Context context;
    public List<CourseModel> courseModelList;
    public List<CourseModel> exampleWistful;
    private final setOnclick callBack;

    public StudentAdapter(Context context, List<CourseModel> courseModelList, setOnclick callBack) {
        this.context = context;
        this.courseModelList = courseModelList;
        exampleWistful = new ArrayList<>(courseModelList); // As we want just a copy of this List
        this.callBack = callBack;
    }

    public void update() {
        exampleWistful = new ArrayList<>(courseModelList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_for_recyclerview, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CourseModel courseModel = courseModelList.get(position);
        holder.fee_struc.setText("Fee Structure-" + courseModel.getFee());
        holder.FName.setText("Full Name - " + courseModel.getFullName());
        holder.Qualification_has.setText("Qualification - " + courseModel.getQualification());
        holder.Subjects_offer.setText("Subject - " + courseModel.getSubjects());
        holder.Conatact_info.setText("Contact - " + courseModel.getContact());
        holder.Descrip.setText(courseModel.getDescription());
        String imageUri = null;
        imageUri = courseModel.getImage();
        Picasso.get().load(imageUri).into(holder.imageView_fetch);


        holder.button.setOnClickListener(v -> callBack.onClick(courseModel.getID()));

        //   Log.d("TAG", "onBindViewHolder: "+courseModel.getFee());


    }

    @Override
    public int getItemCount() {
        return courseModelList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    public Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<CourseModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleWistful);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (CourseModel items : exampleWistful) {
                    if (items.getSubjects().toLowerCase().contains(filterPattern)) {
                        filteredList.add(items);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            courseModelList.clear();
            courseModelList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_fetch;
        TextView FName, Subjects_offer, Qualification_has, Conatact_info, fee_struc, Descrip;
        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_fetch = itemView.findViewById(R.id.Image_reieved);
            FName = itemView.findViewById(R.id.FullName_recieved);
            Subjects_offer = itemView.findViewById(R.id.Subject_recieved);
            Qualification_has = itemView.findViewById(R.id.Qualification_recieved);
            Conatact_info = itemView.findViewById(R.id.Contact_recieved);
            fee_struc = itemView.findViewById(R.id.Fee_recieved);
            Descrip = itemView.findViewById(R.id.Description_recieved);
            button = itemView.findViewById(R.id.quick_ChatBtnID);
        }

    }

    public interface setOnclick {
        void onClick(String receiver);
    }

}
