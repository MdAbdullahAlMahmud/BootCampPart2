package com.mkrlabs.androidbootcampclass12.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mkrlabs.androidbootcampclass12.dao.PersonDAO;
import com.mkrlabs.androidbootcampclass12.entity.Person;

@Database(entities = {Person.class},version = 1,exportSchema = true)
public  abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDAO personDAO();
    private static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context context){


        if (appDatabase==null){
            appDatabase = Room.databaseBuilder(context,AppDatabase.class,"person_db")
                    .allowMainThreadQueries()
                    .build();

        }
        return appDatabase;

    }



}
