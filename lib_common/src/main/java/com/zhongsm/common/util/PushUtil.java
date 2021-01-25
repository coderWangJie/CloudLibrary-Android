package com.zhongsm.common.util;

import android.content.Context;

import com.zhongsm.common.constant.SPKey;

import cn.jpush.android.api.JPushInterface;

/**
 * @author WangJ
 * @version 0.1
 * @since 2021/1/13
 */
public class PushUtil {

    public static void recordDevicePushID(String devicePushID) {
        SharedPreUtil.setSharedPreferencesValue(SPKey.PUSH_ID, devicePushID);
    }

    public static String readDevicePushID(Context context) {
        String id = SharedPreUtil.getSharedPreferencesValue(SPKey.PUSH_ID, "");
        if (StringUtil.isEmpty(id)) {
            id = JPushInterface.getRegistrationID(context.getApplicationContext());
        }
        return id;
    }


}
