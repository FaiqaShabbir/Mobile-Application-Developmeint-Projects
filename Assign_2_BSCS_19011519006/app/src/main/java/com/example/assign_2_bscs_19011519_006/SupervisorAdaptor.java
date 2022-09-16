package com.example.assign_2_bscs_19011519_006;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SupervisorAdaptor extends RecyclerView.Adapter<SupervisorAdaptor.myViewHolder>{

    ArrayList<SupervisorModel> dataHolder;
    DBHelper2 db;
    private ArrayList sname,fname,regno, syno1, summ1, sign1, syno2, summ2, sign2, syno3, summ3, sign3;
    public SupervisorAdaptor(ArrayList<SupervisorModel> dataHolder) {
        this.dataHolder = dataHolder;
        sname = new ArrayList();
        fname = new ArrayList();
        regno = new ArrayList();
        syno1 = new ArrayList();
        summ1 = new ArrayList();
        sign1 = new ArrayList();
        syno2 = new ArrayList();
        summ2 = new ArrayList();
        sign2 = new ArrayList();
        syno3 = new ArrayList();
        summ3 = new ArrayList();
        sign3 = new ArrayList();

    }
    @NonNull
    @Override
    // convert xml to view
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.supervisoradaptor,parent,false);
        return new myViewHolder(view);
    }

    @Override
    //set data in arraylist through references
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.sname.setText(dataHolder.get(position).getStudentName());
        holder.fname.setText(dataHolder.get(position).getFatherName());
        holder.regno.setText(dataHolder.get(position).getRegistrationNo());
        holder.syno1.setText(dataHolder.get(position).getSynop1());
        holder.summ1.setText(dataHolder.get(position).getSumm1());
        holder.sign1.setText(dataHolder.get(position).getSign1());
        holder.syno2.setText(dataHolder.get(position).getSynop2());
        holder.summ2.setText(dataHolder.get(position).getSumm2());
        holder.sign2.setText(dataHolder.get(position).getSign2());
        holder.syno3.setText(dataHolder.get(position).getSynop3());
        holder.summ3.setText(dataHolder.get(position).getSumm3());
        holder.sign3.setText(dataHolder.get(position).getSign3());

        db = new DBHelper2(holder.itemView.getContext());
        holder.itemView.findViewById(R.id.btn_Del).setOnClickListener(v -> {
            String StudentNAme = dataHolder.get(position).getStudentName();

            dataHolder.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, dataHolder.size());

            boolean check = db.deleteUserData(StudentNAme);
        });


        holder.itemView.findViewById(R.id.btn_Edit).setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, UpdateRecord.class);



            intent.putExtra("sname", String.valueOf(holder.sname.getText()));
            Log.i("tests", "onBindViewHolder: " + holder.sname.getText());
            intent.putExtra("fname", String.valueOf(holder.fname.getText()));
            intent.putExtra("regno", String.valueOf(holder.regno.getText()));
            intent.putExtra("syno1", String.valueOf(holder.syno1.getText()));
            intent.putExtra("summ1", String.valueOf(holder.summ1.getText()));
            intent.putExtra("sign1", String.valueOf(holder.sign1.getText()));
            intent.putExtra("syno2", String.valueOf(holder.syno2.getText()));
            intent.putExtra("summ2", String.valueOf(holder.summ2.getText()));
            intent.putExtra("sign2", String.valueOf(holder.sign2.getText()));
            intent.putExtra("syno3", String.valueOf(holder.syno3.getText()));
            intent.putExtra("summ3", String.valueOf(holder.summ3.getText()));
            intent.putExtra("sign3", String.valueOf(holder.sign3.getText()));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView sname,fname,regno, syno1, summ1, sign1, syno2, summ2, sign2, syno3, summ3, sign3;
        Button btn;
        public myViewHolder(@NonNull View itemView)
        {
            super(itemView);
            sname=itemView.findViewById(R.id.studentName);
            fname=itemView.findViewById(R.id.fatherName);
            regno=itemView.findViewById(R.id.registrationNo);
            syno1=itemView.findViewById(R.id.synop1);
            summ1=itemView.findViewById(R.id.Summ1);
            sign1=itemView.findViewById(R.id.SupSign1);
            syno2=itemView.findViewById(R.id.Synop2);
            summ2=itemView.findViewById(R.id.Summ2);
            sign2=itemView.findViewById(R.id.SupSign2);
            syno3=itemView.findViewById(R.id.Synop3);
            summ3=itemView.findViewById(R.id.Summ3);
            sign3=itemView.findViewById(R.id.SupSign3);
            btn = itemView.findViewById(R.id.btn_Edit);
        }
    }
}
