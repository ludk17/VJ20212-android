package com.mendoza.luigi.vj202102;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.widget.TextView;

import com.mendoza.luigi.vj202102.adapters.NameAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Log.i("MAIN_APP", "Iniciando Segnda Actividad");

//        Intent intent = getIntent();
//        String value = intent.getStringExtra("value");

        RecyclerView rv = findViewById(R.id.rvNames);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        List<String> datos = Arrays.asList("data1", "dato2", "dato3", "dato4", "dato5", "dato6", "dato7", "dato8", "dato9", "dato10", "dato11");
        NameAdapter adapter = new NameAdapter(datos);

        rv.setAdapter(adapter);

    }
}