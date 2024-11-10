package com.example.appcep;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;


public class APIClientSingleton {
    private static Retrofit retrofit = null;

    static Retrofit getClient() {


        retrofit = new Retrofit.Builder()
                .baseUrl("https://viacep.com.br/ws/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();



        return retrofit;
    }
}
