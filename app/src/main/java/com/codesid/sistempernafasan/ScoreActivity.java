package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScoreActivity extends AppCompatActivity {

    @BindView(R.id.txt_score)
    TextView txt_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ButterKnife.bind(this);


        txt_score.setText(String.valueOf(getIntent().getIntExtra("score", 0)) );

    }
}