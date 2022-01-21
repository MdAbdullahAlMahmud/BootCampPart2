package com.mkrlabs.androidbootcampclass12.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.mkrlabs.androidbootcampclass12.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RestActivity extends AppCompatActivity {

    String jsonString = "{ \"Employee\" :[{\"id\":\"101\",\"name\":\"Sonoo Jaiswal\",\"salary\":\"50000\"},{\"id\":\"102\",\"name\":\"Vimal Jaiswal\",\"salary\":\"60000\"}] }";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray employeeArray = jsonObject.getJSONArray("Employee");

            int size = employeeArray.length();
            for (int i =0;i<size;i++){
                JSONObject employee = employeeArray.getJSONObject(i);

                if (employee.get("name")!=null){
                    String name = employee.get("name").toString();
                    Log.v("Name" , name);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}