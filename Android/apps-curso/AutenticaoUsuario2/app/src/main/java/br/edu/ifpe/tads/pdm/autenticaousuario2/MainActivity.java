package br.edu.ifpe.tads.pdm.autenticaousuario2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


/* https://firebase.google.com/docs/auth/android/google-signin */
public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private EditText editEmail, editSenha;
    private Button botaoLogin;
    private TextView textoCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = (EditText) findViewById(R.id.emailId);
        editSenha = (EditText) findViewById(R.id.senhaId);
        botaoLogin = (Button) findViewById(R.id.botaoLoginId);
        textoCadastrar = (TextView) findViewById(R.id.textoCadastrarId);


        textoCadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastrarUsuarioActivity.class);
                startActivity(intent);
            }
        });

        /* Já redireciona para a HomeActivity */
        if ( estaLogado() == true ){

            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
           // Toast.makeText(MainActivity.this, "esta logado pegou :)", Toast.LENGTH_LONG).show();
            startActivity(intent);

        }

        botaoLogin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String emailDigitado, senhaDigitada;

                emailDigitado = editEmail.getText().toString();
                senhaDigitada = editSenha.getText().toString();

//                emailDigitado = "cassio@gmail.com";
//                senhaDigitada = "cassio123";

                if( !emailDigitado.equals("")  && !senhaDigitada.equals("") ){

                    logarUsuario(emailDigitado, senhaDigitada);
//
//                    if ( estaLogado() == true ){
//
//                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                        startActivity(intent);
//
//                    }

                }else{
                    Toast.makeText(MainActivity.this, "Os campos não podem ficar vazios", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //estaLogado();

        //cadastrarUsuario(emailDigitado, senhaDigitada);



        //logoutUsuario();

    }


    private void logarUsuario(String email, String senha) {

        firebaseAuth = FirebaseAuth.getInstance();
        //      final boolean loginOk;

        /* Login ----------------------------------------------- */
        firebaseAuth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if( task.isSuccessful() ){

//                           // Toast.makeText(getApplicationContext(), "sucesso login", Toast.LENGTH_SHORT).show();
                            Log.i("signInUser", "sucesso login usuário");
                            //                    loginOk = true;

                            /* Redireciona para a Atividade Home */
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
//
                        }else{
                            Toast.makeText(getApplicationContext(), "falha login " + task.getException(), Toast.LENGTH_SHORT).show();
                            Log.i("signInUser", "falha login usuário");
//                            loginOk = false;

                        }

                    }
                });


    }


    private void cadastrarUsuario(String email, String senha) {

        firebaseAuth = FirebaseAuth.getInstance();

         /* Cadastro -------------------------------- */
        firebaseAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(MainActivity.this,
                        new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
  //                              Toast.makeText(getApplicationContext(), "entrou", Toast.LENGTH_SHORT).show();

                                if( task.isSuccessful() ){

    //                                Toast.makeText(getApplicationContext(), "sucess", Toast.LENGTH_SHORT).show();
                                    Log.i("createUser", "Sucesso ao cadastrar usuário");
                                }else{

                                    // getException é apenas para testes
      //                              Toast.makeText(getApplicationContext(), "fail " + task.getException(), Toast.LENGTH_LONG).show();
                                    Log.i("createUser", "Falha ao cadastrar usuário");
                                }
                            }
                        });

    }

    private Boolean estaLogado() {

        firebaseAuth = FirebaseAuth.getInstance();

        if( firebaseAuth.getCurrentUser() != null ){
        //    Toast.makeText(getApplicationContext(), "Usuário logado", Toast.LENGTH_SHORT)
            //        .show();
            return true;
        }else{
          //  Toast.makeText(getApplicationContext(), "Usuário não logado", Toast.LENGTH_SHORT)
              //      .show();
            return false;
        }
    }


}
