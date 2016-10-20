package com.hebin.yys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.rv_list)
    RecyclerView rvList;
    @InjectView(R.id.tv_total)
    TextView tvTotal;

    private List<DateEntity.ResultsEntity> list = new ArrayList<>();

    private String[] title = {"第一章 - 雀食奇谭", "第二章 - 座敷童子", "第三章 - 凤凰林的占卜师", "第四章 - 桥上的雨女", "第五章 - 黑夜山的食发鬼",
            "第六章 - 似梦非梦", "第七章 - 恋上鲤的美", "第八章 - 樱与桃", "第九章 - 兔蛙茶和锅", "第十章 - 鬼为谁买醉", "第十一章 - 染红的枫叶林",
            "第十二章 - 另一个晴明", "第十三章 - 箭与弓道", "第十四章 - 梦境邂逅", "第十五章 - 阴界的裂缝", "第十六章 - 冥界审判", "第十七章 - 阴阳逆反", "第十八章 - 黑晴明"};
    private String[] info = {
            "天邪鬼绿1——天邪鬼绿x1、提灯小僧x2" + "\n\n" +
                    "天邪鬼绿2——天邪鬼绿x1、灯笼鬼x2\n\n" +
                    "提灯小僧1——天邪鬼绿x2、提灯小僧x1\n\n" +
                    "提灯小僧2——灯笼鬼x2、提灯小僧x1\n\n" +
                    "首领：九命猫——九命猫x3",

            "帚神——帚神x1、寄生魂x1、盗墓小鬼x1" + "\n\n" +
                    "盗墓小鬼1——寄生魂x2、盗墓小鬼x1\n\n" +
                    "盗墓小鬼2——灯笼鬼x2、盗墓小鬼x1\n\n" +
                    "寄生魂1——灯笼鬼x2、寄生魂x1\n\n" +
                    "寄生魂2——盗墓小鬼x2、寄生魂x1\n\n" +
                    "首领：座敷童子——座敷童子x1、天邪鬼绿x2、天邪鬼青x1",

            "天邪鬼黄1——天邪鬼黄x1、帚神x2、涂壁x1" + "\n\n" +
                    "天邪鬼黄2——天邪鬼黄x1、童女x3\n\n" +
                    "赤舌1——赤舌x1、提灯小僧x1、灯笼鬼x2 、鸦天狗x1\n\n" +
                    "赤舌2——赤舌x1、鬼黄x1、童女x2、鸦天狗x1\n\n" +
                    "兵俑1——兵俑x1、提灯小僧x1、童女x2\n\n" +
                    "兵俑2——兵俑x1、提灯小僧x1、灯笼鬼x2\n\n" +
                    "首领：凤凰火——凤凰火x1 寄生魂x3",

            "帚神1——帚神x1、涂壁x2" + "\n\n" +
                    "帚神2——帚神x1、涂壁x1、唐纸伞妖x2\n\n" +
                    "唐纸伞妖1——唐纸伞妖x1、天邪鬼赤x3\n\n" +
                    "唐纸伞妖2——唐纸伞妖x1、天邪鬼赤x1、涂壁x2\n\n" +
                    "天邪鬼赤1——天邪鬼赤x1、唐纸伞妖x1、涂壁x2\n\n" +
                    "天邪鬼赤2——天邪鬼赤x1、唐纸伞妖x2\n\n" +
                    "首领：雨女——雨女x1、青蛙瓷器x1、帚神x2",

            "涂壁1——涂壁x1、天邪鬼赤x2" + "\n\n" +
                    "涂壁2——涂壁x1、天邪鬼赤x3\n\n" +
                    "帚神1——帚神x1、天邪鬼赤x1、涂壁x2\n\n" +
                    "帚神2——帚神x1、天邪鬼赤x1、天邪鬼黄x2\n\n" +
                    "管狐1——管狐x2、天邪鬼黄x2 二回合 寄生魂x1\n\n" +
                    "管狐2——管狐x1、天邪鬼绿x3 二回合 寄生魂x1\n\n" +
                    "首领：食发鬼——食发鬼x1、灯笼鬼x1、天邪鬼青x2",

            "灯笼鬼——灯笼鬼x1、帚神x3" + "\n\n" +
                    "天邪鬼青——天邪鬼青x1、天邪鬼绿x3\n\n" +
                    "蝴蝶精——蝴蝶精x1、涂壁x1、天邪鬼赤x2 二回合 三尾狐x1\n\n" +
                    "提灯小僧2：灯笼鬼×2、提灯小僧×1\n\n" +
                    "首领：巫蛊师——巫蛊师x1、天邪鬼绿x3",

            "鲤鱼精1——鲤鱼精x3、帚神x1" + "\n\n" +
                    "鲤鱼精2——鲤鱼精x1、帚神x3\n\n" +
                    "河童1——河童x1、鲤鱼精x1、涂壁x2\n\n" +
                    "河童2——河童x1、灯笼鬼x1、跳跳犬x2\n\n" +
                    "提灯小僧12——提灯小僧x1、跳跳犬x3、二回合-管狐x1\n\n" +
                    "提灯小僧3——提灯小僧x1、跳跳犬x1、鲤鱼精x2、二回合-管狐x1\n\n" +
                    "首领：妖狐——妖狐x1、涂壁x1、座敷童子x2、二回合-管狐x1、寄生魂x1、天邪鬼赤x2",

            "唐纸伞妖1——伞妖x1、帚神x3" + "\n\n" +
                    "唐纸伞妖2——伞妖x1、山童x1、帚神x2\n\n" +
                    "樱花妖1——樱花妖x1、帚神x1、涂壁x2、二回合-雪女x1\n\n" +
                    "樱花妖2——樱花妖x1、涂壁x3、二回合-雪女x1\n\n" +
                    "天邪鬼绿——天邪鬼绿x1、天邪鬼青x1、天邪鬼黄x2\n\n" +
                    "首领：桃花妖——桃花妖x1、天邪鬼青x1、提灯小僧x2、二回合-樱花妖x1、帚神x1、蝴蝶精x2",

            "提灯小僧1——提灯小僧x1、灯笼鬼x3" + "\n\n" +
                    "提灯小僧2——提灯小僧x1、灯笼鬼x1、铁鼠x2\n\n" +
                    "铁鼠1——铁鼠x1、帚神x3\n\n" +
                    "铁鼠2——铁鼠x2、帚神x2\n\n" +
                    "山兔1——山兔x3、铁鼠x1、二回合-鸦天狗\n\n" +
                    "山兔2——山兔x4、二回合-鸦天狗\n\n" +
                    "首领：孟婆——孟婆x1、饿鬼x3、二回合-孟婆x1、灯笼鬼x1、鸦天狗x2",

            "丑时之女——丑时之女x1、傀儡师x1、天邪鬼青x2" + "\n\n" +
                    "傀儡师1——傀儡师x1、觉x1、狸猫x2\n\n" +
                    "傀儡师2——傀儡师x1、觉x1、座敷童子x2、二回合-犬神x1\n\n" +
                    "觉1——觉x1、狸猫x3\n\n" +
                    "觉2——觉x1、赤舌x1、座敷童子x2、二回合-犬神x1\n\n" +
                    "首领：酒吞童子——酒吞童子x1、跳跳哥哥x1、食发鬼x2、二回合-酒吞童子x1、兵俑x1、骨女x2",

            "武士之灵1——武士之灵x1、寄生魂x3" + "\n\n" +
                    "武士之灵2——武士之灵x1、独眼小僧x3\n\n" +
                    "独眼小僧1——独眼小僧x1、涂壁x1、天邪鬼赤x2\n\n" +
                    "独眼小僧2——独眼小僧x1、管狐x1、天邪鬼赤x2\n\n" +
                    "饿鬼1——饿鬼x1、涂壁x1、管狐x2\n\n" +
                    "饿鬼2——饿鬼x3、管狐x1\n\n" +
                    "首领：鬼女红叶——鬼女红叶x1、童女x1、天邪鬼青x2、二回合-鬼女红叶x1、骨女x1、觉x2",

            "海坊主1——海坊主x1、帚神x1、涂壁x2" + "\n\n" +
                    "海坊主2——海坊主x1、涂壁x1、鸦天狗x2\n\n" +
                    "童男1——童男x1、天邪鬼黄x1、鸦天狗x2\n\n" +
                    "童男2——童男x1、童女x1、鸦天狗x2\n\n" +
                    "童女1——童女x1、盗墓小鬼x1、提灯小僧x2、二回合-雪女x1\n\n" +
                    "童女2——童女x3、盗墓小鬼x1、二回合-雪女x1\n\n" +
                    "首领：雪女——雪女x1、寄生魂x1、武士之灵x2、二回合-雪女x1、跳跳妹妹x1、跳跳哥哥x2",

            "饿鬼12——饿鬼x1 、天邪鬼赤x3" + "\n\n" +
                    "饿鬼3——饿鬼x1 、天邪鬼赤x3、二回合-首无x1\n\n" +
                    "唐纸伞妖12——唐纸伞妖x1、鬼赤x1、天邪鬼绿x2\n\n" +
                    "唐纸伞妖3——唐纸伞妖x1、鬼赤x1、天邪鬼绿x2、二回合-首无x1\n\n" +
                    "首领：首无——首无x1、骨女x1、灯笼鬼x1、山兔x1",

            "帚神123——帚神x1、天邪鬼赤x3" + "\n\n" +
                    "涂壁12——涂壁x6\n\n" +
                    "涂壁3——涂壁x6、二回合-食梦貘x1\n\n" +
                    "首领：食梦貘——食梦貘x1、天邪鬼赤x3、二回合-食梦貘x4",

            "天邪鬼绿123——天邪鬼绿x1、赤舌x1、天邪鬼赤x2" + "\n\n" +
                    "提灯小僧12——提灯小僧x1、赤舌x1、九命猫x2\n\n" +
                    "提灯小僧3——提灯小僧x1、赤舌x1、九命猫x2、二回合-大天狗x1\n\n" +
                    "首领：跳跳妹妹——跳跳妹妹x1、九命猫x3",

            "饿鬼123——饿鬼x1、山兔x1、山童x2" + "\n\n" +
                    "赤舌12——赤舌x1、寄生魂x3\n\n" +
                    "赤舌3——赤舌x1、寄生魂x3、二回合-赤舌x1\n\n" +
                    "首领：判官——判官x1、小黑x1、小白x1",


            "鸦天狗123——鸦天狗x1、觉醒风小怪x3" + "\n\n" +
                    "狸猫12——狸猫x1、觉醒火小怪x3\n\n" +
                    "狸猫3——狸猫x1、觉醒火小怪x3、二回合-暗凤凰(?)x1\n\n" +
                    "首领：荒川之主——荒川之主x1、灯笼鬼x1、骨女x1、山兔x1",

            "天邪鬼绿1：天邪鬼绿×1、提灯小僧×2" + "\n\n" +
                    "天邪鬼绿2：天邪鬼绿×1、灯笼鬼×2\n\n" +
                    "提灯小僧1：天邪鬼绿×2、提灯小僧×1\n\n" +
                    "提灯小僧2：灯笼鬼×2、提灯小僧×1\n\n" +
                    "首领：九命猫 -- 九命猫×3",
    };
    private int[] img = {R.mipmap.ic_item_01, R.mipmap.ic_item_01, R.mipmap.ic_item_01, R.mipmap.ic_item_01, R.mipmap.ic_item_01, R.mipmap.ic_item_01, R.mipmap.ic_item_01,
            R.mipmap.ic_item_01, R.mipmap.ic_item_01, R.mipmap.ic_item_01, R.mipmap.ic_item_01, R.mipmap.ic_item_01, R.mipmap.ic_item_01, R.mipmap.ic_item_01, R.mipmap.ic_item_01,
            R.mipmap.ic_item_01, R.mipmap.ic_item_01, R.mipmap.ic_item_01};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        for (int i = 0; i < title.length; i++) {
            DateEntity.ResultsEntity resultsEntity = new DateEntity.ResultsEntity();
            resultsEntity.setName(title[i]);
            resultsEntity.setInfo(info[i]);
            resultsEntity.setImg(img[i]);
            list.add(resultsEntity);
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvList.setLayoutManager(manager);
        RecyclerAdapter adapter = new RecyclerAdapter(this, list);
        rvList.setAdapter(adapter);
    }

    @OnClick({R.id.tv_total})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_total:
                break;
        }
    }
}