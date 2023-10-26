package br.edu.ifpe.tads.pdm.app5_atmconsultoria;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {


    private ImageView botaoEmpresa, botaoClientes, botaoServicos, botaoContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoEmpresa = (ImageView) findViewById(R.id.empresaId);
        botaoClientes = (ImageView) findViewById(R.id.clientesId);
        botaoServicos = (ImageView) findViewById(R.id.servicoId);
        botaoContato = (ImageView) findViewById(R.id.contatoId);


        /* Evento de click para o "botão" Empresa */
        botaoEmpresa.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // em vez de ser getApplicationContext(), pode ser MainActivity.this
                startActivity(new Intent(getApplicationContext(), EmpresaActivity.class));
            }
        });


        botaoClientes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ClientesActivity.class));
            }
        });

        botaoServicos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ServicoActivity.class));
            }
        });

        botaoContato.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContatoActivity.class);
                startActivity(intent);
            }
        });
    }
}
