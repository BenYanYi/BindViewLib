package com.mylove.viewbind;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author BenYanYi
 * @date 2018/12/26 10:29
 * @email ben@yanyi.red
 * @overview
 */
class NetUtil {
    static boolean networkAvailable(Context context) {
        try {
            //BaseDexClassLoader
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
