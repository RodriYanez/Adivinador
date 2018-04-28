package com.example.rodrigoyanez.adivinador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AdivinaPCActivity extends AppCompatActivity {

    private static final int NUMERO_MAXIMO = 100;
    private static final int NUMERO_MINIMO = 1;

    private int numeroActual, maxActual, minActual;

    private TextView numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivina_pc);

        numero = findViewById(R.id.numero);
        Button btnIgual = findViewById(R.id.btnIgual);
        Button btnMayor = findViewById(R.id.btnMayor);
        Button btnMenor = findViewById(R.id.btnMenor);

        numeroActual = NUMERO_MAXIMO / 2;
        maxActual = NUMERO_MAXIMO;
        minActual = NUMERO_MINIMO;
        numero.setText(numeroActual + "?");

        btnMayor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minActual = numeroActual;
                numeroActual = (maxActual + numeroActual) / 2;
                numero.setText(numeroActual + "?");
            }
        });
        btnMenor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maxActual = numeroActual;
                numeroActual = (minActual + numeroActual) / 2;
                numero.setText(numeroActual + "?");
            }
        });
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.winner_screen);
                Button btnVolverAJugar = findViewById(R.id.btnVolverAJugar);
                TextView txtNumeroGanador = findViewById(R.id.txtNumeroGanador);

                txtNumeroGanador.setText("El numero que pensaste es " + numeroActual);

                btnVolverAJugar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AdivinaPCActivity.this, AdivinaPCActivity.class);
                        AdivinaPCActivity.this.startActivity(intent);
                    }
                });
            }
        });
    }
}
