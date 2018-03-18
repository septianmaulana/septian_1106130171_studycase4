package com.example.sony.septian_1106130171_studycase4;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listnama extends AppCompatActivity {

    ProgressDialog progressDialog;
    ListView listView;
    Button start, pindah;
    private String[] nama = {"Vladimir", "Mahatma", "ilija", "Doni", "Indah", "Fernando", "Shinta", "Reva", "Putra", "Wiliiam"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listnama);
        getSupportActionBar().setTitle("AsynTask");
        listView = (ListView)findViewById(R.id.listMahasiswa);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));
        pindah = (Button)findViewById(R.id.btnPindah);
        start = (Button)findViewById(R.id.btnStart);
        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(listnama.this, carigambar.class);
                startActivity(next);
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyTask().execute();
            }
        });

    }

    class MyTask extends AsyncTask<Void, String, String>{


        ArrayAdapter <String> adapter;
        int count;
        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            adapter = (ArrayAdapter<String>)listView.getAdapter();
            progressDialog = ProgressDialog.show(listnama.this,"Loading Data","Wait for 10 Seconds...");
            progressDialog.setCancelable(true);
            progressDialog.setMax(100);
            progressDialog.setProgress(0);
            count = 0;
        }

        @Override
        protected String doInBackground(Void... voids) {

            for (String Name : nama){
                publishProgress(Name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Names Successfully Added";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //super.onProgressUpdate(values);
            adapter.add(values[0]);
            count ++;
            progressDialog.setProgress(count);
        }

        @Override
        protected void onPostExecute(String result) {
            //super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }
    }
}

