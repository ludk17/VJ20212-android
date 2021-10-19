package com.mendoza.luigi.vj202102;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mendoza.luigi.vj202102.adapters.NameAdapter;
import com.mendoza.luigi.vj202102.adapters.RepositoryAdapter;
import com.mendoza.luigi.vj202102.entities.Repository;
import com.mendoza.luigi.vj202102.services.GitHubService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Log.i("MAIN_APP", "Iniciando Segnda Actividad");

        RecyclerView rv = findViewById(R.id.rvNames);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        service.allRepos().enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                Log.i("MAIN_APP", String.valueOf(response.code()));
                if(response.code() == 200) {
                    RepositoryAdapter adapter = new RepositoryAdapter(response.body());
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Log.i("MAIN_APP", "No hubo comunicación con el servidor");
            }
        });



    }
}