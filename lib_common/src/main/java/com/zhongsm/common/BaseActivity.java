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
    public static String TAG;

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
        TAG = getClass().getSimpleName();

        if (assertLayoutResID() > 0) {
            setContentView(assertLayoutResID());
        } else {
            setContentView(R.layout.view_layout_404);
        }

        doOnCreated();
    }

    @Override
    protected void onStart() {
        super.onStart();

        doOnStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        doOnRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        doOnResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        doOnPause();
    }

    @Override
    protected void onStop() {
        super.onStop();

        doOnStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        doOnDestroy();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
