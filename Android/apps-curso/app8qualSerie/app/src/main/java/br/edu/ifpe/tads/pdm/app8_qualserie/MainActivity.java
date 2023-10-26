package br.edu.ifpe.tads.pdm.app8_qualserie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imagemExibicao;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBarId);
        imagemExibicao = findViewById(R.id.imagemExibicaoId);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//
//                Toast.makeText(MainActivity.this, "progress: " + progress, Toast.LENGTH_SHORT)
//                        .show();
                if (progress == 1) {
                    imagemExibicao.setImageResource(R.drawable.pouco);

                } else if (progress == 2) {
                    imagemExibicao.setImageResource(R.drawable.medio);

                } else if (progress == 3) {
                    imagemExibicao.setImageResource(R.drawable.muito);

                } else if (progress == 4) {
                    imagemExibicao.setImageResource(R.drawable.susto);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }

}
