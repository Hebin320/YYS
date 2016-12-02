package com.hebin.yys.activity;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.hebin.yys.entity.DateEntity;
import com.hebin.yys.R;
import com.hebin.yys.adapter.TotalAdapter;
import com.hebin.yys.search.CharacterParser;

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
    @InjectView(R.id.et_search)
    EditText etSearch;
    @InjectView(R.id.iv_delete)
    ImageView ivDelete;


    List<DateEntity.ResultsEntity> list = new ArrayList<>();
    String[] strList = {"山童 - 第8、16章 、御魂1\n推荐：第十六章饿鬼有2只", "獨眼小僧 - 第11章、御魂1、5\n推荐：第11章武士之灵2有3只", "童女 - 第3、11、12章，御魂2、4\n推荐：第3章天邪鬼黄2有3只，第12章童女有3只",
            "妖狐 - 第7章，御魂2\n推荐：御魂2层", "灯笼鬼 - 第1、2、3、5、6、7、9、13、17章\n推荐：第9章提灯小僧1有3只", "涂壁 - 第3、4、5、6、7、8、11、12、14章、御魂1\n推荐：第14章涂壁1、2各有6只",
            "赤舌 - 第3、10、15、16章\n推荐：第3章赤舌1、2各1只", "天邪鬼赤 - 第4、5、6、7、13、14、15章、御魂1\n推荐：第4章唐纸伞妖1有3只", "天邪鬼黄 - 第3、5、12章\n推荐：第5章帚神2、管狐1各2只",
            "天邪鬼青 - 第2、5、6、10、11章\n推荐：第10章，丑时之女1出2只", "天邪鬼绿 - 第1、2、5、6、8、13、15章\n推荐：第6章天邪鬼青有3只", "山兔 - 第9、13、16、17章\n推荐：第9章山兔1有3只，山兔2有4只",
            "帚神 - 第2、3、4、5、6、7、8、9、12、14章\n推荐：第6、7、8、9章", "桃花妖 - 第8章、御魂3\n推荐：御魂3", "大天狗 - 第15、18章、御魂4、10\n推荐：御魂4",
            "鲤鱼精 - 第7章、御魂2、3、9\n推荐：第7章", "三尾狐 - 第6、18章、御魂1\n推荐：第6章", "鬼使黑 - 妖气封印、第16章、御魂4\n推荐：御魂4", "座敷童子 - 第2、10章、御魂3/6\n推荐：御魂3、第10章",
            "海坊主 - 第12章、妖气封印、御魂3\n推荐：御魂3、妖气封印", "傀儡师 - 第10章、御魂5\n推荐：第10章", "河童 - 第7章、御魂2\n推荐：御魂2、第7章",
            "萤草 - 御魂2、9、10\n推荐：御魂2", "鸦天狗 - 第3、9、12、17、18章、御魂6\n推荐：第12章海坊主2、童男1、2各2只", "青蛙瓷器 - 第4章、御魂3\n推荐：御魂3",
            "蝴蝶精 - 第6、8章、御魂3、8\n推荐：御魂3", "丑时之女 - 第10章、御魂5、7\n推荐：第10章", "跳跳犬 - 第1章困难、第7章、跳跳妹妹召唤\n推荐：第7章", "觉 - 第10、11章、御魂10\n推荐：第10章",
            "寄生魂 - 第2、3、5、7、11、12、16章\n推荐：第11章武士之灵1有3只", "首无 - 第13章\n推荐：第13章", "盗墓小鬼 - 第2、12章\n推荐：第2、12章",
            "狸猫 - 第10、17章、御魂9\n推荐：第10章觉1有3只", "铁鼠 - 第9章、金币妖怪\n推荐：金币妖怪", "唐纸伞妖 - 第4/8/13章\n推荐：第4/8/13章", "二口女 - 御魂10、妖气封印\n推荐：妖气封印",
            "武士之灵 - 第11、12章\n推荐：第11章", "饿鬼 - 第9、11、13、16章、御魂8\n推荐：第11章饿鬼2有3只", "黑豹 - 第5章\n推荐：第5章", "食发鬼 -第5、10章、御魂7\n推荐：第10章首领有2只",};

    @InjectView(R.id.tb_title)
    Toolbar tbTitle;
    @InjectView(R.id.sv_total)
    NestedScrollView svTotal;

    /**
     * 汉字转换成拼音的类
     */
    private CharacterParser characterParser;
    private TotalAdapter adapter;

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
        LinearLayoutManager manager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvList.setLayoutManager(manager);
        adapter = new TotalAdapter(this, list);
        rvList.setAdapter(adapter);
        initViews();
        setTitleClick();
    }

    @OnClick({R.id.iv_back, R.id.iv_delete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_delete:
                etSearch.setText("");
                break;
        }
    }

    private void initViews() {
        //实例化汉字转拼音类
        characterParser = CharacterParser.getInstance();
        //根据输入框输入值的改变来过滤搜索
        etSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
                if (s.toString().length() > 0) {
                    ivDelete.setVisibility(View.VISIBLE);
                } else {
                    ivDelete.setVisibility(View.GONE);
                }
            }
        });
    }


    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<DateEntity.ResultsEntity> filterDateList = new ArrayList<>();
        if (TextUtils.isEmpty(filterStr)) {
            filterDateList = list;
        } else {
            filterDateList.clear();
            for (DateEntity.ResultsEntity sortModel : list) {
                String name = sortModel.getName();
                if (name.contains(filterStr) || characterParser.getSelling(name).startsWith(filterStr)) {
                    filterDateList.add(sortModel);
                }
            }
        }
        adapter.updateListView(filterDateList);
    }

    int count = 0;
    long firClick, secClick;

    private void setTitleClick() {
        tbTitle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    count++;
                    if (count == 1) {
                        firClick = System.currentTimeMillis();
                    } else if (count == 2) {
                        secClick = System.currentTimeMillis();
                        if (secClick - firClick < 1000) {
                            svTotal.smoothScrollTo(0, 0);
                        }
                        count = 0;
                        firClick = 0;
                        secClick = 0;
                    }
                }
                return true;
            }
        });
    }

}
