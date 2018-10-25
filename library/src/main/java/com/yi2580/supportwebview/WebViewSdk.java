package com.yi2580.supportwebview;

import android.content.Context;

import com.tencent.smtt.sdk.QbSdk;
import com.yi2580.supportwebview.utils.WebViewLog;

import ren.yale.android.cachewebviewlib.WebViewCacheInterceptor;
import ren.yale.android.cachewebviewlib.WebViewCacheInterceptorInst;

/**
 * @author zhangqi
 * Date:2018/9/26
 * Description:
 */
public class WebViewSdk {

    private boolean isDebug;
    private boolean isUesCache;

    private static Context mContext;

    private static WebViewSdk mInstance;

    private WebViewSdk() {

    }

    //单例模式，懒加载，线程安全（java中class加载时互斥）减少内存消耗。
    private static class WebViewSdkHolder {
        private static WebViewSdk instance = new WebViewSdk();
    }

    public static WebViewSdk getInstance() {
        return WebViewSdkHolder.instance;
    }

    public WebViewSdk initWebView(Context context){
        mContext = context;
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                WebViewLog.e(" onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(mContext, cb);
        return this;
    }

    /**
     * https://github.com/yale8848/CacheWebView
     * @param builder
     * @return
     */
    public WebViewSdk builderCache(WebViewCacheInterceptor.Builder builder){
        isUesCache = true;
        if (builder == null){
            builder =  new WebViewCacheInterceptor.Builder(mContext);
        }
        //builder.setSSLSocketFactory(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager);//自定义SSLSocketFactory和X509TrustManager
        WebViewCacheInterceptorInst.getInstance().init(builder);
        return this;

    }

    public WebViewSdk setDebug(boolean debug){
        isDebug = debug;
        return this;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public boolean uesCache() {
        return isUesCache;
    }
}
