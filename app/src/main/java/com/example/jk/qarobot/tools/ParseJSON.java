package com.example.jk.qarobot.tools;

import com.example.jk.qarobot.bean.ContentBean;
import com.example.jk.qarobot.bean.VoiceBean;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by JK on 2017/5/3.
 * 解析JSON
 */

public class ParseJSON {
    public static String parse(String json, int type) {
        //创建Gson对象
        Gson gson = new Gson();
        String result = null;
        StringBuffer sb = new StringBuffer();
        switch (type) {
            case Constant.JSON_RESULT:
                try {
                    ContentBean contentBean = gson.fromJson(json, ContentBean.class);
                    result = contentBean.getResult().getText();
                }catch (Exception e){
                    result = "erro:请求参数错误";
                }

                break;
            case Constant.JSON_SPEAK:
                VoiceBean voiceBean = gson.fromJson(json, VoiceBean.class);
                List<VoiceBean.WsBean> ws = voiceBean.getWs();
                for (VoiceBean.WsBean wsBean : ws) {
                    String word = wsBean.getCw().get(0).getW();
                    sb.append(word);
                }
                result = sb.toString();
                break;
        }
        return result;
    }
}
