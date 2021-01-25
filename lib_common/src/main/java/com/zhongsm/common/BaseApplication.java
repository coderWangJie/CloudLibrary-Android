package com.zhongsm.common;

import android.app.Application;
import android.content.Context;

/**
 * @author WangJ
 * @version 0.1
 * @since 2021/1/13
 */
public abstract class BaseApplication extends Application {

    protected static BaseApplication app;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
    }

    public static Context getApplication() {
        return app;
    }
}
