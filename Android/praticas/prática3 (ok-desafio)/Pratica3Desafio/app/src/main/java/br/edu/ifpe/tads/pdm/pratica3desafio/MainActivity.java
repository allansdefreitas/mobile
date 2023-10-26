package br.edu.ifpe.tads.pdm.pratica3desafio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.edu.ifpe.tads.pdm.pratica3desafio.model.City;

public class MainActivity extends AppCompatActivity {


    public static final City [] cities = {
            new City("Ur 11 City", "Capital do Ibura"),
            new City("Recife", "Capital de Pernambuco"),
            new City("João Pessoa", "Capital da Paraíba"),
            new City("Natal", "Capital do Rio Grande do Norte"),
            new City("Fortaleza", "Capital do Ceará"),
            new City("Rio de Janeiro", "Capital do Rio de Janeiro"),
            new City("São Paulo","Capital de São Paulo"),
            new City("Salvador","Capital da Bahia"),
            new City("Vitória","Capital do Espirito Santo"),
            new City("Florianópolis","Capital de Santa Catarina"),
            new City("Porto Alegre","Capital do Rio Grande do Sul"),
            new City("São Luiz","Capital do Maranhão"),
            new City("Teresina","Capital do Piauí"),
            new City("Belém","Capital do Pará"),
            new City("Manaus","Capital do Amazonas")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CityArrayAdapter(cities));

    }
}
