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

public class ZhuanjiActivity extends AppCompatActivity implements MyItemClickListener {

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

    private String[] title = {"阎魔", "大天狗", "妖刀姬", "青行灯", "两面佛", "小鹿男", "荒川之主", "酒吞童子", "茨木童子", "一目连",
            "白狼", "镰鼬", "孟婆", "判官", "清姬", "犬神", "雪女", "妖狐", "妖琴师", "鬼使白", "鬼使黑", "樱花妖", "桃花妖", "二口女", "凤凰火", "姑获鸟", "海坊主", "惠比寿",
            "傀儡师","络新妇","食梦貘","吸血姬","跳跳哥哥","鬼女红叶","般若",
            "觉", "兵佣", "饿鬼", "管狐", "河童", "椒图", "狸猫", "山童", "山兔", "首无", "铁鼠", "童男", "童女", "萤草", "雨女", "蝴蝶精", "九命猫", "鲤鱼精",
            "三尾狐","食发鬼","巫蛊师","鸦天狗","丑时之女","独眼小僧","青蛙瓷器" ,"跳跳弟弟","跳跳妹妹","武士之灵","座敷童子","赤舌","灯笼鬼","盗墓小鬼" ,
            "唐纸伞妖","提灯小僧" };
    private String[] info = {
            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  单人御魂9通关\n\n" +
                    "传记三 :  与判官组队获胜*10",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  单人御魂9通关\n\n" +
                    "传记三 :  斗技中对抗荒川获胜*20",

            "传记一 :  升到30级" + "\n\n" +
                    "传记二 :  技能升级*8\n\n" +
                    "传记三 :  斗技获胜*30",

            "传记一 :  升到30级" + "\n\n" +
                    "传记二 :  技能升级*8\n\n" +
                    "传记三 :  斗技获胜*30",

            "传记一 :  升到30级" + "\n\n" +
                    "传记二 :  技能升级*8\n\n" +
                    "传记三 :  参与结界突破*30",

            "传记一 :  结界养育获取5W经验" + "\n\n" +
                    "传记二 :  碎片祈愿10次\n\n" +
                    "传记三 :  技能升级8次",


            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  技能升级*6\n\n" +
                    "传记三 :  技能升级*8",

            "传记一 :  升到30级" + "\n\n" +
                    "传记二 :  技能升级*8\n\n" +
                    "传记三 :  与红叶组队获胜*10",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  单人御魂9通关\n\n" +
                    "传记三 :  与判官组队获胜*10",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  单人觉醒9通关\n\n" +
                    "传记三 :  与酒吞组队获胜*10",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  升到30级\n\n" +
                    "传记三 :  单人觉醒9通关",

            "传记一 :  寮祈愿*20" + "\n\n" +
                    "传记二 :  阴阳寮捐赠*15\n\n" +
                    "传记三 :  对抗首无获胜*20",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  出战单人觉醒5通关\n\n" +
                    "传记三 :  百鬼夜行获得碎片*40",

            "传记一 :  百鬼夜行获得碎片*40" + "\n\n" +
                    "传记二 :  与山兔组队获胜*10\n\n" +
                    "传记三 :  斗技获胜*30",

            "传记一 :  百鬼夜行获得碎片*40" + "\n\n" +
                    "传记二 :  斗技获胜*30(出错)\n\n" +
                    "传记三 :  斗技获胜*30",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  技能升级*8\n\n" +
                    "传记三 :  阴阳寮祈愿*20",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  阴阳寮捐赠*15(出错)\n\n" +
                    "传记三 :  阴阳寮捐赠*15",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  参与60次结界突破进攻\n\n" +
                    "传记三 :  单人觉醒7通关",

            "传记一 : 阴阳寮捐赠*15" + "\n\n" +
                    "传记二 :  斗技获胜*40\n\n" +
                    "传记三 :  斗技中对抗河童获胜*20",

            "传记一 :  升到30级" + "\n\n" +
                    "传记二 :  出战单人觉醒5通关\n\n" +
                    "传记三 :  与鬼使黑组队获胜*10",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  技能升级*8\n\n" +
                    "传记三 :  与鬼使白组队获胜*10",

            "传记一 :  结界养育获取5W经验" + "\n\n" +
                    "传记二 :  参与结界突破*60\n\n" +
                    "传记三 :  与桃花妖组队获胜*10",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  出战单人御魂7通关\n\n" +
                    "传记三 :  参与结界突破*60",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  参与结界突破*60\n\n" +
                    "传记三 :  对抗雪女获胜*20",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  技能升级*8\n\n" +
                    "传记三 :  对抗雪女获胜*20",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  出战单人御魂5通关\n\n" +
                    "传记三 :  阴阳寮捐赠*15",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  参与结界突破*30\n\n" +
                    "传记三 :  阴阳寮捐赠*15",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  出战单人觉醒5通关\n\n" +
                    "传记三 :  阴阳寮捐赠*15",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 : 结界养育获取5W经验(出错)\n\n" +
                    "传记三 :  结界养育获取5W经验",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  出战单人御魂5通关\n\n" +
                    "传记三 :  出战单人御魂8通关",

            "传记一 :  结界养育获取5W经验" + "\n\n" +
                    "传记二 :  与蝴蝶精组队获胜*10\n\n" +
                    "传记三 :  百鬼夜行获得碎片*40",

            "传记一 :  出战获胜*50" + "\n\n" +
                    "传记二 : 参与结界突破*30\n\n" +
                    "传记三 :  阴阳寮祈愿*20",

            "传记一 :  结界养育获取5W经验" + "\n\n" +
                    "传记二 :  技能升级*8\n\n" +
                    "传记三 :  与跳弟组队获胜*10",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  参与结界突破*30\n\n" +
                    "传记三 :  百鬼夜行获得碎片*40",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  通关御魂7层\n\n" +
                    "传记三 :  百鬼夜行获得碎片*40",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  阴阳寮祈愿*10\n\n" +
                    "传记三 :  百鬼夜行获得碎片*40",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  阴阳寮捐赠*15\n\n" +
                    "传记三 :  百鬼夜行获得碎片*30",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  百鬼夜行获得碎片*30\n\n" +
                    "传记三 :  参与结界突破*30",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  参与结界突破*30\n\n" +
                    "传记三 :  百鬼夜行获得碎片*40",

            "传记一 :  升到30级" + "\n\n" +
                    "传记二 :  参与结界突破*30\n\n" +
                    "传记三 :  与鲤鱼精组队获胜*10",

            "传记一 :  阴阳寮捐赠*15" + "\n\n" +
                    "传记二 :  出战单人御魂5通关\n\n" +
                    "传记三 :  百鬼夜行获得碎片*30",

            "传记一 :  百鬼夜行获得碎片*30" + "\n\n" +
                    "传记二 :  斗技获胜*40\n\n" +
                    "传记三 :  阴阳寮捐赠*15",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  结界养育获取5W经验\n\n" +
                    "传记三 :  阴阳寮捐赠*15",

            "传记一 :  斗技获胜*30" + "\n\n" +
                    "传记二 :  与孟婆组队获胜*10\n\n" +
                    "传记三 :  阴阳寮捐赠*20",

            "传记一 :  出战单人觉醒5通关" + "\n\n" +
                    "传记二 :  斗技中对抗白狼获胜*20\n\n" +
                    "传记三 :  百鬼夜行获得碎片*30",

            "传记一 :  阳寮捐赠*15" + "\n\n" +
                    "传记二 :  出战单人御魂5通关\n\n" +
                    "传记三 :  阴阳寮祈愿*20",

            "传记一 :  斗技获胜*30" + "\n\n" +
                    "传记二 :  与童女组队获胜*10\n\n" +
                    "传记三 :  百鬼夜行获得碎片*40",

            "传记一 :  结界养育获取5W经验" + "\n\n" +
                    "传记二 :  与童男组队获胜*10\n\n" +
                    "传记三 :  阴阳寮捐赠*15",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  结界养育获取5W经验\n\n" +
                    "传记三 :  阴阳寮捐赠*15",

            "传记一 :  结界养育获取5W经验" + "\n\n" +
                    "传记二 :  经验技能升级*6\n\n" +
                    "传记三 :  出战获胜*50",

            "传记一 :  参与结界突破*30" + "\n\n" +
                    "传记二 :  技能升级*6\n\n" +
                    "传记三 :  斗技中对抗巫蛊师获胜*20",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  参与结界突破*30\n\n" +
                    "传记三 :  斗技中对抗犬神获胜*20",

            "传记一 :  结界养育获取5W经验" + "\n\n" +
                    "传记二 :  与河童组队获胜*10\n\n" +
                    "传记三 :  百鬼夜行获得碎片*40",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  参与结界突破*60（出错）\n\n" +
                    "传记三 :  参与结界突破*60",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  结界养育获取5W经验\n\n" +
                    "传记三 :  百鬼夜行获得碎片*40",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  结界养育获取5W经验\n\n" +
                    "传记三 :  阴阳寮捐赠*15",

            "传记一 :  参与结界突破*30" + "\n\n" +
                    "传记二 :  技能升级*6\n\n" +
                    "传记三 :  百鬼夜行获得碎片*40",

            "传记一 :  觉醒" + "\n\n" +
                    "传记二 :  技能升级*8\n\n" +
                    "传记三 :  参与结界突破*30",

            "传记一 :  结界养育获取5W经验" + "\n\n" +
                    "传记二 :  斗技获胜*40\n\n" +
                    "传记三 :  阴阳寮捐赠*15",

            "传记一 :  结界养育获取5W经验" + "\n\n" +
                    "传记二 :  与雨女组队获胜*10\n\n" +
                    "传记三 :  百鬼夜行获得碎片*30",

            "传记一 :  百鬼夜行获得碎片*30（出错）" + "\n\n" +
                    "传记二 :  百鬼夜行获得碎片*30\n\n" +
                    "传记三 :  百鬼夜行获得碎片*40",

            "传记一 :  技能升级*6" + "\n\n" +
                    "传记二 :  出战单人御魂5通关\n\n" +
                    "传记三 :  与跳哥组队获胜*10",

            "传记一 :  升到30级" + "\n\n" +
                    "传记二 :  出战获胜*50\n\n" +
                    "传记三 :  斗技获胜*30",

            "传记一 :  结界养育获取5W经验" + "\n\n" +
                    "传记二 :  斗技获胜*40\n\n" +
                    "传记三 :  阴阳寮捐赠*15",

            "传记一 :  技能升级*8" + "\n\n" +
                    "传记二 :  出战单人觉醒5通关\n\n" +
                    "传记三 :  百鬼夜行获得碎片*30",

            "传记一 :  结界养育获取5W经验" + "\n\n" +
                    "传记二 :  斗技获胜*40\n\n" +
                    "传记三 :  百鬼夜行获得碎片*40",

            "传记一 :  斗技获胜*40" + "\n\n" +
                    "传记二 :  阴阳寮祈愿*10\n\n" +
                    "传记三 :  百鬼夜行获得碎片*40",

            "传记一 :  升到30级" + "\n\n" +
                    "传记二 :  出战单人御魂5通关\n\n" +
                    "传记三 :  百鬼夜行获得碎片*60",

            "传记一 :  出战获胜*50" + "\n\n" +
                    "传记二 :  /\n\n" +
                    "传记三 :  百鬼夜行获得碎片*40",


    };

    /**
     * 汉字转换成拼音的类
     */
    private CharacterParser characterParser;
    private RecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuanji);
        ButterKnife.inject(this);
        for (int i = 0; i < title.length; i++) {
            DateEntity.ResultsEntity resultsEntity = new DateEntity.ResultsEntity();
            resultsEntity.setName(title[i]);
            resultsEntity.setInfo(info[i]);
            list.add(resultsEntity);
        }
        LinearLayoutManager manager = new LinearLayoutManager(this){
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
                if (s.toString().length()>0){
                    ivDelete.setVisibility(View.VISIBLE);
                }else {
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
                String info = sortModel.getInfo();
                if (name.contains(filterStr) || characterParser.getSelling(name).startsWith(filterStr) || info.contains(filterStr) || characterParser.getSelling(info).startsWith(filterStr)) {
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
