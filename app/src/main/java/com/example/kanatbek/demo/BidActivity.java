package com.example.kanatbek.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import model.carTypeEnum;

public class BidActivity extends AppCompatActivity {

    List<String> carType = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bid);
        loadCarType();
        loadCarModel();
    }


    public void loadFunction(View view) {
        RequestQueue queue = Volley.newRequestQueue(this);
        final TextView mTextView = (TextView) findViewById(R.id.textView);
        String url = "https://samples.openweathermap.org/data/2.5/forecast?id=524901&appid=b6907d289e10d714a6e88b30761fae22";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response.toString());
                        mTextView.setText(response.toString());
                        }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("Error");
            }
        });
    queue.add(jsonObjReq);
    }

    public void loadCarType() {
        Spinner carTypes = (Spinner)findViewById(R.id.spinner);
        String[] items = {"Chevy_Sonic", "Ford_Fiesta", "Honda_Fit", "Hyundai_Accent",
                                        "Kia_Rio", "Mazda", "Mitsubishi_Mirage", "Nissan", "Toyota"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, items);
        carTypes.setAdapter(adapter);
    }

    public void loadCarModel() {

    }
}
