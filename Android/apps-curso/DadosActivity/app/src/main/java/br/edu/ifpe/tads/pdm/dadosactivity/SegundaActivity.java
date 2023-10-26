package br.edu.ifpe.tads.pdm.dadosactivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActivity extends Activity {


    private TextView nomeEl;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        nomeEl = (TextView) findViewById(R.id.textoId);

        /* Obtem o intent e os extras */
        Bundle extra = getIntent().getExtras();


        if(extra != null){

            /* Localiza o extra pelo identificador (key) */
            String stringRecebida = extra.getString("nome");

            nomeEl.setText("Hi, " + stringRecebida + " !");

            Toast.makeText(getApplicationContext(), "It's a beautiful name!", Toast.LENGTH_SHORT).show();
        }

    }
}
