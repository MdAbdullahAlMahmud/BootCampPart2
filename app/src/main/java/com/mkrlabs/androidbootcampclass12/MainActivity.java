package com.mkrlabs.androidbootcampclass12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText emailEDT,passwordEDT;
    Button saveButton;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSP();

        emailEDT = findViewById(R.id.emailEDT);
        passwordEDT = findViewById(R.id.passwordEDT);
        saveButton = findViewById(R.id.saveButton);

        boolean states = sharedPreferences.getBoolean("status",false);
        if (states){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEDT.getText().toString();
                String password = passwordEDT.getText().toString();

                if (TextUtils.isEmpty(email)){
                    emailEDT.setError("required");
                    return;
                }
                 if (TextUtils.isEmpty(password)){
                    passwordEDT.setError("required");
                    return;
                }

                 editor.putString("email",email);
                 editor.putString("password",password);
                 editor.putBoolean("status",true);
                 editor.apply();

                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                 startActivity(intent);
                 finish();

            }
        });


    }

    private void initSP() {
        sharedPreferences = getSharedPreferences("config",MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
}