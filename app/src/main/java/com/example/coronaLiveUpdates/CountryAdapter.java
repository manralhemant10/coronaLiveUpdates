package com.example.coronaLiveUpdates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {


    ArrayList<CountryWise> countries = new ArrayList<>();

    public CountryAdapter(ArrayList<CountryWise> countries){
        this.countries = countries;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_covid_country, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CountryWise countryWise = countries.get(position);
        holder.TotalCases.setText(countryWise.getmCases());
        holder.CountryName.setText(countryWise.getmCovidCountry());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TotalCases, CountryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TotalCases = (TextView) itemView.findViewById(R.id.TotalCases);
            CountryName = (TextView) itemView.findViewById(R.id.Country_Name);

        }
    }
}
