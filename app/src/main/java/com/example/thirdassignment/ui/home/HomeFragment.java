package com.example.thirdassignment.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thirdassignment.MainActivity;
import com.example.thirdassignment.R;
import com.example.thirdassignment.StudentAdapter;
import com.example.thirdassignment.model.Student;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView recyclerView;
    List<Student> students = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=root.findViewById(R.id.recycleviewstudents);

        if(MainActivity.stud.isEmpty()) {
            MainActivity.stud.add(new Student("Jay Kate", "Female", "21", "America"));
            MainActivity.stud.add(new Student("Jesus Christ", "Male", "101", "Nepal"));

           StudentAdapter adapter = new StudentAdapter(MainActivity.stud, getContext());
            // StudentAdapter adapter = new StudentAdapter(MainActivity.stud, getContext());

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());

            recyclerView.setLayoutManager(layoutManager);

            recyclerView.setAdapter(adapter);
        }else {
            StudentAdapter adapter2 = new StudentAdapter(MainActivity.stud, getContext());
            RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this.getContext());
            recyclerView.setLayoutManager(layoutManager2);
            recyclerView.setAdapter(adapter2);
        }
        return root;
    }
}