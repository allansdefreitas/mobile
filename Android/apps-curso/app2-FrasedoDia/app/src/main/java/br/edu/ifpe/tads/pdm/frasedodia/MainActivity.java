package br.edu.ifpe.tads.pdm.frasedodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button botaoNovaFrase;
    private TextView textoNovaFrase;

    private String[] frases = {
        "A new commandment I give unto you, That ye love one another; " +
                "as I have loved you, that ye also love one another (John 13:34)",
        "Who knoweth not in all these that the hand of the LORD hath wrought this? (Job 12:9)",
        "All scripture is given by inspiration of God, and is profitable for doctrine, " +
                "for reproof, for correction, for instruction in righteousness: (2 Timothy 3:16)",
        "While the earth remaineth, seedtime and harvest, and cold and heat, " +
                "and summer and winter, and day and night shall not cease. (Genesis 8:22)",
        "This is the day which the LORD hath made; we will rejoice and be glad in it. (Psalms 118:24)",
        "The LORD is my shepherd; I shall not want. (Psalms 23:1)",
        "But my God shall supply all your need according to his riches in glory by Christ Jesus. (Philippians 4:19)"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoNovaFrase = (Button) findViewById(R.id.botaoNovaFraseId);
        textoNovaFrase = (TextView) findViewById(R.id.textoNovaFraseId);
        textoNovaFrase.setText("Click to view the quote");

        botaoNovaFrase.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Random random = new Random();
                int numeroRandom = random.nextInt(frases.length);

                textoNovaFrase.setText(frases[numeroRandom]);
            }
        });

    }
}
