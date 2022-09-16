package com.example.assignm_1_bscs_19011519_006;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SupervisorSelectionFormAdapter extends RecyclerView.Adapter<SupervisorSelectionFormAdapter.MyViewHolder> {

    public List<SupervisorSelectionForm> ssfList = new ArrayList<>();

    public List<SupervisorSelectionForm> getSupervisorSelectionFormList() {
        return ssfList;
    }

    public void setSupervisorSelectionFormList(List<SupervisorSelectionForm> supervisorSelectionFormList) {
        this.ssfList = supervisorSelectionFormList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //SupervisorSelectionForm item = ssfList.get(position);
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.supervisorselection_layout,parent,false);

        view.findViewById(R.id.btn_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ssfList.remove(viewType);
                notifyDataSetChanged();
            }
        });

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvCName.setText(ssfList.get(position).getCandidateName());
        holder.tvRegNo.setText(ssfList.get(position).getRegistrationNo());
        holder.tvDate.setText(ssfList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return ssfList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvCName;
        TextView tvRegNo;
        TextView tvDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCName = itemView.findViewById(R.id.txt_CName);
            tvRegNo = itemView.findViewById(R.id.txt_RegNo);
            tvDate = itemView.findViewById(R.id.txt_Date);
        }
    }
}
