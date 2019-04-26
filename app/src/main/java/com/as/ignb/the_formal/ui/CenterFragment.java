package com.as.ignb.the_formal.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.as.ignb.R;
import com.as.ignb.databinding.FragmentCenterBinding;
import com.as.ignb.the_library.base_ui.fragment.BaseFragment;
import com.as.ignb.the_library.custom_views.dialog.loading.DialogFragment_white;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.OnBoomListener;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

/**
 * A simple {@link Fragment} subclass.
 */
public class CenterFragment extends BaseFragment<FragmentCenterBinding> {

    private String[] zhaoshis={"长虹贯日","天女散花","紫气东来","大雨纷飞","奔雷滚滚","鹰击长空","天旋地转"};

    public CenterFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_center;
    }

    @Override
    public void initView(View rootView) {
    }

    @Override
    protected void initData() {
        mViewBinding.bmb4.setButtonEnum(ButtonEnum.TextOutsideCircle);
        mViewBinding.bmb4.setPiecePlaceEnum(PiecePlaceEnum.DOT_7_1);
        mViewBinding.bmb4.setButtonPlaceEnum(ButtonPlaceEnum.SC_7_2);



        TextOutsideCircleButton.Builder t1 = new TextOutsideCircleButton.Builder();
        TextOutsideCircleButton.Builder t2 = new TextOutsideCircleButton.Builder();
        TextOutsideCircleButton.Builder t3 = new TextOutsideCircleButton.Builder();
        TextOutsideCircleButton.Builder t4 = new TextOutsideCircleButton.Builder();
        TextOutsideCircleButton.Builder t5 = new TextOutsideCircleButton.Builder();
        TextOutsideCircleButton.Builder t6 = new TextOutsideCircleButton.Builder();
        TextOutsideCircleButton.Builder t7 = new TextOutsideCircleButton.Builder();


        t1.normalImageRes(R.drawable.changhongjian);
        t2.normalImageRes(R.drawable.bingpojian);
        t3.normalImageRes(R.drawable.ziyunjian);
        t4.normalImageRes(R.drawable.yuhuajian);
        t5.normalImageRes(R.drawable.benleijian);
        t6.normalImageRes(R.drawable.qingguangjian);
        t7.normalImageRes(R.drawable.xuanfengjian);


        t1.normalTextRes(R.string.jian1);//不知道为啥 就是动不了
        t2.normalTextRes(R.string.jian2);//不知道为啥 就是动不了
        t3.normalTextRes(R.string.jian3);//不知道为啥 就是动不了
        t4.normalTextRes(R.string.jian4);//不知道为啥 就是动不了
        t5.normalTextRes(R.string.jian5);//不知道为啥 就是动不了
        t6.normalTextRes(R.string.jian6);//不知道为啥 就是动不了
        t7.normalTextRes(R.string.jian7);//不知道为啥 就是动不了


        mViewBinding.bmb4.addBuilder(t1);
        mViewBinding.bmb4.addBuilder(t2);
        mViewBinding.bmb4.addBuilder(t3);
        mViewBinding.bmb4.addBuilder(t4);
        mViewBinding.bmb4.addBuilder(t5);
        mViewBinding.bmb4.addBuilder(t6);
        mViewBinding.bmb4.addBuilder(t7);


        mViewBinding.bmb4.setOnBoomListener(new OnBoomListener() {
            @Override
            public void onClicked(int index, BoomButton boomButton) {
                DialogFragment_white dialogFragmentWhite = new DialogFragment_white();
                dialogFragmentWhite.setTitle(zhaoshis[index]);

                FragmentTransaction ft = _mActivity.getSupportFragmentManager().beginTransaction();
                dialogFragmentWhite.show(ft,"ft");

            }

            @Override
            public void onBackgroundClick() {

            }

            @Override
            public void onBoomWillHide() {

            }

            @Override
            public void onBoomDidHide() {

            }

            @Override
            public void onBoomWillShow() {

            }

            @Override
            public void onBoomDidShow() {

            }
        });

    }

    @Override
    protected void initListener() {

    }


    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        mViewBinding.atpv1.startAnimation(0,1 );
    }
}
