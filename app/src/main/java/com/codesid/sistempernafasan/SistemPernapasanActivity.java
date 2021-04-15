package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

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

    String materi[]={
                "Pernapasan adalah proses menghirup udara bebas yang mengandung oksigen (inspirasi) dan mengeluarkan udara yang mengandung karbondioksida (ekspirasi).\n" +
                        "\n" +
                        "Ada dua proses pernapasan pada manusia:\n" +
                        "Respirasi eksternal, yaitu pertukaran oksigen dan karbon dioksida dari atmosfer dengan paru-paru (alveolus).\n" +
                        "Respirasi internal, yaitu pertukaran oksigen dan karbon dioksida  antara kapiler darah dengan sel-sel tubuh.\n"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistem_pernapasan);

        ButterKnife.bind(this);

        txtSistemPernapasan.setText(materi[0]);

        Glide.with(this)
                .asGif()
                .load(R.drawable.as)
                .into(imgGif);
    }
}