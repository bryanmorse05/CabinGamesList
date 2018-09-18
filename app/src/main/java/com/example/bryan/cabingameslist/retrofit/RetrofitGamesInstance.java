package com.example.bryan.cabingameslist.retrofit;

import android.util.JsonReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStreamReader;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGamesInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://script.googleusercontent.com/macros/";

    public static Retrofit getRetrofitInstance() {

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofit;
    }
}
