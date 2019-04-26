package com.as.ignb.the_library.custom_views.dialog.loading;

import android.animation.Animator;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import com.as.ignb.R;
import com.as.ignb.the_library.base_utils.android_util_code.util.ScreenUtils;
import com.luliang.shapeutils.shape.DevShape;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import yanzhikai.textpath.AsyncTextPathView;
import yanzhikai.textpath.PathAnimatorListener;

/**
 * 白色背景的
 */
public class DialogFragment_white extends DialogFragment {

    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
 
        View inflate = inflater.inflate(R.layout.dialog_loading_white, null);

        AsyncTextPathView dialog_white_atpv = inflate.findViewById(R.id.dialog_white_atpv);
        dialog_white_atpv.setText(title);
        dialog_white_atpv.setAnimatorListener(new PathAnimatorListener(){
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                dismiss();
            }
        });

        dialog_white_atpv.startAnimation(1,0 );



        return inflate;
    }
 
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onActivityCreated(savedInstanceState);
 
        //① 设置对话框内的内容为透明
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //② . 将对话框外的内容设置为透明
//        Window window = getDialog().getWindow();
//        WindowManager.LayoutParams windowParams = window != null ? window.getAttributes() : null;
//        windowParams.dimAmount = 0.0f;
//        window.setAttributes(windowParams);
 
 
    }
 
    @Override
    public void onResume() {
        super.onResume();
        //动态设置宽高 
//        getDialog().getWindow().setLayout(ScreenUtils.getScreenWidth()*5/6, ViewGroup.LayoutParams.WRAP_CONTENT);
    }
 
    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return super.onCreateAnimation(transit, enter, nextAnim);
    }
}