package br.edu.ifpe.tads.pdm.app6_caraoucoroa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private ImageView botaoJogar;
    private String[] opcao = {"cara", "coroa"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoJogar = (ImageView) findViewById(R.id.botaoJogarId);

        /* When the button is clicked */
        botaoJogar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Random random = new Random();

                /* Generate a random number from 0 to 1, cause the bound is exclusive interval */
                Integer randomNumber = random.nextInt(2);


                Intent intentToDetalheActivity = new Intent(getApplicationContext(), DetalheActivity.class);

                /* Pass the array by Intent */
                intentToDetalheActivity.putExtra("arrayOpcao", opcao[randomNumber]);

                startActivity(intentToDetalheActivity);


            }
        });
    }
}
