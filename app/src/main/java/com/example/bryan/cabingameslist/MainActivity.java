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

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    ArrayList<CabinGamesModel> cabinGamesModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
