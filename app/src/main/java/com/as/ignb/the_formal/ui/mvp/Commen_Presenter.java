package com.as.ignb.the_formal.ui.mvp;


import android.text.TextUtils;

/**
 * -----------------------------
 * Created by zqf on 2018/2/5.
 * ---------------------------
 */

public class Commen_Presenter extends Commen_Const.pCssPresenter {

    @Override
    public void setMvp() {
       mModel.requestData(new Commen_Const.custom_Model.CallBack() {
           @Override
           public void setString(String string) {
               if(TextUtils.isEmpty(string) && mView != null){
                   mView.showData(string);
               }
           }

           @Override
           public void showError() {
               if(mView!= null)
               mView.showError();
           }

           @Override
           public void showSuccess() {
               if(mView!= null)
               mView.showSuccess();
           }

           @Override
           public void showLoading() {
               if(mView!= null)
               mView.showLoading();
           }
       },mView.getCt());


    }
}
