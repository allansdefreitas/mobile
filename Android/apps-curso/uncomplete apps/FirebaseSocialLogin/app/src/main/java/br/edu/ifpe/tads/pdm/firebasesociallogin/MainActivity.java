package br.edu.ifpe.tads.pdm.firebasesociallogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {


    private FirebaseAuth firebaseAuth;
    private static final int RC_SIGN_IN = 0;
    private Button botaoLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null ){

            /* Usuário logado */
            Log.d("AUTH", firebaseAuth.getCurrentUser().getEmail());

        }else{

            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
                    .setProviders(
                            AuthUI.FACEBOOK_PROVIDER,
                            AuthUI.EMAIL_PROVIDER,
                            AuthUI.GOOGLE_PROVIDER)
                    .build(),RC_SIGN_IN );


        }

        botaoLogout = (Button) findViewById(R.id.botaoLogoutId);

        botaoLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AuthUI.getInstance()
                        .signOut(MainActivity.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {

                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.d("AUTH", "User logged out");

                                finish();

                            }
                        });

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==  RC_SIGN_IN ){
            if ( resultCode == RESULT_OK ){

                /* Usuário logado */
               Toast.makeText(getApplicationContext(), "Hi, " + firebaseAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                Log.d("AUTH", firebaseAuth.getCurrentUser().getEmail());

            }else{
                /* Não autenticado */
                Log.d("AUTH" , "Não autenticado");
            }
        }

    }
}
