package com.as.ignb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.as.ignb.databinding.ActivityMainBinding;
import com.as.ignb.the_formal.ui.CenterFragment;
import com.as.ignb.the_formal.ui.LeftFragment;
import com.as.ignb.the_library.DataBaseGD.GreenDaoUtils_UserInfo;
import com.as.ignb.the_library.DataBaseGD.UserInfo;
import com.as.ignb.the_library.GlideUtils.progress.HttpUtil;
import com.as.ignb.the_library.GlideUtils.progress.ProgressInterceptor;
import com.as.ignb.the_library.GlideUtils.progress.ProgressListener;
import com.as.ignb.the_library.base_ui.activity.BaseActivity;
import com.as.ignb.the_library.base_utils.android_util_code.util.BarUtils;
import com.as.ignb.the_library.base_utils.android_util_code.util.ScreenUtils;
import com.as.ignb.the_library.base_utils.android_util_code.util.ToastUtils;
import com.as.ignb.the_library.custom_utils.ImageSaveToLocalUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.jaeger.library.StatusBarUtil;
import com.luliang.shapeutils.DevShapeUtils;
import com.luliang.shapeutils.shape.DevShape;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.db.CacheManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private String[] titles = {"图", "剑", "宝"};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected void initView() {

        int screenWidth = ScreenUtils.getScreenWidth();

        //这里因为  适应宽高比  之后 图片高度 有点高

        mViewBinding.mainIvTop.getLayoutParams().height = screenWidth  * 300 / 576;

        //这里因为ActionBar 可以超出 所以设置一个View 顶上去
        //设置高度为ActionBar的 高度
        mViewBinding.tvtitle.getLayoutParams().height = BarUtils.getStatusBarHeight();

        //这里设置后 颜色需要重新设置
        // 这里直接修改 colorPrimaryDark  为当前页面状态栏颜色
        //                                MyBaseAc那个不起效了
        StatusBarUtil.setTranslucentForDrawerLayout(this, mViewBinding.dl, 40);

        //设置侧滑菜单的顶部图片 高度  弃用此功能 改为头像的大图 模糊
//        ViewGroup.LayoutParams layoutParams = mViewBinding.mainDrawerTopIvBg.getLayoutParams();
//        int screenWidth = ScreenUtils.getScreenWidth();
//        layoutParams.width=screenWidth;
//        //通过像素比 设置高度
//        layoutParams.height=screenWidth*371/592;


        UserInfo userInfo = GreenDaoUtils_UserInfo.queryAll();
        mViewBinding.mainDrawerTvname.setText(userInfo.getUserName() + ",今天也是充满7W的一天哦");

        //设置头像
        Glide.with(this)
                .load(userInfo.getImagepath())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(mViewBinding.mainDrawerTopIv);

        //给模糊背景设置白色滤镜
        mViewBinding.mainDrawerTopIvBg.setColorFilter(Color.parseColor("#4dffffff"), PorterDuff.Mode.LIGHTEN);

        //设置头像的模糊背景
        Glide.with(this)
                .load(userInfo.getImagepath())
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(14, 4)))
                .into(mViewBinding.mainDrawerTopIvBg);


        //给拖动布局上圆角
        DevShapeUtils.shape(DevShape.RECTANGLE)
                .radius(15)
                .solid(R.color.yellow)
                .into(mViewBinding.includeMainDrawer.includeMainDrawerLl);

        //长按二维码图片 可以保存到本地
        mViewBinding.includeMainDrawer.zhifubao.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Glide.with(mContext)
                        .asBitmap()
                        .load(R.drawable.zhifubao)
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                                ImageSaveToLocalUtil.getInstance().saveImageToGallery(mContext, resource);
                                ToastUtils.showShort("OK");
                            }
                        });
                return false;
            }
        });


        //仿QQ侧滑
        mViewBinding.dl.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //获取屏幕的宽高
                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
                mViewBinding.mainRightLl.layout(mViewBinding.mainLeftLl.getRight(), 0, mViewBinding.mainLeftLl.getRight() + display.getWidth(), display.getHeight());
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


        ArrayList<Fragment> fragmentList = new ArrayList<>();
        LeftFragment l1 = new LeftFragment();
        CenterFragment l2 = new CenterFragment();
        LeftFragment l3 = new LeftFragment();

        fragmentList.add(l1);
        fragmentList.add(l2);
        fragmentList.add(l3);

        mViewBinding.mainTab.setViewPager(mViewBinding.mainVp, titles, MainActivity.this, fragmentList);
        mViewBinding.mainTab.setCurrentTab(0);


    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initListener() {


    }

}
