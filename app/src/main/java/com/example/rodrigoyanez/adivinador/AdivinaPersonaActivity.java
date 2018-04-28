package com.example.rodrigoyanez.adivinador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class AdivinaPersonaActivity extends AppCompatActivity {

    private EditText numeroEditText;
    private TextView txtMensajeEquivocado;

    private int numeroPensado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivina_persona);

        numeroEditText = findViewById(R.id.numeroEditText);
        txtMensajeEquivocado  = findViewById(R.id.txtMensajeEquivocado);
        Button btnAceptar = findViewById(R.id.btnAceptar);

        txtMensajeEquivocado.setText("");

        numeroPensado = new Random().nextInt(100) + 1;

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(numeroEditText.getText().toString());

                if(numeroPensado > numero)
                {
                    txtMensajeEquivocado.setText(String.format(
                            Locale.US,
                            getResources().getString(R.string.lang_error_numero_equivocado_mayor),
                            numero));
                    numeroEditText.setText("");
                }
                else if(numeroPensado < numero)
                {
                    txtMensajeEquivocado.setText(String.format(
                            Locale.US,
                            getResources().getString(R.string.lang_error_numero_equivocado_menor),
                            numero));
                    numeroEditText.setText("");
                }
                else if (numeroPensado == numero)
                {
                    setContentView(R.layout.winner_screen);
                    Button btnVolverAJugar = findViewById(R.id.btnVolverAJugar);
                    Button btnCambiarJuego = findViewById(R.id.btnCambiarJuego);
                    TextView txtNumeroGanador = findViewById(R.id.txtNumeroGanador);

                    txtNumeroGanador.setText(
                            String.format(Locale.US,
                                    getResources().getString(R.string.lang_felicitaciones),
                                    numero));

                    btnVolverAJugar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(
                                    AdivinaPersonaActivity.this,
                                    AdivinaPersonaActivity.class);
                            AdivinaPersonaActivity.this.startActivity(intent);
                        }
                    });
                    btnCambiarJuego.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(
                                    AdivinaPersonaActivity.this,
                                    AdivinaPCActivity.class);
                            AdivinaPersonaActivity.this.startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}
