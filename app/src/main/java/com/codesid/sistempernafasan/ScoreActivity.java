package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;

public class ScoreActivity extends AppCompatActivity {

    @BindView(R.id.txt_score)
    TextView txt_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            txt_score.setText(extras.getInt("score"));
        }
    }
}