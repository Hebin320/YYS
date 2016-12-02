package com.hebin.yys.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.hebin.yys.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ManHuaActivity extends AppCompatActivity {

    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.tb_title)
    Toolbar tbTitle;
    @InjectView(R.id.webview)
    WebView webview;

    String link = "";
    @InjectView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hua);
        ButterKnife.inject(this);
        link = getIntent().getStringExtra("link");
        webnature(webview);
        if (TextUtils.isEmpty(link)) {
            webview.loadUrl("http://yys.163.com/best/index.html");
            tvTitle.setText("漫画");
        } else {
            webview.loadUrl(link);
            tvTitle.setText("同人赏");
        }
    }

    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                if (webview.canGoBack()) {
                    webview.goBack();
                } else {
                    finish();
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            finish();
        }
    }

    //webview的各种属性
    public void webnature(final WebView webview) {
        //webview支持JS
        webview.getSettings().setJavaScriptEnabled(true);
        //自适应屏幕高宽
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        //设置 缓存模式
        webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        // 开启 DOM storage API 功能
        webview.getSettings().setDomStorageEnabled(true);
        //自动清除历史跟缓存
        webview.clearCache(true);
        webview.clearHistory();
        //背景透明，也可修改背景色
        webview.setBackgroundColor(0);
        if (TextUtils.isEmpty(link)) {
            // 设置可以支持缩放
            webview.getSettings().setSupportZoom(true);
            // 设置出现缩放工具
            webview.getSettings().setBuiltInZoomControls(true);
            //扩大比例的缩放
            webview.getSettings().setUseWideViewPort(true);
            //自适应屏幕
            webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            webview.getSettings().setLoadWithOverviewMode(true);
        }
        //在webview中打开网页
        webview.setWebViewClient(new WebViewClient() {

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            public void onPageFinished(WebView view, String url) {
                if (!webview.getSettings().getLoadsImagesAutomatically()) {
                    webview.getSettings().setLoadsImagesAutomatically(true);
                }
            }
        });

        if (Build.VERSION.SDK_INT >= 19) {
            webview.getSettings().setLoadsImagesAutomatically(true);
        } else {
            webview.getSettings().setLoadsImagesAutomatically(false);
        }

    }
}
