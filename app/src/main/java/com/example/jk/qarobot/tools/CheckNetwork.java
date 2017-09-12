package com.example.jk.qarobot.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.jk.qarobot.application.MyApplication;

/**
 * Created by JK on 2017/5/3.
 * 检查网络连接
 */

public class CheckNetwork {
    public static boolean check(){
        ConnectivityManager cm = (ConnectivityManager) MyApplication
                .getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
