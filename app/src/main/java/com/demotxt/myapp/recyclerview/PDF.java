package com.demotxt.myapp.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class PDF extends AppCompatActivity {
    PDFView book1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        Intent intent = getIntent();
        String PDFAsset = intent.getExtras().getString("PDFAsset");
        book1=(PDFView) findViewById(R.id.pdfbook);

        book1.fromAsset(PDFAsset).load();

    }
}
