package br.edu.ifpe.tads.pdm.app7_profetasat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaProfetasActivity extends AppCompatActivity {

    private ListView listViewProfetas;
    private String[] arrayProfetas = {
            "Hosea", "Joel", "Amos", "Obadiah", "Jonah", "Micah", "Nahum",
            "Habakkuk", "Zephaniah", "Haggai", "Zechariah", "Malachi"
    };

    private String[] arrayTemasLivros = {
      "O julgamento divino e o amor redentor de Deus", "O grande e terrível Dia do Senhor",
        "Justiça, retidão e retribuição divina pelo pecado", "O juízo de Edom",
            "A magnitude da misericórdia salvífica de Deus", "Juízo e salvação messiânica",
            "A destruição iminente de Nínive", "Viver pela Fé", "O Dia do Senhor",
            "Reedificação do Templo", "A conclusão do templo e as promessas messiânicas",
            "Acusações de Deus contra o judaísmo pós-exílico"

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_profetas);

        listViewProfetas = (ListView) findViewById(R.id.listViewProfetas);
        ArrayAdapter<String> adaptadorArrayProfetas = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                arrayProfetas
        );

        listViewProfetas.setAdapter(adaptadorArrayProfetas);

        listViewProfetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(getApplicationContext(), arrayTemasLivros[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

}
