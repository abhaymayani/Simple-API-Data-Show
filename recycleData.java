package com.puzzle4kids.mysimpleapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class recycleData extends RecyclerView.Adapter<recycleData.viewHolder> {
    DataActivity dataActivity;
    ArrayList<StudentData> arrayList;

    public recycleData(DataActivity dataActivity, ArrayList<StudentData> arrayList) {
        this.dataActivity = dataActivity;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public recycleData.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(dataActivity).inflate(R.layout.recycldatalayout, parent, false);
        viewHolder viewHolder = new viewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull recycleData.viewHolder holder, int position) {

        StudentData studentData = arrayList.get(position);

        String name = studentData.getS_name();
        String grno = studentData.getS_grno();
        String email = studentData.getS_email();
        String photo = studentData.getS_photo();
        String sem = studentData.getS_sem();
        String div = studentData.getS_div();
        String rollno = studentData.getS_rollno();
        String gender = studentData.getS_gender();


        holder.grno.setText(grno);
        holder.rollno.setText(rollno);
        holder.gender.setText(gender);
        holder.name.setText(name);
        holder.email.setText(email);
        holder.div.setText(div);
        holder.sem.setText(sem);
        Glide.with(dataActivity).load(photo).into(holder.photo);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView photo;
        TextView sem, div, name, email, gender, rollno, grno;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.photo);
            sem = itemView.findViewById(R.id.sem);
            div = itemView.findViewById(R.id.div);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            gender = itemView.findViewById(R.id.gender);
            rollno = itemView.findViewById(R.id.rollno);
            grno = itemView.findViewById(R.id.grno);
        }
    }
}
