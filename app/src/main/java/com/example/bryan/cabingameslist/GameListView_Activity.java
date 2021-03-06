package com.example.bryan.cabingameslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.bryan.cabingameslist.adapter.RecyclerAdapter;
import com.example.bryan.cabingameslist.model.CabinGamesModel;
import com.example.bryan.cabingameslist.retrofit.RetrofitAPI;
import com.example.bryan.cabingameslist.retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameListView_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    ArrayList<CabinGamesModel> cabinGamesModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list_view);

        //Look I made a comment
        cabinGamesModelArrayList = new ArrayList<>();

        //more comments
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(false);

        adapter = new RecyclerAdapter(cabinGamesModelArrayList);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RetrofitAPI retrofitAPI = RetrofitInstance.getRetrofitInstance().create(RetrofitAPI.class);

        Call<List<CabinGamesModel>> call = retrofitAPI.getEvents();

        call.enqueue(new Callback<List<CabinGamesModel>>() {
            @Override
            public void onResponse(Call<List<CabinGamesModel>> call, Response<List<CabinGamesModel>> response) {

                List<CabinGamesModel> eventsList = response.body();

                for (int i = 0; i < eventsList.size(); i++) {

                    CabinGamesModel cabinGamesModel = new CabinGamesModel();

                    cabinGamesModel.setName(eventsList.get(i).getName());
                    cabinGamesModel.setOwner(eventsList.get(i).getOwner());
                    cabinGamesModel.setPlayers((eventsList.get(i).getPlayers()));
                    cabinGamesModel.setTime(eventsList.get(i).getTime());
                    cabinGamesModel.setDescription(eventsList.get(i).getDescription());

                    //Check to see if the URL is empty.  If it is, Picasso will cause the app to crash
                    //because it does not like a null/empty field.  For whatever reason, I can't just
                    //pass eventsList.get(i).getImageURL into the if statement, it must be stored in
                    //a different variable.  By passing "none" at least it's not empty and Picasso
                    //will use the default value in the RecyclerAdapter.
                    String storedImageURL;
                    storedImageURL = eventsList.get(i).getImageURL();
                    if (storedImageURL == null || storedImageURL == "") {
                        cabinGamesModel.setImageURL("none");
                    }
                    else {
                        cabinGamesModel.setImageURL(eventsList.get(i).getImageURL());
                    }

                    cabinGamesModelArrayList.add(cabinGamesModel);

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<CabinGamesModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });


    }
}
