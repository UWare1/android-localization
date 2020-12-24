package com.emericoapp.languages;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    public static final String[] languages ={"Language","English","Arabic","Chinese"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedLang = adapterView.getItemAtPosition(i).toString();
                if(selectedLang.equals("Chinese")){
                    setLocal(MainActivity.this,"zh");
                    Intent intent = new Intent(MainActivity.this, ScreenTwo.class);
                    startActivity(intent);
                }
                else if(selectedLang.equals("Arabic")){
                    setLocal(MainActivity.this, "ar");
                    Intent intent = new Intent(MainActivity.this, ScreenTwo.class);
                    startActivity(intent);
                }
                else if(selectedLang.equals("English")){
                    setLocal(MainActivity.this,"en");
                    Intent intent = new Intent(MainActivity.this, ScreenTwo.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Please select a Language", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public  void setLocal(Activity activity, String langCode){
        Locale locale = new Locale(langCode);
        locale.setDefault(locale);

        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config,resources.getDisplayMetrics());
    }
}
