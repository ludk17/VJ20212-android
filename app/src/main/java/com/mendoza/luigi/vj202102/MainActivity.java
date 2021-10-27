package com.mendoza.luigi.vj202102;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mendoza.luigi.vj202102.entities.User;
import com.mendoza.luigi.vj202102.services.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("MAIN_APP_CICLO_DE_VIDA", "onCreate");

        Button button = findViewById(R.id.btnChangeText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EditText input = findViewById(R.id.inputHello);
//                String value = String.valueOf(input.getText());
//                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
//                intent.putExtra("value", value);
//                startActivity(intent);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://vj20212.free.beeceptor.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                UserService service = retrofit.create(UserService.class);

                User user = new User();
                user.setFirstName("Lionel");
                user.setLastName("Messi");
                user.setEmail("messientoenparis@gmail.com");

//                service.all().enqueue(new Callback<List<User>>() {
//                    @Override
//                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                        Log.i("MAIN_APP", new Gson().toJson(response.body()));
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<User>> call, Throwable t) {
//                        Log.e("MAIN_APP", "No se puede establecer comunicación con el API");
//                    }
//                });

                service.create(user).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.i("MAIN_APP", new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MAIN_APP_CICLO_DE_VIDA", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MAIN_APP_CICLO_DE_VIDA", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MAIN_APP_CICLO_DE_VIDA", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MAIN_APP_CICLO_DE_VIDA", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MAIN_APP_CICLO_DE_VIDA", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MAIN_APP_CICLO_DE_VIDA", "onDestroy");
    }
}