package com.example.thirdassignment_softwaricaapp.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.thirdassignment_softwaricaapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddStudent extends Fragment {

    EditText etName, etAge, etAddress;
    RadioButton etMale, etFemale, etOther;
    Button btnRegister;

    public AddStudent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_add_student, container, false);
    }

}
