package br.edu.ifpe.tads.pdm.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

import br.edu.ifpe.tads.pdm.firebaseapp.model.Produto;
import br.edu.ifpe.tads.pdm.firebaseapp.model.Usuario;


public class MainActivity extends AppCompatActivity {


    private ListView listViewGUI;
    private ArrayList<String> arrayUsuarios = new ArrayList<>();

    /* Referencia o nó Raiz (root) da estrutura de dados do Firebase ;) */
    private DatabaseReference firebaseReferenciaRaiz = FirebaseDatabase.getInstance()
            .getReference();

    /* Referencia, a partir do nó raíz, os sub nós */
    private DatabaseReference usuariosReferenciaFB = firebaseReferenciaRaiz.child("usuarios");
    private  DatabaseReference produtosReferenciaFB = firebaseReferenciaRaiz.child("produtos");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Navega para o nó pontos (se não existir, cria) e seta o valor dele para 200*/
        // firebasefirebaseDBReferencia.child("pontos").setValue("250");

        //usuarioDBReferencia.child("003").child("nome").setValue("Betânia Silva");

//
//        Usuario usuario = new Usuario();
//        usuario.setNome("Cássio");
//        usuario.setSobrenome("Silva");
//        usuario.setIdade(24);
//        usuario.setSexo("Masculino");
//
//        usuariosReferenciaFB.child("002").setValue(usuario);
//
//
//        Produto produto = new Produto();
//        produto.setCor("Grafite");
//        produto.setDescricao("Moto G5 Plus");
//        produto.setFabricante("Motorola");
//
//        produtosReferenciaFB.child("002").setValue(produto);


        listViewGUI = (ListView)  findViewById(R.id.listViewId);
//
//        arrayString.add("oi");
//        arrayString.add("hi");
//        arrayString.add("hey");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            arrayUsuarios
        );

        listViewGUI.setAdapter(arrayAdapter);

        usuariosReferenciaFB.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Usuario user = (Usuario) dataSnapshot.getValue(Usuario.class);
                arrayUsuarios.add(user.getNome());

                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {


//                Usuario user = (Usuario) dataSnapshot.getValue(Usuario.class);
//                arrayUsuarios.add(user.getNome());
//
//                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

//                Usuario user = (Usuario) dataSnapshot.getValue(Usuario.class);
//                arrayUsuarios.add(user.getNome());
//
//
//                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





//
//        usuariosReferenciaFB.addValueEventListener(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.i("FIREBASE", dataSnapshot.getValue().toString());
////                Toast.makeText(MainActivity.this, dataSnapshot.getValue().toString(), Toast.LENGTH_SHORT)
////                        .show();
//
//                /* Se o tipo a ser recuperado for String apenas (não for objeto):
//                * Map<String, String>  map = dataSnapshot.getValue(Map.class);
//                * String nome = map.get("nomeDoNo") */
//                Usuario user = (Usuario) dataSnapshot.getValue(Usuario.class);
//
//                Toast.makeText(MainActivity.this, user.getNome(), Toast.LENGTH_SHORT)
//                        .show();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

    }
}
