package br.edu.ifpe.tads.pdm.pratica3desafio;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifpe.tads.pdm.pratica3desafio.model.City;

public class CityArrayAdapter extends RecyclerView.Adapter<CityArrayAdapter.CityHolder>
{
    private final City[] cities;
    public CityArrayAdapter(City[] cities) {
        this.cities = cities;
    }
    @Override
    public CityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_listitem, parent, false);
        return new CityHolder(inflatedView);
    }
    @Override
    public void onBindViewHolder(CityHolder holder, int position) {
        holder.bindCity(cities[position]);
    }
    @Override
    public int getItemCount() {
        return cities.length;
    }


    public static class CityHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private final TextView cityName;
        private final TextView cityInfo;
        private City city;
        public CityHolder(View itemView) {
            super(itemView);
            this.cityName = (TextView) itemView.findViewById(R.id.city_name);
            this.cityInfo = (TextView) itemView.findViewById(R.id.city_info);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Cidade selecionada: " +
                    city.getName(), Toast.LENGTH_SHORT).show();
        }
        public void bindCity(City city) {
            this.city = city;
            cityName.setText(city.getName());
            cityInfo.setText(city.getInfo());
        }
    }
}