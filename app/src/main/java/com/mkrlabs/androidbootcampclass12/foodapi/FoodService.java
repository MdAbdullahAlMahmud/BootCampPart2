package com.mkrlabs.androidbootcampclass12.foodapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodService {

    @GET("categories.php")
    Call<Categories> getAllCategories();

    @GET("search.php?s=Arrabiata")
    Call<Meals> getFoodBySearch();
}
