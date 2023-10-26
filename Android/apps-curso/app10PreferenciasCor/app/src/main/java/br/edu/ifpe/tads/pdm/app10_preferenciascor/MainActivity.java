package br.edu.ifpe.tads.pdm.app10_preferenciascor;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    private RadioGroup radioGroupId;
    private RadioButton radioButtonSelecionadoId;
    private Button botaoSalvarId;
    private static final String ARQUIVO_PREFERENCIAS = "ARQUIVO_PREFERENCIA";
    private static final String COR_KEY = "COR_SELECIONADA";
    private SharedPreferences sharedPreferences;
    private RelativeLayout layout;
    private String corEscolhida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioGroupId = findViewById(R.id.radioGroupId);
        botaoSalvarId = findViewById(R.id.botaoSalvarId);
        layout = (RelativeLayout) findViewById(R.id.layoutId);

        /* SharedPreferences no context mode private (0) */

        sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIAS, 0);

        /* Existe no sharedPreferencias uma chave COR_KEY ? */
        if ( sharedPreferences.contains(COR_KEY) ){

            /* Recupera o valor dessa chave, que é uma string com o nome da cor */
            corEscolhida = sharedPreferences.getString(COR_KEY, "");

            setLayoutBackgroundColor(corEscolhida);
        }

        botaoSalvarId.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                /* Pega o id do radioButton selecionado */
                int idRadioSelecionado = radioGroupId.getCheckedRadioButtonId();

                if (idRadioSelecionado > 0) {


                    /* Localiza qual radio foi selecionado */
                    radioButtonSelecionadoId = findViewById(idRadioSelecionado);


                    /* Obtém o nome do radio button (text), que é, no caso, o nome da cor */
                    corEscolhida = radioButtonSelecionadoId.getText().toString();

                    sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIAS, 0);
                    SharedPreferences.Editor editorSharedPreferences = sharedPreferences.edit();

                    /* Salva esse nome no arquivo de preferências */
                    editorSharedPreferences.putString(COR_KEY, corEscolhida);
                    editorSharedPreferences.commit();

                    setLayoutBackgroundColor(corEscolhida);


//                    if (idRadioSelecionado == R.id.azulId) {
//                    /* Cor azul */
//                        findViewById(R.id.backgroundId).setBackgroundColor();
//                    } else if (){
//
//                    }

                }
            }
        });
    }

    private void setLayoutBackgroundColor(String corEscolhida) {

        if (corEscolhida.equals("Azul")) {
            layout.setBackgroundColor(Color.parseColor("#FF1572D6"));

        } else if (corEscolhida.equals("Laranja")) {
            layout.setBackgroundColor(Color.parseColor("#FFD67915"));

        } else if (corEscolhida.equals("Verde")) {
            layout.setBackgroundColor(Color.parseColor("#FF0C7613"));
        }else{
            /* Deixa a cor padrão */
        }
    }
}
