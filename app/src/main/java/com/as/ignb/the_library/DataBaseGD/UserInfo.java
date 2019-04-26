package com.as.ignb.the_library.DataBaseGD;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Keep;

/**
 * -----------------------------
 * Created by zqf on 2019/1/21.
 * ---------------------------
 */
@Entity
public class UserInfo {

    //不能用int
    @Id(autoincrement = true)
    private Long id;

    private String userName;

    private String imagepath;

    @Generated(hash = 388664947)
    public UserInfo(Long id, String userName, String imagepath) {
        this.id = id;
        this.userName = userName;
        this.imagepath = imagepath;
    }

    @Keep
    public UserInfo(String userName, String imagepath) {
        this.userName = userName;
        this.imagepath = imagepath;
    }

    @Generated(hash = 1279772520)
    public UserInfo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImagepath() {
        return this.imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }





}
