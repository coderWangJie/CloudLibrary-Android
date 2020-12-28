package com.zhongsm.cloudlibrary;

import android.widget.TextView;

import com.zhongsm.common.BaseActivity;

public class MainActivity extends BaseActivity {

    TextView tv;

    @Override
    public int assertLayoutResID() {
        return R.layout.app_activity_main;
    }

    @Override
    public void beforeResume() {
        tv = findViewById(R.id.tv);
    }

}