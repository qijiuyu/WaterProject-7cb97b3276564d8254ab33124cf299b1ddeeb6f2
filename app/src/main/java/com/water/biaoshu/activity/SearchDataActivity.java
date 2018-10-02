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
 * 设置参数2
 * Created by Administrator on 2018/7/4 0004.
 */

public class SearchDataActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        setContentView(R.layout.activity_getdata);
        initView();
    }


    /**
     * 初始化控件
     */
    private void initView(){
        TextView tvHead=(TextView)findViewById(R.id.tv_head);
        tvHead.setText("实时数据采集");
        findViewById(R.id.lin_back).setOnClickListener(this);
        final ScrollView scrollView=(ScrollView)findViewById(R.id.scrollView);
        tvHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap= Util.screenshot(scrollView);
                Util.saveImageToGallery(mContext,bitmap);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lin_back:
                finish();
                break;
            default:
                break;
        }

    }
}
