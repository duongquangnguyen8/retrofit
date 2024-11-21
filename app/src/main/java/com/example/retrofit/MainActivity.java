package com.example.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.adapter.DistributorAdapter;
import com.example.retrofit.models.ResposeData;
import com.example.retrofit.models.Distributor;
import com.example.retrofit.screens.FruitActivity;
import com.example.retrofit.service.ApiService;
import com.example.retrofit.service.HttpRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Distributor> list=new ArrayList<>();
    private DistributorAdapter adapter;
    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView=findViewById(R.id.recycleview);
        btnNext=findViewById(R.id.btnNext);
        btnNext.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, FruitActivity.class));
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    public void loadData(){
        HttpRequest request=new HttpRequest(ApiService.URLDistributor);
        request.getApiService().getListDistributor().enqueue(getDistributor);
        //enqueue xử lí kh đồng bộ và xử lí callback
    }
    Callback<ResposeData<List<Distributor>>> getDistributor=new Callback<ResposeData<List<Distributor>>>() {
        @Override
        public void onResponse(Call<ResposeData<List<Distributor>>> call, Response<ResposeData<List<Distributor>>> response) {
            if (response.body().getStatus()==200){
                list=response.body().getData();
                Toast.makeText(MainActivity.this, "Success"+list.size(), Toast.LENGTH_SHORT).show();
                adapter=new DistributorAdapter(list,MainActivity.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);

            }
        }

        @Override
        public void onFailure(Call<ResposeData<List<Distributor>>> call, Throwable t) {
            Log.d("zzz","onFailure: "+t.getMessage());
        }
    };
}
