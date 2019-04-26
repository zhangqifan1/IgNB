package com.as.ignb.the_formal.http;

import android.content.Context;

import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.File;

/**
 * -----------------------------
 * Created by zqf on 2018/3/18.
 * ---------------------------
 */

public  class FileCallbackDialog extends FileCallback {
    @Override
    public void onSuccess(Response<File> response) {

    }
    private Context context;

    protected FileCallbackDialog(Context context) {
        this.context = context;
    }

    @Override
    public void onStart(Request<File, ? extends Request> request) {
        super.onStart(request);
//        LoadingUtil.getInstance().show(context);
    }

    @Override
    public void onFinish() {
        super.onFinish();
//        LoadingUtil.getInstance().dismiss();
    }

}
