package com.zhongsm.cloudlibrary;

import android.content.Intent;
import android.widget.TextView;

import com.zhongsm.common.BaseActivity;
import com.zhongsm.common.LogUtil;

public class MainActivity extends BaseActivity {

    TextView tv;

    @Override
    public int assertLayoutResID() {
        return R.layout.app_activity_main;
    }

    @Override
    public void doOnCreated() {

    }

    @Override
    public void doOnStart() {

    }

    @Override
    public void doOnRestart() {

    }

    @Override
    public void doOnResume() {
        tv = findViewById(R.id.tv);

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void doOnPause() {

    }

    @Override
    public void doOnStop() {

    }

    @Override
    public void doOnDestroy() {

    }

}