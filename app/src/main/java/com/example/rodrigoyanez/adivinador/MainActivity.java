package com.example.rodrigoyanez.adivinador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAdivinaPC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdivinaPC = (Button) findViewById(R.id.btnAdivinaPC);

        btnAdivinaPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdivinaPCActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
