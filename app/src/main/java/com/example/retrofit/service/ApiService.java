package com.example.retrofit.service;

import com.example.retrofit.models.Fruit;
import com.example.retrofit.models.ResposeData;
import com.example.retrofit.models.Distributor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    static  String URLDistributor ="http://10.0.3.2:3000/distributor/";
    static String URLFruit="http://10.0.3.2:3000/fruit/";
    @GET("getAllDistributor")
    Call<ResposeData<List<Distributor>>> getListDistributor();
    @GET("get-list-fruit")
    Call<ResposeData<List<Fruit>>> getListFruit();
}
