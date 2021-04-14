package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        ButterKnife.bind(this);

        btn_materi_organ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MateriActivity.this,ActivityOrgan.class);
                startActivity(intent);
            }
        });

        btn_materi_volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MateriActivity.this,VolumeActivity.class);
                startActivity(intent);
            }
        });


        btn_materi_frekuensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MateriActivity.this,VolumeActivity.class);
                startActivity(intent);
            }
        });
        btn_materi_pernapasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MateriActivity.this,SistemPernapasanActivity.class);
                startActivity(intent);
            }
        });




    }
}