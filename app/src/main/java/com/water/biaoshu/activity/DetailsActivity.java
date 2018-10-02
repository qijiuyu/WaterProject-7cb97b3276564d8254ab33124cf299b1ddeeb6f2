package com.water.biaoshu.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;

import com.water.biaoshu.R;
import com.water.biaoshu.utils.Util;

/**
 * Created by Administrator on 2018/10/1.
 */

public class DetailsActivity extends BaseActivity{

    private ScrollView scrollView;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        setContentView(R.layout.activity_details);
        initView();
    }


    private void initView(){
        scrollView=(ScrollView)findViewById(R.id.scrollView);
        TextView tvHead=(TextView)findViewById(R.id.tv_head);
        tvHead.setText("详情查看");
        findViewById(R.id.tv_ben).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClass(WeihuJilUActivity.class);

            }
        });
        tvHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap= Util.screenshot(scrollView);
                Util.saveImageToGallery(mContext,bitmap);
            }
        });
        findViewById(R.id.lin_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsActivity.this.finish();
            }
        });
    }
}
