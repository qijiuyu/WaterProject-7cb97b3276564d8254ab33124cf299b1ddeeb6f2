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
 * 关于我们
 * Created by Administrator on 2018/7/4 0004.
 */

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        setContentView(R.layout.activity_about);
        initView();
    }

    private void initView(){
        TextView textView=(TextView)findViewById(R.id.tv_head);
        textView.setText("关于我们");
        final ScrollView scrollView=(ScrollView)findViewById(R.id.scrollView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap= Util.screenshot(scrollView);
                Util.saveImageToGallery(mContext,bitmap);
            }
        });

        findViewById(R.id.lin_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutActivity.this.finish();
            }
        });

    }
}
