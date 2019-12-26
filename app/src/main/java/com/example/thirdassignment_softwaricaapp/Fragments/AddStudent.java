package com.example.thirdassignment_softwaricaapp.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.thirdassignment_softwaricaapp.Dashboard;
import com.example.thirdassignment_softwaricaapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddStudent extends Fragment implements RadioGroup.OnCheckedChangeListener {

    private EditText etName, etAge, etAddress;
    private Button btnRegister;
    private RadioGroup rGroup;
    int age;
    String name,address,gender = "Male";

    public AddStudent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_student, container, false);
        etName = view.findViewById(R.id.etName);
        etAge = view.findViewById(R.id.etAge);
        etAddress = view.findViewById(R.id.etAddress);
        rGroup = view.findViewById(R.id.RadioGroup);
        btnRegister = view.findViewById(R.id.btnRegister);

        rGroup.setOnCheckedChangeListener(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    name = etName.getText().toString();
                    address = etAddress.getText().toString();
                    age = Integer.parseInt(etAge.getText().toString());
                    Dashboard.studentList.add(new Students(name,gender,age,address));
                    Toast.makeText(getContext(), "Student has been added succesfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return (view);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rdMale) {
            gender = "Male";
        }
        if (checkedId == R.id.rdFemale){
            gender = "Female";
        }
        if (checkedId == R.id.rdOther){
            gender = "Other";
        }
    }

    private boolean validate() {
        if (TextUtils.isEmpty(etName.getText())) {
            etName.setError("Enter full name");
            etName.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etAge.getText())) {
            etAge.setError("Enter the age");
            etAge.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etAddress.getText())) {
            etAddress.setError("Enter the address");
            etAddress.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(gender)) {
            Toast.makeText(getContext(), "Select gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
