    package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

    public class MainMenu extends AppCompatActivity {

     @BindView(R.id.img_btn_petunjuk)
     ImageView img_btn_petunjuk;
     @BindView(R.id.img_btn_profile)
     ImageView img_btn_profile;
     @BindView(R.id.img_btn_info)
     ImageView img_btn_info;
     @BindView(R.id.img_btn_exit)
     ImageView img_btn_exit;
        @BindView(R.id.btnMenuLatihan)
        ImageView btnMenuLatihan;
        @BindView(R.id.btnMenuMateri)
        ImageView btnMenuMateri;
        @BindView(R.id.btnMenuVideo)
        ImageView btnMenuVideo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ButterKnife.bind(this);
        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.menu);
        mp.start();


        Animation connectingAnimation = AnimationUtils.loadAnimation(MainMenu.this, R.anim.alpha_scale_animation);
        img_btn_petunjuk.startAnimation(connectingAnimation);
        img_btn_exit.startAnimation(connectingAnimation);
        img_btn_info.startAnimation(connectingAnimation);
        img_btn_profile.startAnimation(connectingAnimation);
        btnMenuMateri.startAnimation(connectingAnimation);
        btnMenuVideo.startAnimation(connectingAnimation);
        btnMenuLatihan.startAnimation(connectingAnimation);


        btnMenuLatihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(MainMenu.this,ActivityLatihan.class);
                startActivity(intent);
                mp.release();
                finish();

            }
        });
        btnMenuMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(MainMenu.this,MateriActivity.class);
                startActivity(intent);
                mp.release();
                finish();

            }
        });
        btnMenuVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(MainMenu.this,VideoActivity.class);
                startActivity(intent);
                mp.release();
                finish();

            }
        });

        img_btn_petunjuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                view.startAnimation(AnimationUtils.loadAnimation(MainMenu.this, R.anim.image_click));
                Dialog alertDialog = new Dialog(MainMenu.this);
                alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                alertDialog.setContentView(R.layout.dialog_petunjuk);
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.setCancelable(false);
                ImageView img_close = (ImageView) alertDialog.findViewById(R.id.img_btn_exit_dialog1);

                img_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp_click.start();
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();

            }
        });
        img_btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                view.startAnimation(AnimationUtils.loadAnimation(MainMenu.this, R.anim.image_click));
                Dialog alertDialog = new Dialog(MainMenu.this);
                alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                alertDialog.setContentView(R.layout.dialog_petunjuk);
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.setCancelable(false);
                ImageView imgDialog = (ImageView) alertDialog.findViewById(R.id.imgInsideDialog);
                imgDialog.setImageResource(R.drawable.developer);
                ImageView img_close = (ImageView) alertDialog.findViewById(R.id.img_btn_exit_dialog1);

                img_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp_click.start();
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();
            }
        });
        img_btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                view.startAnimation(AnimationUtils.loadAnimation(MainMenu.this, R.anim.image_click));
                Dialog alertDialog = new Dialog(MainMenu.this);
                alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                alertDialog.setContentView(R.layout.dialog_petunjuk);
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.setCancelable(false);
                ImageView imgDialog = (ImageView) alertDialog.findViewById(R.id.imgInsideDialog);
                imgDialog.setImageResource(R.drawable.petunjuk);
                ImageView img_close = (ImageView) alertDialog.findViewById(R.id.img_btn_exit_dialog1);

                img_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp_click.start();
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();
            }
        });
        img_btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                view.startAnimation(AnimationUtils.loadAnimation(MainMenu.this, R.anim.image_click));
                Dialog alertDialog = new Dialog(MainMenu.this);
                alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                alertDialog.setContentView(R.layout.dialog_exit);
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.setCancelable(false);
                ImageView btn_yes = (ImageView) alertDialog.findViewById(R.id.btn_yes_exit);
                ImageView btn_no = (ImageView) alertDialog.findViewById(R.id.btn_no_exit);
                btn_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mp_click.start();
                        finishAffinity();
                        System.exit(0);
                    }
                });
                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mp_click.start();
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });


    }


        @Override
        public void onBackPressed() {
            
        }
    }