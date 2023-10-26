package br.edu.ifpe.tads.pdm.app6_caraoucoroa;

import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DetalheActivity extends AppCompatActivity {


    private ImageView imagem, botaoVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        imagem = (ImageView) findViewById(R.id.imagemMoedaId);
        botaoVoltar = (ImageView) findViewById(R.id.botaoVoltarId);

        /* Obtain the extras from other (MainActivity) */
        Bundle extra = getIntent().getExtras();

        /* Validation */
        if(extra != null){

            /* Getting the extra from MainActivity */
             String ladoMoeda = extra.getString("arrayOpcao");

             if(ladoMoeda.equals("cara")){

                 imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_cara));

             }else if(ladoMoeda.equals("coroa")){

                 imagem.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.moeda_coroa));
             }else{

                 /* Impossible to happen ;) */
             }

        }

        botaoVoltar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /* To finish the actual activity, backing to MainActivity */
                finish();
            }

        });

    }
}
