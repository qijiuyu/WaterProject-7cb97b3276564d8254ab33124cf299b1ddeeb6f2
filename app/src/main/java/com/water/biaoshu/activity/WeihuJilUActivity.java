package com.water.biaoshu.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.water.biaoshu.R;
import com.water.biaoshu.adapter.GridImageAdapter;
import com.water.biaoshu.photo.BigPhotoActivity;
import com.water.biaoshu.utils.Util;
import com.water.biaoshu.utils.photo.Bimp;
import com.water.biaoshu.utils.photo.ImageItem;
import com.water.biaoshu.utils.photo.PicturesUtil;
import com.water.biaoshu.view.MyGridView;

import java.io.File;

/**
 * 创建维护记录
 * Created by Administrator on 2018/10/1.
 */

public class WeihuJilUActivity extends BaseActivity {

    private MyGridView gridView;
    private GridImageAdapter adapter = null;
    private Spinner spinner1,spinner2;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        setContentView(R.layout.activity_cjwhjl);
        initView();
    }


    private void initView(){
        TextView tvHead=(TextView)findViewById(R.id.tv_head);
        tvHead.setText("创建维护记录");
        spinner1=(Spinner)findViewById(R.id.spinner1);
        spinner2=(Spinner)findViewById(R.id.spinner2);
        gridView=(MyGridView)findViewById(R.id.mg_aiu);
        //清空图片集合
        if (Bimp.selectBitmap.size() != 0) {
            Bimp.selectBitmap.clear();
        }
        adapter = new GridImageAdapter(getApplicationContext(), Bimp.selectBitmap);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (arg2 == Bimp.selectBitmap.size()) {
                    if (Bimp.selectBitmap.size() >=5) {
                        showToastView("图片最多选择5个！");
                    } else {
                        PicturesUtil.selectPhoto(WeihuJilUActivity.this,1);
                    }
                } else {
                    Intent intent = new Intent(mContext, BigPhotoActivity.class);
                    intent.putExtra("ID", arg2);
                    startActivityForResult(intent, PicturesUtil.CODE_RESULT_REQUEST);
                }
            }
        });

        //设备自检
        findViewById(R.id.tv_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(mContext,DeviceZJActivity.class);
                startActivityForResult(intent,1001);

            }
        });
        findViewById(R.id.lin_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeihuJilUActivity.this.finish();
            }
        });

        final ScrollView scrollView=(ScrollView)findViewById(R.id.scrollView);
        tvHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap= Util.screenshot(scrollView);
                Util.saveImageToGallery(mContext,bitmap);
            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            //返回拍照图片
            case PicturesUtil.CODE_CAMERA_REQUEST:
                if (resultCode == RESULT_OK) {
                    File file = new File(PicturesUtil.pai);
                    if(file.isFile()){
                        ImageItem takePhoto = new ImageItem();
                        takePhoto.setImagePath(file.getPath());
                        Bimp.selectBitmap.add(takePhoto);
                        Bimp.imgList.add(takePhoto);
                        adapter=new GridImageAdapter(getApplicationContext(), Bimp.selectBitmap);
                        gridView.setAdapter(adapter);
                    }else{
                        showToastView("拍照失败！");
                    }
                }
                break;
            //返回相册选择图片
            case PicturesUtil.CODE_GALLERY_REQUEST:
                adapter=new GridImageAdapter(getApplicationContext(), Bimp.selectBitmap);
                gridView.setAdapter(adapter);
                break;
            case PicturesUtil.CODE_RESULT_REQUEST:
                adapter.notifyDataSetChanged();
                break;
            case 1001:
                 spinner1.setSelection(1);
                 spinner2.setSelection(1);
                 break;
            default:
                break;

        }
    }

}
