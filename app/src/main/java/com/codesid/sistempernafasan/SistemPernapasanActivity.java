package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SistemPernapasanActivity extends AppCompatActivity {

    @BindView(R.id.imgGif)
    ImageView imgGif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistem_pernapasan);

        ButterKnife.bind(this);
        Glide.with(this)
                .asGif()
                .load(R.drawable.as)
                .into(imgGif);
    }
}