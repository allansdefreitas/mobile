package br.edu.ifpe.tads.pdm.app11_minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText textoAnotacaoEl;
    private ImageView botaoSalvarEl;
    private final static String ARQUIVO_ANOTACAO = "ARQUIVO_ANOTACAO.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoAnotacaoEl = findViewById(R.id.textoId);
        botaoSalvarEl =  findViewById(R.id.botaoSalvarId);

        botaoSalvarEl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String textoDigitadoAnotacao;
                textoDigitadoAnotacao = textoAnotacaoEl.getText().toString();

                salvarAnotacao(textoDigitadoAnotacao);
            }
        });


        /* De qualquer forma, todas as vezes:
            Verifica se há conteúdo gravado no arquivo
                caso sim:
                   Atribui o conteúdo ao elemento EditTex "textoAnotacaoEl"
       */
        String textoAnotacaoRecuperado = recuperarAnotacao();

        if ( textoAnotacaoRecuperado != null ){
            textoAnotacaoEl.setText(textoAnotacaoRecuperado);

            /* Put the cursor at the end of the text */
            textoAnotacaoEl.setSelection(textoAnotacaoEl.getText().length());
        }
    }

    private void salvarAnotacao(String textoDigitadoAnotacao) {

        try{

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    /* NOME DO ARQUIVO, MODO DE GRAVAÇÃO */
                    openFileOutput(ARQUIVO_ANOTACAO, Context.MODE_PRIVATE)
            );

            /* Grava a anotação no arquivo */
            outputStreamWriter.write(textoDigitadoAnotacao);

            /* Encerra a gravação */
            outputStreamWriter.close();
            Toast.makeText(MainActivity.this, "Anotação salva", Toast.LENGTH_SHORT)
                    .show();

        }catch (IOException exception){
            Toast.makeText(MainActivity.this, "Não foi possível salvar :(", Toast.LENGTH_SHORT)
                    .show();

            Log.v("MainActivity", exception.toString() );
        }
    }


    private String recuperarAnotacao(){


        String resultadoArquivo = "";

        try{

            /* Abre o arquivo, localizando-o pelo nome */
            InputStream arquivo = openFileInput(ARQUIVO_ANOTACAO);

            /* Se o arquivo existir... */
            if( arquivo != null ){

                /* Lê o arquivo */
                InputStreamReader inputStreamReader = new InputStreamReader( arquivo );

                /* Gerar buffer do arquivo */
                BufferedReader bufferedReader = new BufferedReader( inputStreamReader );

                String linhaArquivo;

                /* Enquanto houver linha do arquivo... */
                while ( ( linhaArquivo = bufferedReader.readLine() ) != null){

                    /* Recupera o texto, linha por linha */
                    resultadoArquivo += linhaArquivo;

                }


                /* CÓDIGO ABAIXO É PROBLEMÁTICO: A cada vez que se usa o readline, retorna uma linha,
                * de modo que, quando se usa o readLine novamente, já se está na segunda linha
                * do arquivo e assim sucessivamente, por isso, a cada vez que se usa esse
                * método, deve-se recuperar seu valor para não perder nenhuma linha do seu
                * conteúdo nem causar defeitos de leitura no app. */

//                /* Enquanto houver linha do arquivo... */
//                while ( bufferedReader.readLine() != null){
//
//                    /* Recupera o texto, linha por linha */
//                    resultadoArquivo += bufferedReader.readLine();
//
//                }

                /* Fecha o arquivo :) */
                arquivo.close();
            }

        }catch(IOException exception){
            Log.v("MainActivity", exception.toString());
        }

        /* Retorna o conteúdo do arquivo, no caso, a anotação */
        return resultadoArquivo;

    }
}
