package com.zhongsm.common;

import android.util.Log;

/**
 * Logcat日志工具
 *
 * @author WangJ
 * @version 1.0
 * @since 2020/12/28
 */
public class LogUtil {
    private static int logLevel;

    /**
     * 设置 APP 运行日志输出等级
     *
     * @param logLevel 日志输出等级，使用系统等级{@link Log#VERBOSE}、{@link Log#DEBUG}、{@link Log#INFO}、{@link Log#WARN}、{@link Log#ERROR}
     */
    public static void setLogLevel(int logLevel) {
        LogUtil.logLevel = logLevel;
    }

    public static void v(String tag, String msg, Throwable... throwable) {
        if (logLevel > Log.VERBOSE) {
            return;
        }

        if (throwable != null && throwable.length > 0) {
            Log.v(tag, msg, throwable[0]);
        } else {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg, Throwable... throwable) {
        if (logLevel > Log.DEBUG) {
            return;
        }

        if (throwable != null && throwable.length > 0) {
            Log.d(tag, msg, throwable[0]);
        } else {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg, Throwable... throwable) {
        if (logLevel > Log.INFO) {
            return;
        }

        if (throwable != null && throwable.length > 0) {
            Log.i(tag, msg, throwable[0]);
        } else {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg, Throwable... throwable) {
        if (logLevel > Log.WARN) {
            return;
        }

        if (throwable != null && throwable.length > 0) {
            Log.w(tag, msg, throwable[0]);
        } else {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg, Throwable... throwable) {
        if (logLevel > Log.ERROR) {
            return;
        }

        if (throwable != null && throwable.length > 0) {
            Log.e(tag, msg, throwable[0]);
        } else {
            Log.e(tag, msg);
        }
    }
}
