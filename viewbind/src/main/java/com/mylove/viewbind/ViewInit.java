package com.mylove.viewbind;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.view.View;

/**
 * @author BenYanYi
 * @date 2018/12/26 09:28
 * @email ben@yanyi.red
 * @overview
 */
class ViewInit {
    private Activity mActivity;
    private View mView;

    ViewInit(Activity mActivity) {
        this.mActivity = mActivity;
    }

    ViewInit(View mView) {
        this.mView = mView;
    }

    View find(@IdRes int value) {
        if (mActivity != null) {
            return mActivity.findViewById(value);
        } else {
            return mView.findViewById(value);
        }
    }
}
