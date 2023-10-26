package br.edu.ifpe.tads.pdm.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;


/* Bom ver
    Estados do Mediaplayer
        https://developer.android.com/reference/android/media/MediaPlayer.html */
public class MainActivity extends AppCompatActivity {


    private Button botaoTocar, botaoParar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoTocar = (Button) findViewById(R.id.botaoPlayId);
        botaoParar = (Button) findViewById(R.id.botaoStopId);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.eli_soares_minha_oracao);

        botaoTocar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if( mediaPlayer.isPlaying() ){
                    pausarMusica();
                }else{
                    tocarMusica();
                }

            }
        });

        botaoParar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if( mediaPlayer.isPlaying() ){
                    pararMusica();
                }
            }
        });


    }


    private void tocarMusica(){

        /* foi instanciado */
        if(mediaPlayer != null ){

            mediaPlayer.start();

         botaoTocar.setText("Pause");

        }


    }


    private void pausarMusica(){

        if( mediaPlayer != null && mediaPlayer.isPlaying() ){

            mediaPlayer.pause();

            botaoTocar.setText("Play");
        }

    }


    private void pararMusica() {

        if( mediaPlayer != null && mediaPlayer.isPlaying() ){

            mediaPlayer.stop();

            try {
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            botaoTocar.setText("Play");

            Toast.makeText(MainActivity.this, "Música parada :)", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "A música não está nem tocando :/", Toast.LENGTH_SHORT).show();
        }

    }

    /* Ao destruir a activity, liberar os recursos do mediaPlayer */
    @Override
    protected void onDestroy() {

        if( mediaPlayer != null && mediaPlayer.isPlaying() ){
            mediaPlayer.stop();

            /* liberar recursos do player */
            mediaPlayer.release();
            mediaPlayer = null;
        }

        super.onDestroy();
    }

}
