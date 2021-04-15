package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EvaluasiActivity extends AppCompatActivity {

    @BindView(R.id.btnStartEvaluasi)
    ImageView btnStartEvaluasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluasi);

        ButterKnife.bind(this);

        btnStartEvaluasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EvaluasiActivity.this,ActivityEvaluasiSoal.class);
                startActivity(intent);
            }
        });


    }
}