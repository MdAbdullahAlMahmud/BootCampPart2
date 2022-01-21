package com.mkrlabs.androidbootcampclass12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView userEmailTV;
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences = getSharedPreferences("config",MODE_PRIVATE);

        editor = sharedPreferences.edit();

        userEmailTV= findViewById(R.id.userEmailTV);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        userEmailTV.setText(sharedPreferences.getString("email", "Empty"));
        bottomNavigation.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){
                    case R.id.rateUsMenuItem:
                        Toast.makeText(HomeActivity.this, "Rate Us", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.logOutMenuItem:
                        Toast.makeText(HomeActivity.this, "Log Out  Us", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.addPersonMenu:
                        return true;
                    default:
                        return false;

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.rateUsMenuItem:
                startActivity(new Intent(HomeActivity.this,PersonHomeActivity.class));
                return true;

            case R.id.logOutMenuItem:

                editor.putBoolean("status",false);
                editor.apply();
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }



    }
}