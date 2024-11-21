package com.example.retrofit.service;

import com.example.retrofit.models.Distributor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import java.util.ArrayList;
import java.util.List;

public class HttpRequest {
    ApiService requestApiService;

    public HttpRequest(String baseUrl){
        requestApiService=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService.class);
    }
    public  ApiService getApiService(){
        return requestApiService;
    }

}
