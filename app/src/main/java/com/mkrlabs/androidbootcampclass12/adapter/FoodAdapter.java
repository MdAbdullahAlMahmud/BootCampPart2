package com.mkrlabs.androidbootcampclass12.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mkrlabs.androidbootcampclass12.CategoryItem;
import com.mkrlabs.androidbootcampclass12.R;
import com.mkrlabs.androidbootcampclass12.foodapi.Categories;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{

    private Context context;
    private ArrayList<CategoryItem> categoriesArrayList;

    public FoodAdapter(Context context, ArrayList<CategoryItem> categoriesArrayList) {
        this.context = context;
        this.categoriesArrayList = categoriesArrayList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.food_item,parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

        CategoryItem categoryItem = categoriesArrayList.get(position);
        holder.foodName.setText(categoryItem.getStrCategory());
        String url = categoryItem.getStrCategoryThumb();

        Glide.with(context)
                .load(url)
                .into(holder.foodImge);
    }

    @Override
    public int getItemCount() {
        return categoriesArrayList.size();
    }

    public  class FoodViewHolder extends RecyclerView.ViewHolder {

        public ImageView foodImge;
        public TextView foodName;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImge = itemView.findViewById(R.id.foodImage);
            foodName = itemView.findViewById(R.id.foodName);
        }
    }
}
