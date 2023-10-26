package br.edu.ifpe.tads.pdm.listview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {


    private ListView listaItensEl;

    private String[] arrayItens = {"Salvador", "Recife", "Fernando de Noronha",
            "Porto de Galinhas", "Bonito - PE", "Mendonça", "Rio de Janeiro",
                "Gramado - RS", "Florianóplis", "Porto - POR", "Olinda",
                "Itamaracá", "Alagoas", "Natal", "Campina Grande", "Fortaleza"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaItensEl = (ListView) findViewById(R.id.listViewId);

        /* Adapatar o formato de array para listView */
        ArrayAdapter<String> adaptadorListaParaListView = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                arrayItens
        );

        listaItensEl.setAdapter(adaptadorListaParaListView);

        /* Captura o evento de clik num item específico da listView */
        listaItensEl.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /* Não precisava nem fazer isso :/ ...é meramente didático ;)*/
                int posicaoItem = position;

                /* Converts from Object to String*/
                String lugar = listaItensEl.getItemAtPosition(posicaoItem).toString();


                Toast.makeText(MainActivity.this,lugar  +" é um lugar bom pra ir!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
