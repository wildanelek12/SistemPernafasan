package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MateriActivity extends AppCompatActivity {

    @BindView(R.id.btn_materi_organ)
    ImageView btn_materi_organ;
    @BindView(R.id.btn_materi_volume)
    ImageView btn_materi_volume;
    @BindView(R.id.btn_materi_frekuensi)
    ImageView btn_materi_frekuensi ;
    @BindView(R.id.btn_materi_pernapasan)
    ImageView btn_materi_pernapasan ;
    @BindView(R.id.btn_materi_gangguan)
    ImageView btn_materi_gangguan ;
    @BindView(R.id.btn_materi_mekanisme)
    ImageView btn_materi_mekanisme ;
    @BindView(R.id.btnBackMateri)
    ImageView btnBackMateri ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        ButterKnife.bind(this);
        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);
        btn_materi_organ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(MateriActivity.this,ActivityOrgan.class);
                startActivity(intent);
            }
        });

        btn_materi_volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(MateriActivity.this,VolumeActivity.class);
                startActivity(intent);
            }
        });


        btn_materi_frekuensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(MateriActivity.this,FrekuensiActivity.class);
                startActivity(intent);
            }
        });
        btn_materi_pernapasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(MateriActivity.this,SistemPernapasanActivity.class);
                startActivity(intent);
            }
        });

        btn_materi_gangguan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(MateriActivity.this,GangguanActivity.class);
                startActivity(intent);
            }
        });
        btn_materi_mekanisme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(MateriActivity.this,MekanismeActivity.class);
                startActivity(intent);
            }
        });
        btnBackMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(MateriActivity.this,MainMenu.class);
                startActivity(intent);
            }
        });



    }
}