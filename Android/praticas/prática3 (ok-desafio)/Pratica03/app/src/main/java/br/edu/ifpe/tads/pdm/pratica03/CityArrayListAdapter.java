package br.edu.ifpe.tads.pdm.pratica03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CityArrayListAdapter extends ArrayAdapter<City> {

    private City [] cities;

    public CityArrayListAdapter(Context context, int resource, City [] cities) {
        super(context, resource, cities);
        this.cities = cities;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View listItem = null;
        ViewHolder holder = null;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            listItem = inflater.inflate(R.layout.city_listitem, null, true);
            holder = new ViewHolder();
            holder.cityName = (TextView) listItem.findViewById(R.id.city_name);
            holder.cityInfo = (TextView) listItem.findViewById(R.id.city_info);

            listItem.setTag(holder);

        } else {
            listItem = view;
            holder = (ViewHolder)view.getTag();
        }

        holder.cityName.setText(cities[position].getName());
        holder.cityInfo.setText(cities[position].getInfo());

        return listItem;
    }

//    @Override
//    public View getView(int position, View view, ViewGroup parent) {
//
//        View listItem = null;
//
//        if (view == null) {
//            LayoutInflater inflater = LayoutInflater.from(getContext());
//            listItem = inflater.inflate(R.layout.city_listitem, null, true);
//        } else {
//            listItem = view;
//        }
//
////        LayoutInflater inflater = LayoutInflater.from(getContext());
////        View listItem = inflater.inflate(R.layout.city_listitem, null, true);
//
//        TextView cityName = (TextView) listItem.findViewById(R.id.city_name);
//        TextView cityInfo = (TextView) listItem.findViewById(R.id.city_info);
//
//        cityName.setText(cities[position].getName());
//        cityInfo.setText(cities[position].getInfo());
//
//        return listItem;
//
//    }

    static class ViewHolder {
        TextView cityName;
        TextView cityInfo;
    }

}


