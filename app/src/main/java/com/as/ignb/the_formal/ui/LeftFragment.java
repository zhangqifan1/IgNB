package com.as.ignb.the_formal.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.as.ignb.R;
import com.as.ignb.databinding.FragmentLeftBinding;
import com.as.ignb.the_formal.Const;
import com.as.ignb.the_formal.adapter.Recycle_left_adapter;
import com.as.ignb.the_formal.diff.Left_DiffCallBack;
import com.as.ignb.the_formal.ui.mvp.Commen_Const;
import com.as.ignb.the_formal.ui.mvp.Commen_Model;
import com.as.ignb.the_formal.ui.mvp.Commen_Presenter;
import com.as.ignb.the_library.base_ui.fragment.BaseMvpFragment;
import com.as.ignb.the_library.base_utils.android_util_code.util.ScreenUtils;
import com.as.ignb.the_library.base_utils.android_util_code.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends BaseMvpFragment<Commen_Presenter,Commen_Model,FragmentLeftBinding> implements Commen_Const.custom_View {


    private List<String> list;
    private Recycle_left_adapter list_adapter;

    public LeftFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_left;
    }

    @Override
    public void initView(View rootView) {
        mViewBinding.listFragSrRefresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {

                for (int i = 0; i < 5; i++) {
                    list.add(list.get(i));
                }
                //发生变化的item 起始范围
                list_adapter.notifyItemRangeChanged(list.size()-1-5, 5);

                mViewBinding.listFragRecycler.scrollToPosition(list.size() - 1);

                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mPresenter.setMvp();
            }
        });
        mViewBinding.listFragSrRefresh.autoRefresh();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError() {
        serRecycle();
    }

    @Override
    public void showSuccess() {

    }

    @Override
    public void showData(String string) {
        serRecycle();
    }

    private void serRecycle() {
        mViewBinding.listFragSrRefresh.finishRefresh();
        list = new ArrayList<>();

        list.add(Const.image0);
        list.add(Const.image1);
        list.add(Const.image2);
        list.add(Const.image3);
        list.add(Const.image4);
        list.add(Const.image5);
        list.add(Const.image6);
        list.add(Const.image7);
        list.add(Const.image8);
        list.add(Const.image9);
        list.add(Const.image10);
        list.add(Const.image11);
        list.add(Const.image12);
        list.add(Const.image13);


        StaggeredGridLayoutManager sglmanager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        list_adapter = new Recycle_left_adapter(R.layout.recycle_list_item, list);
        list_adapter.setImagewidth(ScreenUtils.getScreenWidth()/2-40);
        list_adapter.setActivity(_mActivity);


        mViewBinding.listFragRecycler.setLayoutManager(sglmanager);
        mViewBinding.listFragRecycler.setAdapter(list_adapter);

        list_adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShort(""+position);
            }
        });
    }
}
