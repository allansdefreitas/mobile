package br.edu.ifpe.tads.pdm.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupEl;
    private RadioButton radioButtonEscolhidoEl;
    private Button botaoEscolherEl;
    private TextView textoResultadoEl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupEl = (RadioGroup) findViewById(R.id.radioGroupId);
        botaoEscolherEl = (Button) findViewById(R.id.botaoEscolherId);
        textoResultadoEl = (TextView) findViewById(R.id.textoResultadoId);


        botaoEscolherEl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /* Obtém o id do radioButton selecionado */
                int idRadioButtonEscolhido = radioGroupEl.getCheckedRadioButtonId();

                /* Se algum radioButton for selecionado */
                if( idRadioButtonEscolhido > 0 ){

                    /* Obtemos o elemento radioButton a partir do seu id */
                    radioButtonEscolhidoEl = (RadioButton) findViewById(idRadioButtonEscolhido);

                    String texto = radioButtonEscolhidoEl.getText().toString();
                    textoResultadoEl.setText(texto);
                }

        //        textoResultadoId.setText("id " + R.id.radioGroupId);
            }
        });

    }
}
