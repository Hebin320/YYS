package com.hebin.yys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TongRenShangActivity extends AppCompatActivity implements MyItemClickListener {

    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.tb_title)
    Toolbar tbTitle;
    @InjectView(R.id.rv_tongrenshang)
    RecyclerView rvTongrenshang;


    String[] info = {
            "阴阳寮日常丨看粘土与式神碰撞出的火花",
            "阴阳寮日常丨扒一扒寮院里那些辣眼睛的事儿",
            "阴阳寮日常丨论攻略冰山少女的正确方式",
            "阴阳寮日常丨寮院二三事",
            "阴阳寮日常丨后面非洲的朋友，你们好吗！",
            "阴阳寮日常丨小鹿男依赖症",
            "阴阳寮日常丨没出息的阴阳师一家",
            "阴阳寮日常丨关于隔壁大天狗",
            "阴阳寮日常丨用粘土的方式打开式神录",
            "阴阳寮日常丨叮！一草当关！万夫莫开！",
            "阴阳寮日常丨式神的正确养成攻略",
            "阴阳寮日常丨关于隔壁的茨木·续集",
            "阴阳寮日常丨看完这个刷新你对结界突破的认识！",
            "阴阳寮日常丨我家男神不可能这么撩",
            "阴阳寮日常丨听说你们想听男神音唱歌？",
            "阴阳寮日常丨关于隔壁的茨木",
            "阴阳寮日常丨粘土上の式神",
            "阴阳寮日常丨萌化的男神你们爱吗？",
            "阴阳寮日常丨这，不是一堆普通的像素方块儿",
            "阴阳寮日常丨阴阳师寓言故事集",
    };

    int[] image = {
            R.mipmap.ic_trs_01,
            R.mipmap.ic_trs_02,
            R.mipmap.ic_trs_03,
            R.mipmap.ic_trs_04,
            R.mipmap.ic_trs_03,
            R.mipmap.ic_trs_02,
            R.mipmap.ic_trs_04,
            R.mipmap.ic_trs_03,
            R.mipmap.ic_trs_05,
            R.mipmap.ic_trs_06,
            R.mipmap.ic_trs_03,
            R.mipmap.ic_trs_07,
            R.mipmap.ic_trs_08,
            R.mipmap.ic_trs_07,
            R.mipmap.ic_trs_09,
            R.mipmap.ic_trs_04,
            R.mipmap.ic_trs_10,
            R.mipmap.ic_trs_07,
            R.mipmap.ic_trs_04,
            R.mipmap.ic_trs_11,
    };

    String[] link = {
            "http://mp.weixin.qq.com/s/BIwDHP3k8kAs51aJueLang",
            "http://mp.weixin.qq.com/s/JuwuM22MREBZRHA0XkGOwQ",
            "http://mp.weixin.qq.com/s/QRF9krhZFNAcIYBMIRWqvA",
            "http://mp.weixin.qq.com/s/2-bY2t0USsXD0PwUB7BLjQ",
            "http://mp.weixin.qq.com/s/iQQ3IhJ4-Q4kBzbqw4PfUw",
            "http://mp.weixin.qq.com/s/pF0dw3HiTqmdQqqEq5Qw2Q",
            "http://mp.weixin.qq.com/s/_1hRlbbHe-K9STu8N4kZXQ",
            "http://mp.weixin.qq.com/s/KwQ4M1Mo2gdgvqlYYvFWsw",
            "http://mp.weixin.qq.com/s/oswnt8L3djeW2f-a4dbbTw",
            "http://mp.weixin.qq.com/s/xJZzYT4U7AbmGLAOrG2uCg",
            "http://mp.weixin.qq.com/s/PnwOdq9n8dhiUh2zZa6DZg",
            "http://mp.weixin.qq.com/s/_8N1hqFiBOCqVW68g_KlNA",
            "http://mp.weixin.qq.com/s/yRzRXTA9YoIraWUOYe86aA",
            "http://mp.weixin.qq.com/s/Hr_O18Jdvtol7Q8bQ4zlJQ",
            "http://mp.weixin.qq.com/s/5qJQmZZ7QO2yxWX8989vSA",
            "http://mp.weixin.qq.com/s/ebGDBatv8LKY_ZaveCCc_A",
            "http://mp.weixin.qq.com/s/05BuQU3Vc5u0Rx9LzZqI_Q",
            "http://mp.weixin.qq.com/s/2K6alXd-WFcXZCBkDJqOkA",
            "http://mp.weixin.qq.com/s/Apkbt_d_ob6EXALZBcWBsg",
            "http://mp.weixin.qq.com/s/eiSuYa4kLqldaHWCZFgSgQ",
    };

    private List<DateEntity.ResultsEntity> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tong_ren_shang);
        ButterKnife.inject(this);

        for (int i = 0; i < info.length; i++) {
            DateEntity.ResultsEntity resultsEntity = new DateEntity.ResultsEntity();
            resultsEntity.setInfo(info[i]);
            resultsEntity.setImg(image[i]);
            list.add(resultsEntity);
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTongrenshang.setLayoutManager(manager);
        RecyclerAdapter adapter = new RecyclerAdapter(this, list);
        rvTongrenshang.setAdapter(adapter);
        adapter.setListener(this);
    }

    @OnClick({R.id.iv_back, R.id.rv_tongrenshang})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(View view, int postion) {
        Intent intent = new Intent();
        intent.putExtra("link", link[postion]);
        intent.setClass(this, ManHuaActivity.class);
        startActivity(intent);
    }
}
