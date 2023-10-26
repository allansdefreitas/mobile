package br.edu.ifpe.tads.pdm.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textoNome;
    private Button botaoSalvar;
    private TextView textoSaudacao;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNome = (EditText) findViewById(R.id.textoNomeId);
        botaoSalvar = (Button) findViewById(R.id.botaoSalvarId);
        textoSaudacao = (TextView) findViewById(R.id.textoSaudacaoId);


        recuperarDados();

        botaoSalvar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                /* O parâmetro 0 indica que os dados serão salvos no modo CONTEXT_MODE_PRIVATE,
                * isto é, os dados estarão restritos à aplicação atual */

                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editorSharedPreferences = sharedPreferences.edit();

                String nome = textoNome.getText().toString();

                if( nome.equals("") ){
                    Toast.makeText(getApplicationContext(), "O nome deve ser preenchido", Toast.LENGTH_SHORT).show();
                }else{

                    /* "Salva" o par chave/valor */
                    editorSharedPreferences.putString("nomeKey", nome);
                    /* commita, salvando de fato */
                    editorSharedPreferences.commit();

                    Toast.makeText(getApplicationContext(),  nome + " salvo com sucesso", Toast.LENGTH_LONG).show();


                }

                /* Independemente se salvou ou não, tenta recuperar os dados */
                recuperarDados();


            }
        });


    }

    private void recuperarDados() {

        /* Recuperando dados do SharedPreferences, no CONTEXT_MODE_PRIVATE */
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

        String nomeRecuperado = "";

        /* Se existir essa chave 'nomeKey' */
        if( sharedPreferences.contains("nomeKey")){

            /* Recupera seu valor*/
            nomeRecuperado = sharedPreferences.getString("nomeKey", "NAME NOT FOUND :/");
            /* Exibe num textView */
            textoSaudacao.setText("Bem-vindo, " + nomeRecuperado + "!");

        }else{

            textoSaudacao.setText("Oops, name not found :/");

        }

    }

//
//    private void salvarDados(String key, String nome){
//
//    }


}
