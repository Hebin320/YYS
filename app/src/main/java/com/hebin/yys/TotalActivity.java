package com.hebin.yys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TotalActivity extends AppCompatActivity {

    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.rv_list)
    RecyclerView rvList;

    List<DateEntity.ResultsEntity> list = new ArrayList<>();
    String[] strList = {"铁鼠最多：金币妖怪","山兔最多：樱与桃","铁鼠最多：金币妖怪","山兔最多：樱与桃","铁鼠最多：金币妖怪","山兔最多：樱与桃",
            "铁鼠最多：金币妖怪","山兔最多：樱与桃","铁鼠最多：金币妖怪","山兔最多：樱与桃"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        ButterKnife.inject(this);
        for (int i = 0; i < strList.length; i++) {
            DateEntity.ResultsEntity resultsEntity = new DateEntity.ResultsEntity();
            resultsEntity.setName(strList[i]);
            list.add(resultsEntity);
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvList.setLayoutManager(manager);
        TotalAdapter adapter = new TotalAdapter(this, list);
        rvList.setAdapter(adapter);
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
