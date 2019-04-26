package com.as.ignb.the_library.custom_utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.as.ignb.R;
import com.as.ignb.the_library.custom_views.dialog.loading.DialogFragment_white;


/**
 * -----------------------------
 * Created by zqf on 2018/7/13.
 * 用这个 单例  做工具类
 * ---------------------------
 */

public class LoadingUtil {


    private DialogFragment baseDialog;

    private LoadingUtil() {
    }

    private static class LoadingUtil_Holder {
        private static LoadingUtil INSTANCE = new LoadingUtil();
    }

    /**
     * 获取实例
     */
    public static LoadingUtil getInstance() {
        return LoadingUtil_Holder.INSTANCE;
    }


    /**
     *  背景白色
     * @param activity
     */
    public void showWhite( AppCompatActivity activity) {

        if(baseDialog!=null && baseDialog.isVisible()){
            return;
        }

        baseDialog=new DialogFragment_white();
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        baseDialog.show(ft,"laoding_white");
    }

    public void dismiss(){
        if(baseDialog!=null){
            baseDialog.dismiss();
        }
    }

}
