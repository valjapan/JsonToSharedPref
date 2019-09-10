package com.valjapan.teatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //SharedPreferencesを起動
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        //ArrayList<String>を作成
        ArrayList<String> strings = new ArrayList<String>();

        //ArrayListの中身を追加
        strings.add("AA学校");
        strings.add("BB学校");
        strings.add("CC学校");

        //Gsonをインスタンス化
        Gson gson = new Gson();
        //GsonでJsonに変換
        pref.edit().putString("mydata", gson.toJson(strings)).apply();

        Log.d("addString", gson.toJson(strings));
    }

    public void pull(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        }
    }


