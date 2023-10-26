package br.edu.ifpe.tads.pdm.pratica3desafio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.edu.ifpe.tads.pdm.pratica3desafio.model.City;

public class MainActivity extends AppCompatActivity {


    public static final City [] cities = {
            new City("Ur 11 City"),
            new City("Recife"),
            new City("João Pessoa"),
            new City("Natal"),
            new City("Fortaleza"),
            new City("Rio de Janeiro"),
            new City("Belém"),
            new City("Manaus")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // parei aqui...seria melhor pegar o código da prática 3 sem o dasafio?
        //this.queue = Volley.newRequestQueue(this);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CityArrayAdapter(cities));

    }
}
