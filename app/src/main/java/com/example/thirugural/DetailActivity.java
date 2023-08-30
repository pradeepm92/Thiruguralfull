package com.example.thirugural;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.thirugural.Model.Kural;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    TextView Translation,mv,sp,mk,couplet,explanation,transliteration1,transliteration2;
    int position;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Translation=findViewById(R.id.Translationdet);
        mv=findViewById(R.id.mvdet);
        sp=findViewById(R.id.spdet);
        mk=findViewById(R.id.mkdet);
        couplet=findViewById(R.id.coupletdet);
        explanation=findViewById(R.id.explanationdet);
        transliteration1=findViewById(R.id.transliteration1det);
        transliteration2=findViewById(R.id.transliteration2det);
        dointent();


        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray jsonArray = obj.getJSONArray("kural");
            Log.e("position", String.valueOf(position));
            JSONObject kuralobject = jsonArray.getJSONObject(position);

            Log.e("kural",kuralobject.toString());

            Kural kuralmodel=new Kural();
            kuralmodel.setTranslation(kuralobject.getString("Translation"));
            kuralmodel.setMv(kuralobject.getString("mv"));
            kuralmodel.setSp(kuralobject.getString("sp"));
            kuralmodel.setMk(kuralobject.getString("mk"));
            kuralmodel.setCouplet(kuralobject.getString("couplet"));
            kuralmodel.setExplanation(kuralobject.getString("explanation"));
            kuralmodel.setTransliteration1(kuralobject.getString("transliteration1"));
            kuralmodel.setTransliteration2(kuralobject.getString("transliteration2"));

            Translation.setText(kuralmodel.getTranslation());
            mv.setText(kuralmodel.getMv());
            mk.setText(kuralmodel.getMk());
            sp.setText(kuralmodel.getSp());
            transliteration1.setText(kuralmodel.getTransliteration1());
            transliteration2.setText(kuralmodel.getTransliteration2());
            explanation.setText(kuralmodel.getExplanation());
            couplet.setText(kuralmodel.getCouplet());


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void dointent() {
     Intent i=getIntent();
        position = i.getIntExtra("position",0);
        Log.e("intentposition", String.valueOf(position));
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