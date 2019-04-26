package com.as.ignb.the_formal.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/4/16.
 * ---------------------------
 */
public class Vp_main_adapter extends FragmentPagerAdapter {

    public Vp_main_adapter(FragmentManager fm) {
        super(fm);
    }

    private List<Fragment> list;

    public void setFragList(List<Fragment> list1) {
        this.list = list1;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
