package br.edu.ifpe.tads.pdm.somdosbichos;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    MediaPlayer mediaPlayer;
    ImageView dogImageView, catImageView, lionImageView, monkeyImageView,
            sheepImageView, cowImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogImageView = findViewById(R.id.dogImageId);
        catImageView = findViewById(R.id.catImageId);
        lionImageView = findViewById(R.id.lionImageId);
        monkeyImageView = findViewById(R.id.monkeyImageId);
        sheepImageView = findViewById(R.id.sheepImageId);
        cowImageView = findViewById(R.id.cowImageId);

        dogImageView.setOnClickListener(this);
        catImageView.setOnClickListener(this);
        lionImageView.setOnClickListener(this);
        monkeyImageView.setOnClickListener(this);
        sheepImageView.setOnClickListener(this);
        cowImageView.setOnClickListener(this);

/* This is a TRASH CODE:
 * WOW: A listener for each ImageView!! This wasn't the best way to do it. */
//        dogImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cao);
//
//                tocarSom();
//            }
//        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.dogImageId:
                mediaPlayer = MediaPlayer.create(MainActivity.this,
                        R.raw.cao);
                tocarSom();
                break;

            case R.id.catImageId:
                mediaPlayer = MediaPlayer.create(MainActivity.this,
                        R.raw.gato);
                tocarSom();
                break;

            case R.id.lionImageId:
                mediaPlayer = MediaPlayer.create(MainActivity.this,
                        R.raw.leao);
                tocarSom();
                break;

            case R.id.monkeyImageId:
                mediaPlayer = MediaPlayer.create(MainActivity.this,
                        R.raw.macaco);
                tocarSom();
                break;

            case R.id.sheepImageId:
                mediaPlayer = MediaPlayer.create(MainActivity.this,
                        R.raw.ovelha);
                tocarSom();
                break;

            case R.id.cowImageId:
                mediaPlayer = MediaPlayer.create(MainActivity.this,
                        R.raw.vaca);
                tocarSom();
                break;

        }

    }

    private void tocarSom() {

        if (mediaPlayer != null) {
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();

                };
            });

        }
    }

//    private void pararSom(){
//
//        if (mediaPlayer != null && mediaPlayer.isPlaying() ){
//            mediaPlayer.stop();
//
//            try {
//                mediaPlayer.prepare();
//            }catch(IOException ex){
//                ex.printStackTrace();
//            }
//
//        }
//    }

    @Override
    protected void onDestroy() {

        if (mediaPlayer != null) {
            mediaPlayer.release(); /* Free resources */
            mediaPlayer = null;
        }

        super.onDestroy();
    }
}
