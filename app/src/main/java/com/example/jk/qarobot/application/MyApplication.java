package com.example.jk.qarobot.application;

import android.app.Application;
import android.content.Context;

import com.example.jk.qarobot.tools.Constant;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

/**
 * Created by JK on 2017/5/3.
 * 应用入口
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        //讯飞语音听写 初始化
        SpeechUtility.createUtility(this, SpeechConstant.APPID+ "="+Constant.IFLYTEK_ID);
        context=getApplicationContext();
    }
    //全局Context
    public static Context getContext(){
        return context;
    }
}
