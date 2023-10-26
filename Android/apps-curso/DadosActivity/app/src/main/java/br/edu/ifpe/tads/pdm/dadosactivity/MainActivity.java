package br.edu.ifpe.tads.pdm.dadosactivity;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {


    private  EditText nomeEl; /* "nomeEl", porque nome é um Elemento gráfico do layout xml ;)*/
    private Button botaoDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoDados = (Button) findViewById(R.id.botaoDados);
        nomeEl = (EditText) findViewById(R.id.nomeId);



        botaoDados.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SegundaActivity.class);

                // Converte o valor obtido do EditText de Editable para String
                final String nome = nomeEl.getText().toString();

                /* Passa no extra, o nome recebido */
                intent.putExtra("nome", nome);

                startActivity(intent);

            }
        });
    }
}
