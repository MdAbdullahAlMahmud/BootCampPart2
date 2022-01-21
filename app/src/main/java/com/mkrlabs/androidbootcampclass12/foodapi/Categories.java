package com.mkrlabs.androidbootcampclass12.foodapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mkrlabs.androidbootcampclass12.CategoryItem;

import java.util.List;

public class Categories {
    @SerializedName("categories")
    @Expose
    private List<CategoryItem> categories = null;

    public List<CategoryItem> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryItem> categories) {
        this.categories = categories;
    }
}
