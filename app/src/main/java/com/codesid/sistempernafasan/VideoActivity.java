package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends AppCompatActivity {
    @BindView(R.id.btnPlayVideo)
    ImageView btnPlayVideo;
    @BindView(R.id.btnBackVideo)
    ImageView btnBackVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);

        btnPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(VideoActivity.this,VideoPlayActivity.class);
                startActivity(intent);
            }
        });

        btnBackVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(VideoActivity.this,MainMenu.class);
                startActivity(intent);
            }
        });


    }
}