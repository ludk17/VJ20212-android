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
        Button button = findViewById(R.id.btnChangeText);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = findViewById(R.id.inputHello);
                String value = String.valueOf(input.getText());
                Log.i("MAIN_APP", "El valor de input es: " + value);

                // pasar a otra actividad
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("value", value);
                startActivity(intent);

                //llamar por telefono
//                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", value, null));
//                startActivity(intent);

            }
        });

    }
}