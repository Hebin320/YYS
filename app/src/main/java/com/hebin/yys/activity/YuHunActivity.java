package com.hebin.yys.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hebin.yys.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class YuHunActivity extends AppCompatActivity {

    @InjectView(R.id.iv_back)
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yu_hun);
        ButterKnife.inject(this);
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
