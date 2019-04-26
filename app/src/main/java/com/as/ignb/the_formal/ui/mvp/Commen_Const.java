package com.as.ignb.the_formal.ui.mvp;

import android.content.Context;

import com.as.ignb.the_library.base_ui.mvp.BaseIModel;
import com.as.ignb.the_library.base_ui.mvp.BaseIView;
import com.as.ignb.the_library.base_ui.mvp.BasePresenter;

/**
 * -----------------------------
 * Created by zqf on 2018/2/5.
 * ---------------------------
 */

public interface Commen_Const {

    interface custom_Model extends BaseIModel {
        interface CallBack{
            void  setString(String string);
            void  showError();
            void  showSuccess();
            void  showLoading();
        }
        void  requestData(CallBack callBack, Context context);
    }

    interface custom_View extends BaseIView {
        void showData(String string);
    }

    abstract class pCssPresenter extends BasePresenter<custom_Model,custom_View> {
        public abstract  void setMvp();
    }

}
