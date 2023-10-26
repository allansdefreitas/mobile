package br.edu.ifpe.tads.pdm.allansfreitas.pratica05;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by allan on 26/12/17.
 */

public class FirebaseAuthListener implements FirebaseAuth.AuthStateListener {

    private final Activity activity;
    public FirebaseAuthListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {


        FirebaseUser user = firebaseAuth.getCurrentUser();
        Intent intent = null;
        if ((user != null) && !(activity instanceof HomeActivity)) {
            intent = new Intent(activity, HomeActivity.class);
        }
        if ((user == null) && (activity instanceof HomeActivity)) {
            intent = new Intent(activity, MainActivity.class);
        }
        if (intent != null) {
            activity.startActivity(intent);
            activity.finish();
        }
    }

}
