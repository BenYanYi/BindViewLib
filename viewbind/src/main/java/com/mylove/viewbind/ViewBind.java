package com.mylove.viewbind;

import android.app.Activity;
import android.view.View;

/**
 * @author BenYanYi
 * @date 2018/12/26 09:13
 * @email ben@yanyi.red
 * @overview
 */
public class ViewBind {

    public static void bind(Activity activity) {
        bind(new ViewInit(activity), activity);
    }

    public static void bind(View view) {
        bind(new ViewInit(view), view);
    }

    public static void bind(View view, Object object) {
        bind(new ViewInit(view), object);
    }

    private static void bind(ViewInit inject, Object object) {
        ViewInject.injectFiled(inject, object);
        ViewInject.injectClick(inject, object);
//        ViewInject.injectException(inject, object);
    }
}
