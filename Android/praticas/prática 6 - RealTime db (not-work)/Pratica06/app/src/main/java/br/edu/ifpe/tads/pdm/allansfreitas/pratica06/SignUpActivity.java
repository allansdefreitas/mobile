package br.edu.ifpe.tads.pdm.allansfreitas.pratica06;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.edu.ifpe.tads.pdm.allansfreitas.pratica06.model.User;

public class SignUpActivity extends AppCompatActivity {


    EditText edEmail, edName, edPassword;
    FirebaseAuthListener authListener;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edEmail = (EditText) findViewById(R.id.edit_email);
        edPassword = (EditText) findViewById(R.id.edit_password);

        this.mAuth = FirebaseAuth.getInstance();
        this.authListener = new FirebaseAuthListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(authListener);
    }

    public void buttonSignUpClick(View view) {
        final String name = edName.getText().toString();
        final String email = edEmail.getText().toString();
        final String password = edPassword.getText().toString();
        final FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String msg = task.isSuccessful() ? "SIGN UP OK!":
                                "SIGN UP ERROR!";
                        Toast.makeText(SignUpActivity.this, msg,
                                Toast.LENGTH_SHORT).show();
                        if (task.isSuccessful()) {
                            User tempUser = new User(name, email);
                            DatabaseReference drUsers = FirebaseDatabase.
                                    getInstance().getReference("users");
                            drUsers.child(mAuth.getCurrentUser().getUid()).
                                    setValue(tempUser);
                        }
                    }
                });
    }

}

