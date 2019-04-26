package com.as.ignb.the_formal.ui.mvp;

import android.content.Context;

import com.as.ignb.the_formal.http.BeanCallbackNoDialog;
import com.as.ignb.the_library.base_utils.android_util_code.util.ToastUtils;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONObject;


/**
 * -----------------------------
 * Created by zqf on 2018/2/5.
 * ---------------------------
 */

public class Commen_Model implements Commen_Const.custom_Model {


    @Override
    public void requestData(CallBack callBack, Context context) {
        OkGo.<Object>get("")
                .tag(context)
                .execute(new BeanCallbackNoDialog<Object>() {

                    @Override
                    public void onStart(Request<Object, ? extends Request> request) {

                        callBack.showLoading();
                    }

                    @Override
                    public String convertResponse(okhttp3.Response response) throws Throwable {
                        String string = response.body().string();
                        return string;
                    }

                    @Override
                    public void onError(Response<Object> response) {


                        callBack.showError();
                    }

                    @Override
                    public void onSuccess(Response<Object> response) {

                        callBack.showSuccess();
                        callBack.setString(response.body().toString());
                    }
                });
    }

    @Override
    public void OnDestroy() {

    }
}
