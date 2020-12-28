package com.zhongsm.cloudlibrary;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.zhongsm.common.LogUtil;

/**
 * @author WangJ
 * @version 0.1
 * @since 2020/12/28
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        LogUtil.setLogLevel(Log.VERBOSE);
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }
}
