package com.example.sony.septian_1106130171_studycase4;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.net.URL;

public class carigambar extends AppCompatActivity {

    EditText pencarian;
    Button cari;
    ImageView foto;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carigambar);

        getSupportActionBar().hide();
        pencarian = (EditText) findViewById(R.id.edtCariGambar);
        cari = (Button) findViewById(R.id.btnCari);
        foto = (ImageView) findViewById(R.id.gambar);
    }
    public void search(View view) {
        foto = (ImageView)findViewById(R.id.gambar);
        pencarian = (EditText)findViewById(R.id.edtCariGambar);

        String urlGambar = pencarian.getText().toString();
//        String stoneisland= "https://seeklogo.com/vector-logo/321649/stone-island#"
//        String fredperry = "http://master-logo.blogspot.co.id/2015/05/fred-perry-logo-vector.html"
        Glide.with(carigambar.this)
                // LOAD URL DARI INTERNET
                .load(urlGambar)
                // LOAD GAMBAR AWAL SEBELUM GAMBAR UTAMA MUNCUL, BISA DARI LOKAL DAN INTERNET
                .placeholder(R.drawable.fredperry)
                //. LOAD GAMBAR SAAT TERJADI KESALAHAN MEMUAT GMBR UTAMA
                .error(R.drawable.stoneislandlogo)
                .into(foto);
    }}

