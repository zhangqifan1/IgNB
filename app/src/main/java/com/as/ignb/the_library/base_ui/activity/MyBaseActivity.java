package com.as.ignb.the_library.base_ui.activity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

import com.as.ignb.R;
import com.jaeger.library.StatusBarUtil;

import cn.jzvd.Jzvd;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * -----------------------------
 * Created by zqf on 2018/7/4.
 * ---------------------------
 */

@SuppressLint("Registered")
public class MyBaseActivity extends SupportActivity {

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int statuBarColor = setStatuBarColor();
        int color = getResources().getColor(statuBarColor);
        StatusBarUtil.setColor(this, color, 0);
    }

    /**
     * 设置状态栏颜色 这里设置默认
     * @return
     */
    private int setStatuBarColor() {
        return R.color.colorAccent;
    }


}
