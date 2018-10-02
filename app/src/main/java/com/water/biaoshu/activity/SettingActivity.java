package com.water.biaoshu.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;

import com.water.biaoshu.R;
import com.water.biaoshu.utils.Util;

/**
 * 设置参数1
 * Created by Administrator on 2018/7/4 0004.
 */

public class SettingActivity extends BaseActivity implements View.OnClickListener{

    private TextView tvJc,tvYq;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        setContentView(R.layout.activity_setting);
        initView();
    }


    /**
     * 初始化控件
     */
    private void initView(){
        TextView textView=(TextView)findViewById(R.id.tv_head);
        textView.setText("设备参数设置");
        tvJc=(TextView)findViewById(R.id.tv_aso_jc);
        tvYq=(TextView)findViewById(R.id.tv_aso_yq);
        tvJc.setOnClickListener(this);
        tvYq.setOnClickListener(this);
        findViewById(R.id.tv_aso_setting).setOnClickListener(this);
        findViewById(R.id.lin_back).setOnClickListener(this);
        final ScrollView scrollView=(ScrollView)findViewById(R.id.scrollView);
        textView.setOnClickListener(new View.OnClickListener() {
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
            case R.id.tv_aso_jc:
                tvJc.setTextColor(getResources().getColor(android.R.color.white));
                tvJc.setBackground(getResources().getDrawable(R.drawable.bg_setting_select));
                tvYq.setTextColor(getResources().getColor(R.color.color_1fc37f));
                tvYq.setBackground(getResources().getDrawable(R.drawable.bg_setting));
                 break;
            case R.id.tv_aso_yq:
                tvYq.setTextColor(getResources().getColor(android.R.color.white));
                tvYq.setBackground(getResources().getDrawable(R.drawable.bg_setting_select));
                tvJc.setTextColor(getResources().getColor(R.color.color_1fc37f));
                tvJc.setBackground(getResources().getDrawable(R.drawable.bg_setting));
                 break;
            //保存
            case R.id.tv_aso_setting:
                 View view= LayoutInflater.from(mContext).inflate(R.layout.dialog,null);
                 dialogPop(view,true);
                 view.findViewById(R.id.tv_confirm).setOnClickListener(new View.OnClickListener() {
                     public void onClick(View v) {
                         closeDialog();
                     }
                 });
                 break;
            case R.id.lin_back:
                 finish();
                 break;
            default:
                break;
        }

    }
}
