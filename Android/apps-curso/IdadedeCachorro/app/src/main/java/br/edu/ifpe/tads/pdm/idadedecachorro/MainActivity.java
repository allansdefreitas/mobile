package br.edu.ifpe.tads.pdm.idadedecachorro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText caixaTextoIdadeCao;
    private Button botaoIdade;
    private TextView resultadoIdade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        caixaTextoIdadeCao = (EditText) findViewById(R.id.caixaTextoIdadeCaoId);
        botaoIdade = (Button) findViewById(R.id.botaoIdadeId);
        resultadoIdade = (TextView) findViewById(R.id.resultadoIdadeId);

        botaoIdade.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String textoDigitado =  caixaTextoIdadeCao.getText().toString();

                if( textoDigitado.isEmpty() ){
                    resultadoIdade.setText("Digite algum valor ;)");

                }else{

                    // Converts the text from String to int
                    int valorDigitado = Integer.parseInt(textoDigitado);
                    int resultadoFinal = valorDigitado * 7;

                    resultadoIdade.setText("A idade do cão em anos humanos é: " + resultadoFinal + ""
                            + " anos");

                }

            }
        });

    }
}
