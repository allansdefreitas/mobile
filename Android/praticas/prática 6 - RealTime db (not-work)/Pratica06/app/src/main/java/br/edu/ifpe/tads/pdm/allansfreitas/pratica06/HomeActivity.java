package br.edu.ifpe.tads.pdm.allansfreitas.pratica06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import br.edu.ifpe.tads.pdm.allansfreitas.pratica06.model.Message;
import br.edu.ifpe.tads.pdm.allansfreitas.pratica06.model.User;

public class HomeActivity extends AppCompatActivity {


    FirebaseAuthListener authListener;
    FirebaseAuth mAuth;
    ViewGroup vgChat;
    DatabaseReference drUser, drChat;
    EditText edMessage;

    TextView txWelcome;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.mAuth = FirebaseAuth.getInstance();
        this.authListener = new FirebaseAuthListener(this);
// Dando erro :(
//        vgChat = (ViewGroup) findViewById(R.id.messages_area);

        edMessage = (EditText) findViewById(R.id.edit_text_message);
        txWelcome = (TextView) findViewById(R.id.text_view_welcome) ;

        FirebaseDatabase fbDB = FirebaseDatabase.getInstance();
        FirebaseUser fbUser = mAuth.getCurrentUser();
        drUser = fbDB.getReference("users/" + fbUser.getUid());
        drChat = fbDB.getReference("chat");
        drUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User tempUser = dataSnapshot.getValue(User.class);
                if (tempUser != null) {
                    HomeActivity.this.user = tempUser;
                    txWelcome.setText("Welcome " + tempUser.getName() + "!");
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        drChat.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Message message = dataSnapshot.getValue(Message.class);
                showMessage(message);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }


            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });


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

    public void buttonSignOutClick(View view) {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            mAuth.signOut();

            //            this.finish();
        } else {
            Toast.makeText(HomeActivity.this, "Error!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showMessage(Message message) {
        TextView tvMsg = new TextView(this);
        tvMsg.setText(message.getName() + ": " + message.getText());
        vgChat.addView(tvMsg);
    }

    public void buttonSendMsgClick(View view) {
        String message = edMessage.getText().toString();
        edMessage.setText("");
        drChat.push().setValue(new Message(user.getName(), message));
    }
}
