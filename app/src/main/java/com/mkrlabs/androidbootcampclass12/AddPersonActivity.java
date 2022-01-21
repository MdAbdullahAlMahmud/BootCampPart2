package com.mkrlabs.androidbootcampclass12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mkrlabs.androidbootcampclass12.dao.PersonDAO;
import com.mkrlabs.androidbootcampclass12.database.AppDatabase;
import com.mkrlabs.androidbootcampclass12.entity.Person;

public class AddPersonActivity extends AppCompatActivity {

    private EditText nameEdt,phoneEdt,emailEdt;
    private Button addPersonButton;
    private PersonDAO personDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        init_field();

        addPersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEdt.getText().toString().trim();
                String phone = phoneEdt.getText().toString().trim();
                String email = emailEdt.getText().toString().trim();

                if (TextUtils.isEmpty(name)){
                    nameEdt.setError("required");
                    return;
                }
                 if (TextUtils.isEmpty(phone)){
                    phoneEdt.setError("required");
                    return;
                }
                 if (TextUtils.isEmpty(email)){
                    emailEdt.setError("required");
                    return;
                }

                 addPersonToDB(name,phone,email);


            }
        });

    }

    private void addPersonToDB(String name, String phone, String email) {
        Person person = new Person(name,phone,email);
        personDAO = AppDatabase.getInstance(AddPersonActivity.this).personDAO();

        long successId = personDAO.insertPerson(person);
        if (successId>0){
            Toast.makeText(AddPersonActivity.this, "Successfully Added", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(AddPersonActivity.this,PersonHomeActivity.class));

        }else {
            Toast.makeText(AddPersonActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
        }




    }

    private void init_field() {
        nameEdt = findViewById(R.id.userNameEdt);
        phoneEdt = findViewById(R.id.userPhoneEdt);
        emailEdt = findViewById(R.id.userEmailEdt);
        addPersonButton = findViewById(R.id.addPersonButton);
    }
}