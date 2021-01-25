package com.zhongsm.cloudlibrary;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zhongsm.common.BaseApplication;
import com.zhongsm.common.util.LogUtil;

import cn.jpush.android.api.JPushInterface;

/**
 * @author WangJ
 * @version 0.1
 * @since 2020/12/28
 */
public class MyApplication extends BaseApplication {
    
    @Override
    public void onCreate() {
        super.onCreate();

        // 设置全局日志打印等级
        LogUtil.setLogLevel(Log.VERBOSE);

        initARouter();

        initJGPush();
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    private void initARouter() {
        ARouter.openLog();     // Print log
        ARouter.openDebug();
        ARouter.init(this);
    }

    private void initJGPush() {
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
