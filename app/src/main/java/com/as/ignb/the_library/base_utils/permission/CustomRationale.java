package com.as.ignb.the_library.base_utils.permission;

import android.content.Context;

import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2018/12/26.
 * Andpermission
 * 在这里进行权限 请求的 自定义弹窗  如果是 使用系统的 权限 就 不要调用.rationale
 * 值得一提的 就是 在自定义布局中点了确定 executor.execute();  还是会走系统的
 * ---------------------------
 */
public class CustomRationale implements Rationale {
    @Override
    public void showRationale(Context context, List<String> permissions, RequestExecutor executor) {

    }
/*
    @Override
    public void showRationale(final Context context, final List<String> permissions, final RequestExecutor executor) {
//       executor.cancel();  停止请求
//        executor.execute(); 继续请求
        new BaseDialog(context) {
            CustomRationaleBinding binding ;
            @Override
            public View onCreateView() {

//                widthScale(1);

                setCanceledOnTouchOutside(true);
                dimEnabled(false);

                showAnim(new BounceTopEnter());
                dismissAnim(new FadeExit());

                View view = View.inflate(context, R.layout.custom_rationale, null);
                binding = DataBindingUtil.bind(view);
                return view;
            }

            @Override
            public void setUiBeforShow() {

                DevShapeUtils.shape(DevShape.RECTANGLE)
                        .radius(5)
                        .line(2,R.color.colorAccent)
                        .into(binding.tvTitle);
                DevShapeUtils.shape(DevShape.RECTANGLE)
                        .radius(5)
                        .line(2,R.color.colorPrimary)
                        .into(binding.tvYes);
                DevShapeUtils.shape(DevShape.RECTANGLE)
                        .radius(5)
                        .line(2,R.color.colorPrimaryDark)
                        .into(binding.tvNo);

                binding.tvTitle.setText("需要权限:"+"\n"+permissions.get(0));
                binding.tvYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        executor.execute();
                    }
                });
                binding.tvNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        executor.cancel();
                    }
                });
            }
        }.show();
    }*/
}
