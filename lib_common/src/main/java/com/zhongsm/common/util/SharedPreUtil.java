package com.zhongsm.common.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.zhongsm.common.BaseApplication;

/**
 * @author WangJ
 * @version 0.1
 * @since 2021/1/13
 */
public class SharedPreUtil {

    /**
     *
     */
    private static final String NAME = "sp_eLibrary";

    private static final SharedPreferences sp = BaseApplication.getApplication().getSharedPreferences(NAME, Context.MODE_PRIVATE);

    public static boolean getSharedPreferencesValue(String key, boolean defValue) {
        return sp.getBoolean(key, defValue);
    }

    public static int getSharedPreferencesValue(String key, int defValue) {
        return sp.getInt(key, defValue);
    }

    public static float getSharedPreferencesValue(String key, float defValue) {
        return sp.getFloat(key, defValue);
    }

    public static long getSharedPreferencesValue(String key, long defValue) {
        return sp.getLong(key, defValue);
    }

    public static String getSharedPreferencesValue(String key, String defValue) {
        return sp.getString(key, defValue);
    }

    public static boolean setSharedPreferencesValue(String key, boolean newValue) {
        return sp.edit().putBoolean(key, newValue).commit();
    }

    public static boolean setSharedPreferencesValue(String key, int newValue) {
        return sp.edit().putInt(key, newValue).commit();
    }

    public static boolean setSharedPreferencesValue(String key, float newValue) {
        return sp.edit().putFloat(key, newValue).commit();
    }

    public static boolean setSharedPreferencesValue(String key, long newValue) {
        return sp.edit().putLong(key, newValue).commit();
    }

    public static boolean setSharedPreferencesValue(String key, String newValue) {
        return sp.edit().putString(key, newValue).commit();
    }
}
