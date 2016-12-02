package com.hebin.yys.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.hebin.yys.R;
import com.hebin.yys.adapter.VpAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class QiDongTuActivity extends AppCompatActivity {

    @InjectView(R.id.iv_back)
    FloatingActionButton ivBack;
    @InjectView(R.id.vp_main)
    ViewPager vpMain;

    int[] imgID = {
            R.mipmap.ic_welcome_01,
            R.mipmap.ic_welcome_02,
            R.mipmap.ic_welcome_03,
            R.mipmap.ic_welcome_04,
            R.mipmap.ic_welcome_05,
            R.mipmap.ic_welcome_06,
            R.mipmap.ic_welcome_07,
            R.mipmap.ic_welcome_08,
            R.mipmap.ic_welcome_09,
            R.mipmap.ic_welcome_10,
            R.mipmap.ic_welcome_11,
            R.mipmap.ic_welcome_12,
            R.mipmap.ic_welcome_13,
            R.mipmap.ic_welcome_14,
            R.mipmap.ic_welcome_15,
            R.mipmap.ic_welcome_16,
            R.mipmap.ic_welcome_17,
            R.mipmap.ic_welcome_18,
            R.mipmap.ic_welcome_19,
            R.mipmap.ic_welcome_20,
            R.mipmap.ic_welcome_21,
            R.mipmap.ic_welcome_22,
            R.mipmap.ic_welcome_23,
            R.mipmap.ic_welcome_24
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_qi_dong_tu);
        ButterKnife.inject(this);
        ArrayList<Fragment> list = new ArrayList<>();
        for (int i = 0; i < imgID.length; i++) {
            WelcomeFragment fragment = WelcomeFragment.newInstance(imgID[i]);
            list.add(fragment);
        }
        VpAdapter adapter = new VpAdapter(getSupportFragmentManager(), list);
        vpMain.setAdapter(adapter);
        vpMain.setOffscreenPageLimit(list.size() - 1);
    }

    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
