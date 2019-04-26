package com.as.ignb.the_formal.diff;

import android.support.v7.util.DiffUtil;
import android.text.TextUtils;

import java.util.List;

public class Left_DiffCallBack extends DiffUtil.Callback {
    //旧的数据集合
    private List<String> mOldUserList;
    // 新的数据集合
    private List<String> mNewUserList;

    //构造方法 传入旧的数据结构和新的数据结构


    public Left_DiffCallBack(List<String> mOldUserList, List<String> mNewUserList) {
        this.mOldUserList = mOldUserList;
        this.mNewUserList = mNewUserList;
    }

    //获取旧的数据量大小
    @Override
    public int getOldListSize() {
        return null == mOldUserList ? 0 : mOldUserList.size();
    }

    //获取新的数据量大小
    @Override
    public int getNewListSize() {
        return null == mNewUserList ? 0 : mNewUserList.size();
    }

    //判断两个条目是否是一致的
// 在真实的项目中，我们一般使用id或者index搜索来判断两条item是否一致
// 如果我们的id一样，在系统里面我就认为两个数据记录是一样的
    @Override
    public boolean areItemsTheSame(int oldPosition, int newPosition) {
        return TextUtils.equals(mOldUserList.get(oldPosition), mNewUserList.get(newPosition));
    }

    //这个需要areItemsTheSame 返回true时才调用
// 即使我们的id是一致的，我们在系统中是同一个对象，但是的name可能更新，或者图像可能更新了
// 这里可以填写自己的逻辑，如果图像是一致的，我就认为内容没有变化
    @Override
    public boolean areContentsTheSame(int oldPosition, int newPosition) {
       return TextUtils.equals(mOldUserList.get(oldPosition), mNewUserList.get(newPosition));
    }


}