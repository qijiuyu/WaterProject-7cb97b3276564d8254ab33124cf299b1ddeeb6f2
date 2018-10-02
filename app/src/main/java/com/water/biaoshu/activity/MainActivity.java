package com.water.biaoshu.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.water.biaoshu.R;
import com.water.biaoshu.utils.LogUtils;
import com.water.biaoshu.utils.Util;

import java.io.File;

/**
 * 首页
 * Created by Administrator on 2018/7/2 0002.
 */

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private ScrollView scrollView;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView(){
        scrollView=(ScrollView)findViewById(R.id.scrollView);
        findViewById(R.id.tv_setting).setOnClickListener(this);
        findViewById(R.id.tv_about).setOnClickListener(this);
        findViewById(R.id.tv_search).setOnClickListener(this);
        findViewById(R.id.tv_searchOld).setOnClickListener(this);
        findViewById(R.id.tv_upload).setOnClickListener(this);
        findViewById(R.id.tv_weihu).setOnClickListener(this);
        findViewById(R.id.tv_find_weihu).setOnClickListener(this);
        findViewById(R.id.tv_head).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bitmap bitmap= Util.screenshot(scrollView);
                Util.saveImageToGallery(mContext,bitmap);

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_setting:
                 setClass(SettingActivity.class);
                 break;
            case R.id.tv_search:
                 setClass(SearchDataActivity.class);
                 break;
            case R.id.tv_upload:
                 setClass(UploadActivity.class);
                 break;
            case R.id.tv_searchOld:
                 setClass(SearchOldActivity.class);
                 break;
            case R.id.tv_weihu:
                 setClass(WeiHuActivity.class);
                 break;
            case R.id.tv_find_weihu:
                 setClass(WeiHuListActivity.class);
                 break;
            case R.id.tv_about:
                setClass(AboutActivity.class);
                 break;
            default:
                break;
        }

    }
}
