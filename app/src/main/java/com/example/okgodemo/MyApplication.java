package com.example.okgodemo;

import android.app.Application;

import com.lzy.okgo.OkGo;

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
//        初始化
        OkGo.init(this);
    }
}
