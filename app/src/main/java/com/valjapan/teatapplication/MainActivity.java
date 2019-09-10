package com.valjapan.teatapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinnerを関連付け
        spinner = findViewById(R.id.spinner);
        //SharedPreferencesを起動
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);

        Gson gson = new Gson();

        String json = pref.getString("mydata","");
        //GsonでJsonからArrayListにsetする
        ArrayList<String> arrayList = gson.fromJson(json,new TypeToken<ArrayList<String>>(){}.getType());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //spinnerにAdapterをセット
        spinner.setAdapter(arrayAdapter);

    }

}


