package com.rrinc.pustice.support;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rrinc.pustice.R;
import com.rrinc.pustice.UserprofileActivity;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {


    private Context nContext;
    private List<Students> studentsList;

    public StudentAdapter() {
    }

    public StudentAdapter(Context nContext, List<Students> studentsList) {
        this.nContext = nContext;
        this.studentsList = studentsList;
    }

    public void update(List<Students> result) {
        studentsList=new ArrayList<>();
        studentsList.addAll(result);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(nContext).inflate(R.layout.sample_view,parent,false);
        return new StudentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Students students = studentsList.get(position);

        holder.username.setText(students.getName());
        holder.profile_image.setImageResource(students.getPic());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nContext,UserprofileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("image",students.getPic());
                intent.putExtra("name",students.getName());
                intent.putExtra("dist",students.getDistname());
                intent.putExtra("blood",students.getBlood());
                intent.putExtra("nick",students.getNick());
                intent.putExtra("roll",students.getRoll());
                intent.putExtra("emil",students.getEmail());
                intent.putExtra("phn",students.getPhn());
                intent.putExtra("bod",students.getBod());
                intent.putExtra("schl",students.getSchl());
                intent.putExtra("clg",students.getClg());
                nContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView username;
        ImageView profile_image;
        CardView layout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.stdNm);
            profile_image = itemView.findViewById(R.id.stPic);
            layout = itemView.findViewById(R.id.cv);
        }
    }
}
