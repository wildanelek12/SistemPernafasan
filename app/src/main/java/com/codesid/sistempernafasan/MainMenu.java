    package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ButterKnife.bind(this);

        img_btn_petunjuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();

            }
        });

    }
}