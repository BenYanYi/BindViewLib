package com.mylove.viewbind;

import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author BenYanYi
 * @date 2018/12/26 10:31
 * @email ben@yanyi.red
 * @overview
 */
class ViewInject {
    /**
     * 控件id反射
     */
    static void injectFiled(ViewInit inject, Object object) {
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            BindView bindView = field.getAnnotation(BindView.class);
            if (bindView != null) {
                int value = bindView.value();
                View view = inject.find(value);
                //能够注入所有修饰符
                field.setAccessible(true);
                try {
                    //动态注入找到view
                    field.set(object, view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 控件点击事件反射
     */
    static void injectClick(ViewInit inject, Object object) {
        Class<?> aClass = object.getClass();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            OnClick onClick = method.getAnnotation(OnClick.class);
            if (onClick != null) {
                int[] values = onClick.value();
                if (values.length > 0) {
                    for (int value : values) {
                        View view = inject.find(value);
                        String netErrorMsg = "";
                        boolean isCheckNet = false;
                        ClickNet clickNet = method.getAnnotation(ClickNet.class);
                        if (clickNet != null) {
                            netErrorMsg = clickNet.netErrorMsg();
                            isCheckNet = clickNet.isCheckNet();
                        }
                        if (view != null) {
                            view.setOnClickListener(new clickListener(method, object, netErrorMsg, isCheckNet));
                        }
                    }
                }
            }
        }
    }
//    Mac⁩ ▸ ⁨应用程序⁩ ▸ ⁨Android Studio⁩ ▸ ⁨Contents⁩ ▸ ⁨gradle⁩
//    #Gradle
//    export GRADLE_HOME=/Applications/Android\ Studio.app/Contents/gradle/gradle-4.1
//    export PATH=$PATH:$GRADLE_HOME/bin

//    static void injectException(ViewInit inject, Object object) {
//        Class<?> aClass = object.getClass();
//        Method[] methods = aClass.getMethods();
//        for (Method method : methods) {
//            Exceptions exceptions = method.getAnnotation(Exceptions.class);
//            if (exceptions != null) {
//
//            }
//        }
//    }
}
