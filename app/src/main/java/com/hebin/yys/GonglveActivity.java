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

public class GonglveActivity extends AppCompatActivity implements MyItemClickListener {

    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.tb_title)
    Toolbar tbTitle;
    @InjectView(R.id.rv_gonglve)
    RecyclerView rvGonglve;

    private List<DateEntity.ResultsEntity> list = new ArrayList<>();

    private String[] info = {
            "阴阳天机谱丨从萌新讲起，全面解锁式神育成正确姿势",
            "阴阳天机谱丨你可能还不知道的《阴阳师》冷门小知识",
            "阴阳天机谱丨狗粮卡的逆袭",
            "阴阳天机谱丨一击无心！白狼神教养成攻略",
            "阴阳天机谱丨吸血姬残血反杀的终极奥义！",
            "阴阳天机谱丨感受被凤凰火支配的恐惧吧！",
            "阴阳天机谱丨前排承包小姐姐全方位攻略！",
            "阴阳天机谱丨隔山打牛！手把手教你玩冷门式神丑时之女！",
            "阴阳天机谱丨御魂副本高层（5-8）详细攻略",
            "阴阳天机谱丨论R卡的隐藏套路",
            "阴阳天机谱丨高速型络新妇的日常",
            "阴阳天机谱丨细数那些低配版SSR式神",
            "阴阳天机谱丨阴阳师手游PVP常见套路全解析",
            "阴阳天机谱丨我家二口女养成计划",
    };
    private int[] image = {
            R.mipmap.ic_gonglve_01,
            R.mipmap.ic_gonglve_02,
            R.mipmap.ic_gonglve_03,
            R.mipmap.ic_gonglve_04,
            R.mipmap.ic_gonglve_05,
            R.mipmap.ic_gonglve_06,
            R.mipmap.ic_gonglve_07,
            R.mipmap.ic_gonglve_08,
            R.mipmap.ic_gonglve_09,
            R.mipmap.ic_gonglve_10,
            R.mipmap.ic_gonglve_11,
            R.mipmap.ic_gonglve_12,
            R.mipmap.ic_gonglve_13,
            R.mipmap.ic_gonglve_14,
    };
    private String[] link = {
            "http://mp.weixin.qq.com/s/MTmmLyK6DgV3bkC7ljOycQ",
            "http://mp.weixin.qq.com/s/yBDLixPGyl-m0ej6KYuW7A",
            "http://mp.weixin.qq.com/s/ACX05VfIUslWcQ5-PKa3ew",
            "http://mp.weixin.qq.com/s/SHQ7H7HkrhRYRIpqNNJzWg",
            "http://mp.weixin.qq.com/s/he8_ZpTMSntjF_RHu9vjIw",
            "http://mp.weixin.qq.com/s/z_xW0tEINTB-KskrOwTgcQ",
            "http://mp.weixin.qq.com/s/tpWQjp2EcKrXhq5tn1SRbA",
            "http://mp.weixin.qq.com/s/owrx9_aeHgM7EhfztqYPXg",
            "http://mp.weixin.qq.com/s/Pnvsue1nuW2BdV_L_hlecA",
            "http://mp.weixin.qq.com/s/FJuKyyxtVjO25nwOoNnEiQ",
            "http://mp.weixin.qq.com/s/SVAI_Snh5R63uOCqUbjEsg",
            "http://mp.weixin.qq.com/s/05NEDAyzJsboF3uK4itYvA",
            "http://mp.weixin.qq.com/s/h1YoNdqZXvES5UpdFoec3Q",
            "http://mp.weixin.qq.com/s/adptUVFRoATS6zMIkp65kw",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gonglve);
        ButterKnife.inject(this);
        for (int i = 0; i < info.length; i++) {
            DateEntity.ResultsEntity resultsEntity = new DateEntity.ResultsEntity();
            resultsEntity.setInfo(info[i]);
            resultsEntity.setImg(image[i]);
            list.add(resultsEntity);
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvGonglve.setLayoutManager(manager);
        RecyclerAdapter adapter = new RecyclerAdapter(this, list);
        rvGonglve.setAdapter(adapter);
        adapter.setListener(this);
    }

    @OnClick({R.id.iv_back})
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
