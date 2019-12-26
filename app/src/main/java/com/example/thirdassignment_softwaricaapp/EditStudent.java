package com.example.thirdassignment_softwaricaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.RadialGradient;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EditStudent extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    EditText editName,editAge, editAddress;
    RadioGroup rGender;
    RadioButton editMale, editFemale, editOther;
    Button btnSave;
    String name, address, gender;
    int age;
public static int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        editAddress = findViewById(R.id.editAddress);
        btnSave= findViewById(R.id.btnSave);
        rGender = findViewById(R.id.editRadioGroup);
        editMale = findViewById(R.id.editMale);
        editFemale = findViewById(R.id.editFemale);
        editOther = findViewById(R.id.editOther);
        editName.setText(Dashboard.studentsList.get(index).getName());
        editAge.setText(Dashboard.studentsList.get(index).getAge() + "");
        editAddress.setText(Dashboard.studentsList.get(index).getAddress());
        gender = Dashboard.studentsList.get(index).getGender();

        if (gender == "Male") {
            editMale.setChecked(true);
            editFemale.setChecked(false);
            editOther.setChecked(false);
        } else if (gender == "Female") {
            editMale.setChecked(false);
            editFemale.setChecked(true);
            editOther.setChecked(false);
        }
        if (gender == "Other") {
            editMale.setChecked(false);
            editFemale.setChecked(false);
            editOther.setChecked(true);
        }
        rGender.setOnCheckedChangeListener(this);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    name = editName.getText().toString();
                    address = editAddress.getText().toString();
                    age = Integer.parseInt(editAge.getText().toString());
                    try {
                        Dashboard.studentsList.get(index).setName(name);
                        Dashboard.studentsList.get(index).setAddress(address);
                        Dashboard.studentsList.get(index).setAge(age);
                        Dashboard.studentsList.get(index).setGender(gender);
                        Toast.makeText(EditStudent.this, "The record has been updated!", Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(EditStudent.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private boolean validate() {
        if (TextUtils.isEmpty(editName.getText())) {
            editName.setError("Enter your full name");
            editName.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(editAge.getText())) {
            editAge.setError("Enter new age");
            editAge.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(editAddress.getText())) {
            editAddress.setError("Enter new address");
            editAddress.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(gender)) {
            Toast.makeText(EditStudent.this, "Please select gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.editMale) {
            gender = "Male";
        }
        if (checkedId == R.id.editFemale) {
            gender = "Female";
        }
        if (checkedId == R.id.editOther) {
            gender = "Other";
        }
    }
}
