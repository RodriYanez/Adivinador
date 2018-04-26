package com.example.rodrigoyanez.adivinador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AdivinaPCActivity extends AppCompatActivity {

    private static final int NUMERO_MAXIMO = 100;
    private static final int NUMERO_MINIMO = 1;

    private int numeroActual, maxActual, minActual;

    private TextView numero;
    private Button btnMayor, btnMenor, btnIgual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivina_pc);

        numero = (TextView) findViewById(R.id.numero);
        btnIgual = (Button) findViewById(R.id.btnIgual);
        btnMayor = (Button) findViewById(R.id.btnMayor);
        btnMenor = (Button) findViewById(R.id.btnMenor);

        numeroActual = NUMERO_MAXIMO / 2;
        numero.setText(numeroActual + "?");
    }
}
