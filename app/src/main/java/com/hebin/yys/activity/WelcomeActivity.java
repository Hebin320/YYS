package com.hebin.yys.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.hebin.yys.R;

import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class WelcomeActivity extends AppCompatActivity {

    @InjectView(R.id.iv_main)
    ImageView ivMain;

    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        ButterKnife.inject(this);
        int a = new Random().nextInt(25);
        switch (a) {
            case 0:
                ivMain.setImageResource(R.mipmap.ic_welcome_01);
                break;
            case 1:
                ivMain.setImageResource(R.mipmap.ic_welcome_02);
                break;
            case 2:
                ivMain.setImageResource(R.mipmap.ic_welcome_03);
                break;
            case 3:
                ivMain.setImageResource(R.mipmap.ic_welcome_04);
                break;
            case 4:
                ivMain.setImageResource(R.mipmap.ic_welcome_05);
                break;
            case 5:
                ivMain.setImageResource(R.mipmap.ic_welcome_06);
                break;
            case 6:
                ivMain.setImageResource(R.mipmap.ic_welcome_07);
                break;
            case 7:
                ivMain.setImageResource(R.mipmap.ic_welcome_08);
                break;
            case 8:
                ivMain.setImageResource(R.mipmap.ic_welcome_09);
                break;
            case 9:
                ivMain.setImageResource(R.mipmap.ic_welcome_10);
                break;
            case 10:
                ivMain.setImageResource(R.mipmap.ic_welcome_11);
                break;
            case 11:
                ivMain.setImageResource(R.mipmap.ic_welcome_12);
                break;
            case 12:
                ivMain.setImageResource(R.mipmap.ic_welcome_13);
                break;
            case 13:
                ivMain.setImageResource(R.mipmap.ic_welcome_14);
                break;
            case 14:
                ivMain.setImageResource(R.mipmap.ic_welcome_15);
                break;
            case 15:
                ivMain.setImageResource(R.mipmap.ic_welcome_16);
                break;
            case 16:
                ivMain.setImageResource(R.mipmap.ic_welcome_17);
                break;
            case 17:
                ivMain.setImageResource(R.mipmap.ic_welcome_18);
                break;
            case 18:
                ivMain.setImageResource(R.mipmap.ic_welcome_19);
                break;
            case 19:
                ivMain.setImageResource(R.mipmap.ic_welcome_20);
                break;
            case 20:
                ivMain.setImageResource(R.mipmap.ic_welcome_21);
                break;
            case 21:
                ivMain.setImageResource(R.mipmap.ic_welcome_22);
                break;
            case 22:
                ivMain.setImageResource(R.mipmap.ic_welcome_23);
                break;
            case 23:
                ivMain.setImageResource(R.mipmap.ic_welcome_24);
                break;
            default:
                break;
        }
        setTime();
    }

    @Override
    protected void onDestroy() {
        countDownTimer.cancel();
        super.onDestroy();
    }

    private void setTime() {
        countDownTimer = new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                finish();
            }
        }.start();
    }
}
