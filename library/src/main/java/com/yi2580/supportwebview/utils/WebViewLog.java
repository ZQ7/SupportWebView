package com.yi2580.supportwebview.utils;

import android.util.Log;

import com.yi2580.supportwebview.WebViewSdk;

/**
 * @author zhangqi
 * Date:2018/9/26
 * Description:
 */
public class WebViewLog {

    private final static String TAG = "SupportWebView";

    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void i(String tag, String msg) {
        if (WebViewSdk.getInstance().isDebug()) {
            Log.i(tag, msg);
        }
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        if (WebViewSdk.getInstance().isDebug()) {
            Log.d(tag, msg);
        }
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        if (WebViewSdk.getInstance().isDebug()) {
            Log.e(tag, msg);
        }
    }

}
