package com.demotxt.myapp.recyclerview;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Book_Activity extends AppCompatActivity {

    private TextView tvtitle, tvdescription, txtAuth;
    private ImageView img;
    private Button pdf;
    private Button audio;
    private Button btn3;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_);

        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvdescription = (TextView) findViewById(R.id.txtDesc);

        img = (ImageView) findViewById(R.id.bookthumbnail);
        pdf = (Button) findViewById(R.id.pdf);
        txtAuth = (TextView) findViewById(R.id.txtAuth);
        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        String Author = intent.getExtras().getString("Author");
        final String PDFAsset = intent.getExtras().getString("PDFAsset");
        int image = intent.getExtras().getInt("Thumbnail");

        // Setting values

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        txtAuth.setText(Author);
        img.setImageResource(image);
        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PDF.class);
                intent.putExtra("PDFAsset", PDFAsset);
                getApplicationContext().startActivity(intent);
            }
        });

        mp = MediaPlayer.create(getApplicationContext(), R.raw.audios);
        audio = (Button) findViewById(R.id.audio);
        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp.isPlaying()) {
                    mp.pause();
                } else {
                    mp.start();
                }
            }
        });
        btn3 = (Button) findViewById(R.id.barcode);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                IntentIntegrator intentIntegrator = new IntentIntegrator(Book_Activity.this);
                intentIntegrator.setDesiredBarcodeFormats(intentIntegrator.ALL_CODE_TYPES);
                intentIntegrator.setBeepEnabled(false);
                intentIntegrator.setCameraId(0);
                intentIntegrator.setPrompt("SCAN");
                intentIntegrator.setBarcodeImageEnabled(false);
                intentIntegrator.initiateScan();
            }
        });
    }
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
String txt;
  txt=getIntent().getExtras().getString("Title");
            IntentResult Result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if (Result != null) {
                if (Result.getContents() == null) {
                    Log.d("MainActivity", "cancelled scan");
                    Toast.makeText(this, "cancelled", Toast.LENGTH_LONG).show();
                } else {
                    Log.d("MainActivity", "Scanned");
                    Toast.makeText(this, "Thank you for borrowing " + txt + "" + Result.getContents(), Toast.LENGTH_LONG).show();
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

