package com.boroda.dictionary;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class MyActivity extends Activity implements View.OnClickListener {

    TextView tvTranslated;
    Button btnCheck;
    Button btnNext;
    EditText etTranslation;
    TextView tvResult;
    TextView tvStatistic;
    String inputValue = "";
    int index;
    List dict;
    Dictionary d = new Dictionary();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        try {
            dict = d.initCsvDict();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        f.save("firstfile", context=getApplicationContext());
//        f.writeFile(getApplicationContext());
//        context=getApplicationContext();
//        File ff = context.getFilesDir();
//        String ss = ff.getAbsolutePath();
//        File r= ff.listFiles()[0];
//        String g = f.read("file");
//        System.out.println(g);




        tvTranslated = (TextView) findViewById(R.id.translatedWord);
        etTranslation = (EditText) findViewById(R.id.etTranslation);
        tvStatistic = (TextView) findViewById(R.id.tvStatistic);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnCheck.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        index = d.getRandomIndexFromDict(dict.size());
        tvTranslated.setText(d.getNewEngWordFromDict(dict, index));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //  d.writeСsv(getResources());

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCheck:
                inputValue = String.valueOf(etTranslation.getText());
                if (d.getTranslationFromDict(dict, index).contains(inputValue) && inputValue.length() >= 1) {
                    tvResult.setText("Правильно");
                    d.increaseSuccessfulCounter(index);
                } else {
                    tvResult.setText("Неправильно");
                }

                break;
            case R.id.btnNext:
                index = d.getRandomIndexFromDict(dict.size());
                tvTranslated.setText(d.getNewEngWordFromDict(dict, index));
                etTranslation.setText("");
                tvResult.setText("");
                break;
        }
    }

}
