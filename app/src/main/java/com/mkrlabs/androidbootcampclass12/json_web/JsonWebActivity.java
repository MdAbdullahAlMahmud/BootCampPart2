package com.mkrlabs.androidbootcampclass12.json_web;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mkrlabs.androidbootcampclass12.CategoryItem;
import com.mkrlabs.androidbootcampclass12.Food;
import com.mkrlabs.androidbootcampclass12.R;
import com.mkrlabs.androidbootcampclass12.adapter.FoodAdapter;
import com.mkrlabs.androidbootcampclass12.foodapi.Categories;
import com.mkrlabs.androidbootcampclass12.foodapi.FoodClient;
import com.mkrlabs.androidbootcampclass12.foodapi.FoodService;
import com.mkrlabs.androidbootcampclass12.foodapi.Meals;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonWebActivity extends AppCompatActivity {

    private ArrayList<Food> foodArrayList;
    String jsonFile = "{\n" +
            "  \"categories\": [\n" +
            "    {\n" +
            "      \"idCategory\": \"1\",\n" +
            "      \"strCategory\": \"Beef\",\n" +
            "      \"strCategoryThumb\": \"https://www.themealdb.com/images/category/beef.png\",\n" +
            "      \"strCategoryDescription\": \"Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.[1] Beef is a source of high-quality protein and essential nutrients.[2]\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"idCategory\": \"1\",\n" +
            "      \"strCategory\": \"vegetables\",\n" +
            "      \"strCategoryThumb\": \"https://www.themealdb.com/images/category/beef.png\",\n" +
            "      \"strCategoryDescription\": \"Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.[1] Beef is a source of high-quality protein and essential nutrients.[2]\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"idCategory\": \"2\",\n" +
            "      \"strCategory\": \"Chicken\",\n" +
            "      \"strCategoryThumb\": \"https://www.themealdb.com/images/category/chicken.png\",\n" +
            "      \"strCategoryDescription\": \"Chicken is a type of domesticated fowl, a subspecies of the red junglefowl. It is one of the most common and widespread domestic animals, with a total population of more than 19 billion as of 2011.[1] Humans commonly keep chickens as a source of food (consuming both their meat and eggs) and, more rarely, as pets.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"idCategory\": \"3\",\n" +
            "      \"strCategory\": \"Dessert\",\n" +
            "      \"strCategoryThumb\": \"https://www.themealdb.com/images/category/dessert.png\",\n" +
            "      \"strCategoryDescription\": \"Dessert is a course that concludes a meal. The course usually consists of sweet foods, such as confections dishes or fruit, and possibly a beverage such as dessert wine or liqueur, however in the United States it may include coffee, cheeses, nuts, or other savory items regarded as a separate course elsewhere. In some parts of the world, such as much of central and western Africa, and most parts of China, there is no tradition of a dessert course to conclude a meal.\\r\\n\\r\\nThe term dessert can apply to many confections, such as biscuits, cakes, cookies, custards, gelatins, ice creams, pastries, pies, puddings, and sweet soups, and tarts. Fruit is also commonly found in dessert courses because of its naturally occurring sweetness. Some cultures sweeten foods that are more commonly savory to create desserts.\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    private RecyclerView foodRV;
    private ArrayList<CategoryItem> categoryItems;
    private FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_web);
        foodArrayList = new ArrayList<>();
        categoryItems = new ArrayList<>();

        foodRV =findViewById(R.id.foodRV);
        foodRV.setHasFixedSize(true);
        foodRV.setLayoutManager(new LinearLayoutManager(this));

       /* try {
            JSONObject jsonObject = new JSONObject(jsonFile);
            JSONArray array = jsonObject.getJSONArray("categories");

            for (int i=0;i<array.length();i++){
                JSONObject food = array.getJSONObject(i);
                String id = food.getString("idCategory");
                String name = food.getString("strCategory");
                String url = food.getString("strCategoryThumb");
                String desc = food.getString("strCategoryDescription");


                Food item = new Food(id,name,url,desc);
                foodArrayList.add(item);



                String foodItem = "ID "+ id +"\n"+
                        "Name "+ name +"\n"+
                        "URl "+ url +"\n"+
                        "Desc "+ desc +"\n";

                Log.v("Food", foodItem);



            }


            JSONObject singleObject = array.getJSONObject(1);





        } catch (JSONException e) {
            e.printStackTrace();
        }*/


        FoodService foodService = FoodClient.getInstance().create(FoodService.class);

        foodService.getAllCategories().enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {

                if (response.code()==200){

                    Categories categories = response.body();

                    categoryItems.addAll(categories.getCategories());

                    adapter = new FoodAdapter(JsonWebActivity.this,categoryItems);
                    foodRV.setAdapter(adapter);
                    adapter.notifyDataSetChanged();


                }

            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                Toast.makeText(JsonWebActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });


        foodService.getFoodBySearch().enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {

            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {

            }
        });


    }
}