package com.example.thirdassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thirdassignment.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {

    List<Student> stu_list = new ArrayList<>();
    Context contexts;

    public StudentAdapter(List<Student> stut_list, Context contexts) {
        this.stu_list = stut_list;
        this.contexts = contexts;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_student_adapter,parent,false);
        StudentHolder studentHolder = new StudentHolder(view);
        return studentHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, final int position) {
        final  Student stu = stu_list.get(position);

        holder.fullname.setText(stu.getFullname());
        holder.age.setText(stu.getAge());
        holder.address.setText(stu.getAddress());
        holder.gender.setText(stu.getGender());
//        holder.delete.setImageResource(R.drawable.ic_delete);
        holder.imageview.setImageDrawable(contexts.getResources().getDrawable(R.drawable.ic_delete));

        String gen= stu.getGender();

        if(gen=="Male"){
            holder.imageview.setImageResource(R.drawable.man);
//            holder.imageview.setImageDrawable(context.getResources().getDrawable(R.drawable.man));

        }
        else if(gen=="Female"){
            holder.imageview.setImageDrawable(contexts.getResources().getDrawable(R.drawable.woman));

        }
        else{
            holder.imageview.setImageDrawable(contexts.getResources().getDrawable(R.drawable.woman));


        }



        holder.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contexts,"Hey "+stu.getFullname(), Toast.LENGTH_SHORT).show();
            }
        });


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Student studen=stu_list.get(position);

                // Remove the item on remove/button click
                stu_list.remove(position);

                notifyItemRemoved(position);

                notifyItemRangeChanged(position,stu_list.size());

                // Show the removed item label
                Toast.makeText(contexts,"Removed : " + studen.getFullname(),Toast.LENGTH_SHORT).show();
            }
        });

    }



    @Override
    public int getItemCount() {
        return stu_list.size();
    }


    public class StudentHolder extends RecyclerView.ViewHolder {
        ImageView imageview,delete;
        TextView fullname,age,address,gender;
        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            imageview= itemView.findViewById(R.id.imageView2);
            fullname = itemView.findViewById(R.id.textView);
            age=itemView.findViewById(R.id.textView2);
            address=itemView.findViewById(R.id.textView3);
            gender =itemView.findViewById(R.id.textView4);
            delete=itemView.findViewById(R.id.stdelete);

        }
    }

}
