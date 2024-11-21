package com.example.retrofit.screens;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.R;
import com.example.retrofit.adapter.FruitAdapter;
import com.example.retrofit.models.Fruit;
import com.example.retrofit.models.ResposeData;
import com.example.retrofit.service.ApiService;
import com.example.retrofit.service.HttpRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FruitActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FruitAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fruit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initUi();
    }
    private void initUi(){
        recyclerView=findViewById(R.id.recycleview_fruit);
    }

    @Override
    protected void onResume() {
        super.onResume();
        onLoad();
    }
    private void onLoad(){
        HttpRequest httpRequest=new HttpRequest(ApiService.URLFruit);
        httpRequest.getApiService().getListFruit().enqueue(getFruit);
    }
    Callback<ResposeData<List<Fruit>>> getFruit=new Callback<ResposeData<List<Fruit>>>() {
        @Override
        public void onResponse(Call<ResposeData<List<Fruit>>> call, Response<ResposeData<List<Fruit>>> response) {

            if (response.body().getStatus()==200){
                List<Fruit> list=response.body().getData();
                adapter=new FruitAdapter(list,FruitActivity.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(FruitActivity.this,LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(adapter);
            }
        }

        @Override
        public void onFailure(Call<ResposeData<List<Fruit>>> call, Throwable t) {

        }
    };
}
