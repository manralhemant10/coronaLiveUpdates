package com.example.coronaLiveUpdates;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fragment_Home extends Fragment {
    TextView tvTotalConfirmed,tvTotalDeath,tvTotalRecovered,tvLastUpdated,tvprogress;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home,container,false);

        tvTotalConfirmed = root.findViewById(R.id.Total_confirmed_num);
        tvTotalDeath = root.findViewById(R.id.Total_death_num);
        tvTotalRecovered = root.findViewById(R.id.Total_recovered_num);
       // tvLastUpdated  = root.findViewById(R.id.Last_Updated);

        getData();
        return root;

    }
    private String getDate(long miliseconds){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE ,dd MM yyyy hh:mm:ss aaa");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(miliseconds);
        return  simpleDateFormat.format(calendar.getTime());
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        String url = "https://corona.lmao.ninja/v2/all";
        StringRequest stringRequest  = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    tvTotalConfirmed.setText(jsonObject.getString("cases"));
                    tvTotalDeath.setText(jsonObject.getString("deaths"));
                    tvTotalRecovered.setText(jsonObject.getString("recovered"));
                    //tvLastUpdated.setText("Last Updated\n" + getDate(jsonObject.getLong("updated")));
                    Toast.makeText(getActivity(),"Last Updated\n" + getDate(jsonObject.getLong("updated")), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("Error response", error.toString());
            }
        });
        queue.add(stringRequest);


    }


}
