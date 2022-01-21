package com.mkrlabs.androidbootcampclass12.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mkrlabs.androidbootcampclass12.entity.Person;

import java.util.List;

@Dao
public interface PersonDAO {

    @Query("select * from person")
    List<Person> getAllPerson();

    @Insert()
    long  insertPerson(Person person);
}
