package com.mkrlabs.androidbootcampclass12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mkrlabs.androidbootcampclass12.dao.PersonDAO;
import com.mkrlabs.androidbootcampclass12.database.AppDatabase;
import com.mkrlabs.androidbootcampclass12.entity.Person;

import java.util.List;

public class PersonHomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PersonAdapter adapter;
    AppDatabase appDatabase;
    List<Person> personList;
    private FloatingActionButton personAddButtonFloting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_home);
        inits();

        appDatabase = AppDatabase.getInstance(this);
        Person person = new Person("Abdullah","01303156228","mmunna864@gmail.com");
        //appDatabase.personDAO().insertPerson(person);



        personList = appDatabase.personDAO().getAllPerson();
        adapter = new PersonAdapter(this,personList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        personAddButtonFloting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PersonHomeActivity.this,AddPersonActivity.class));
            }
        });
    }

    private void inits() {
        recyclerView=findViewById(R.id.personRV);
        personAddButtonFloting=findViewById(R.id.personAddButtonFloting);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

    }

}