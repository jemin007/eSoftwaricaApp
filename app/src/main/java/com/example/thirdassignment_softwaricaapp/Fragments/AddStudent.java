package com.example.thirdassignment_softwaricaapp.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.thirdassignment_softwaricaapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddStudent extends Fragment {

    private EditText etName, etAge, etAddress;
    private RadioButton radioButton;
    private Button btnRegister;
    private RadioGroup radioGroup;

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
        btnRegister = view.findViewById(R.id.btnRegister);

        return (view);
    }

}
