package br.edu.ifpe.tads.pdm.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = (EditText) findViewById(R.id.precoAlcoolId);
        precoGasolina = (EditText) findViewById(R.id.precoGasolinaId);
        botaoVerificar = (Button) findViewById(R.id.botaoVerificarId);
        textoResultado = (TextView) findViewById(R.id.textoResultadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

            String textoPrecoAlcool = precoAlcool.getText().toString();
            String textoPrecoGasolina = precoGasolina.getText().toString();

            if(textoPrecoAlcool.isEmpty() || textoPrecoAlcool.isEmpty() ){
                textoResultado.setText("Os dois campos devem ser preenchidos ;)");
            }else{

                Double valorAlcool = Double.parseDouble(textoPrecoAlcool);
                Double valorGasolina = Double.parseDouble(textoPrecoGasolina);

                Double resultado = valorAlcool / valorGasolina;

                if(resultado >= 0.7){

                    textoResultado.setText("Melhor utilizar Gasolina :)");

                }else{
                    textoResultado.setText("Melhor utilizar Álcool :)");
                }

            }
                
            }
        });

    }
}
