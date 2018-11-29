package com.yi2580.webviewdemo;

import android.app.Application;

import com.yi2580.supportwebview.WebViewSdk;

import ren.yale.android.cachewebviewlib.WebViewCacheInterceptor;

/**
 * @author zhangqi
 * Date:2018/9/26
 * Description:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        WebViewSdk.getInstance()
                .setDebug(true)
                .initWebView(this)
                .builderCache(new WebViewCacheInterceptor.Builder(this))
        ;
    }
}
