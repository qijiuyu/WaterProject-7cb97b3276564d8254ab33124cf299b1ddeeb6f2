package com.water.biaoshu.activity;

import android.graphics.Bitmap;
import android.graphics.Paint;
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

public class WeiHuActivity extends BaseActivity implements View.OnClickListener{
    TextView tvLook1,tvLook2,tvLook3;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        setContentView(R.layout.activity_weihu);
        initView();
    }


    private void initView(){
        TextView tvHead=(TextView)findViewById(R.id.tv_head);
        tvHead.setText("异常设备维护");
        tvLook1=(TextView)findViewById(R.id.tv_look1);
        tvLook2=(TextView)findViewById(R.id.tv_look2);
        tvLook3=(TextView)findViewById(R.id.tv_look3);
        tvLook1.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        tvLook2.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        tvLook3.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        findViewById(R.id.tv_look1).setOnClickListener(this);
        findViewById(R.id.tv_look2).setOnClickListener(this);
        findViewById(R.id.tv_look3).setOnClickListener(this);
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
            case R.id.tv_look1:
            case R.id.tv_look2:
            case R.id.tv_look3:
                 setClass(DetailsActivity.class);
                break;
            case R.id.lin_back:
                 finish();
                break;
        }
    }
}
