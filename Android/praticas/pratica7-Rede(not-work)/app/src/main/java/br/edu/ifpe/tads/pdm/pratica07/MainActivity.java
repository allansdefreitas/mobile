package br.edu.ifpe.tads.pdm.pratica07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ForecastListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void buttonOkClick(View view) {
        String cityName = ((EditText)findViewById(R.id.edit_city)).getText().toString();
        new ForecastTask(this).execute(cityName);
    }

    @Override
    public void showForecast(String [] forecast) {
        if (forecast == null) {
            String cityName =
                    ((EditText)findViewById(R.id.edit_city)).getText().toString();
            Toast toast = Toast.makeText(this, "Previsão não encontrada para " +
                    cityName, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            ArrayList<CharSequence> data =
                    new ArrayList<CharSequence>(Arrays.asList(forecast));
            Intent intent = new Intent(this, ForecastActivity.class);
            intent.putCharSequenceArrayListExtra("data", data);
            startActivity(intent);
        }
    }
}
