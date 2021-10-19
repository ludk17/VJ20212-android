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
                EditText input = findViewById(R.id.inputHello);
                String value = String.valueOf(input.getText());
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("value", value);
                startActivity(intent);
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