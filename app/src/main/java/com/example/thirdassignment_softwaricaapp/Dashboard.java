package com.example.thirdassignment_softwaricaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.thirdassignment_softwaricaapp.Adapter.Students;
import com.example.thirdassignment_softwaricaapp.Fragments.AboutUs;
import com.example.thirdassignment_softwaricaapp.Fragments.AddStudent;
import com.example.thirdassignment_softwaricaapp.Fragments.ShowStudent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    public static List<Students>studentsList = new ArrayList<>();
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.frag_container)!=null){

            if (savedInstanceState!=null)
            {
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ShowStudent showStudent = new ShowStudent();
            fragmentTransaction.add(R.id.frag_container,showStudent,null);
            fragmentTransaction.commit();

        }

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (studentsList.isEmpty()){
            studentsList.add(new Students("Jemin Shrestha", "Male", "Thamel", 21));
            studentsList.add(new Students("KP Oli", "Other", "Babarmahal", 69));
            studentsList.add(new Students("Sherey Sharma", "Female", "Chabhel", 34));
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new ShowStudent()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.home:
                            selectedFragment = new ShowStudent();
                            break;
                        case R.id.addStudent:
                            selectedFragment = new AddStudent();
                            break;
                        case R.id.about:
                            selectedFragment = new AboutUs();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,selectedFragment).commit();
                    return true;
                }
            };
}
