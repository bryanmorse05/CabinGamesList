package com.rainy.bryan.cabingameslist.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.rainy.bryan.cabingameslist.R;
import com.rainy.bryan.cabingameslist.adapter.FriendsRecyclerAdapter;
import com.rainy.bryan.cabingameslist.model.CabinFriendsModel;
import com.rainy.bryan.cabingameslist.retrofit.RetrofitFriendsAPI;
import com.rainy.bryan.cabingameslist.retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Friends_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    FriendsRecyclerAdapter adapter;

    ArrayList<CabinFriendsModel> cabinFriendsModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_);

        //Setting up and enabling the back button in the support bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Your Friends");

        //Setting up the array
        cabinFriendsModelArrayList = new ArrayList<>();

        //Setting recycler viewer to any size
        recyclerView = findViewById(R.id.friendsRecyclerView);
        recyclerView.setHasFixedSize(false);

        adapter = new FriendsRecyclerAdapter(cabinFriendsModelArrayList);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RetrofitFriendsAPI retrofitFriendsAPI = RetrofitInstance.getRetrofitInstance().create(RetrofitFriendsAPI.class);

        Call<List<CabinFriendsModel>> call = retrofitFriendsAPI.getEvents();

        call.enqueue(new Callback<List<CabinFriendsModel>>() {
            @Override
            public void onResponse(Call<List<CabinFriendsModel>> call, Response<List<CabinFriendsModel>> response) {

                List<CabinFriendsModel> eventsList = response.body();

                for (int i = 0; i < eventsList.size(); i++) {

                    CabinFriendsModel cabinFriendsModel = new CabinFriendsModel();

                    cabinFriendsModel.setName(eventsList.get(i).getName());
                    cabinFriendsModel.setYear(eventsList.get(i).getYear());
                    cabinFriendsModel.setCabins((eventsList.get(i).getCabins()));
                    cabinFriendsModel.setPictureID(eventsList.get(i).getPictureID());

                    //Check to see if the URL is empty.  If it is, Picasso will cause the app to crash
                    //because it does not like a null/empty field.  For whatever reason, I can't just
                    //pass eventsList.get(i).getImageURL into the if statement, it must be stored in
                    //a different variable.  By passing "none" at least it's not empty and Picasso
                    //will use the default value in the RecyclerAdapter.
                    String storedImageURL;
                    storedImageURL = eventsList.get(i).getPictureID();
                    if (storedImageURL == null || storedImageURL == "") {
                        cabinFriendsModel.setPictureID("none");
                    }
                    else {
                        cabinFriendsModel.setPictureID(eventsList.get(i).getPictureID());
                    }

                    cabinFriendsModelArrayList.add(cabinFriendsModel);

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<CabinFriendsModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
