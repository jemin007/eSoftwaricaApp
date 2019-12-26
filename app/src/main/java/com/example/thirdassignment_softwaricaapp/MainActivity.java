package com.example.thirdassignment_softwaricaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thirdassignment_softwaricaapp.Fragments.ShowStudent;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etUsername.setSelection(0);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString(),
                        password = etPassword.getText().toString();

                if(validate()) {
                    if ((username.equals("softwarica") && (password.equals("coventry")))) {
                        Intent intent = new Intent(MainActivity.this, Dashboard.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, " The username or password is incorrect! ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

        private boolean validate() {
                if (TextUtils.isEmpty(etUsername.getText())) {
            etUsername.setError("Please provide username!");
            etUsername.requestFocus();
            return false;
                } else if (TextUtils.isEmpty(etPassword.getText())) {
            etPassword.setError("Please provide password!");
            etPassword.requestFocus();
            return false;
             }
                 return true;
                                }
}
