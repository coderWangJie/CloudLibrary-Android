package com.zhongsm.launcher;

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
        return R.layout.launcher_activity_splash;
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
                LogUtil.d(BaseActivity.TAG, "onFinish");

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

    @Override
    public void doOnStop() {
        super.doOnStop();
        /* 需要消除，否则 CountDownTimer 的 handler 未及时释放持有的 Activity 引用，可能在下一次提前触发 CountDownTimer 的 onFinish()
         * 如：在倒计时未完成时点击返回按钮，立即重新进入 SplashActivity，就可能由上一次的倒计时触发本次新开倒计时的 onFinish()
         * 另一种方案是重写 Splash 的 onBackPressed()，不让他能退出
         */
        timer.cancel();
    }
}
