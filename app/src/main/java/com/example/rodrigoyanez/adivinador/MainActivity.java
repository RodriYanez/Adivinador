package com.example.rodrigoyanez.adivinador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdivinaPC = findViewById(R.id.btnAdivinaPC);
        Button btnAdivinaPersona = findViewById(R.id.btnAdivinaPersona);

        btnAdivinaPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdivinaPCActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        btnAdivinaPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdivinaPersonaActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
