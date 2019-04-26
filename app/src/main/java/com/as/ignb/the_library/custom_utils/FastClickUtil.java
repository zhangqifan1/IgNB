package com.as.ignb.the_library.custom_utils;

/**
 * -----------------------------
 * Created by zqf on 2018/7/13.
 * 用这个 单例  做工具类
 * ---------------------------
 */

public class FastClickUtil {


    private FastClickUtil(){}

    private static class FastClickUtil_Holder{
        private static FastClickUtil INSTANCE = new FastClickUtil();
    }
    /**
     * 获取实例
     */
    public static FastClickUtil getInstance() {
        return FastClickUtil_Holder.INSTANCE;
    }

    // 两次点击按钮之间的点击间隔不能少于1000毫秒
    private  final int MIN_CLICK_DELAY_TIME = 1000;
    private  long lastClickTime;

    public  boolean isFastClick() {
        boolean flag = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
            flag = true;
        }
        lastClickTime = curClickTime;
        return !flag;
    }


//     if (!FastClickUtil.getInstance().isFastClick()) {
//        return;//点击间隔 至少1秒
//    }

}
