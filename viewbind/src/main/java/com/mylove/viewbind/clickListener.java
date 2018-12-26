package com.mylove.viewbind;

import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Method;

/**
 * @author BenYanYi
 * @date 2018/12/26 10:32
 * @email ben@yanyi.red
 * @overview
 */
class clickListener implements View.OnClickListener {
    private long lastClickTime;
    private Method method;
    private Object object;
    private String netErrorMsg;
    private boolean isCheckNet;

    clickListener(Method method, Object object, String netErrorMsg, boolean isCheckNet) {
        this.method = method;
        this.object = object;
        this.netErrorMsg = netErrorMsg;
        this.isCheckNet = isCheckNet;
    }

    @Override
    public void onClick(View v) {
        long time = System.currentTimeMillis();
        if (isCheckNet) {
            //判断网络问题
            if (!NetUtil.networkAvailable(v.getContext())) {
                Toast.makeText(v.getContext(), netErrorMsg, Toast.LENGTH_SHORT).show();
                return;
            }
        }
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 600) {
            return;
        }
        lastClickTime = time;
        method.setAccessible(true);
        try {
            method.invoke(object, v);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                method.invoke(object, new Object[]{});
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
