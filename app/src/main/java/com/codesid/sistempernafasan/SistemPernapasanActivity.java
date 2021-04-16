package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SistemPernapasanActivity extends AppCompatActivity {

    @BindView(R.id.imgGif)
    ImageView imgGif;
    @BindView(R.id.txtSistemPenapasan)
    TextView txtSistemPernapasan;
    @BindView(R.id.btnNextSistemPernapasan)
    ImageView btnNextSistemPernapasan;
    @BindView(R.id.btnPreviousSistemPernapasan)
    ImageView btnPreviousSistemPernapasan;
    @BindView(R.id.btnBackSistemPernapasan)
    ImageView btnBackSistemPernapasan;


    String materi[]={
                "Pernapasan adalah proses menghirup udara bebas yang mengandung oksigen (inspirasi) dan mengeluarkan udara yang mengandung karbondioksida (ekspirasi).\n" +
                        "\n" +
                        "Ada dua proses pernapasan pada manusia:\n" +
                        "Respirasi eksternal, yaitu pertukaran oksigen dan karbon dioksida dari atmosfer dengan paru-paru (alveolus).\n" +
                        "Respirasi internal, yaitu pertukaran oksigen dan karbon dioksida  antara kapiler darah dengan sel-sel tubuh.\n"

            ,"Sistem organ manusia yang tersusun atas hidung, faring (tekak), laring (ruang suara), trakea (tenggorokan), bronkus, dan paru-paru.\n" +
            "\n" +
            "Secara struktural, sistem pernapasan tersusun atas 2 bagian utama:\n" +
            "Saluran pernapasan bagian atas : rongga hidung dan faring.\n" +
            "Saluran pernapasan bagian bawah: laring, trakea, bronkus, dan paru-paru.\n"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistem_pernapasan);

        ButterKnife.bind(this);

        txtSistemPernapasan.setText(materi[0]);
        btnPreviousSistemPernapasan.setVisibility(View.GONE);

        btnNextSistemPernapasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPreviousSistemPernapasan.setVisibility(View.VISIBLE);
                btnNextSistemPernapasan.setVisibility(View.GONE);
                txtSistemPernapasan.setText(materi[1]);
            }
        });
        btnPreviousSistemPernapasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPreviousSistemPernapasan.setVisibility(View.GONE);
                btnNextSistemPernapasan.setVisibility(View.VISIBLE);
                txtSistemPernapasan.setText(materi[1]);
            }
        });

        btnBackSistemPernapasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Glide.with(this)
                .asGif()
                .load(R.drawable.as)
                .into(imgGif);
    }
}