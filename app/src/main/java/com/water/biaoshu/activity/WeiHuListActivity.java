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
import com.water.biaoshu.view.time.SlideDateTimeListener;
import com.water.biaoshu.view.time.SlideDateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 维护记录查询
 * Created by Administrator on 2018/10/1.
 */

public class WeiHuListActivity extends BaseActivity implements View.OnClickListener{

    private  TextView tvTime,tvSelect1,tvSelect2,tvSelect3;
    TextView tvLook1,tvLook2,tvLook3;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        setContentView(R.layout.activity_weihu_list);
        initView();
    }

    private void initView() {
        TextView tvHead = (TextView) findViewById(R.id.tv_head);
        tvHead.setText("维护记录查询");
        tvTime=(TextView)findViewById(R.id.tv_time);
        tvSelect1=(TextView)findViewById(R.id.tv_select1);
        tvSelect2=(TextView)findViewById(R.id.tv_select2);
        tvSelect3=(TextView)findViewById(R.id.tv_select3);
        tvLook1=(TextView)findViewById(R.id.tv_look1);
        tvLook2=(TextView)findViewById(R.id.tv_look2);
        tvLook3=(TextView)findViewById(R.id.tv_look3);
        tvLook1.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        tvLook2.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        tvLook3.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        tvTime.setOnClickListener(this);
        tvSelect1.setOnClickListener(this);
        tvSelect2.setOnClickListener(this);
        tvSelect3.setOnClickListener(this);
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
            case R.id.tv_time:
                new SlideDateTimePicker.Builder(getSupportFragmentManager())
                        .setListener(listener)
                        .setInitialDate(new Date())
                        .build()
                        .show();
                 break;
            case R.id.tv_select1:
                 tvSelect1.setBackgroundColor(getResources().getColor(R.color.color_E3E3E3));
                tvSelect2.setBackgroundColor(getResources().getColor(R.color.color_1fc37f));
                tvSelect3.setBackgroundColor(getResources().getColor(R.color.color_1fc37f));
                 break;
            case R.id.tv_select2:
                tvSelect1.setBackgroundColor(getResources().getColor(R.color.color_1fc37f));
                tvSelect2.setBackgroundColor(getResources().getColor(R.color.color_E3E3E3));
                tvSelect3.setBackgroundColor(getResources().getColor(R.color.color_1fc37f));
                break;
            case R.id.tv_select3:
                tvSelect1.setBackgroundColor(getResources().getColor(R.color.color_1fc37f));
                tvSelect2.setBackgroundColor(getResources().getColor(R.color.color_1fc37f));
                tvSelect3.setBackgroundColor(getResources().getColor(R.color.color_E3E3E3));
                break;
            case R.id.tv_look1:
            case R.id.tv_look2:
            case R.id.tv_look3:
                setClass(WeiHuDetailsActivity.class);
                break;
            case R.id.lin_back:
                 finish();
                 break;
            default:
                break;
        }
    }


    private SimpleDateFormat mFormatter = new SimpleDateFormat("yyyy-MM-dd");
    private SlideDateTimeListener listener = new SlideDateTimeListener() {
        public void onDateTimeSet(Date date) {
            tvTime.setText(mFormatter.format(date));
        }
        public void onDateTimeCancel() {
        }
    };
}
