package com.as.ignb.the_library.custom_utils;

/**
 * -----------------------------
 * Created by zqf on 2018/7/13.
 * 用这个 单例  做工具类
 * ---------------------------
 */

public class SingleUtil {


    private SingleUtil(){}

    private static class SingleUtil_Holder{
        private static SingleUtil INSTANCE = new SingleUtil();
    }
    /**
     * 获取实例
     */
    public static SingleUtil getInstance() {
        return SingleUtil_Holder.INSTANCE;
    }


}
