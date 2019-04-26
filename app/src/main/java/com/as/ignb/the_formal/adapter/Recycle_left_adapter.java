package com.as.ignb.the_formal.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.as.ignb.R;
import com.as.ignb.the_library.GlideUtils.progress.HttpUtil;
import com.as.ignb.the_library.GlideUtils.progress.ProgressInterceptor;
import com.as.ignb.the_library.GlideUtils.progress.ProgressListener;
import com.as.ignb.the_library.base_utils.android_util_code.util.ToastUtils;
import com.as.ignb.the_library.custom_views.shuibowen_progress.WaterWaveProgress;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * -----------------------------
 * Created by zqf on 2019/4/15.
 * ---------------------------
 */
public class Recycle_left_adapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private int imagewidth;
    private Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setImagewidth(int imagewidth) {
        this.imagewidth = imagewidth;
    }

    public Recycle_left_adapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView iv = helper.getView(R.id.list_iv_item);

//        WaterWaveProgress wwprogress = helper.getView(R.id.recycle_iv_progress_bar);

        Glide.with(mContext)
                .load(item)
                .into(iv);

        int position = helper.getAdapterPosition();
        switch (position % 2) {
            case 0:
                iv.getLayoutParams().height = imagewidth * 1;
                break;
            case 1:
                iv.getLayoutParams().height = imagewidth * 2;
                break;
            default:
                break;
        }



//        loadBingPic(item, iv, wwprogress);
//        loadBingPic(item, iv);


    }


    private void loadBingPic(String url, ImageView iv) {

        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                final String bingPic = response.body().string();

                activity.runOnUiThread(() -> {

                    ProgressInterceptor.addListener(bingPic, new ProgressListener() {
                        @Override
                        public void onProgress(int progress) {
                            System.out.println("progressXXXX   :"+progress);
                        }
                    });

                    RequestOptions requestOptions =
                            new RequestOptions()
                                    .placeholder(R.drawable.ic_launcher_background)
                                    .error(R.drawable.guide_bg)
                                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                                    .override(Target.SIZE_ORIGINAL);

                    Glide
                            .with(activity)
                            .load(bingPic)
                            .apply(requestOptions)
                            .into(new DrawableImageViewTarget(iv) {

                                @Override
                                public void onLoadStarted(@Nullable Drawable placeholder) {
                                    super.onLoadStarted(placeholder);
                                }

                                @Override
                                public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                                    super.onResourceReady(resource, transition);

                                    ProgressInterceptor.removeListener(bingPic);
                                }
                            });
                });
            }
        });
    }


}
