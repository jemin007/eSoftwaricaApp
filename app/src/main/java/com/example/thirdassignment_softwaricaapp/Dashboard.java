package com.example.thirdassignment_softwaricaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.thirdassignment_softwaricaapp.Fragments.AboutUs;
import com.example.thirdassignment_softwaricaapp.Fragments.AddStudent;
import com.example.thirdassignment_softwaricaapp.Fragments.ShowStudent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {

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
