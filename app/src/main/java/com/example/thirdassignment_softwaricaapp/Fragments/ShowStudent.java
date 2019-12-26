package com.example.thirdassignment_softwaricaapp.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thirdassignment_softwaricaapp.Adapter.StudentsAdapter;
import com.example.thirdassignment_softwaricaapp.Dashboard;
import com.example.thirdassignment_softwaricaapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowStudent extends Fragment {

    RecyclerView recyclerView;
    public ShowStudent() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_student, container, false);
        recyclerView = view.findViewById(R.id.tvRecycleShow);
        if (Dashboard.studentsList.isEmpty()) {
            Toast.makeText(getContext(), "Empty", Toast.LENGTH_SHORT).show();
        }
        else {
            StudentsAdapter studentsAdapter = new StudentsAdapter(getContext(), Dashboard.studentsList);
            recyclerView.setAdapter(studentsAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }

        return view;
    }

}
