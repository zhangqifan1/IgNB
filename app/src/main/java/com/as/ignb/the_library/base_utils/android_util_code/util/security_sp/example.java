package com.as.ignb.the_library.base_utils.android_util_code.util.security_sp;


import com.as.ignb.the_library.base_utils.android_util_code.util.ToastUtils;

/**
 * -----------------------------
 * Created by zqf on 2018/12/26.
 * ---------------------------
 */
public class example {
    public void exampleUse(){
        boolean isFirstUse = SecuritySharedPreference.getInstance().getBoolean("isFirstUse", false);
        if(!isFirstUse){
            ToastUtils.showShort("第一次登陆");
            SecuritySharedPreference.getInstance().edit().putBoolean("isFirstUse",true).apply();
        }else{
            ToastUtils.showShort("第N次登陆");
        }
    }
}
