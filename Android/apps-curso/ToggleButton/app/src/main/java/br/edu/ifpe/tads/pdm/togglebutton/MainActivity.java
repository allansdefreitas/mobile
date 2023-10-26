package br.edu.ifpe.tads.pdm.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton eLToggleButton;
    private TextView elTextoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eLToggleButton = (ToggleButton) findViewById(R.id.toggleButtonId);
        elTextoResultado = (TextView) findViewById(R.id.textoResultadoId);

        eLToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                /* Zera o texto */
                elTextoResultado.setText("");

                if ( isChecked ){
                    elTextoResultado.setText("está ligado");
                }else{
                    elTextoResultado.setText("Eśtá desligado");
                }
            }
        });
    }
}
