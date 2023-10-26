package br.edu.ifpe.tads.pdm.autenticaousuario2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastrarUsuarioActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private EditText textoEmailCadastrarId, textoSenhaCadastrarId;
    private Button botaoCadastrarId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        textoEmailCadastrarId = (EditText) findViewById(R.id.textoEmailCadastrarId);
        textoSenhaCadastrarId = (EditText) findViewById(R.id.textoSenhaCadastrarId);
        botaoCadastrarId = (Button) findViewById(R.id.botaoCadastrarId);

        botaoCadastrarId.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String emailDigitado, senhaDigigada;
                emailDigitado = textoEmailCadastrarId.getText().toString();
                senhaDigigada = textoSenhaCadastrarId.getText().toString();

                if( !emailDigitado.equals("")  && !senhaDigigada.equals("") ){

                    cadastrarUsuario(emailDigitado, senhaDigigada);

                }else{
                    Toast.makeText(CadastrarUsuarioActivity.this, "Os campos não podem ficar vazios", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void cadastrarUsuario(String email, String senha) {

        firebaseAuth = FirebaseAuth.getInstance();

         /* Cadastro -------------------------------- */
        firebaseAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(CadastrarUsuarioActivity.this,
                        new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if( task.isSuccessful() ){

                                    Toast.makeText(getApplicationContext(), "sucess", Toast.LENGTH_SHORT).show();
                                    Log.i("createUser", "Sucesso ao cadastrar usuário");
                                }else{

                                    // getException é apenas para testes
                                    Toast.makeText(getApplicationContext(), "fail " + task.getException(), Toast.LENGTH_LONG).show();
                                    Log.i("createUser", "Falha ao cadastrar usuário");
                                }
                            }
                        });

    }

}
