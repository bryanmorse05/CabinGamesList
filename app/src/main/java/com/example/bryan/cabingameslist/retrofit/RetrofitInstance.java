package com.example.bryan.cabingameslist.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;
    private static Gson gson;
    private static final String BASE_URL = "https://script.googleusercontent.com/a/macros/phunware.com/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null || gson == null) {

            gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
