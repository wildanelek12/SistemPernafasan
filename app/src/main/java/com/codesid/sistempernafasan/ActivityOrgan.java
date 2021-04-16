package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityOrgan extends AppCompatActivity {


    @BindView(R.id.btnHidung)
    ConstraintLayout btnHidung;
    @BindView(R.id.btnBronkus)
    ConstraintLayout btnBronkus;
    @BindView(R.id.btnBronkiolus)
    ConstraintLayout btnBronkiolus;
    @BindView(R.id.btnAlveolus)
    ConstraintLayout btnAlveolus;
    @BindView(R.id.btnFaring)
    ConstraintLayout btnFaring;
    @BindView(R.id.btnLaring)
    ConstraintLayout btnLaring;
    @BindView(R.id.btnTrakea)
    ConstraintLayout btnTrakea;
    @BindView(R.id.btnParu)
    ConstraintLayout btnParu;
    @BindView(R.id.txtHidung)
    TextView txtHidung;
    @BindView(R.id.txtBronkus)
    TextView txtBronkus;
    @BindView(R.id.txtBronkiolus)
    TextView txtBronkiolus;
    @BindView(R.id.txtAlveolus)
    TextView txtAlveolus;
    @BindView(R.id.txtFaring)
    TextView txtFaring;
    @BindView(R.id.txtLaring)
    TextView txtLaring;
    @BindView(R.id.txtTrakea)
    TextView txtTrakea;
    @BindView(R.id.txtParu)
    TextView txtParu;
    @BindView(R.id.btnBackOrgan)
    ImageView btnBackOrgan;
    


    int skor = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organ);

        ButterKnife.bind(this);

        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);
        btnHidung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                startDetail(0);
            }
        });
        btnBronkus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                startDetail(1);
            }
        });
        btnBronkiolus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                startDetail(2);
            }
        });

        btnAlveolus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                startDetail(3);
            }
        });
        btnFaring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                startDetail(4);
            }
        });
        btnLaring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                startDetail2(5);
            }
        });
        btnTrakea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                startDetail(6);
            }
        });
        btnParu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                startDetail(7);

            }
        });

        btnBackOrgan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                finish();
            }
        });

    }

    public void startDetail(int id){
        Intent intent = new Intent(ActivityOrgan.this,ActivityOrganDetail.class);
        intent.putExtra("key",id);
        startActivity(intent);
    }
    public void startDetail2(int id){
        Intent intent = new Intent(ActivityOrgan.this,ActivityKhususFaring.class);
        intent.putExtra("key",id);
        startActivity(intent);
    }

}