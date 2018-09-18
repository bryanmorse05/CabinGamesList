package com.example.bryan.cabingameslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.bryan.cabingameslist.adapter.VideosRecyclerAdapter;
import com.example.bryan.cabingameslist.model.CabinVideosModel;
import com.example.bryan.cabingameslist.retrofit.RetrofitVideosAPI;
import com.example.bryan.cabingameslist.retrofit.RetrofitGamesInstance;
import com.example.bryan.cabingameslist.retrofit.RetrofitVideosInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoListView_Activity extends AppCompatActivity {

    RecyclerView videosRecyclerView;
    VideosRecyclerAdapter adapter;

    ArrayList<CabinVideosModel> cabinVideosModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list_view_);


        //Setting up and enabling the back button in the support bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Past Cabin Videos");


        //Setting up the array
        cabinVideosModelArrayList = new ArrayList<>();

        //Setting recycler viewer to any size
        videosRecyclerView = findViewById(R.id.videosRecyclerView);
        videosRecyclerView.setHasFixedSize(false);

        adapter = new VideosRecyclerAdapter(cabinVideosModelArrayList);
        videosRecyclerView.setAdapter(adapter);

        videosRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        RetrofitVideosAPI retrofitVideosAPI = RetrofitVideosInstance.getRetrofitInstance().create(RetrofitVideosAPI.class);

        Call<List<CabinVideosModel>> call = retrofitVideosAPI.getEvents();

        call.enqueue(new Callback<List<CabinVideosModel>>() {
            @Override
            public void onResponse(Call<List<CabinVideosModel>> call, Response<List<CabinVideosModel>> response) {

                List<CabinVideosModel> eventsList = response.body();

                    for (int i = 0; i < eventsList.size(); i++) {
                        CabinVideosModel cabinVideosModel = new CabinVideosModel();

                        cabinVideosModel.setVideoYear(eventsList.get(i).getVideoYear());
                        cabinVideosModel.setVideoTitle(eventsList.get(i).getVideoTitle());
                        cabinVideosModel.setVideoURL((eventsList.get(i).getVideoURL()));
                        cabinVideosModel.setPictureURL(eventsList.get(i).getPictureURL());

                        //Check to see if the URL is empty.  If it is, Picasso will cause the app to crash
                        //because it does not like a null/empty field.  For whatever reason, I can't just
                        //pass eventsList.get(i).getImageURL into the if statement, it must be stored in
                        //a different variable.  By passing "none" at least it's not empty and Picasso
                        //will use the default value in the RecyclerAdapter.
                        String storedImageURL;
                        storedImageURL = eventsList.get(i).getPictureURL();
                        if (storedImageURL == null || storedImageURL == "") {
                            cabinVideosModel.setPictureURL("none");
                        } else {
                            cabinVideosModel.setPictureURL(eventsList.get(i).getPictureURL());
                        }

                        cabinVideosModelArrayList.add(cabinVideosModel);

                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<List<CabinVideosModel>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
