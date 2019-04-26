package com.as.ignb.the_formal.guide;

import android.animation.Animator;
import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.as.ignb.MainActivity;
import com.as.ignb.R;
import com.as.ignb.databinding.GuideLayoutBinding;
import com.as.ignb.the_library.DataBaseGD.GreenDaoUtils_UserInfo;
import com.as.ignb.the_library.DataBaseGD.UserInfo;
import com.as.ignb.the_library.base_utils.android_util_code.util.ActivityUtils;
import com.as.ignb.the_library.base_utils.android_util_code.util.DeviceUtils;
import com.as.ignb.the_library.base_utils.android_util_code.util.PhoneUtils;
import com.as.ignb.the_library.base_utils.android_util_code.util.ToastUtils;
import com.as.ignb.the_library.base_utils.android_util_code.util.security_sp.SecuritySharedPreference;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nanchen.compresshelper.CompressHelper;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.api.widget.Widget;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;

public class GuideActivity extends Activity {

    private boolean isFirstLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isFirstLogin = SecuritySharedPreference.getInstance().getBoolean("isFirstLogin", false);
    }

    @Override
    protected void onResume() {
        super.onResume();


        View view = getLayoutInflater().inflate(R.layout.guide_layout, null);
        getWindow().setContentView(view);
        GuideLayoutBinding layoutBinding = DataBindingUtil.bind(view);
        YoYo.with(Techniques.Tada)
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (isFirstLogin) {
                                    ActivityUtils.startActivity(MainActivity.class);
                                    finish();
                                } else {  //没有设置过头像
                                    Album.image(GuideActivity.this) // 选择图片。
                                            .multipleChoice()
                                            .camera(true)//有照相机
                                            .columnCount(3)//一行三个
                                            .selectCount(1)//选择一个
                                            .onResult(new Action<ArrayList<AlbumFile>>() {
                                                @Override
                                                public void onAction(int requestCode, @android.support.annotation.NonNull ArrayList<AlbumFile> result) {
                                                    AlbumFile albumFile = result.get(0);
                                                    String path = albumFile.getPath();
                                                    //获取设备型号
                                                    String model = DeviceUtils.getModel();
                                                    String manufacturer = DeviceUtils.getManufacturer();

                                                    new AsyncTask<Void, Void, Void>() {
                                                        @Override
                                                        protected Void doInBackground(Void... voids) {
                                                            GreenDaoUtils_UserInfo.insertUserInfo(new UserInfo(model + manufacturer, path));
                                                            SecuritySharedPreference.getInstance().edit().putBoolean("isFirstLogin", true).apply();
                                                            return null;
                                                        }

                                                        @Override
                                                        protected void onPostExecute(Void aVoid) {

                                                            ActivityUtils.startActivity(MainActivity.class);
                                                            finish();
                                                        }
                                                    }.execute();
                                                }
                                            })
                                            .onCancel(new Action<String>() {
                                                @Override
                                                public void onAction(int requestCode, @android.support.annotation.NonNull String result) {
                                                    ToastUtils.showShort("亲亲,不给权限玩蛋哦");
                                                }
                                            })
                                            .start();
                                }

                            }
                        }, 1000);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .duration(1000).delay(200).repeat(0)

                .playOn(layoutBinding.guideImage);


    }
}
