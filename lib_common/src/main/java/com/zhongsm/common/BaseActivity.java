package com.zhongsm.common;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author WangJ
 * @version 0.1
 * @since 2020/12/28
 */
public abstract class BaseActivity extends AppCompatActivity {

    public abstract int assertLayoutResID();

    public abstract void doOnCreated();
    public abstract void doOnStart();
    public abstract void doOnRestart();
    public abstract void doOnResume();
    public abstract void doOnPause();
    public abstract void doOnStop();
    public abstract void doOnDestroy();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (assertLayoutResID() > 0) {
            setContentView(assertLayoutResID());
        } else {
            setContentView(R.layout.view_layout_404);
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
