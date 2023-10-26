package br.edu.ifpe.tads.pdm.app7_profetasat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imagemProfetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagemProfetas = (ImageView) findViewById(R.id.imagemProfetasId);

        imagemProfetas.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ListaProfetasActivity.class);
                startActivity(intent);

            }
        });

    }
}
