package com.example.thirugural;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.thirugural.Model.Kural;
import com.example.thirugural.Model.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    ArrayList<Kural> kural = new ArrayList<>();
    KuralAdapter adapter;
    Listener listener;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        progressBar = findViewById(R.id.progressbar);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray jsonArray = obj.getJSONArray("kural");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject kuralobject = jsonArray.getJSONObject(i);

                Log.e("kural", kuralobject.toString());

                Kural kuralmodel = new Kural();
                kuralmodel.setLine1(kuralobject.getString("Line1"));
                kuralmodel.setLine2(kuralobject.getString("Line2"));
                kuralmodel.setTranslation(kuralobject.getString("Translation"));
                kuralmodel.setMv(kuralobject.getString("mv"));
                kuralmodel.setSp(kuralobject.getString("sp"));
                kuralmodel.setMk(kuralobject.getString("mk"));
                kuralmodel.setCouplet(kuralobject.getString("couplet"));
                kuralmodel.setExplanation(kuralobject.getString("explanation"));
                kuralmodel.setTransliteration1(kuralobject.getString("transliteration1"));
                kuralmodel.setTransliteration2(kuralobject.getString("transliteration2"));
                kuralmodel.setNumber(Integer.valueOf(kuralobject.getString("Number")));

                kural.add(kuralmodel);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        adapter = new KuralAdapter(this, kural, new Listener() {
            @Override
            public void onclick(int position) {
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                Log.e("onclick position", String.valueOf(position));
                i.putExtra("position",position);
                startActivity(i);
            }
        });
        recyclerView.setAdapter(adapter);

    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("kural.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}