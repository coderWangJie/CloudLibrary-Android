package com.zhongsm.cloudlibrary;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
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

        // 设置全局日志打印等级
        LogUtil.setLogLevel(Log.VERBOSE);

        ARouter.openLog();     // Print log
        ARouter.openDebug();
        ARouter.init(this);
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }
}
