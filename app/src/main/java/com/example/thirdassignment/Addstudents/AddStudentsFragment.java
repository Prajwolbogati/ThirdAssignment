package com.example.thirdassignment.Addstudents;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.thirdassignment.MainActivity;
import com.example.thirdassignment.R;
import com.example.thirdassignment.model.Student;

public class AddStudentsFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private AddStudentsViewModel mViewModel;
    private String fullname, gender, address, age;
    private EditText etfullname, etaddress, etage;
    private RadioGroup radiog;
    private Button btnsubmit;


    public static AddStudentsFragment newInstance() {
        return new AddStudentsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(AddStudentsViewModel.class);
        View root = inflater.inflate(R.layout.add_students_fragment, container, false);
        etfullname = root.findViewById(R.id.fullname);
        etaddress = root.findViewById(R.id.address);
        etage = root.findViewById(R.id.age);
        radiog = root.findViewById(R.id.gender);
        btnsubmit = root.findViewById(R.id.btnsave);

        radiog.setOnCheckedChangeListener(this);
        btnsubmit.setOnClickListener(this);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddStudentsViewModel.class);
        // TODO: Use the ViewModel
    }

    private boolean validate() {
        if (TextUtils.isEmpty(fullname)) {
            etfullname.setError("Please enter a name");
            etfullname.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(age)) {
            etage.setError("Please enter age");
            etage.requestFocus();
            return false;
        }

        if (!TextUtils.isDigitsOnly(age)) {
            etage.setError("Please enter age");
            etage.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(address)) {
            etaddress.setError("Please enter an address");
            etaddress.requestFocus();
            return false;
        }


        if (TextUtils.isEmpty(gender)) {
            Toast.makeText(getContext(), "Please select a gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        if (i == R.id.male) {
            gender = "Male";
            //Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.female) {
            gender = "Female";
            //Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.other) {
            gender = "Other";
            //Toast.makeText(this, "Other", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnsave) {

            fullname = etfullname.getText().toString();
            age = etage.getText().toString();
            address = etaddress.getText().toString();
            if (validate()) {
                MainActivity.stud.add(new Student(fullname, gender, age, address));
                //MainActivity.stud.add(new Student(fullname,gender,age,address));
                Toast.makeText(getContext(), "Student added", Toast.LENGTH_SHORT).show();

            }
        }
    }
}
