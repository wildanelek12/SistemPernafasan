package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityLatihan extends AppCompatActivity {

    @BindView(R.id.btnLks)
    ImageView btnLks;
    @BindView(R.id.btnEvaluasi)
    ImageView btnEvaluasi;
    @BindView(R.id.btnBackLatihan)
    ImageView btnBackLatihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan);

        ButterKnife.bind(this);
        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);
        btnEvaluasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(ActivityLatihan.this,EvaluasiActivity.class);
                startActivity(intent);
            }
        });
        btnLks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(ActivityLatihan.this,ActivityLks.class);
                startActivity(intent);
            }
        });
        btnBackLatihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(ActivityLatihan.this,MainMenu.class);
                startActivity(intent);
            }
        });

    }
}