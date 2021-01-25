package com.zhongsm.cloudlibrary.push;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;

import com.zhongsm.common.util.LogUtil;
import com.zhongsm.common.util.PushUtil;

import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;

/**
 * @author WangJ
 * @version 0.1
 * @since 2021/1/12
 */
public class MyPushMessageReceiver extends JPushMessageReceiver {
    private final String TAG = "MyPushMessageReceiver";

    public MyPushMessageReceiver() {
        super();
        LogUtil.d(TAG, "BroadcastReceiver 创建");
    }

    @Override
    public void onRegister(Context context, String s) {
        super.onRegister(context, s);

        LogUtil.d(TAG, "onRegister: " + s);
        // 获取到极光返回的 registerID，即为调用推送时推送的对象
        PushUtil.recordDevicePushID(s);
    }

    @Override
    public void onConnected(Context context, boolean b) {
        super.onConnected(context, b);

        LogUtil.d(TAG, "onConnected: " + b);
    }

    @Override
    public void onCommandResult(Context context, CmdMessage cmdMessage) {
        super.onCommandResult(context, cmdMessage);

        LogUtil.d(TAG, "onCommandResult: " + cmdMessage.toString());

        //cmd为10000时说明为厂商token回调
        if (cmdMessage.cmd == 10000 && cmdMessage.extra != null) {
            String token = cmdMessage.extra.getString("token");
            int platform = cmdMessage.extra.getInt("platform");
            String deviceName = "unknown";
            switch (platform) {
                case 1:
                    deviceName = "小米";
                    break;
                case 2:
                    deviceName = "华为";
                    break;
                case 3:
                    deviceName = "魅族";
                    break;
                case 4:
                    deviceName = "OPPO";
                    break;
                case 5:
                    deviceName = "VIVO";
                    break;
                case 6:
                    deviceName = "ASUS";
                    break;
                case 8:
                    deviceName = "FCM";
                    break;
            }
            LogUtil.d(TAG, "获取到 " + deviceName + " 的token:" + token);
        }
    }

    @Override
    public Notification getNotification(Context context, NotificationMessage notificationMessage) {
        LogUtil.d(TAG, "getNotification: " + notificationMessage.toString());

        return super.getNotification(context, notificationMessage);
    }

    @Override
    public void onMessage(Context context, CustomMessage customMessage) {
        super.onMessage(context, customMessage);

        LogUtil.d(TAG, "onMessage: " + customMessage.toString());
    }

    @Override
    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        super.onNotifyMessageArrived(context, notificationMessage);

        LogUtil.d(TAG, "onNotifyMessageArrived: " + notificationMessage.toString());
    }

    @Override
    public void onNotifyMessageUnShow(Context context, NotificationMessage notificationMessage) {
        super.onNotifyMessageUnShow(context, notificationMessage);

        LogUtil.d(TAG, "onNotifyMessageUnShow: " + notificationMessage.toString());
    }

    @Override
    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        super.onNotifyMessageOpened(context, notificationMessage);

        LogUtil.d(TAG, "onNotifyMessageOpened: " + notificationMessage.toString());
    }

    @Override
    public void onNotifyMessageDismiss(Context context, NotificationMessage notificationMessage) {
        super.onNotifyMessageDismiss(context, notificationMessage);

        LogUtil.d(TAG, "onNotifyMessageDismiss: " + notificationMessage.toString());
    }

    @Override
    public void onMultiActionClicked(Context context, Intent intent) {
        super.onMultiActionClicked(context, intent);

        LogUtil.d(TAG, "onMultiActionClicked: " + intent.toString());
    }

    @Override
    public void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onTagOperatorResult(context, jPushMessage);

        LogUtil.d(TAG, "onTagOperatorResult: " + jPushMessage.toString());
    }

    @Override
    public void onCheckTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onCheckTagOperatorResult(context, jPushMessage);

        LogUtil.d(TAG, "onCheckTagOperatorResult: " + jPushMessage.toString());
    }

    @Override
    public void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onAliasOperatorResult(context, jPushMessage);

        LogUtil.d(TAG, "onAliasOperatorResult: " + jPushMessage.toString());
    }

    @Override
    public void onMobileNumberOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onMobileNumberOperatorResult(context, jPushMessage);

        LogUtil.d(TAG, "onMobileNumberOperatorResult: " + jPushMessage.toString());
    }

    @Override
    public void onNotificationSettingsCheck(Context context, boolean b, int i) {
        super.onNotificationSettingsCheck(context, b, i);

        LogUtil.d(TAG, "onNotificationSettingsCheck: boolean= " + b + " ; int= " + i);
    }

    @Override
    public boolean isNeedShowNotification(Context context, NotificationMessage notificationMessage, String s) {
        LogUtil.d(TAG, "isNeedShowNotification: " + notificationMessage.toString() + "\nString: " + s);

        return super.isNeedShowNotification(context, notificationMessage, s);
    }

    @Override
    public void onInAppMessageArrived(Context context, NotificationMessage notificationMessage) {
        super.onInAppMessageArrived(context, notificationMessage);

        LogUtil.d(TAG, "onInAppMessageArrived: " + notificationMessage.toString());
    }

    @Override
    public boolean isNeedShowInAppMessage(Context context, NotificationMessage notificationMessage, String s) {
        LogUtil.d(TAG, "isNeedShowInAppMessage: " + notificationMessage.toString() + "\nString: " + s);

        return super.isNeedShowInAppMessage(context, notificationMessage, s);
    }

    @Override
    public void onInAppMessageClick(Context context, NotificationMessage notificationMessage) {
        super.onInAppMessageClick(context, notificationMessage);

        LogUtil.d(TAG, "onInAppMessageClick: " + notificationMessage.toString());
    }

    @Override
    public void onInAppMessageDismiss(Context context, NotificationMessage notificationMessage) {
        super.onInAppMessageDismiss(context, notificationMessage);

        LogUtil.d(TAG, "onInAppMessageDismiss: " + notificationMessage.toString());
    }

    @Override
    public void onInAppMessageUnShow(Context context, NotificationMessage notificationMessage) {
        super.onInAppMessageUnShow(context, notificationMessage);

        LogUtil.d(TAG, "onInAppMessageUnShow: " + notificationMessage.toString());
    }

    @Override
    public boolean onSspNotificationWillShow(Context context, NotificationMessage notificationMessage, String s) {
        LogUtil.d(TAG, "onSspNotificationWillShow: " + notificationMessage.toString() + "\nString: " + s);

        return super.onSspNotificationWillShow(context, notificationMessage, s);
    }

    @Override
    public void onPullInAppResult(Context context, JPushMessage jPushMessage) {
        super.onPullInAppResult(context, jPushMessage);

        LogUtil.d(TAG, "onPullInAppResult: " + jPushMessage.toString());
    }
}
