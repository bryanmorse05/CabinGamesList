package com.example.bryan.cabingameslist.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitVideosInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://script.googleusercontent.com/a/macros/phunware.com/";

    public static Retrofit getRetrofitInstance() {

        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
