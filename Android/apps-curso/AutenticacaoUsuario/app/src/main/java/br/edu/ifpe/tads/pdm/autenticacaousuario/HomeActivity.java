package br.edu.ifpe.tads.pdm.autenticacaousuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    private TextView textoSaudacao;
    private Button botaoLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textoSaudacao = (TextView) findViewById(R.id.textoSaudacaoId);
        botaoLogout = (Button) findViewById(R.id.botaoLoginId);



        botaoLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                logoutUsuario();
            }
        });

    }

    private void logoutUsuario() {

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signOut();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

}


