package br.edu.ifpe.tads.pdm.pratica03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* Array de cidades com descrição */
    public static final City [] cities = {
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

        ListView listView = (ListView)findViewById(R.id.list_view);

        /* usar o novo adapter */
        listView.setAdapter(new CityArrayListAdapter(this,
                        R.layout.city_listitem, cities
                )
        );

//        listView.setAdapter(new ArrayAdapter<String>(this,
//                R.layout.city_listitem, R.id.city_name, cities)
//        );

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {


                Toast.makeText(parent.getContext(), "Cidade selecionada: " +
                        cities[position].getName(), Toast.LENGTH_SHORT).show();

//                Toast.makeText(parent.getContext(), "Cidade selecionada: " +
//                        cities[position], Toast.LENGTH_SHORT).show();



            }
        });
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ListView listView = (ListView)findViewById(R.id.list_view);
//        listView.setAdapter(new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, cities)
//        );
//    }
}
