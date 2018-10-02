package com.water.biaoshu.application;

import android.app.Application;

import com.water.biaoshu.utils.SPUtil;

/**
 * Created by Administrator on 2018/7/2 0002.
 */

public class MyApplication extends Application {

    public static MyApplication application;
    public static SPUtil spUtil;
    public void onCreate() {
        super.onCreate();
        application = this;
        spUtil = SPUtil.getInstance(this);
    }
}
