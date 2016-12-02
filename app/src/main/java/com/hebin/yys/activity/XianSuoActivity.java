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
import com.hebin.yys.help.MyItemClickListener;
import com.hebin.yys.R;
import com.hebin.yys.adapter.RecyclerAdapter;
import com.hebin.yys.search.CharacterParser;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class XianSuoActivity extends AppCompatActivity implements MyItemClickListener {

    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.tb_title)
    Toolbar tbTitle;
    @InjectView(R.id.et_search)
    EditText etSearch;
    @InjectView(R.id.iv_delete)
    ImageView ivDelete;
    @InjectView(R.id.rv_list)
    RecyclerView rvList;
    @InjectView(R.id.sv_main)
    NestedScrollView svMain;


    private List<DateEntity.ResultsEntity> list = new ArrayList<>();

    private String[] info = {
            "羽毛/笛子/扇\n\n大天狗\n\n第15/18章、御魂4/10",
            "水池\n\n鲤鱼精\n\n第7章、御魂2/3/9",
            "樱花树/红色\n\n三尾狐\n\n第6/18章、御魂1",
            "单眼/石锤/怪力\n\n山童\n\n第8/16章、御魂1/7",
            "黑镰/短刀\n\n鬼使黑\n\n妖气封印、第16章、御魂4",
            "单眼/石菩萨、金刚经\n\n独眼小僧\n\n第11章、御魂1/5",
            "鬼火/角 财富/幸运\n\n座敷童子\n\n第2章、御魂3/6",
            "翅膀/羽衣/幼女\n\n童女\n\n第3/11/12章、御魂2/4",
            "渔夫、海、胡须、杖\n\n海坊主\n\n第12章、妖气封印、御魂3",
            "纸扇、书生、面具\n\n妖狐\n\n第7章、御魂2",
            "鼓、单眼\n\n天邪鬼黄\n\n第3、5、12章",
            "人偶、操纵\n\n傀儡师\n\n第10章、御魂5",
            "锤子、钉耙、剑\n\n镰鼬\n\n御魂5，第18章式神挑战以及，式神副本",
            "铃铛、噩梦\n\n食梦貘\n\n第14章、御魂4/9",
            "青皮肤、风筝\n\n天邪鬼青\n\n第2/5/6/10/11章",
            "石、青苔\n\n凃壁\n\n第4/14章、御魂1",
            "水球、河流、荷叶\n\n河童\n\n第7章、御魂2",
            "蒲公英、治疗\n\n萤草\n\n御魂2/9/10",
            "杖妖艳/红尾\n\n三尾狐\n\n第6/18章、御魂1",
            "雉刀、翅膀、面具\n\n鸦天狗\n\n第3/9/12/17/18章、御魂6",
            "二筒、瓷、出千\n\n青蛙瓷器\n\n第4章、御魂3",
            "手鼓、小妖精、可爱\n\n蝴蝶精\n\n第6/8章、御魂3/8",
            "汤碗、琴、牙牙\n\n孟婆\n\n第9章、御魂5/6",
            "剑雀、屋、守护\n\n犬神\n\n第10章、御魂4",
            "贝壳、扇子、尾巴\n\n椒图\n\n妖气封印、御魂3/8/9/10",
            "云、鬼面、冥界\n\n阎魔\n\n御魂6",
            "大翅膀、风、扇\n\n大天狗\n\n第15/18章、御魂4/10",
            "翅膀、雨衣、献祭\n\n童男\n\n第12章、御魂4",
            "剑、坚甲、石化\n\n兵俑\n\n第3/10章、御魂2",
            "稻草人、咒锥\n\n丑时之女\n\n第10章、御魂5/7",
            "冥界、白、夺命\n\n鬼使白\n\n第16章、御魂4",
            "红鬼、拍屁股\n\n天邪鬼赤\n\n第4/5/6/7/13/14/15章、御魂1",
            "泪珠、雨、伞\n\n雨女\n\n第4章、御魂6",
            "血、蝙蝠\n\n吸血姬\n\n御魂2层",
            "蜡烛、棺材\n\n跳跳哥哥\n\n第10/12章、御魂5/10、妖气封印",
            "水泡/尾巴\n\n鲤鱼精\n\n第7章、御魂2/3/9",
    };


    /**
     * 汉字转换成拼音的类
     */
    private CharacterParser characterParser;
    private RecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xian_suo);
        ButterKnife.inject(this);
        setSupportActionBar(tbTitle);
        for (int i = 0; i < info.length; i++) {
            DateEntity.ResultsEntity resultsEntity = new DateEntity.ResultsEntity();
            resultsEntity.setInfo(info[i]);
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
        adapter = new RecyclerAdapter(this, list);
        rvList.setAdapter(adapter);
        adapter.setListener(this);
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
                String info = sortModel.getInfo();
                if (info.contains(filterStr) || characterParser.getSelling(info).startsWith(filterStr)) {
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
                            svMain.smoothScrollTo(0, 0);
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


    @Override
    public void onItemClick(View view, int postion) {

    }
}
