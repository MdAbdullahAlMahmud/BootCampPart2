package com.mkrlabs.androidbootcampclass12.foodapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodClient {

    private static String baseURL = "https://www.themealdb.com/api/json/v1/1/";

    public static Retrofit retrofit;

    public static Retrofit getInstance(){
        retrofit = new Retrofit.Builder().baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit;
    }
}
