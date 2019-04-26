package com.as.ignb.the_library.DataBaseGD;

import com.as.ignb.the_library.application.baseapp;
import com.ping.greendao.gen.UserInfoDao;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 * 例子
 */

public class GreenDaoUtils_UserInfo {
    /**
     * 添加数据，如果有重复则覆盖
     *
     */
    public static void insertUserInfo(UserInfo userInfo) {
        baseapp.getDaoInstant().getUserInfoDao().insertOrReplace(userInfo);
    }

    /**
     * 删除数据
     */
    public static void deleteAllUserInfo() {
        baseapp.getDaoInstant().getUserInfoDao().deleteAll();
    }

    /**
     * 更新数据
     *
     */
    public static void updateUserInfo(UserInfo userInfo) {
        baseapp.getDaoInstant().getUserInfoDao().update(userInfo);
    }

//    /**
//     * 查询条件为Type=TYPE_LOVE的数据
//     *
//     * @return
//     */
//    public static LocalMusic queryMusic(int uid) {
//        LocalMusic localMusic = BaseApplication.getDaoInstant().getLocalMusicDao().queryBuilder().where(LocalMusicDao.Properties.Uid.eq(uid)).uniqueOrThrow();
//        return localMusic;
//    }

    /**
     * 查询全部数据
     */
    public static UserInfo queryAll() {
        List<UserInfo> userInfos = baseapp.getDaoInstant().getUserInfoDao().loadAll();
        return userInfos.get(0);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
//    public static LocalMusic queryIdMusic(Long id) {
//        LocalMusic localMusic = BaseApplication.getDaoInstant().getLocalMusicDao().queryBuilder().where(LocalMusicDao.Properties.Id.eq(id)).uniqueOrThrow();
//        return localMusic;
//    }

    /**
     * 查询全部数据
     */
    public static String queryUserName (){
        return baseapp.getDaoInstant().getUserInfoDao().queryBuilder().where(UserInfoDao.Properties.Id.eq(1L)).uniqueOrThrow().getUserName();
    }
}
