package com.wiselteach.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//TODO(12): StudentAdapter extends RecyclerView Adapter with ViewHolder class


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    //TODO(13): Create two empty arrayList and one context variable;

    Context mainActivityContext;
    ArrayList<String> namesArrayList = new ArrayList<>();
    ArrayList<String> mobileArrayList = new ArrayList<>();

    //TODO(14): Create one constructor with three parameters which will passed from MainActivity class

    public StudentAdapter(Context mainActivityContext, ArrayList<String> namesArrayList, ArrayList<String> mobileArrayList) {
        this.mainActivityContext = mainActivityContext;
        this.namesArrayList = namesArrayList;
        this.mobileArrayList = mobileArrayList;
    }

    //TODO(15): Complete each method as mentioned below


    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Used to connect our custom UI to our recycler view

        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_student, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(StudentAdapter.ViewHolder holder, int position) {
        //Used to set data in each row of recycler view

        String currentName = namesArrayList.get(position);
        String currentMobileNumber = mobileArrayList.get(position);

        holder.tvName.setText(currentName);
        holder.tvMobileNumber.setText(currentMobileNumber);

    }

    @Override
    public int getItemCount() {
        //Returns total number of rows inside recycler view

        return namesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Used to work with the elements of our custom UI.

        LinearLayout llItemStudents;

        TextView tvName;
        TextView tvMobileNumber;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvStudentName);
            tvMobileNumber = (TextView) itemView.findViewById(R.id.tvMobileNumber);

            llItemStudents = (LinearLayout) itemView.findViewById(R.id.llItemStudents);

            llItemStudents.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mainActivityContext,
                            "You clicked item number: "+ getAdapterPosition(),
                            Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
