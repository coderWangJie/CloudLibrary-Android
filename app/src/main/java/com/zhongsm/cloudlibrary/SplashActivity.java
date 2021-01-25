package com.zhongsm.cloudlibrary;

import android.os.CountDownTimer;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zhongsm.common.BaseActivity;
import com.zhongsm.common.constant.ARouterMapping;
import com.zhongsm.common.util.LogUtil;

import java.util.Locale;

/**
 * @author WangJ
 * @version 0.1
 * @since 2021/1/13
 */
public class SplashActivity extends BaseActivity {

    private TextView tvCountDown;
    private CountDownTimer timer;

    @Override
    public int assertLayoutResID() {
        return R.layout.app_activity_splash;
    }

    @Override
    public void doOnCreated() {
        tvCountDown = findViewById(R.id.tv_countDown);

        timer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // millisUntilFinished会比实际毫秒数 1000*n 小几毫秒，需要取整处理一下
                tvCountDown.setText(String.format(Locale.getDefault(), "%d s", (int) millisUntilFinished / 1000 + 1));
            }

            @Override
            public void onFinish() {
                LogUtil.d(TAG, "onFinish");

                ARouter.getInstance().build(ARouterMapping.Home.Main).navigation();
                finish();
            }
        };
    }

    @Override
    public void doOnStart() {

    }

    @Override
    public void doOnResume() {
        timer.start();
    }
}
