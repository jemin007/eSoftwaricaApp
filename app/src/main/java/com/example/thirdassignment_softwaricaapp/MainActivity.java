package com.example.thirdassignment_softwaricaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.thirdassignment_softwaricaapp.Fragments.ShowStudent;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valdidation(etUsername.getText().toString(), etPassword.getText().toString());
            }
        });


    }

    private void valdidation(String username, String password){
        if ((username.equals("softwarica")) && (password.equals("coventry"))){
             Intent intent = new Intent(MainActivity.this, Dashboard.class);
             startActivity(intent);
        }
    }
}
